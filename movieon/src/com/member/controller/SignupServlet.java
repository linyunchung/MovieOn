package com.member.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.*;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				String username = req.getParameter("username");
				String usernameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (username == null || username.trim().length() == 0) {
					errorMsgs.add("�|���W�ٽФŪť�");
				} else if (!username.trim().matches(usernameReg)) {
					errorMsgs.add("�|���W�٥u��^�� , �Ʀr�M_ , �B���ץ����b2��10����");
				}
				String email = req.getParameter("email");
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("email�ФŪť�");
				}
				String password = req.getParameter("password");
				if (password == null || password.trim().length() == 0) {
					errorMsgs.add("�K�X�ФŪť�");
				}
				
				MemberVO memberVO = new MemberVO();
				
				memberVO.setUsername(username);
				memberVO.setEmail(email);
				memberVO.setPassword(password);
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberVO", memberVO); 
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/log_in.jsp");
					failureView.forward(req, res);
					return;
				}
				
				MemberService memberSvc = new MemberService();
				memberVO = memberSvc.addMember(username, email, password);
				
				String url = "/member/index.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);
				
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/member/addMember.jsp");
				failureView.forward(req, res);
			}				
			
			
		}
		
		
		
	}
}
