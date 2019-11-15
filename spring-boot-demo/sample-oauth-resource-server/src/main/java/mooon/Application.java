package mooon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author Administrator
 * @date 2019/11/15.
 */
@SpringBootApplication
@EnableResourceServer
@Slf4j
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
