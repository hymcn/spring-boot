package mooon;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Administrator
 * @date 2019/12/16.
 */
@Component
public class MyFallbackProvider implements FallbackProvider {

	public String getRoute() {
		return "*";
	}

	public ClientHttpResponse fallbackResponse(String s, Throwable throwable) {
		return new ClientHttpResponse() {
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			public int getRawStatusCode() throws IOException {
				return 200;
			}

			public String getStatusText() throws IOException {
				return "OK";
			}

			public void close() {
			}

			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("fallback".getBytes());
			}

			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}


}
