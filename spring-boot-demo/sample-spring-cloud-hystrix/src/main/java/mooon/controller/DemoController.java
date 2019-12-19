package mooon.controller;

import mooon.component.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/12/17.
 */
@RestController
@EnableHystrixDashboard
public class DemoController {

	@Autowired
	DemoService demoService;

	@RequestMapping("/hello")
	public String hello(){
		return demoService.sayHello();
	}


	@RequestMapping("/timeout")
	public String timeout(){
		return demoService.timeout();
	}

	@RequestMapping("/other")
	public String other(){
		return demoService.otherMethod();
	}
}
