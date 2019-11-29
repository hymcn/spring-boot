package mooon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Administrator
 * @date 2019/11/14.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext app  = SpringApplication.run(Application.class, args);
	}

}
