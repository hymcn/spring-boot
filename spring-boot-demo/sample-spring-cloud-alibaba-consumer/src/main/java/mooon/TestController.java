package mooon;

import mooon.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/12/3.
 */
@RestController
public class TestController {

	@Reference(version = "1.0.0")
	private DemoService demoService;

	@GetMapping(value = "/echo-dubbo/{str}")
	public String dubbo(@PathVariable String str) {
		return demoService.sayName(str);
	}
}