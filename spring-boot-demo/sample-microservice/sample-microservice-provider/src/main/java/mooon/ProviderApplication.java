package mooon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author Administrator
 * @date 2019/12/18.
 */
@SpringBootApplication
@Slf4j
@RefreshScope
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ProviderApplication {

	@Value("${v}")
	private String version;

	@Autowired
	Environment environment;

	public static void main(String[] args){
		SpringApplication.run(ProviderApplication.class);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		return new ApplicationRunner() {
			public void run(ApplicationArguments applicationArguments) throws Exception {
				log.info("应用启动中，配置版本{}", version);
			}
		};
	}
}
