package la.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemDAOTest {

	//	@Test
	//	@DisplayName("getConnectionメソッド")
	//	void test1() throws DAOException {
	//		ItemDAO dao = new ItemDAO();
	//		try {
	//			dao.getConnection();
	//			return;
	//		} catch (Exception e) {
	//			fail();
	//		}
	//	}

	//	@Test
	//	@DisplayName("findAllメソッドの動作確認")
	//	void test2() {
	//		try {
	//			ItemDAO dao = new ItemDAO();
	//			List<ItemBean> list = dao.findAll();
	//			//			System.out.println(list);
	//
	//			ItemBean[] b = new ItemBean[list.size()];
	//			for (int i = 0; i < list.size(); i++) {
	//				b[i] = list.get(i);
	//				System.out.println(
	//						b[i].getCode() + ":" + b[i].getName()
	//								+ ":" + b[i].getAge() + ":" + b[i].getTel());
	//
	//			}
	//
	//			return;
	//		} catch (DAOException e) {
	//			fail();
	//		}
	//
	//	}

	@Test
	@DisplayName("addDataメソッドの動作確認")
	void test3() {
		try {
			ItemDAO dao = new ItemDAO();
			Assertions.assertEquals(1, dao.addData("亀田", 25, "111-111-1111"));

			//			System.out.println(list);

			return;
		} catch (DAOException e) {
			fail();
		}

	}

}
