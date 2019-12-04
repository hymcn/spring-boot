package mooon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Administrator
 * @date 2019/12/3.
 */
@FeignClient(name = "service-provider")
public interface EchoService {

	@GetMapping(value = "/echo/{str}")
	String echo(@PathVariable("str") String str);

}