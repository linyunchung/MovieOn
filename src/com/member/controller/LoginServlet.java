package com.member.controller;

import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.member.model.*;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");


			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				String email = req.getParameter("email");
				String emailReg = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
				if(email == null || (email.trim()).length() == 0) {
					errorMsgs.add("請輸入email");
				} else if(!email.trim().matches(emailReg)) {
					errorMsgs.add("email格式錯誤");
				}
				
				String password = req.getParameter("password");
				if(password == null || (password.trim()).length() == 0) {
					errorMsgs.add("請輸入密碼");
				}
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/log_in.jsp");
					failureView.forward(req, res);
					return;
				}
/*******************************************************************************************/
				MemberService memberSvc = new MemberService();
				MemberVO memberVO = memberSvc.login(email, password);
				if (memberVO == null) {
					errorMsgs.add("帳號密碼錯誤");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/log_in.jsp");
					failureView.forward(req, res);
					return;
				}
				if(memberVO.getEmail().equals(email) && memberVO.getPassword().equals(password)) {
					HttpSession session = req.getSession();
					session.setAttribute("memberVO", memberVO);
					String url = "/member/index.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
					return;
				}

				
			} catch (Exception e){
				
			}
		}
}
