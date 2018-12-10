package com.internousdev.login.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	//MySQL接続に必要な情報を設定
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/logindb";

	private static String user = "root";
	private static String password = "mysql";

	public Connection getConnection(){
		Connection con = null;

		try{
			Class.forName(driverName);
			//設定した情報を使って自分のパソコンにインストールされているMySQLサーバへ接続するための記述で
			con = (Connection)DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		//MySQLサーバに接続した結果をメソッドの呼び出し元に渡す
		return con;
	}
}
