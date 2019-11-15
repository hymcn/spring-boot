package mooon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Administrator
 * @date 2019/11/14.
 */
@RestController
public class UserController {

    @RequestMapping("/api/userinfo")
    public Principal userInfo(Principal principal){
        return principal;
    }

}
