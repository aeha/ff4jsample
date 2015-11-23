import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.ff4j.FF4j;
import org.junit.Test;

public class Group {

	@Test
	public void test() throws Exception {
		FF4j ff4j = new FF4j("ff4j-group.xml");
		assertFalse(ff4j.check("sun"));
		assertFalse(ff4j.check("bay"));
		ff4j.enableGroup("summer");
		assertTrue(ff4j.check("sun"));
		assertTrue(ff4j.check("bay"));
	}
}
