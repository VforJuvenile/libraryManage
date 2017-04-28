package com.manage.library;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication
public class ApplicationMain extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class,args);
	/*
		ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMain.class, args);
		System.out.println("Let's inspect the beans provided by Spring Boot:");

		Object dataSource = ctx.getBean("dataSource");
		Object transactionManager = ctx.getBean("transactionManager");
		Object entityManagerFactory = ctx.getBean("entityManagerFactory");
		System.out.println(dataSource);
		System.out.println(entityManagerFactory);
		System.out.println(transactionManager);
		System.out.println(((JpaTransactionManager)transactionManager).getDataSource());
		System.out.println(((JpaTransactionManager)transactionManager).getEntityManagerFactory());
	 */
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationMain.class);
    }
	
	@RequestMapping("/")
	public String welcomeLibManege(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String simpleDf =  sdf.format(date);
		return "<h1><a href='/index' style='text-decoration:none'>欢迎进入由SpringBoot框架开发的图书管理系统</a></h1>" + "<h2>现在时间：<font color='red'>" + simpleDf+"</font><h2>";
	}
}
