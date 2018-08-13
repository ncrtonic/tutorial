package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.study.model.User;

public class UserDao {
	private Connection conn;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "JAVA";
	private static final String PW = "1111";

	public Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(URL, USER, PW);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public User confirmUser(String userid, String pw) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		if (conn != null) {
			String sql = "select userid, pw, name, email from todo_user where userid=? and pw=?";

			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, userid);
				ps.setString(2, pw);

				rs = ps.executeQuery();

				if (rs.next()) {
					String name = rs.getString(3);
					String email = rs.getString(4);
					User user = new User();
					user.setUserid(userid);
					user.setPw(pw);
					user.setName(name);
					user.setEmail(email);

					return user;
				} else {
					return null;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return null;
	}

	public boolean addUser(User user) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int result;

		if (conn != null && user != null) {
			String sql = "insert into todo_user values (?,?,?,?)";

			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getUserid());
				ps.setString(2, user.getPw());
				ps.setString(3, user.getName());
				ps.setString(4, user.getEmail());

				result = ps.executeUpdate();

				if (result == 0) {
					return false;
				} else {
					return true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	public boolean idCheck(String id) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		if (conn != null) {
			String sql = "select userid from todo_user where userid=(?)";

			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();

				while (rs.next()) {
					if (rs.getString("userid").equals(id)) {
						return true;
					} else {
						return false;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

		return false;
	}

	// public boolean delUser(String id, String pw) {
	//
	// Connection conn = getConnection();
	// PreparedStatement ps = null;
	// int result;
	//
	// if(conn != null && pw != null) {
	// String sql = " delete todo_user where id=(?) and pw=(?)";
	//
	// try {
	// ps = conn.prepareStatement(sql);
	// result = ps.executeUpdate();
	//
	// if (result == 0 ) {
	// return false;
	// }
	// TodoDao dao = new TodoDao();
	// if (dao.delTodo()) {
	// return true;
	// } else {
	// return false;
	// }
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// return false;
	// }
}
