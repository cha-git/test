package com.internousdev.login.action;

import java.sql.SQLException;
import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String name;
	private String password;

	public String execute() throws SQLException{
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		//「DAOクラス」を呼び出してDBに接続する。ユーザーが入力した「ログインID」と「パスワード」に一致する情報があるか検索する。
		dto = dao.select(name, password);

		if(name.equals(dto.getName())){
			if(password.equals(dto.getPassword())){
				ret = SUCCESS;
			}
		}
		return ret;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}
}