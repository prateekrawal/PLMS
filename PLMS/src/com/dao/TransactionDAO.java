package com.dao;

import java.util.ArrayList;

import com.pojo.Transaction;

public interface TransactionDAO {
	int addTransaction(ArrayList<Transaction> t_AL , long acc_no);
}
