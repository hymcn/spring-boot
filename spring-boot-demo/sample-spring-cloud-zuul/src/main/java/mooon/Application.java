package mooon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 * @date 2019/12/4.
 */
@SpringBootApplication
@EnableZuulProxy
public class Application {

	@Bean
	public LocationRewriteFilter locationRewriteFilter() {
		return new LocationRewriteFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
