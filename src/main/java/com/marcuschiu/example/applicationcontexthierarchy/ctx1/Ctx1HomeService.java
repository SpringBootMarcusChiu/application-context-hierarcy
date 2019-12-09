package com.marcuschiu.example.applicationcontexthierarchy.ctx1;

import com.marcuschiu.example.applicationcontexthierarchy.parent.IHomeService;
import org.springframework.stereotype.Service;

@Service
public class Ctx1HomeService implements IHomeService {
    public String getGreeting() {
        return "This is Ctx1HomeService.java";
    }
}