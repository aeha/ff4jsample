import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.ff4j.FF4j;
import org.junit.Test;

public class Expression {

	@Test
	public void test() throws Exception {
		FF4j ff4j = new FF4j("ff4j-el.xml");
		assertFalse(ff4j.check("climbing"));
		assertFalse(ff4j.check("skiing"));
		ff4j.enable("morning");
		assertTrue(ff4j.check("climbing"));
		assertTrue(ff4j.check("skiing"));
	}
}
