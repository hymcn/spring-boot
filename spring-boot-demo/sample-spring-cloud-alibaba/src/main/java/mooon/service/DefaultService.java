package mooon.service;

import mooon.api.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Value;


/**
 * @author Administrator
 * @date 2019/12/9.
 */
@Service(version = "${demo.service.version}")
public class DefaultService implements DemoService {

	@Value("${demo.service.name}")
	private String serviceName;

	public String sayName(String name) {
		RpcContext rpcContext = RpcContext.getContext();
		return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
				serviceName,
				rpcContext.getLocalPort(),
				rpcContext.getMethodName(),
				name,
				name);
	}
}