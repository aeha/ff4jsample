package hello;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.ff4j.FF4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class HelloControllerIT {

	@Autowired
	FF4j ff4j;

	@Value("${local.server.port}")
	int port;

	URL base;
	RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		this.template = new TestRestTemplate();
	}

	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toURI(),
				String.class);
		assertEquals("Hello", response.getBody());
	}
}
