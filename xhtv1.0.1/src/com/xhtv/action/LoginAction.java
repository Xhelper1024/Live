package com.xhtv.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhtv.dao.UserDAO;
import com.xhtv.entity.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private PrintWriter out;
	private HttpSession session;
	private User user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
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
		String type = request.getParameter("type");
		// 注销
		if ("logout".equals(type)) {
			user = (User) session.getAttribute(request.getCookies()[0].getValue());
			System.out.println(user.getNickname() + "注销成功" + new Date());
			session.setAttribute(session.getId(), null);
			response.sendRedirect("/xhtv1.0.1");
			return;
		}
		// 登录，用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 回调
		response.setContentType("text");
		out = response.getWriter();
		int isRight = userDAO.login(username, password);
		if (isRight == 2) {
			user = userDAO.getUser(username);
			session.setAttribute(session.getId(), user);
			System.out.println(session.getId());
			System.out.println(user.getNickname() + "登录成功" + new Date());
		}
		out.print(isRight);
		out.flush();
		out.close();
	}

}
