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

	public void setEmp(String name, String age, String tel) throws DAOException {
		if (con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//sql文の完成
			String sql = "SELECT * FROM emp";
			String sql2 = "INSERT INTO emp(code,name,age, tel) VALUES(?,?,?,?)";
			//オブジェクトの取得
			st = con.prepareStatement(sql);
			//SQLの実行
			rs = st.executeQuery();
			//最新の番号取得
			int code = 0;
			while (rs.next()) {
				code = rs.getInt("code");
			}
			st = con.prepareStatement(sql2);
			//プレースホルダーに値を入れる
			st.setInt(1, code + 1);
			st.setString(2, name);
			int ageInt = Integer.parseInt(age);
			st.setInt(3, ageInt);
			st.setString(4, tel);
			int rows = st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの登録に失敗しました");
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

	public void updateEmp(String code, String name, String age, String tel) throws DAOException {

		if (con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//sql文の完成
			String sql = "SELECT * FROM emp Where code=?";
			String sql2 = "UPDATE emp SET name=? age = ?  tel=? WHERE code = ?";

			//オブジェクトの取得
			st = con.prepareStatement(sql);
			int codeInt = Integer.parseInt(code);
			st.setInt(1, codeInt);

			//SQLの実行
			rs = st.executeQuery();

			rs.next();
			if (name == null || name.isEmpty()) {
				name = rs.getString("name");
			}

			if (age == null || age.isEmpty()) {
				age = rs.getString("age");
			}

			if (tel == null || tel.isEmpty()) {
				tel = rs.getString("tel");
			}

			st = con.prepareStatement(sql2);
			st.setString(1, name);
			int ageInt = Integer.parseInt(age);
			st.setInt(2, ageInt);
			st.setString(3, tel);
			st.setString(4, code);

			//プレースホルダーに値を入れる
			int rows = st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの登録に失敗しました");
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
}
