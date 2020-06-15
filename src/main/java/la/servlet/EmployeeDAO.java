package la.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

	private Connection con;

	//	public EmployeeDAO() throws DAOException {
	//		getConnection();
	//	}

	public /*List<EmployeeBean>*/ String findAll() throws DAOException{
		if(con == null) {
			getConnection();

		}
		String sql = "SELECT * FROM emp";

		try (PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();){
			close();
		}catch(Exception e){
			//				throw new DAOException("レコード取得に失敗しました");
			return "レコード取得に失敗しました";
		}

		return sql;



	}

	private void getConnection() throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";

			con = DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			throw new DAOException("接続に失敗しました");
		}
	}

	private void close() throws SQLException{
		if (con != null) {
			con.close();
			con = null;
		}
	}
}
