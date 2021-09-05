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
import com.review.model.ReviewService;
import com.review.model.ReviewVO;

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

			HttpSession session = req.getSession();
			
			try {
				int profileid = new Integer(req.getParameter("id"));
				FollowVO followVO = null;

				// 如果有追蹤，關係為FollowVO；未追蹤就是null
				if (session.getAttribute("memberVO") != null) {

					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					int loginMemberId = loginMember.getUserid();
					followVO = followService.findBySourceAndTarget(loginMemberId, profileid);
					session.setAttribute("followVO", followVO);

				}

				// 如果沒登入則絕對是null，表示未追蹤
				String url = "/follow/userid.jsp";
				RequestDispatcher sucessView = req.getRequestDispatcher(url);
				sucessView.forward(req, res);
				// parameter內的id會被一起forward

			} catch (NumberFormatException nfe) {
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					int loginMemberId = loginMember.getUserid();
					
					String url = "/profile?id="+loginMemberId;
					RequestDispatcher sucessView = req.getRequestDispatcher(url);
					sucessView.forward(req, res);
				}
				
//			}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if ("followers".equals(action)) {
			try {
				String url = "/follow/followers.jsp";
				RequestDispatcher sucessView = req.getRequestDispatcher(url);
				sucessView.forward(req, res);
			
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if ("following".equals(action)) {
			try {
				String url = "/follow/following.jsp";
				RequestDispatcher sucessView = req.getRequestDispatcher(url);
				sucessView.forward(req, res);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ("films".equals(action)) {
			try {
				String url = "/follow/films.jsp";
				RequestDispatcher sucessView = req.getRequestDispatcher(url);
				sucessView.forward(req, res);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ("reviews".equals(action)) {
			try {
				String url = "/follow/reviews.jsp";
				RequestDispatcher sucessView = req.getRequestDispatcher(url);
				sucessView.forward(req, res);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ("network".equals(action)) {
			try {
				String url = "/follow/network.jsp";
				RequestDispatcher sucessView = req.getRequestDispatcher(url);
				sucessView.forward(req, res);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if ("myfollowers".equals(action)) {
			try {
				HttpSession session = req.getSession();
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					int loginMemberId = loginMember.getUserid();
					
					
					
					String url = "/profile?id="+loginMemberId+"&action=follows";
					RequestDispatcher sucessView = req.getRequestDispatcher(url);
					sucessView.forward(req, res);
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		if ("myfollowing".equals(action)) {
			try {
				HttpSession session = req.getSession();
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					int loginMemberId = loginMember.getUserid();
					
					String url = "/profile?id="+loginMemberId+"&action=following";
					RequestDispatcher sucessView = req.getRequestDispatcher(url);
					sucessView.forward(req, res);
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if ("myfilms".equals(action)) {
			try {
				HttpSession session = req.getSession();
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					int loginMemberId = loginMember.getUserid();		
					
					String url = "/profile?id="+loginMemberId+"&action=films";
					RequestDispatcher sucessView = req.getRequestDispatcher(url);
					sucessView.forward(req, res);
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if ("myreviews".equals(action)) {
			try {
				HttpSession session = req.getSession();
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					int loginMemberId = loginMember.getUserid();
					
					String url = "/profile?id="+loginMemberId+"&action=reviews";
					RequestDispatcher sucessView = req.getRequestDispatcher(url);
					sucessView.forward(req, res);
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if ("mynetwork".equals(action)) {
			try {
				HttpSession session = req.getSession();
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					int loginMemberId = loginMember.getUserid();
					
					String url = "/profile?id="+loginMemberId+"&action=network";
					RequestDispatcher sucessView = req.getRequestDispatcher(url);
					sucessView.forward(req, res);
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 回給Ajax的response要set content type and set header;

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
		
		if ("addFollow_jsp".equals(action)) {
//			try {
				HttpSession session = req.getSession();
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					Integer targetId = new Integer(req.getParameter("targetId"));
					followService.newFollow(loginMember.getUserid(), targetId);
					
					Integer reviewId = new Integer(req.getParameter("reviewId"));
					ReviewService reSvc = new ReviewService();
					ReviewVO reVO = reSvc.getOneReview(reviewId);
					req.setAttribute("reviewVO", reVO);
					
					String url = "/review/listOneReview2.jsp";
//					String  userPath = req.getRequestURI();
//					System.out.println("userPath");
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
					
				} else {
					RequestDispatcher successView = req.getRequestDispatcher("/member/log_in.jsp");
					successView.forward(req,res);
				}

//			} catch (Exception e) {
//				e.printStackTrace();
//				res.getWriter().write("false");
//			}
			return;
		}
				
		if ("removeFollow_jsp".equals(action)) {
			try {
				HttpSession session = req.getSession();
				if (session.getAttribute("memberVO") != null) {
					MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
					Integer targetId = new Integer(req.getParameter("targetId"));
					
					Integer reviewId = new Integer(req.getParameter("reviewId"));
					ReviewService reSvc = new ReviewService();
					ReviewVO reVO = reSvc.getOneReview(reviewId);
					req.setAttribute("reviewVO", reVO);
					
					followService.deleteBySourceAndTarget(loginMember.getUserid(), targetId);
					
					String url = "/review/listOneReview2.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
					
				} else {
					RequestDispatcher successView = req.getRequestDispatcher("/member/log_in.jsp");
					successView.forward(req,res);
				}

			} catch (Exception e) {
				e.printStackTrace();
				res.getWriter().write("false");
			}
			return;
		}

	}

}
