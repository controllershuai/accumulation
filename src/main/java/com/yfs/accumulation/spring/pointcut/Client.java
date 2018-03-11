package com.yfs.accumulation.spring.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class Client {

    public static void main(String[] args) {
        //pointcut 定义， 匹配方式可以按上面的说明修改，  这里是注解类的所有方法都匹配  
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forClassAnnotation(ClassLevelAnnotation.class);

        // advice 定义， 根据前面的介绍知道 这个是 横切逻辑的定义， 这里是 方法执行前插入横切逻辑  
        BeforeAdvice advice = new MethodBeforeAdvice() {
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println(target.getClass().getSimpleName() + ":" + method.getName() + " - before logic ");
            }
        };

        // Spring 中的 Aspect ， pointcut 和 advice 的封装类  
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(advice);

        // Spring 基本织入器 weaving 和 weaver  
        ProxyFactory weaver = new ProxyFactory();
        weaver.setTarget(new PointCutTestService());   //指定代理目标对象
        weaver.addAdvisor(advisor);             //指定 Aspect  

        Object proxyObject = weaver.getProxy(); //生成代理对象 （这里没接口， Spring 使用 CGLIB 创建子类）  

        ((PointCutTestService) proxyObject).method1();
        ((PointCutTestService) proxyObject).method2();
    }

    public void pointCutGetMethod() {
        //仅指定类级别的注解， 标注了 ClassLevelAnnotation 注解的类中的所有方法执行的时候，将全部匹配。
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(ClassLevelAnnotation.class);

        //还可以使用静态方法创建 pointcut 实例
        AnnotationMatchingPointcut pointcut1 = AnnotationMatchingPointcut.forClassAnnotation(ClassLevelAnnotation.class);


        //仅指定方法级别的注解，标注了 MethodLeavelAnnotaion 注解的方法（忽略类匹配）都将匹配
        AnnotationMatchingPointcut pointcut2 = AnnotationMatchingPointcut.forMethodAnnotation(MethodLevelAnnotation.class);


        //同时限定类级别和方法级别的注解，只有标注了 ClassLevelAnnotation 的类中 同时标注了 MethodLevelAnnotation 的方法才会匹配
        AnnotationMatchingPointcut pointcut3 = new AnnotationMatchingPointcut(ClassLevelAnnotation.class, MethodLevelAnnotation.class);
    }
}  