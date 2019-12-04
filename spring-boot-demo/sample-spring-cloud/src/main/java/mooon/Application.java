package mooon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/12/4.
 */
@RestController
@SpringBootApplication
@EnableConfigServer
public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private Environment environment;

	@RequestMapping("/")
	public String query(@RequestParam("q") String q) {
		return this.environment.getProperty(q);
	}




}
