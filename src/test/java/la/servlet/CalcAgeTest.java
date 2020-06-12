package la.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalcAgeTest extends CalcAge {

	@Test
	void test() {
		CalcAge c = new CalcAge();
		int a = c.howOld(1981, 4, 17);
		Assertions.assertEquals(39, a);
	}

}
