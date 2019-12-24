package mooon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ServerList;
import lombok.extern.slf4j.Slf4j;
import mooon.api.IEchoService;
import mooon.config.NacosRibbonClientExtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author Administrator
 * @date 2019/12/18.
 */
@Slf4j
@RefreshScope
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = NacosRibbonClientExtConfig.class)})
@RibbonClients(defaultConfiguration= NacosRibbonClientExtConfig.class)
@EnableFeignClients
public class ConsumerApplication {

	@Value("${v:0.0}")
	private String version;

	@Autowired
	Environment environment;

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		log.info(environment.getProperty("v", "vv"));
		Map beans = applicationContext.getBeansOfType(IEchoService.class);
		log.info("IEchoService beans :  {}", beans);
		log.info("应用启动中，配置版本{}", version);

		 beans = applicationContext.getBeansOfType(IClientConfig.class);
		log.info("IClientConfig beans :  {}", beans);

		 beans = applicationContext.getBeansOfType(ServerList.class);
		log.info("ServerList beans :  {}", beans);

		return new ApplicationRunner() {
			public void run(ApplicationArguments applicationArguments) throws Exception {
			}
		};
	}
}
