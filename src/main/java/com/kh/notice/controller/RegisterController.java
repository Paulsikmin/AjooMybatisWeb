package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

@WebServlet("/notice/register.do")
public class RegisterController extends HttpServlet{
	
	private static final long serialVersionUID = -3648217477294469905L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 출력용
		request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 등록용
		request.setCharacterEncoding("UTF-8"); // A/S 사항
		String noticeSubject = request.getParameter("notice-subject");
		String noticeContent = request.getParameter("notice-content");
		Notice notice = new Notice(noticeSubject, noticeContent);
		NoticeService nService = new NoticeService();
		int result = nService.insertNotice(notice);
		if(result > 0) {
			// 등록 성공!
			response.sendRedirect("/notice/list.do");
		}else {
			// 등록 실패
			request.setAttribute("msg", "등록 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
			.forward(request, response);
		}
	}
}



















