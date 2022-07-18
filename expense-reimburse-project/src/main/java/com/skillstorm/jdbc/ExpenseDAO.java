package com.skillstorm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.skillstorm.beans.Expense;

public class ExpenseDAO {

	private Connection connection;
	
	public ExpenseDAO() throws SQLException {
		// Establish a Connection to the database
		String url = "jdbc:mysql://localhost:3306/expense";
		String username = "root";
		String password = "root";
		this.connection = DriverManager.getConnection(url, username, password);
	}
	
	//CRUD
	public Expense create(Expense expense) throws SQLException {
		String query = "insert into Expense() values ()";
		PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, expense.getName());
		
		ResultSet rs = statement.getGeneratedKeys();
		
		rs.next();
		int generatedId = rs.getInt(1);
		expense.setExpenseId(generatedId);
		
		return expense;
	}
	
	/*
	{
		// 3. Issue the SQL Statement
		String variable = "Pickles Band";
		String sql = "insert into Expense(name) values ('" + variable + "');";
		Statement statement = conn.createStatement();
		// 4. Execute statement
		statement.executeUpdate(sql); // insert, update, delete, create, alter, drop

		// 5. Close the connection
		conn.close();
	}*/
}
