package la.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import la.bean.EmpBean;

class EmployeeDAOTest extends EmployeeDAO {

	@Test
	void test() {
		EmployeeDAO e = new EmployeeDAO();
		try {
			List<EmpBean> list = e.findAll();

			Assertions.assertEquals(1, list.get(0).getCode());
			Assertions.assertEquals("木間", list.get(0).getName());
			Assertions.assertEquals(24, list.get(0).getAge());
			Assertions.assertEquals("080-1111-1111", list.get(0).getTel());

			Assertions.assertEquals(2, list.get(1).getCode());
			Assertions.assertEquals("鈴木", list.get(1).getName());
			Assertions.assertEquals(30, list.get(1).getAge());
			Assertions.assertEquals("080-2222-2222", list.get(1).getTel());

		} catch (Exception e2) {
			fail();
		}
	}

	@BeforeEach
	void test1() {
		String url = "jdbc:postgresql:sample";
		String user = "student";
		String pass = "himitu";

		String sql = "DELETE FROM emp";
		String sql2 = "INSERT INTO emp VALUES(1,'木間',24,'080-1111-1111')";
		String sql3 = "INSERT INTO emp VALUES(2,'鈴木',30,'080-2222-2222')";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				PreparedStatement st2 = con.prepareStatement(sql2);
				PreparedStatement st3 = con.prepareStatement(sql3);) {

			st.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
