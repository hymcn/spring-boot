package mooon;

import lombok.extern.slf4j.Slf4j;
import mooon.service.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Administrator
 * @date 2019/11/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.jmx.enabled:true",
		"spring.datasource.jmx-enabled:true" })
@Slf4j
@ActiveProfiles("test")
public class RepositoryTest {

	@Autowired
	UserRepository userRepository;


	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testJmx() throws Exception {
		assertThat(ManagementFactory.getPlatformMBeanServer()
				.queryMBeans(new ObjectName("jpa.sample:type=HikariDataSource,*"), null))
				.hasSize(1);
	}


	@Test
	public void testAA() {
		log.info("a Test");
	}

	@Test
	public void testFindAll(){
		List datas = userRepository.findAll();
		log.info(datas.toString());
	}
}
