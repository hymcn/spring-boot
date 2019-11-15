package mooon;

import mooon.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author Administrator
 * @date 2019/11/11.
 */
@Controller
@EnableResourceServer
public class AdminController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/admin/home")
	public String home(ModelMap modelMap, Principal principal){
		modelMap.put("title", "Home pages");
		modelMap.put("username", principal.getName());
		return "home";
	}

	@ResponseBody
	@RequestMapping("/index")
	public ModelMap index(ModelMap modelMap){
		modelMap.put("title", "Home pages");
		return modelMap;
	}
}
