package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.EmpBean;

public class EmpDAO {

	private Connection con;

	public EmpDAO() throws DAOException {
		getConnection();
	}

	private void getConnection() throws DAOException {
		// TODO 自動生成されたメソッド・スタブ
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//URL,user.passの設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";
			//DBへの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new DAOException("接続に失敗しました");
		}

	}

	public List<EmpBean> findAll() throws DAOException {
		if (con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//sql文の完成
			String sql = "SELECT * FROM emp";
			//オブジェクトの取得
			st = con.prepareStatement(sql);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得および表示
			List<EmpBean> list = new ArrayList<EmpBean>();
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");
				EmpBean bean = new EmpBean(code, name, age, tel);
				list.add(bean);
			}
			//社員一覧をListとして返す
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				//リソースの開放
				if (rs != null)
					rs.close();
				if (rs != null)
					st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソース」のか開放に失敗しました");
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
