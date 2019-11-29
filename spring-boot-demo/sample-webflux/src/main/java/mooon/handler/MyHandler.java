package mooon.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.reactive.function.BodyExtractors.toDataBuffers;
import static org.springframework.web.reactive.function.BodyExtractors.toFormData;
import static org.springframework.web.reactive.function.server.EntityResponse.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author Administrator
 * @date 2019/11/28.
 */
@Slf4j
@Component
public class MyHandler {

	public Mono<ServerResponse> indexHandler(ServerRequest request) {
		return ServerResponse.ok().body(Mono.just("index"), String.class);
	}
}
