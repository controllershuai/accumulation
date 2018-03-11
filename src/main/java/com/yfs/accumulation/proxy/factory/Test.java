package com.yfs.accumulation.proxy.factory;

import com.yfs.accumulation.proxy.beans.PayGateWay;
import com.yfs.accumulation.proxy.beans.PayGateWayType;
import javassist.*;

import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, CannotCompileException, NotFoundException, InvocationTargetException {
        createObjectByCodes();
        cglibProxy();
        jdkProxy();
        javassistProxy();
    }

    public static void createObjectByCodes() throws CannotCompileException, NoSuchMethodException, NotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("com.Mysuperclass");
        CtField field = new CtField(classPool.get("java.lang.String"), "name", ctClass);
        field.setModifiers(Modifier.PRIVATE);
        ctClass.addField(field);
        ctClass.addMethod(CtNewMethod.setter("setName", field));
        ctClass.addMethod(CtNewMethod.getter("getName", field));

        CtMethod method = new CtMethod(CtClass.voidType, "hello", null, ctClass);
        method.setModifiers(Modifier.PUBLIC);
        method.setBody("{System.out.println(\"Hello\" + this.name);}");
        ctClass.addMethod(method);

        CtConstructor constructor = new CtConstructor(null, ctClass);
        constructor.setModifiers(Modifier.PUBLIC);
        constructor.setBody("{System.out.println(\"created \"+this); }");
        ctClass.addConstructor(constructor);

        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        clazz.getMethod("setName", String.class).invoke(obj, " Super Man");
        clazz.getMethod("hello").invoke(obj);
    }

    public static void cglibProxy() {
        //jdk自带InvocationHandler使用方法
        PayGateWay aliPay= JavassistPayGateWayFactory.getPayGateWay(PayGateWayType.Alipay);
        aliPay.pay(555, 123456, 100);
        aliPay.backPay(555, 123456, 100);
        PayGateWay weChatPay= JavassistPayGateWayFactory.getPayGateWay(PayGateWayType.WeCaht);
        weChatPay.pay(555, 123456, 100);
        weChatPay.backPay(555, 123456, 100);
        System.out.println("=============");
        System.out.println(weChatPay.getClass().getName());
    }

    public static void jdkProxy() {
        //jdk自带InvocationHandler使用方法
        PayGateWay aliPay= JdkPayGateWayFactory.getPayGateWay(PayGateWayType.Alipay);
        aliPay.pay(555, 123456, 100);
        aliPay.backPay(555, 123456, 100);
        PayGateWay weChatPay= JdkPayGateWayFactory.getPayGateWay(PayGateWayType.WeCaht);
        weChatPay.pay(555, 123456, 100);
        weChatPay.backPay(555, 123456, 100);
        System.out.println("============");
        System.out.println(weChatPay.getClass().getName());
    }


    public static void javassistProxy() {
        //jdk自带InvocationHandler使用方法
        PayGateWay aliPay= JavassistPayGateWayFactory.getPayGateWay(PayGateWayType.Alipay);
        aliPay.pay(555, 123456, 100);
        aliPay.backPay(555, 123456, 100);
        PayGateWay weChatPay= JavassistPayGateWayFactory.getPayGateWay(PayGateWayType.WeCaht);
        weChatPay.pay(555, 123456, 100);
        weChatPay.backPay(555, 123456, 100);
        System.out.println("===============");
        System.out.println(weChatPay.getClass().getName());
    }

}
