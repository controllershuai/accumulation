package com.yfs.accumulation.spring.ioc.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
	@Bean
    HelloWorldBean helloBean () {
		HelloWorldBean thebean= new HelloWorldBean();
		thebean.setMyName("洋富帅");
		return thebean;
	}
}
