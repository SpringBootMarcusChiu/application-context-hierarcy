package com.marcuschiu.example.applicationcontexthierarchy.ctx1;

import com.marcuschiu.example.applicationcontexthierarchy.parent.IHomeService;

// @Service removed see Ctx1Config.java for more details
// removed because IHomeService is defined as a @Bean, no need to define it as a @Service @Component
public class Ctx1HomeService implements IHomeService {
    public String getGreeting() {
        return "This is Ctx1HomeService.java";
    }
}