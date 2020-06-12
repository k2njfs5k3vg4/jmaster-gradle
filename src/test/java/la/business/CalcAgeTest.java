package la.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalcAgeTest extends CalcAge {

	@Test
	void test() {
		CalcAge c=new CalcAge();
		//c.howOld(1994,7,4);

		Assertions.assertEquals(25,c.howOld(1994, 7, 4));
	}

}
