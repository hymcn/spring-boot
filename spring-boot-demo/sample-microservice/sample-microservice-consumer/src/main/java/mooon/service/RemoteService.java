package mooon.service;

import mooon.api.IEchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author Administrator
 * @date 2019/12/18.
 */
@Component
public class RemoteService {

	@Reference(version = "${v}", check = false)
	IEchoService iEchoService;

	public String echo(String e){
		return iEchoService.echo(e);
	}
}
