package la.dao;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import la.bean.ItemBean;

class ItemDAOTest extends ItemDAO {

	//	@Test
	//	@DisplayName("getConnectionメソッド")
	//	void test1() {
	//		ItemDAO dao = new ItemDAO();
	//		try {
	//			dao.getConnection();
	//			return;
	//		}catch{
	//			fail("まだ実装されていません");
	//		}
	//	}

	public ItemDAOTest() throws DAOException {
		super();
	}

	@Test
	@DisplayName("getConnectionメソッド")
	void test1() {
		try {
			ItemDAO dao = new ItemDAO();
			List<ItemBean> list = dao.findAll();

		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
