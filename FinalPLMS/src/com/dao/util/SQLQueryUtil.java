package com.dao.util;

public class SQLQueryUtil {
	
	public static final String SQL_INSERT_USER="insert into user_details values (?,?,?,?,?,?,?)";
	public static final String SQL_FIND_LAST_UID="select max(userid) from user_details";
	public static final String SQL_INSERT_ACCOUNT="insert into account values(?,?,?,?)";
	
	public static final String SQL_GET_AC_NO = "select currency_type, max(accountno) from account group by currency_type";
	public static final String SQL_GET_USER = "select username, password from user_details where username=? and password=?";
	

}

