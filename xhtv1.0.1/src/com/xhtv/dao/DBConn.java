package com.xhtv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection conn;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/live?characterEncoding=utf8&useSSL=true", "root", "123456");
			System.out.println("���ӳɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
