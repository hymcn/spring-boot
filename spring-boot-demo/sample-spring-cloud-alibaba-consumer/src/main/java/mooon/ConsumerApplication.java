package mooon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 * @date 2019/12/3.
 */
@SpringBootApplication
@RefreshScope
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ConsumerApplication {

	@Value("${appName:NONAME}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		return applicationArguments -> System.out.println("App name from nacos config: "+ appName);
	}

}
