package hello;

import org.ff4j.FF4j;
import org.ff4j.web.api.FF4JProvider;
import org.ff4j.web.embedded.ConsoleServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.ff4j.aop")
public class FF4JConfig {

	@Bean
	public FF4j ff4j() {
		return new FF4j().autoCreate(true);
	}

	@Bean
	public ServletRegistrationBean console(FF4j ff4j) {
		Provider.ff4j = ff4j;
		ServletRegistrationBean srb = new ServletRegistrationBean(
				new ConsoleServlet(), "/ff4j-console");
		srb.addInitParameter("ff4jProvider", Provider.class.getName());
		return srb;
	}

	public static class Provider implements FF4JProvider {
		static FF4j ff4j;

		@Override
		public FF4j getFF4j() {
			return ff4j;
		}
	}
}
