package edu.bcp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import edu.bcp.config.AppConfig;

@ContextConfiguration(classes = AppConfig.class)
@SpringBootTest
class AppConfigTest {

	@Test
	void contextLoads() {
	}

}
