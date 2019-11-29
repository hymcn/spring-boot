package mooon.router;

import mooon.handler.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebHandler;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;


/**
 * @author Administrator
 * @date 2019/11/28.
 */
@Configuration
public class MainRouter {

	@Bean
	RouterFunction<ServerResponse> indexRoute(MyHandler myHandler) {
		return RouterFunctions.route(GET("/api/f1"), myHandler::indexHandler);
	}

}
