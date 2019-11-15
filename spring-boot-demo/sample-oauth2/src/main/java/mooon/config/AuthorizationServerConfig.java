package mooon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2019/11/12.
 */
//@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory().withClient("appid")
//                .resourceIds("userinfo")
//                .authorizedGrantTypes("client_credentials", "authorization_code")
//                .scopes("app")
//                .authorities("ROLE_APP")
//                .redirectUris("http://localhost:8080/callback")
//                .secret(passwordEncoder().encode("123"))
//                .accessTokenValiditySeconds(60 * 30)
//                .refreshTokenValiditySeconds(60 * 60);
//    }
//
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        Map<String, PasswordEncoder> passwordEncoderMap = new HashMap<>();
//        passwordEncoderMap.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
//        return new DelegatingPasswordEncoder("noop", passwordEncoderMap);
//    }
}
