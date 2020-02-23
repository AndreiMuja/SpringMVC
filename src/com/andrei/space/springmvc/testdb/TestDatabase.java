package com.andrei.space.springmvc.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;


/**
 * Servlet implementation class TestDatabase
 */
@WebServlet("/TestDatabase")
public class TestDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="springstudent";
		String pass="springstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/space_info?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.cj.jdbc.Driver";
		
		try {
			PrintWriter pw=response.getWriter();
			pw.println("Connecting to database: " + jdbcUrl);
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(jdbcUrl,user,pass);
			DSLContext create=DSL.using(conn);
			Result<Record> records=create.fetch("select * from planets");
			for(Record rec : records) {
				System.out.println(rec);
			}
			pw.println("Succes!");
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
