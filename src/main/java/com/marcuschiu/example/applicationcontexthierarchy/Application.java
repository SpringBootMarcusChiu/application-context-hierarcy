package com.marcuschiu.example.applicationcontexthierarchy;

import com.marcuschiu.example.applicationcontexthierarchy.ctx1.Ctx1Config;
import com.marcuschiu.example.applicationcontexthierarchy.ctx2.Ctx2Config;
import com.marcuschiu.example.applicationcontexthierarchy.parent.ParentConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class Application {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplicationBuilder()
				.parent(ParentConfig.class).web(WebApplicationType.NONE)	// returns the Parent AnnotationConfigApplicationContext
				.child(Ctx1Config.class).web(WebApplicationType.SERVLET)	// returns the Child1 AnnotationConfigServletWebServerApplicationContext
				.sibling(Ctx2Config.class).web(WebApplicationType.SERVLET)	// returns the Child2 AnnotationConfigServletWebServerApplicationContext
				.build();

		ConfigurableApplicationContext appContext = springApplication.run(args);

		System.out.println(appContext.getDisplayName());				// org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@702c436b
		System.out.println(appContext.getParent().getDisplayName());	// org.springframework.context.annotation.AnnotationConfigApplicationContext@57a3af25
	}
}
