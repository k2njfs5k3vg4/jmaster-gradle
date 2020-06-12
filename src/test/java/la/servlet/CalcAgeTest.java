package la.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalcAgeTest extends CalcAge {

	@Test
	void test() {
		CalcAge c = new CalcAge();
		int age = c.howOld(1997, 06, 12);

		Assertions.assertEquals(23, age);
	}

}
