package org.study.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.study.model.Todo;

public class TodoDao {
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
	
	public boolean addTodo(Todo todo) {
		
		
		Connection conn = getConnection();
		PreparedStatement ps = null;
		
	
		if (conn != null) {
			String sql = "insert into todo_list values (todo_idx.nextval,?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, todo.getUserid());
				ps.setDate(2, todo.getS_date());
				ps.setDate(3, todo.getE_date());
				ps.setString(4, todo.getMemo());
				
				int result = ps.executeUpdate();
				if (result == 0) {
					return false;
				} else {
					return true;
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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
	
	public Todo[] myTodo(String id) {
		
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cnt = 0;
		if (conn != null) {
			String sql = "select * from todo_list where userid = (?)";
			try {
				ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ps.setString(1, id);
				rs = ps.executeQuery();

					rs.last();
					Todo[] todo = new Todo[rs.getRow()];
					rs.beforeFirst();
					while (rs.next()) {
						Todo td = new Todo();
						td.setIdx(rs.getString("idx"));
						td.setUserid(rs.getString("userid"));
						td.setS_date(rs.getDate("s_date"));
						td.setE_date(rs.getDate("e_date"));
						td.setMemo(rs.getString("memo"));
					
					todo[cnt] = td;
					cnt++;
					}
					System.out.println(Arrays.toString(todo));
					return todo;
				
				
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
		return null;
	}
	public Todo findTodo(String idx) {
		
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Todo todo = new Todo();
		
		if (conn != null) {
			String sql = "select * from todo_list where idx=(?)";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, idx);
				rs = ps.executeQuery();
				rs.next();
				todo.setIdx(idx);
				todo.setS_date(rs.getDate("S_date"));
				todo.setE_date(rs.getDate("E_date"));
				todo.setMemo(rs.getString("memo"));
				
				return todo;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ps != null) {
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
		
		return null;
	}
	
	public boolean updateTodo(Todo todo) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		
	
		if (conn != null) {
			String sql = "update todo_list set s_date = ?, e_date = ?, memo=? where idx= ?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setDate(1, todo.getS_date());
				ps.setDate(2, todo.getE_date());
				ps.setString(3, todo.getMemo());
				System.out.println(todo.getIdx());
				ps.setInt(4, Integer.parseInt(todo.getIdx()));

				
				int result = ps.executeUpdate();
				if (result == 0) {
					return false;
				} else {
					return true;
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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
	
	public boolean delTodo() {
		return false;
	}
	
	public boolean clearTodo() {
		return false;
	}
}
