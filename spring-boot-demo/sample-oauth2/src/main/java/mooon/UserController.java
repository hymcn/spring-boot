package mooon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Administrator
 * @date 2019/11/12.
 */
@RestController
@Slf4j
public class UserController {

    @RequestMapping("/who")
    public Principal getLoginUser(Principal principal){
        return principal;
    }

    @RequestMapping("/abc")
    public String abc(){
        return "abc";
    }

    @RequestMapping("/callback")
    public String callback(String state, String code) {
        log.info("code: {}, state: {}", code, state);
        return "get token success";
    }
}
