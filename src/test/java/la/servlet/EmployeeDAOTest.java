package la.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeDAOTest {

	//	@Test
	//	void test() throws DAOException {
	//		EmployeeDAO dao = new EmployeeDAO();
	//		Assertions.assertTrue(dao.getConnection());
	//	}
	//
	//	@Test
	//	void test1() {
	//		EmployeeDAO dao;
	//		try {
	//			dao = new EmployeeDAO();
	//			Assertions.assertFalse(dao.getConnection());
	//		} catch (DAOException e) {
	//			return;
	//		}fail();
	//
	//	}

	@Test
	void test() throws DAOException {
		EmployeeDAO dao = new EmployeeDAO();
		Assertions.assertEquals("SELECT * FROM emp",dao.findAll());
	}

}
