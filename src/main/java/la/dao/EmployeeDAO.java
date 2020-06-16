package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.EmpBean;

public class EmployeeDAO {
	private final String url = "jdbc:postgresql:sample";
	private final String user = "student";
	private final String pass = "himitu";

	public List<EmpBean> findAll() throws DAOException {
		String sql = "SELECT * FROM emp";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {

			List<EmpBean> list = new ArrayList<EmpBean>();
			while (rs.next()) {
				EmpBean bean = new EmpBean(rs.getInt("code"), rs.getString("name"), rs.getInt("age"),
						rs.getString("tel"));
				list.add(bean);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("データベースの操作に失敗しました。" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("error" + e.getMessage());
		}
	}

	public EmpBean find(int code) throws DAOException {
		String sql = "SELECT * FROM emp where code=?";
		EmpBean bean = null;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, code);

			try (ResultSet rs = st.executeQuery();) {

				while (rs.next()) {
					bean = new EmpBean(rs.getInt("code"), rs.getString("name"), rs.getInt("age"),
							rs.getString("tel"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("データベースの操作に失敗しました。" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("error" + e.getMessage());
		}

		return bean;
	}

	public EmpBean add(int code, String name, int age, String tel) throws DAOException {

		String sql = "INSERT INTO emp(code,name,age,tel) VALUES(?,?,?,?)";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, code);
			st.setString(2, name);
			st.setInt(3, age);
			st.setString(4, tel);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("データベースの操作に失敗しました。" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("error" + e.getMessage());
		}

		return this.find(code);

	}

	public void delete(int code) throws DAOException {

		String sql = "DELETE FROM emp where code=?";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, code);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("データベースの操作に失敗しました。" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("error" + e.getMessage());
		}
	}

	public EmpBean update(int code, String name, int age, String tel) throws DAOException {
		this.delete(code);
		return this.add(code, name, age, tel);

	}

}
