package mooon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/12/16.
 */
@RestController
public class DemoController {

	@Autowired
	private LoadBalancerClient loadBalancer;

	@RequestMapping("/")
	public String hello(){
		return "hello";
	}

	@RequestMapping("/lb")
	public String lb(){
		ServiceInstance serviceInstance = loadBalancer.choose("demo");
		return String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort());
	}

}
