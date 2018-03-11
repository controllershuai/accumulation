package com.yfs.accumulation.spring.pointcut;

@ClassLevelAnnotation
public class PointCutTestService {
    @MethodLevelAnnotation
    public void method1() {
        System.out.println("target : method1");
    }

    public void method2() {
        System.out.println("target : method2");
    }
}
