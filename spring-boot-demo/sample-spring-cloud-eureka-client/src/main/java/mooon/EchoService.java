package mooon;

import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2019/12/9.
 */
@Service
public class EchoService {

	public String echo(String req){
		return req;
	}

}
