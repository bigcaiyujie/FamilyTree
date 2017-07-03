package cn.jxufe.dao;

import java.sql.*;

public class DataBase {
	private String driver = "com.mysql.jdbc.Driver";
	// URL指向要访问的数据库名mydata
	private String url = "jdbc:mysql://localhost:3306/Family";
	// MySQL配置时的用户名
	private String user = "root";
	// MySQL配置时的密码
	private String password = "123456";
	private Connection con = null;
	private Statement statement = null;

	public DataBase() {
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (ClassNotFoundException e) {
			// 数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("数据库数据成功获取！！");
		}
	}

	public Connection getCon() {
		return con;
	}

	public void close() {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}