package la.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemDAOTest extends ItemDAO {

	@Test
	@DisplayName("getConnectionメソッド")
	void test1() {
		ItemDAO dao = new ItemDAO();
		try {
			dao.getConnection();
			return;
		}catch{
			fail("まだ実装されていません");
		}
	}

}
