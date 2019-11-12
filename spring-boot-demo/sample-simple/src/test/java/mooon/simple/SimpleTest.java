package mooon.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @date 2019/11/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SimpleTest {

    @Test
    public void testA(){
      log.info("test A");
    }
}
