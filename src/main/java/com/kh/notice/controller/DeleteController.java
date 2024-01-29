package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;

@WebServlet("/notice/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = -8042103979275805129L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService nService = new NoticeService();
		int result = nService.deleteNotice(noticeNo);
		if(result > 0) {
			response.sendRedirect("/notice/list.do");
		}else {
			request.setAttribute("msg", "No Data Found!!!");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
			.forward(request, response);
		}
	}
	
}
