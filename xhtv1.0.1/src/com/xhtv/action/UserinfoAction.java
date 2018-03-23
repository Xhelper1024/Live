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
import com.xhtv.entity.Liver;
import com.xhtv.entity.User;

/**
 * Servlet implementation class UserinfoAction
 */
@WebServlet("/userinfo.do")
public class UserinfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private UserDAO userDAO;
	private User user;
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserinfoAction() {
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
		out = response.getWriter();
		response.setContentType("text/json");
		// 获取数据
		String type = request.getParameter("type");
		String uid = request.getParameter("username");
		System.out.println("UesrInfoAction:" + uid);
		session = request.getSession();
		user = (User) session.getAttribute(request.getCookies()[0].getValue());
		String result = "";
		// 修改密码
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		// 修改房间信息
		int roomid = Integer.parseInt(request.getParameter("roomid"));
		String roomtitle = request.getParameter("roomtitle");
		String roomimage = request.getParameter("roomimage");
		String classification = request.getParameter("classification");
		// 分别处理
		switch (type) {
		case "roominfo":
			Liver liver = new Liver();
			liver.setUid(user.getUid());
			liver.setRoomid(roomid);
			liver.setRoomtitle(roomtitle);
			liver.setRoomimage(roomimage);
			liver.setClassification(classification);
			int ret = userDAO.alterroom(liver);
			if (ret == 1) {
				result = "success";
			}
			if (ret == 0) {
				result = "SQL异常";
			}
			break;
		case "userinfo":
			ret = userDAO.alterpwd(user, oldpwd, newpwd);
			if (ret == 1) {
				result = "success";
			}
			if (ret == 2) {
				result = "原密码错误";
			}
			if (ret == 0) {
				result = "SQL异常";
			}
			break;
		default:
			break;
		}
		out.print(result);
		out.flush();
		out.close();
	}

}
