package mooon.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/11/7.
 */
@RestController
public class SimpleController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello SpringBoot";
	}
}
