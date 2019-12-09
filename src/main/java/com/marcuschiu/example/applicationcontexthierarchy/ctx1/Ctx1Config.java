package com.marcuschiu.example.applicationcontexthierarchy.ctx1;

import com.marcuschiu.example.applicationcontexthierarchy.parent.IHomeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.marcuschiu.example.applicationcontexthierarchy.ctx1")
@PropertySource("classpath:ctx1.properties")
@EnableAutoConfiguration
public class Ctx1Config {
    @Bean
    public IHomeService homeService() {
        return new Ctx1HomeService();
    }
}