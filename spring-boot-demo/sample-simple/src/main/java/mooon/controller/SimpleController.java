package mooon.controller;


import mooon.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/11/7.
 */
@RestController
public class SimpleController {

	@Autowired
	AppConfig appConfig;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello SpringBoot" + appConfig.getName();
	}

	@Value("${app.demo.name}")
	private String appName;

	@RequestMapping("/index")
	public String index(){
		return appName;
	}

}
