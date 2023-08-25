package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list.do")
public class ListController extends HttpServlet {
	
	private static final long serialVersionUID = -3262191788834862821L;

	@Override
	public void init() throws ServletException {
		System.out.println("ListController init()...1");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ListController doGet()...1");
		
		// View 포워딩
		RequestDispatcher dispatcher = req.getRequestDispatcher("/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
