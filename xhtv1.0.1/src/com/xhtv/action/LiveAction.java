package com.xhtv.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhtv.dao.UserDAO;
import com.xhtv.entity.Liver;

/**
 * Servlet implementation class LiveAction
 */
@WebServlet("/live.do")
public class LiveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LiveAction() {
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
		response.setContentType("text/json");
		String roomid = request.getParameter("roomid");
		Liver liver = userDAO.getLiver(Integer.parseInt(roomid));
		// 读取emoji文件夹下的图片
		String path = "E:\\JavaWebTest\\xhtv1.0.1\\WebContent\\emoji";
		File file = new File(path);
		request.setAttribute("imgList", file.list());
		// end
		request.setAttribute("liver", liver);
		request.getRequestDispatcher("jsp/liveroom.jsp").forward(request, response);
	}

}
