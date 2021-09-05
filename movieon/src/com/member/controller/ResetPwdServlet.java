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

public class ResetPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("reset".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				
				
				String email = req.getParameter("email");
				String emailReg = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
				if (email == null || (email.trim()).length() == 0) {
					errorMsgs.add("請輸入email");
				} else if (!email.trim().matches(emailReg)) {
					errorMsgs.add("email格式錯誤");
				}
						
				MemberVO memberVO = new MemberVO();
				memberVO.setEmail(email);
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberVO", memberVO); 
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/reset_pwd1.jsp");
					failureView.forward(req, res);
					return;
				}	
				/********************************************************/
				
				
				
				MemberService memberSvc = new MemberService();
				memberVO = memberSvc.getEmail(email);
				
//				memberVO.getUserid();
//				if(email == null) {
//					errorMsgs.add("查無此email");
//				}
				
				getRandom random = new getRandom();
					
				String xxx = random.getStringRandom(10);
				
				memberSvc.changepwd(xxx, memberVO.getUserid());

				String subject = "新密碼";
				String messageText = random.getStringRandom(10) ;
					
			    MailService mailService = new MailService();
			    mailService.sendMail(email, subject, messageText);
				
				req.setAttribute("memberVO", memberVO);
				String url = "/member/reset_pwd3.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/member/reset_pwd1.jsp");
				failureView.forward(req, res);
			}				
			
			
		}
		
	}

}
