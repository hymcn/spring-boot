package mooon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * @date 2019/12/18.
 */
@FeignClient("sample-microservice-app-provider")
public interface RemoteFeignService {

	@RequestMapping("/backend/echo/{str}")
	String echo(@RequestParam(name = "str") String str);

}
