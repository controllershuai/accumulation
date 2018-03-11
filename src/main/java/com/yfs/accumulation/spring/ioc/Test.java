package com.yfs.accumulation.spring.ioc;

import com.yfs.accumulation.spring.ioc.beans.HelloWorldBean;
import com.yfs.accumulation.spring.ioc.beans.HelloWorldConfig;
import com.yfs.accumulation.spring.ioc.beans.MyOrder;
import com.yfs.accumulation.spring.ioc.beans.PropertyBean;
import com.yfs.accumulation.spring.ioc.beans.datasource.DataSourceService;
import com.yfs.accumulation.spring.ioc.beans.datasource.MenuService;
import com.yfs.accumulation.spring.ioc.dao.*;
import com.yfs.accumulation.spring.ioc.event.MySpringEvtSender;
import com.yfs.accumulation.spring.ioc.service.AnnotationBean;
import com.yfs.accumulation.spring.ioc.service.UserService;
import com.yfs.accumulation.spring.ioc.service.UserServiceInterface;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        xmlIocTest();
//        annotationConfigTest();
//        componentScanTest();
//        getBeanByClass();
//        dataSourceTest();
//        propertyBeanTest();
//        aopUtilsTest();
//        genericParadigmTest();
//        collectionIocTest();
        eventTest();
    }

    public static void eventTest() throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        MySpringEvtSender evtSender = ctx.getBean(MySpringEvtSender.class);
        evtSender.createDemoEvent();
        Thread.sleep(5000);
    }

    public static void collectionIocTest() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext4.xml");
//        CompletedService myServc=ctx.getBean(CompletedService.class);
//    	System.out.println("map class "+myServc.getAllDaos().getClass());
//    	myServc.getAllDaos().forEach((key,value)->{System.out.println(key+"="+value);});
        System.out.println(AppContextUtil.getBean(CompletedService2.class));
        CompletedService2 myServc2 = ctx.getBean(CompletedService2.class);
        //class class java.util.LinkedHashMap$LinkedValues
        //意思是，Collection系列也是按照map存的，如果我们定义为Collection则为LinkedHashMap$LinkedValues
        System.out.println(" class " + myServc2.getAllDaos().getClass());
        myServc2.getAllDaos().forEach((a) -> {
            System.out.println(a);
        });
        ctx.registerShutdownHook();
    }

    public static void genericParadigmTest() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext4.xml");
        UserInfoService userInfoService = ctx.getBean(UserInfoService.class);
        System.out.println("dao class " + userInfoService.getDao().getClass());
        ResolvableType resolvableType1 = ResolvableType.forClass(UserInfoService.class);
        //获取泛型对应的类型  spring
        System.out.println("type is " + resolvableType1.as(AbstractService.class).getGeneric(0).resolve());
        //获取泛型对应的类型  reflect
        ParameterizedType parameterizedType = (ParameterizedType) UserInfoService.class.getGenericSuperclass();
        Type genericType = parameterizedType.getActualTypeArguments()[0];
        System.out.println("type is " + genericType);
        ctx.registerShutdownHook();
    }

    public static void aopUtilsTest() {
        //调试不通过
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext3.xml");
        MyOrder myOrder = new MyOrder();
        PropertyBean propertyBean = myOrder.getPropertyBean();
        propertyBean.hello();
        System.out.println(" isAopProxy  " + AopUtils.isAopProxy(myOrder));
        System.out.println(" isCglibProxy  " + AopUtils.isCglibProxy(myOrder));
        System.out.println(" isJdkDynamicProxy  " + AopUtils.isJdkDynamicProxy(myOrder));
        ctx.registerShutdownHook();
    }

    public static void propertyBeanTest() {
        //TODO value没有注入，why?
//        System.setProperty("spring.profiles.default", "application");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext2.xml");
        PropertyBean propertyBean = ctx.getBean(PropertyBean.class);
        propertyBean.hello();
        ctx.registerShutdownHook();
    }

    public static void dataSourceTest() {
        System.setProperty("spring.profiles.active", "full_version");
        System.setProperty("spring.profiles.active", "_version");
        System.setProperty("spring.profiles.active", "full_version,free_version");
        System.setProperty("spring.profiles.default", "free_version");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext2.xml");
        Environment env = ctx.getEnvironment();
        System.out.println(env.getClass().getName());
        System.out.println("getDefaultProfiles " + Arrays.toString(env.getDefaultProfiles()));
        System.out.println("getActiveProfiles " + Arrays.toString(env.getActiveProfiles()));
        // ctx.getEnvironment().setActiveProfiles("local_dev");
        // ctx.getEnvironment().setDefaultProfiles("local_dev");
        DataSourceService ds = ctx.getBean(DataSourceService.class);
        MenuService menuSrv = ctx.getBean(MenuService.class);
        System.out.println("menus  " + Arrays.toString(menuSrv.getMenus("user")));
        System.out.println(ds);
        ctx.close();

    }

    public static void getBeanByClass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService.getInnerUser());
        UserService userService1 = ctx.getBean(UserService.class);
        System.out.println(userService1.getInnerUser());
        UserServiceInterface userService2 = ctx.getBean(UserServiceInterface.class);
        System.out.println(userService2.getInnerUser());
    }

    public static void componentScanTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        AnnotationBean helloworld = (AnnotationBean) ctx.getBean("annotationBean");
        helloworld.hello();
    }

    public static void annotationConfigTest() {
        System.out.println(new Date() + "  begin");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        //helloBean 和 config里面的方法名一样
        HelloWorldBean helloworld = (HelloWorldBean) ctx.getBean("helloBean");
        helloworld.hello();
    }

    public static void xmlIocTest() throws InterruptedException {
        System.out.println(new Date() + "  begin");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Thread.sleep(2000);
        HelloWorldBean helloworld = (HelloWorldBean) ctx.getBean("helloBean");
        HelloWorldBean helloworld1 = (HelloWorldBean) ctx.getBean("helloWorldBean");
        System.out.println(new Date() + " get bean " + helloworld);
        Thread.currentThread();
        Thread.sleep(2000);
        helloworld.hello();
    }
}
