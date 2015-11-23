import org.ff4j.FF4j;

public class First {

	class Target {
		final FF4j ff4j;

		public Target(FF4j ff4j) {
			this.ff4j = ff4j;
		}

		public String greeting() {
			if (ff4j.check("welcome")) {
				return "Hi";
			}
			return "goodbye";
		}
	}

	@org.junit.Test
	public void check() throws Exception {
		Target t = new Target(new FF4j("ff4j.xml"));
		org.junit.Assert.assertEquals("Hi", t.greeting());
	}
}
