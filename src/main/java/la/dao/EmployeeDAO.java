package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.EmployeeBean;

public class EmployeeDAO {

	private Connection con;

	public EmployeeDAO() throws DAOException {
		getConnection();
	}

	public void getConnection() throws DAOException {
		String url = "jdbc:postgresql:sample";
		String user = "student";
		String pass = "himitu";
		try {
			//データベースへの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new DAOException("接続に失敗しました。");
		}

	}

	public List<EmployeeBean> findAll() throws DAOException {
		if (con == null) {
			getConnection();
		}

		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		String sql = "SELECT * FROM emp";

		try (PreparedStatement st = con.prepareStatement(sql);) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");
				EmployeeBean bean = new EmployeeBean(code, name, age, tel);
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}

		return list;
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}

	}

}
