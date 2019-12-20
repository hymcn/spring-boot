package mooon;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @date 2019/12/16.
 */
@Configuration
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class RibbonConfiguration {

	///// default ribbon beans for overwrite ////

	// ribbonClientConfig
	// ribbonRule
 	// ribbonPing
	// ribbonServerList
	// ribbonServerListFilter
	// ribbonLoadBalancer
	// ribbonServerListUpdater

	@Bean
	public ZonePreferenceServerListFilter serverListFilter() {
		ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
		filter.setZone("demoZone");
		return filter;
	}
	@Bean
	public IPing ribbonPing() {
		return new PingUrl();
	}
}
