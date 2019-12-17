package mooon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/12/16.
 */
@RestController
public class DemoContoller {

	@RequestMapping("/downstream/index")
	public String index(){
		return "index";
	}

	@RequestMapping("/user/others")
	public String others(){
		return "others";
	}

}
