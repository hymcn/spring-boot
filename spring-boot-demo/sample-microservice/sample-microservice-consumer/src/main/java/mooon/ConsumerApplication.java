package mooon;

import lombok.extern.slf4j.Slf4j;
import mooon.api.IEchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author Administrator
 * @date 2019/12/18.
 */
@SpringBootApplication
@Slf4j
@RefreshScope
@EnableHystrix
@EnableHystrixDashboard
public class ConsumerApplication {

	@Value("${v:0.0}")
	private String version;

	@Autowired
	Environment environment;

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args){
		SpringApplication.run(ConsumerApplication.class);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		log.info(environment.getProperty("v", "vv"));
		Map beans = applicationContext.getBeansOfType(IEchoService.class);
		log.info("IEchoService beans :  {}", beans);
		log.info("应用启动中，配置版本{}", version);
		return new ApplicationRunner() {
			public void run(ApplicationArguments applicationArguments) throws Exception {
			}
		};
	}
}
