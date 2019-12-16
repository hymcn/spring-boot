package mooon.service;

import mooon.api.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author Administrator
 * @date 2019/12/9.
 */
@Service
public class DefaultService implements DemoService {

	public String sayName(String name) {
		RpcContext rpcContext = RpcContext.getContext();
		return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
				"DemoService",
				rpcContext.getLocalPort(),
				rpcContext.getMethodName(),
				name,
				name);
	}
}