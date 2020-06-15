package la.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import la.bean.EmpBean;

class EmpDAOTest {

	@Test
	@DisplayName("DBへ接続できるか")
	void test() {
		try {
			EmpDAO dao = new EmpDAO();
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			fail();
		}
	}

	@Test
	@DisplayName("DBから一覧を取得し何件とれるか")
	void test2() {
		try {
			EmpDAO dao = new EmpDAO();
			List<EmpBean> list = dao.findAll();
			Assertions.assertEquals(6, list.size());

		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			fail();
		}

	}

}
