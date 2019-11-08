package mooon;

import lombok.extern.slf4j.Slf4j;
import mooon.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @author Administrator
 * @date 2019/11/7.
 */
@SpringBootApplication()
@EnableConfigurationProperties({AppConfig.class})
@Slf4j
public class Application {


	public static void main(String[] args){
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
	}
}
