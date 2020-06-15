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

}
