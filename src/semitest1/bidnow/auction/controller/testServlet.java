package semitest1.bidnow.auction.controller;

import static semitest1.bidnow.common.jdbc.JDBCTemplate.getConnection;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semitest1.bidnow.common.ConfigLocation;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testservlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("잘넘오니??");
//		
//		String usetId = request.getParameter("userId");
//		
//		Connection con = getConnection();
//		
//		
//		System.out.println(con);
//		
//		System.out.println("usetId" + usetId);
		
//		System.out.println("mapper path : " + ConfigLocation.MAPPER_LOCATION);
	}

}
