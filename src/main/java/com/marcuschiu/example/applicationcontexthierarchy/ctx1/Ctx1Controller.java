package com.marcuschiu.example.applicationcontexthierarchy.ctx1;

import com.marcuschiu.example.applicationcontexthierarchy.parent.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ctx1Controller {

    @Autowired
    private IHomeService homeService;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/controller")
    public String getGreeting() {
        return homeService.getGreeting();
    }

    /**
     * http://localhost:8081/ctx1/application-context
     * @return org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@68702e03
     */
    @GetMapping("/application-context")
    public String getApplicationContext() {
        return applicationContext.getDisplayName();
    }

    /**
     * http://localhost:8081/ctx1/parent/application-context
     * @return org.springframework.context.annotation.AnnotationConfigApplicationContext@57a3af25
     */
    @GetMapping("/parent/application-context")
    public String getParentApplicationContext() {
        return applicationContext.getParent().getDisplayName();
    }
}