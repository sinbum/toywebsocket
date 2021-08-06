package controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Configuration
@ComponentScan
//@ComponentScan(basePackages = "controller")
@Controller
public class WebSocketController {

	@RequestMapping("/websocket1")	
	public String websocket1() {
		return "/WEB-INF/view/websocket1.jsp";
	}
}
