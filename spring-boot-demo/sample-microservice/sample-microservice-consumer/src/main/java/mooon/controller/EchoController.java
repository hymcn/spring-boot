package mooon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mooon.api.IEchoService;
import mooon.service.RemoteFeignService;
import mooon.service.RemoteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/12/18.
 */
@RestController
public class EchoController {

	@Reference(version = "${v}")
	IEchoService echoService;

	@Autowired
	RemoteService remoteService;

	@Autowired
	RemoteFeignService remoteFeignService;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@HystrixCommand(commandKey = "echo")
	@RequestMapping("/echo/{e}")
	public String echo(@PathVariable("e") String echo) {
		return echoService.echo(echo);
	}

	@HystrixCommand(commandKey = "remoteEcho")
	@RequestMapping("/remoteecho/{e}")
	public String remoteEcho(@PathVariable("e") String echo) {
		return remoteService.echo(echo);
	}

	@HystrixCommand(commandKey = "feignEcho")
	@RequestMapping("/feignecho/{e}")
	public String feignEcho(@PathVariable("e") String echo) {
		return remoteFeignService.echo(echo);
	}

	@HystrixCommand(commandKey = "error")
	@RequestMapping("/error/{e}")
	public String error(@PathVariable("e") String echo) {
		throw new RuntimeException("Error ");
	}

	@RequestMapping("/lb")
	public String lb() {
		ServiceInstance serviceInstance = loadBalancer.choose("providers:mooon.api.IEchoService:1.1:");
		return String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort());
	}

}
