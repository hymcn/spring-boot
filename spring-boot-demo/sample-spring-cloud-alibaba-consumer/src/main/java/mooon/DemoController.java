package mooon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mooon.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @date 2019/12/3.
 */
@EnableFeignClients
@RestController
@RefreshScope
public class DemoController {

	@Value("${appName:NONAME}")
	private String appName;

	@Autowired
	private DemoService demoService;

	@GetMapping(value = "/dubbo/{str}")
	public String dubbo(@PathVariable String str) {
		return demoService.sayName(str);
	}

	@GetMapping(value = "/feign/{str}")
	public String feign(@PathVariable String str) {
		return helloClient.hello();
	}

	@Autowired
	HelloClient helloClient;

	@FeignClient("dubbo-registry-nacos-provider-sample")
	interface HelloClient {
		@HystrixCommand(fallbackMethod = "helloDefault")
		@RequestMapping(value = "/hello", method = RequestMethod.GET)
		String hello();
	}

	public String helloDefault(){
		return "Hello world";
	}

	@RequestMapping("/")
	public String getAppName(){
		return appName;
	}
}