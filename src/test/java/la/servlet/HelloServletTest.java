package la.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloServletTest {

	@Test
	void test() {
		Assertions.assertEquals("私 です", HelloServlet.introduce("私"));
	}

}
