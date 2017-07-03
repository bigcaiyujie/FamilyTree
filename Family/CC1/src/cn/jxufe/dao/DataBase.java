package cn.jxufe.dao;

import java.sql.*;

public class DataBase {
	private String driver = "com.mysql.jdbc.Driver";
	// URLָ��Ҫ���ʵ����ݿ���mydata
	private String url = "jdbc:mysql://localhost:3306/Family";
	// MySQL����ʱ���û���
	private String user = "root";
	// MySQL����ʱ������
	private String password = "123456";
	private Connection con = null;
	private Statement statement = null;

	public DataBase() {
		try {
			// ������������
			Class.forName(driver);
			// 1.getConnection()����������MySQL���ݿ⣡��
			con = DriverManager.getConnection(url, user, password);
			
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (ClassNotFoundException e) {
			// ���ݿ��������쳣����
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// ���ݿ�����ʧ���쳣����
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("���ݿ����ݳɹ���ȡ����");
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