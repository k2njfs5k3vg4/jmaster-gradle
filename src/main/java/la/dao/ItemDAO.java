package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ItemDAO {

	private Connection con;

	public  void getConnection() throws DAOException{
		try {
			// 初期設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";

			// DBへの接続
			con = DriverManager.getConnection(url, user, pass);
		}catch(Exception e) {
			throw new DAOException("接続に失敗");
		}

	}

}
