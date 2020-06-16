package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.EmployeeBean;

public class EmployeeDAO2 {

	private Connection con;

	public EmployeeDAO2() throws DAOException {
		getConnection();
	}

	public void getConnection() throws DAOException {
		String url = "jdbc:postgresql:sample";
		String user = "student";
		String pass = "himitu";
		try {
			//データベースへの接続
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
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

	public int addEmployee(int code, String name, int age, String tel) throws DAOException {
		// TODO 自動生成されたメソッド・スタブ
		if (con == null)
			getConnection();

		String sql = "INSERT INTO emp VALUES(?,?,?,?)";
		//		PreparedStatement st = null;

		try (PreparedStatement st = con.prepareStatement(sql)) {

			st.setInt(1, code);
			st.setString(2, name);
			st.setInt(3, age);
			st.setString(4, tel);

			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public void deleteByPrimaryKey(int code) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
