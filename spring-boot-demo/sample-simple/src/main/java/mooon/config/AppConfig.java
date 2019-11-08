package mooon.config;


import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author Administrator
 * @date 2019/11/8.
 */
@ConfigurationProperties(prefix = "app.demo")
@Getter
@lombok.Setter
@ToString
public class AppConfig {
	private String name;
}
