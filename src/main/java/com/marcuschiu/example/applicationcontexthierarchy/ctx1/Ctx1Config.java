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
    /**
     * IS NEEDED EVEN THOUGH @ComponentScan will pick up Ctx1HomeService
     * when @Autowired IHomeService is used in for example Ctx1Controller, this
     * cause error:
     * - An exception occured while executing the Java class. Error creating bean
     *   with name 'ctx1Controller': Unsatisfied dependency expressed through field
     *   'homeService'; nested exception is org.springframework.beans.factory.
     *   NoUniqueBeanDefinitionException: No qualifying bean of type 'com.marcuschiu.
     *   example.applicationcontexthierarchy.parent.IHomeService' available: expected
     *   single matching bean but found 2: ctx1HomeService,parentHomeService
     * Thus, bean definition below removes this duplication bean error
     * @return
     */
    @Bean
    public IHomeService homeService() {
        return new Ctx1HomeService();
    }
}