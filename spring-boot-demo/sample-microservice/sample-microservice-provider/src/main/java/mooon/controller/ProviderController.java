package mooon.controller;

import mooon.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/12/19.
 */
@RestController
public class ProviderController {

	@Autowired
	EchoService echoService;

	@RequestMapping("/backend/echo/{e}")
	public String backendEcho(@PathVariable(name = "e") String e){
		return echoService.echo(e);
	}
}
