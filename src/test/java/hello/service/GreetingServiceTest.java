package hello.service;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@org.junit.runner.RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = hello.Application.class)
public class GreetingServiceTest {

	@Autowired
	org.ff4j.FF4j ff4j;

	@Autowired
	@Qualifier("greeting.default")
	GreetingService target;

	@org.junit.Test
	public void test() {
		assertEquals("Hello", this.target.sayHello());
		this.ff4j.enable("new-year-greeting");
		assertEquals("Happy New Year!!", this.target.sayHello());
	}
}
