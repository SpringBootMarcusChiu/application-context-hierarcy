package com.marcuschiu.example.applicationcontexthierarchy.ctx2;

import com.marcuschiu.example.applicationcontexthierarchy.parent.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ctx2Controller {

    @Autowired
    private IHomeService homeService;

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/controller")
    public String getGreeting() {
        return homeService.getGreeting();
    }

    /**
     * http://localhost:8082/ctx2/application-context
     * @return org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@702c436b
     */
    @GetMapping("/application-context")
    public String getApplicationContext() {
        return applicationContext.getDisplayName();
    }

    /**
     * http://localhost:8082/ctx2/parent/application-context
     * @return org.springframework.context.annotation.AnnotationConfigApplicationContext@57a3af25
     */
    @GetMapping("/parent/application-context")
    public String getParentApplicationContext() {
        return applicationContext.getParent().getDisplayName();
    }
}