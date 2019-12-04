package mooon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 * @date 2019/12/3.
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerApp {

	public static void main(String[] args){
		SpringApplication.run(ConsumerApp.class, args);
	}

}
