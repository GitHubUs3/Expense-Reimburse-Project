package com.skillstorm.jdbc;

import java.util.LinkedList;
import java.util.List;

import com.skillstorm.beans.Expense;

public class FakeExpenseDAO {

	LinkedList<Expense> data = new LinkedList<>();

	public List<Expense> findAll() {
		return data;
	}

	public void add(Expense product) {
		data.add(product);
	}
}
