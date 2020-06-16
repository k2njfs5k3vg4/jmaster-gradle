package la.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import la.bean.ItemBean;

class ItemDAOTest  {


		@Test
		@DisplayName("getConnectionメソッド")
		void test1() throws DAOException{
			ItemDAO dao = new ItemDAO();
			try {
				dao.getConnection();
				return;
			}catch(Exception e){
				fail();
			}
		}


	@Test
	@DisplayName("findAllメソッドの動作確認")
	void test2() {
		try {
			ItemDAO dao = new ItemDAO();
			List<ItemBean> list = dao.findAll();
//			System.out.println(list);
			return;
		} catch (DAOException e) {
			fail();
		}

	}

}
