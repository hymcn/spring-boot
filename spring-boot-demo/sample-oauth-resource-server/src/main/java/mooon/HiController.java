package mooon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/11/15.
 */
@RestController
public class HiController {

    @RequestMapping("/api/a")
    public String a(){
        return "a";
    }

    @RequestMapping("/api/b")
    public String b(){
        return "b";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
