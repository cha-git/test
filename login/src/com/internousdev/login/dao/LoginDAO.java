package com.internousdev.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

public class LoginDAO {
	public LoginDTO select(String name, String password) throws SQLException{
		LoginDTO dto = new LoginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from user where user_name=? and password=?";

		try{
			//セキュリティ対策を考慮してJavaではPreparedStatementを利用する
			PreparedStatement ps = con.prepareStatement(sql);
			//SQL文の「?」パラメータに指定した値を挿入することができる
			ps.setString(1, name);
			ps.setString(2, password);
			//SQL文を実行
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				//select文でDBから取得した内容をDTOクラスに格納
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
			}
		}catch(SQLException e){
			//処理中にSQL関連のエラーが発生した際に実行する処理
			e.printStackTrace();
		}finally{
			//必ず実行する処理。DB接続を切断する。
			if(con != null){
			con.close();
			}
		}

		return dto;
	}
}
