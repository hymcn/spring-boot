package mooon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author Administrator
 * @date 2019/11/12.
 */
@EnableAuthorizationServer
@SpringBootApplication
//@EnableResourceServer
//@EnableWebSecurity
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
