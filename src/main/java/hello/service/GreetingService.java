package hello.service;

@org.ff4j.aop.Flip(name = "new-year-greeting", alterBean = "greeting.newyear")
public interface GreetingService {

	String sayHello();
}
