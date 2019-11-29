package mooon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Administrator
 * @date 2019/11/28.
 */
@RestController
public class AController {

	WebClient client = WebClient.create("http://localhost");

	@RequestMapping("/api/a")
	public String a(){
		return "a";
	}

	@RequestMapping("/api/b")
	public Mono<String> b(){
		Mono<String> resp = client.get().uri("/api/a").retrieve().bodyToMono(String.class);
		resp.subscribe(System.out::println);
		return resp.map(x-> String.format("response from %s", x));
	}

	@RequestMapping("/api/admin")
	public Mono<String> c(){
		return Mono.just("admin");
	}
}
