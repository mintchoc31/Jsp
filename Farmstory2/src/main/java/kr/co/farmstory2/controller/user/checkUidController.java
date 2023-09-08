package kr.co.farmstory2.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.farmstory2.dto.UserDTO;
import kr.co.farmstory2.service.UserService;

@WebServlet("/user/checkUid.do")
public class checkUidController extends HttpServlet{

	private static final long serialVersionUID = 5910357373509939974L;
	
	private UserService service = UserService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		
		UserDTO dto = new UserDTO();
		dto.setUid(uid);
		
		int result = service.selectCountUid(uid);
		
		// json 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		
		// json 출력
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/user/checkUid.jsp");
		//dispatcher.forward(req, resp);
	}
}
