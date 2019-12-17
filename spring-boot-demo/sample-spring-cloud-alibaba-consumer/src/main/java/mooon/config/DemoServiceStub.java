package mooon.config;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mooon.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2019/12/11.
 */
@Primary
@Component
public class DemoServiceStub implements DemoService {

	@Reference(check = false)
	private DemoService demoService;

	@HystrixCommand(fallbackMethod = "defaultSayName")
	@Override
	public String sayName(String name) {
		return demoService.sayName(name);
	}

	public String defaultSayName(String name){
		return "Hello Mooon";
	}
}
