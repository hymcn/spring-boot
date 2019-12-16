package mooon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
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

}
