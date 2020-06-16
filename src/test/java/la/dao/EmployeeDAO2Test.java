package la.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeDAO2Test {

	//	@Test
	//	@DisplayName("deleteByPrimaryKeyメソッドの戻り値確認")
	//	void test() {
	//		try {
	//			EmployeeDAO2 dao = new EmployeeDAO2();
	//			int res = dao.deleteByPrimaryKey(100);
	//			Assertions.assertEquals(res, 100);
	//		} catch (DAOException e) {
	//			e.printStackTrace();
	//			fail();
	//		}
	//
	//	}

	@Test
	@DisplayName("deleteByPrimaryKeyメソッドによる削除の動作確認")
	void test2() {
		try {
			EmployeeDAO2 dao = new EmployeeDAO2();
			int res = dao.deleteByPrimaryKey(100);
			Assertions.assertEquals(res, 1);
		} catch (DAOException e) {
			e.printStackTrace();
			fail();
		}

	}

	//	@BeforeAll
	//	@DisplayName("削除したデータのインサート")
	//	static void test3() {
	//		try {
	//			EmployeeDAO2 dao = new EmployeeDAO2();
	//			dao.addEmployee(100, "liang", 27, "080-5555-5555");
	//		} catch (DAOException e) {
	//			// TODO 自動生成された catch ブロック
	//			e.printStackTrace();
	//		}
	//
	//	}

}
