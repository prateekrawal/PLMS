package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.pojo.Account;

public interface AccountDAO {
	
	public List<Long> retriveAccountNumber() throws SQLException;
	
	public int addAccount(Account a, int userid) throws SQLException;
}
