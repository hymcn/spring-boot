package mooon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author Administrator
 * @date 2019/12/17.
 */
@SpringBootApplication
@EnableCircuitBreaker
public class Application {

	public static void main(String[] args){
		new SpringApplicationBuilder(Application.class).run(args);
	}
}