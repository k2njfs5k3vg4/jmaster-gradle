package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ItemBean;

public class ItemDAO {

	private Connection con;

	public ItemDAO() throws DAOException {
		getConnection();
	}

	public void getConnection() throws DAOException {
		try {
			// 初期設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";

			// DBへの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new DAOException("接続に失敗");
		}

	}

	public List<ItemBean> findAll() throws DAOException {
		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//SQL文の作成
			String sql = "select * from emp";

			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");
				ItemBean bean = new ItemBean(code, name, age, tel);
				list.add(bean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				//リソースの解放
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				close();

			} catch (Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

}
