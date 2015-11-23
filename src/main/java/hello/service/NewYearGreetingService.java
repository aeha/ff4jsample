package hello.service;

@org.springframework.stereotype.Component("greeting.newyear")
public class NewYearGreetingService implements GreetingService {
	@Override
	public String sayHello() {
		return "Happy New Year!!";
	}
}
