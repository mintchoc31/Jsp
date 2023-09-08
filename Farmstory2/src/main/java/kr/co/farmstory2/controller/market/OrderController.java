package kr.co.farmstory2.controller.market;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.service.ProductService;

/*
 * 해당 서블릿(/market/order.do) web.xml에 CheckLoginFilter 필터 주소 등록
 */

@WebServlet("/market/order.do")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = -764008782917500862L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Order페이지는 폼전송(POST방식)으로 페이지(JSP)가 출력되기 때문에 doPost에서 처리  
		String thumb2   = req.getParameter("thumb2");
		String pName    = req.getParameter("pName");
		String pNo      = req.getParameter("pNo");
		String delivery = req.getParameter("delivery");
		String price    = req.getParameter("price");
		String count    = req.getParameter("count");
		String total    = req.getParameter("total");
		String finalPrice    = req.getParameter("final");
		
		req.setAttribute("thumb2", thumb2);
		req.setAttribute("pName", pName);
		req.setAttribute("pNo", pNo);
		req.setAttribute("delivery", delivery);
		req.setAttribute("price", price);
		req.setAttribute("count", count);
		req.setAttribute("total", total);
		req.setAttribute("finalPrice", finalPrice);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/market/order.jsp");
		dispatcher.forward(req, resp);	
	}
}