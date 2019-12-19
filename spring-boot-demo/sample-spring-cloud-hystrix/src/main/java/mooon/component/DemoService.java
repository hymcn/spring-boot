package mooon.component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2019/12/17.
 */
@Component
public class DemoService {

	@HystrixCommand(fallbackMethod = "sayHelloDefault", commandProperties = {
			@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
	})
	public String sayHello(){
		return String.format("hello, im run in {%s}", Thread.currentThread().getName());
	}

	@HystrixCommand(fallbackMethod = "sayHelloDefault", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")
	})
	public String timeout() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return String.format("hello, im run in {%s}", Thread.currentThread().getName());
	}

	@HystrixCommand
	public String otherMethod(){
		return "other method";
	}

	public String sayHelloDefault(){
		return "hello default";
	}
}
