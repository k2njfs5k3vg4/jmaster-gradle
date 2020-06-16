package la.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	private Connection con;

	//	public EmployeeDAO() throws DAOException {
	//		getConnection();
	//	}

	public List<EmployeeBean> findAll() throws DAOException {
		if (con == null) {
			getConnection();

		}
		String sql = "SELECT * FROM emp ORDER BY code";

		try (PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<EmployeeBean> list = new ArrayList<EmployeeBean>();
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");
				EmployeeBean bean = new EmployeeBean(code, name, age, tel);
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			throw new DAOException("レコード取得に失敗しました");
		} finally {
			try {
				close();

			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}

	private void getConnection() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";

			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new DAOException("接続に失敗しました");
		}
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

	public void addEmployee(int code, String name, int age, String tel) throws DAOException {
		if (con == null) {
			getConnection();

		}
		String sql = "INSERT INTO emp VALUES(?,?,?,?)";

		try (PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, code);
			st.setString(2, name);
			st.setInt(3, age);
			st.setString(4, tel);
			int rows = st.executeUpdate();
			System.out.println(rows + "件追加");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close();

			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}

	public void deleteEmployee(int code) throws DAOException {
		if (con == null) {
			getConnection();

		}
		String sql = "Delete FROM emp WHERE code=?";

		try (PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, code);
			int rows = st.executeUpdate();
			System.out.println(rows + "件削除");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close();

			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました");
			}
		}

	}

	public void updateEmployee(int code, String name, int age, String tel) throws DAOException {
		if (con == null) {
			getConnection();

		}
		String select_sql = "SELECT * FROM emp WHERE code=?";
		String update_sql = "UPDATE emp SET name=?,age=?,tel=? WHERE code=?";

		try (PreparedStatement st1 = con.prepareStatement(select_sql);
				PreparedStatement st2 = con.prepareStatement(update_sql);) {
			st1.setInt(1, code);
			ResultSet rs = st1.executeQuery();
			rs.next();

			// selectで取得したレコードをbeanに一時格納
			EmployeeBean bean = new EmployeeBean(rs.getInt("code"), rs.getString("name"),
					rs.getInt("age"), rs.getString("tel"));

			rs.close();

			// 任意のフィールドの上書き
			if (code != 0) {
				bean.setCode(code);
			}
			if (!"".equals(name)) {
				bean.setName(name);
			}
			if (age != 0) {
				bean.setAge(age);
			}
			if (!"".equals(tel)) {
				bean.setTel(tel);
			}

			// st2(update)のプレースホルダ設定をbeanで処理
			st2.setString(1, bean.getName());
			st2.setInt(2, bean.getAge());
			st2.setString(3, bean.getTel());
			st2.setInt(4, bean.getCode());

			int rows = st2.executeUpdate();
			System.out.println(rows + "件更新");
		} catch (Exception e) {
			throw new DAOException("レコード取得に失敗しました");
		} finally {
			try {
				close();

			} catch (SQLException e) {
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}
}
