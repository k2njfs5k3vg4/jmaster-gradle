package la.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import la.bean.EmployeeBean;

class EmployeeDAOTest {

	//	@Test
	//	@DisplayName("getConnectionメソッドによるDAOExceptionの確認")
	//	void test1() {
	//		EmployeeDAO dao = new EmployeeDAO();
	//		try {
	//			dao.getConnection();
	//		} catch (DAOException e) {
	//			e.printStackTrace();
	//			return;
	//		}
	//		fail();
	//	}

	@Test
	@DisplayName("コンストラクタを介したgetConnectionメソッドによるデータベース接続の確認")
	void test2() throws DAOException {
		EmployeeDAO dao = new EmployeeDAO();
		//		try {
		//			dao.getConnection();
		//		} catch (DAOException e) {
		//			e.printStackTrace();
		//			fail();
		//		}
	}

	//	@Test
	//	@DisplayName("findAllメソッドのreturnの確認")
	//	void test3() throws DAOException {
	//		try {
	//			EmployeeDAO dao = new EmployeeDAO();
	//			List<EmployeeBean> list = dao.findAll();
	//		} catch (DAOException e) {
	//			e.printStackTrace();
	//			fail();
	//		}
	//	}
	//	@Test
	//	@DisplayName("findAllメソッドからのエクセプション取得")
	//	void test4() throws DAOException {
	//		try {
	//			EmployeeDAO dao = new EmployeeDAO();
	//			List<EmployeeBean> list = dao.findAll();
	//		} catch (DAOException e) {
	//			e.printStackTrace();
	//			return;
	//		}
	//		fail();
	//	}

	//	@Test
	//	@DisplayName("findAllメソッドからの、SQLの実行結果の取得")
	//	void test5() throws DAOException {
	//		try {
	//			EmployeeDAO dao = new EmployeeDAO();
	//			List<EmployeeBean> list = dao.findAll();
	//			Assertions.assertEquals(1, list.get(0).getCode());
	//			Assertions.assertEquals("鈴木", list.get(0).getName());
	//			Assertions.assertEquals(30, list.get(0).getAge());
	//			Assertions.assertEquals("03-1111-1111", list.get(0).getTel());
	//		} catch (DAOException e) {
	//			e.printStackTrace();
	//			fail();
	//		}
	//	}
	@Test
	@DisplayName("findAllメソッドから全件取得できているか否かの確認")
	void test5() throws DAOException {
		try {
			EmployeeDAO dao = new EmployeeDAO();
			List<EmployeeBean> list = dao.findAll();
			Assertions.assertEquals(6, list.size());
		} catch (DAOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
