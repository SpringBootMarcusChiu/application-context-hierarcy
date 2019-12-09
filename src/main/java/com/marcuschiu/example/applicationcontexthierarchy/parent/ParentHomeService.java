package com.marcuschiu.example.applicationcontexthierarchy.parent;

import org.springframework.stereotype.Service;

@Service
public class ParentHomeService implements IHomeService {
    public String getGreeting() {
        return "This is ParentHomeService.java";
    }
}