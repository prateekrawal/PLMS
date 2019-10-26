package com.dao;

import java.sql.SQLException;

import com.pojo.User;

public interface UserDAO {
	
	int retriveUserId() throws SQLException;
	int addUser(User u) throws SQLException;
	boolean validateUser(String name, String pwd) throws SQLException;

}
