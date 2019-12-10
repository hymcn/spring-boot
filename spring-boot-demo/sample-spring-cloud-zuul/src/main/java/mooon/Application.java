package mooon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/12/4.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class Application {

	@Autowired
	HelloClient client;

	@RequestMapping("/")
	public String hello(String q) {
		return client.echo(q);
	}

	@FeignClient("HelloServer")
	interface HelloClient {
		String echo(String q);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
