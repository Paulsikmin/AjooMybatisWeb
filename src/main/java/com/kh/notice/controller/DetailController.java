package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

@WebServlet("/notice/detail.do")
public class DetailController extends HttpServlet{

	private static final long serialVersionUID = 1070927730385852372L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// /notice/detail.do?noticeNo=445
		// SELECT * FROM NOTICE_TBL WHERE NOTICE_NO = ?
		String noticeNo = req.getParameter("noticeNo");
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNo(Integer.parseInt(noticeNo));
		if(notice != null) {
			req.setAttribute("notice", notice);
			req.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "No Data Found!!");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
	
}
