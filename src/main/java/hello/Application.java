package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Import(FF4JConfig.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RestController
	public static class HelloController {

		@Autowired
		@Qualifier("greeting.default")
		hello.service.GreetingService greeting;

		@RequestMapping("/")
		public String index() {
			return greeting.sayHello();
		}
	}
}
