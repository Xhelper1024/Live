package com.xhtv.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhtv.dao.UserDAO;
import com.xhtv.entity.User;

/**
 * Servlet implementation class RegisterAction
 */
@WebServlet("/register.do")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private PrintWriter out;
	private User user;
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterAction() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		session = request.getSession();
		out = response.getWriter();
		response.setContentType("text/json");
		// 获取数据
		String username = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		user = new User();
		user.setNickname(username);
		user.setUid(email);
		user.setPwd(pwd);
		user.setBalance(0);
		user.setLiver(false);
		// 注册
		boolean succes = userDAO.doRegister(user);
		if (succes) {
			session.setAttribute(session.getId(), user);
		}
		out.print(succes);
		out.flush();
		out.close();
	}

}
