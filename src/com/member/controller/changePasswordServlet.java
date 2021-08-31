package com.member.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberService;
import com.member.model.MemberVO;


public class changePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		
		if("changepwd".equals(action)) {
			
			try {
				Integer userid = new Integer(req.getParameter("userid"));
				
				String password = req.getParameter("password").trim();
				if(password == null || password.trim().length() == 0) {
					errorMsgs.add("請輸入舊密碼");
				}
				String newpassword = req.getParameter("newpassword").trim();	
				String newpassword2 = req.getParameter("newpassword2").trim();
				if(newpassword == null || newpassword.trim().length() == 0) {
					errorMsgs.add("請輸入新密碼");
				}else if (!newpassword.equals(newpassword2)) {
					errorMsgs.add("新密碼兩次輸入不一樣");
				}
				
				/*
				 * MemberVO memberVO = new MemberVO(); memberVO.setPassword(newpassword);
				 * memberVO.setUserid(userid);
				 */
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/change_password.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************************************************************/	
				MemberService memberSvc = new MemberService();
				MemberVO memberVO = memberSvc.changepwd(newpassword, userid);	
				
				if(password == null) {
					errorMsgs.add("eee");
				}

					
				req.setAttribute("memberVO", memberVO);
				String url = "/member/change_password.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			
			  } catch (Exception e) { errorMsgs.add("修改資料失敗:"+e.getMessage());
			  	RequestDispatcher failureView =req
			  			.getRequestDispatcher("/member/change_password.jsp");
			  	failureView.forward(req, res); }

		}
		
	}

}
