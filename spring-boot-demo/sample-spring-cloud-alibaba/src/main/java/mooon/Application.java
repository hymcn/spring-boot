package mooon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2019/11/29.
 */
@SpringBootApplication
@RefreshScope
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

		while (true) {
			//当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
			String appName = applicationContext.getEnvironment().getProperty("app.name");
			System.out.println("app name :" + appName);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}


@RestController
class SampleController {

	@Value("${app.name}")
	String appName;

	@RequestMapping("/conf")
	public String simple() {
		return "Hello Nacos Config!" + "Hello " + appName + "!";
	}

}
