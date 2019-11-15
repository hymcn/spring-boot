package mooon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/11/15.
 */
@RestController
public class MyController {

    @Autowired
    OAuth2RestTemplate  oAuth2RestTemplate;

    @RequestMapping("/token")
    public OAuth2AccessToken token(){
        return oAuth2RestTemplate.getAccessToken();
    }

}
