package com.member.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.member.model.*;

public class MemberServlet extends HttpServlet {
       
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Display".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			
			try {
				String str = req.getParameter("userid");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入會員ID");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				Integer userid = null;
				try {
					userid = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("會員ID格式不正確");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
			
				/************************************************************/
				MemberService memberSvc = new MemberService();
				MemberVO memberVO = memberSvc.getoneMember(userid);
				if (memberVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/************************************************************/
				req.setAttribute("memberVO", memberVO);
				String url = "/member/listOneMember";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
				/***********************************************************/
			}catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		

	}
}
