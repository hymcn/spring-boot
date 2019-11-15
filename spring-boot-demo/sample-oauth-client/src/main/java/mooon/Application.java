package mooon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author Administrator
 * @date 2019/11/14.
 */
@EnableOAuth2Client
@SpringBootApplication
public class Application {

    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @Bean
    public OAuth2RestTemplate restTemplate() {
        return new OAuth2RestTemplate(new AuthorizationCodeResourceDetails(), oauth2ClientContext);
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
