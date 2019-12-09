package com.marcuschiu.example.applicationcontexthierarchy;

import com.marcuschiu.example.applicationcontexthierarchy.ctx1.Ctx1Config;
import com.marcuschiu.example.applicationcontexthierarchy.ctx2.Ctx2Config;
import com.marcuschiu.example.applicationcontexthierarchy.parent.ParentConfig;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.parent(ParentConfig.class).web(WebApplicationType.NONE)
				.child(Ctx1Config.class).web(WebApplicationType.SERVLET)
				.sibling(Ctx2Config.class).web(WebApplicationType.SERVLET)
				.run(args);
	}
}
