package mooon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/11/29.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
	}
}


@RestController
class EchoController {
	@GetMapping(value = "/echo/{string}")
	public String echo(@PathVariable String string) {
		return string;
	}
}

@RestController
class SampleController {

	@Value("${app.name}")
	String appName;

	@RequestMapping("/conf")
	public String simple() {
		return "Hello Nacos Config!" + "Hello " + appName + "!";
	}

}
