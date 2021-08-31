package com.profile.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.follow.model.*;
import com.member.model.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FollowService followService;

	@Override
	public void init() throws ServletException {
		// newing all the services here
		followService = new FollowService();
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if (action == null || "".equals(action)) {
			int profileid = new Integer(req.getParameter("id"));
			HttpSession session = req.getSession();
			FollowVO followVO = null;
			boolean myProfile = false;

			// 如果有追蹤，關係為FollowVO；未追蹤就是null
			if (session.getAttribute("memberVO") != null) {

				MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
				int loginMemberId = loginMember.getUserid();
				followVO = followService.findBySourceAndTarget(loginMemberId, profileid);
				
//				if (profileid == loginMemberId) {
//					myProfile = true;
//				}

			}

			// 如果沒登入則絕對是null，表示未追蹤
			req.setAttribute("followVO", followVO);
			req.setAttribute("myProfile", myProfile);

			String url = "/follow/userid.jsp";
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);
			// parameter內的id會被一起forward
		}

		if ("followers".equals(action)) {
			String url = "/follow/followers.jsp";
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);
		}

		if ("following".equals(action)) {
			String url = "/follow/following.jsp";
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);
		}

		if ("films".equals(action)) {
			String url = "/follow/films.jsp";
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);
		}
		
		if ("reviews".equals(action)) {
			String url = "/follow/reviews.jsp";
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);
		}
		
		if ("network".equals(action)) {
			String url = "/follow/network.jsp";
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);
		}
	}

	
	//回給Ajax的response要set content type and set header;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.addHeader("Access-Control-Allow-Origin", "*");
		String action = req.getParameter("action");

		if ("addFollow".equals(action)) {

			try {
				HttpSession session = req.getSession();
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					Integer targetId = new Integer(req.getParameter("targetId"));
					followService.newFollow(loginMember.getUserid(), targetId);
					res.getWriter().write("true");
				} else {
					res.getWriter().write("請登入會員");
				}

			} catch (Exception e) {
				e.printStackTrace();
				res.getWriter().write("false");
			}
			return;
		}

		if ("removeFollow".equals(action)) {

			try {
				HttpSession session = req.getSession();
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					Integer targetId = new Integer(req.getParameter("targetId"));
					followService.deleteBySourceAndTarget(loginMember.getUserid(), targetId);
					res.getWriter().write("true");
				} else {
					res.getWriter().write("請登入會員");
				}

			} catch (Exception e) {
				e.printStackTrace();
				res.getWriter().write("false");
			}
			return;
		}

	}

}
