/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package cn.mzsoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述.
 * @author Ma Zhuang.
 */
@Configuration
@ComponentScan(basePackages = "cn.mzsoft")
public  class AppConfig {
	public static void main(String[] args) {
		System.out.println("hello");

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		String obj = (String) context.getBean("helloworld");
		System.out.println(obj);
		System.out.println(new TestGroovy().testVar());
		JavaBean javaBean = (JavaBean) context.getBean("javaBean");
		javaBean.hello();
		GroovyBean testGroovy =(GroovyBean) context.getBean("groovyBean");
		testGroovy.hello();

		ThreadBean th = context.getBean(ThreadBean.class);
		th.threadStudy();

	}




	@Bean(name="helloworld")
	public String getHello(){
		System.out.println("hello world");
		return "bean hello world";

	}




}
