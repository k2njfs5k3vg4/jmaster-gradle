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

			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");

			// 初期設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";

			// DBへの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new DAOException("接続に失敗", e);
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
			throw new DAOException("レコードの取得に失敗しました。", e);
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
				throw new DAOException("リソースの解放に失敗しました。", e);
			}
		}
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

	public int addData(String name, int age, String tel) throws DAOException {
		if (con == null) {
			getConnection();
		}

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;

		ResultSet rs = null;

		try {
			//SQL文の作成
			String sql1 = "insert into emp(code,name,age,tel) values(?,?,?,?)";

			//現在の最終行codeを持ってくる
			String sql2 = "select * from emp order by code desc";
			st2 = con.prepareStatement(sql2);
			rs = st2.executeQuery();
			rs.next();
			int codeMax = rs.getInt("code");

			//PreparedStatementオブジェクトの取得
			st1 = con.prepareStatement(sql1);
			st1.setInt(1, codeMax + 1);
			st1.setString(2, name);
			st1.setInt(3, age);
			st1.setString(4, tel);

			int rows = st1.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの追加に失敗しました。", e);
		} finally {
			try {
				//リソースの解放
				if (st1 != null) {
					st1.close();
				}
				if (st2 != null) {
					st2.close();
				}
				if (rs != null) {
					rs.close();
				}

				close();

			} catch (Exception e) {
				throw new DAOException("リソースの解放に失敗しました。", e);
			}
		}
	}

	public int deleteData(int code) throws DAOException {
		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		try {
			//SQL文の作成
			String sql = "delete from emp where code = ?";

			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 削除するcode番号の設定
			st.setInt(1, code);

			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの削除に失敗しました。", e);
		} finally {
			try {
				//リソースの解放
				if (st != null) {
					st.close();
				}
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの解放に失敗しました。", e);
			}
		}
	}

	public List<ItemBean> findByAge(int leAge) throws DAOException {
		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//SQL文の作成
			String sql = "select * from emp where age <= ?";

			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 年齢のセット
			st.setInt(1, leAge);
			// SQL実行
			rs = st.executeQuery();
			// 結果の取得
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
			throw new DAOException("レコードの検索に失敗しました。", e);
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
				throw new DAOException("リソースの解放に失敗しました。", e);
			}
		}
	}

	public int updateData(int code) throws DAOException {
		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		try {
			//SQL文の作成
			String sql = "delete from emp where code = ?";

			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 削除するcode番号の設定
			st.setInt(1, code);

			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの削除に失敗しました。", e);
		} finally {
			try {
				//リソースの解放
				if (st != null) {
					st.close();
				}
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの解放に失敗しました。", e);
			}
		}
	}


}
