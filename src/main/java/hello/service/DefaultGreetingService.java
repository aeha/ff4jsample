package hello.service;

@org.springframework.stereotype.Component("greeting.default")
public class DefaultGreetingService implements GreetingService {
	@Override
	public String sayHello() {
		return "Hello";
	}
}
