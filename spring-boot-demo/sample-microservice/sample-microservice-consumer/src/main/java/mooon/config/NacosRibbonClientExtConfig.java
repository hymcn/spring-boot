package mooon.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Administrator
 * @date 2019/12/20.
 */
@Configuration
public class NacosRibbonClientExtConfig {

	@Bean
	public ServerList<?> nacosRibbonServerList(IClientConfig clientConfig, NacosDiscoveryProperties nacosDiscoveryProperties) {
		NacosRibbonServerList serverList = new NacosRibbonServerList(nacosDiscoveryProperties);
		serverList.initWithNiwsConfig(clientConfig);
		return serverList;
	}

}
