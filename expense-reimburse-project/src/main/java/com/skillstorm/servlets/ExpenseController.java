package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.Expense;
import com.skillstorm.jdbc.FakeExpenseDAO;

@WebServlet(urlPatterns = "/expenses")
public class ExpenseController extends HttpServlet {

	private FakeExpenseDAO dao = new FakeExpenseDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dao.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(dao.findAll());
		resp.getWriter().println(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HTTP request body
		InputStream requestBody = req.getInputStream();
		ObjectMapper objectMapper = new ObjectMapper(); // convert serlvet inputstream -> Expense object
		// take inStream -> convert to Expense object
		Expense expense = objectMapper.readValue(requestBody, Expense.class); 
		dao.add(expense);
		System.out.println("Added Expense: " + expense);
	}
}
