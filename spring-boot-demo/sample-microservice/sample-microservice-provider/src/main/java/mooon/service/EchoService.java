package mooon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import mooon.api.IEchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author Administrator
 * @date 2019/12/18.
 */
@Service(version = "${v}")
@Slf4j
public class EchoService implements IEchoService {

	@HystrixCommand(fallbackMethod = "error")
	public String echo(String e) {
		log.error("call from remote: " + e);
		return e;
	}

	public String error(String e) {
		return "Error from provider: "+e;
	}
}
