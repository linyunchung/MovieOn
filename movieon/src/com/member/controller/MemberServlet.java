package com.member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.creditcard.model.CreditCardService;
import com.creditcard.model.CreditCardVO;
import com.google.gson.Gson;
import com.member.model.MemberService;
import com.member.model.MemberVO;
import com.profile.model.FavoritesService;

@MultipartConfig
public class MemberServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

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
					RequestDispatcher failureView = req.getRequestDispatcher("memberDataSearch.jsp");
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
					RequestDispatcher failureView = req.getRequestDispatcher("memberDataSearch.jsp");
					failureView.forward(req, res);
					return;
				}

				/************************************************************/
				MemberService memberSvc = new MemberService();
				MemberVO memberVO = memberSvc.getOneMember(userid);
				if (memberVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("memberDataSearch.jsp");
					failureView.forward(req, res);
					return;
				}

				/************************************************************/
				req.setAttribute("memberVO", memberVO);
				String url = "/member/memberData.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***********************************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("memberDataSearch.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				Integer userid = new Integer(req.getParameter("userid"));

				MemberService memberSvc = new MemberService();
				MemberVO memberVO = memberSvc.getOneMember(userid);

				req.setAttribute("memberVO", memberVO);
				String url = "/member/update_member_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/member/listAllMember.jsp");
				failureView.forward(req, res);
			}
		}

		if ("updateProfile".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				Integer userid = new Integer(req.getParameter("userid"));

				String name = req.getParameter("name");

				String gender = req.getParameter("gender");
			
				java.sql.Date birthday = null;
				birthday = java.sql.Date.valueOf(req.getParameter("birthday"));

				String address = req.getParameter("address");

				String education = req.getParameter("education");

				String occupation = req.getParameter("occupation");

				String ig = req.getParameter("ig");

				String fb = req.getParameter("fb");

				String twt = req.getParameter("twt");
				
                String username = req.getParameter("username");

				MemberService memberSvc = new MemberService();
				InputStream in = req.getPart("upload").getInputStream();
				byte[] profilepic = null;
				if (in.available() != 0) {
					profilepic = new byte[in.available()];
					in.read(profilepic);
					in.close();
				} else {
					profilepic = memberSvc.getOneMember(userid).getProfilepic();
				}

				MemberVO memberVO = new MemberVO();
				memberVO.setName(name);
                memberVO.setUsername(username);
				memberVO.setProfilepic(profilepic);
				memberVO.setAddress(address);
				memberVO.setBirthday(birthday);
				memberVO.setEducation(education);
				memberVO.setGender(gender);
				memberVO.setOccupation(occupation);
				memberVO.setIg(ig);
				memberVO.setFb(fb);
				memberVO.setTwt(twt);
				memberVO.setUserid(userid);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberVO", memberVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/member/profile.jsp");
					failureView.forward(req, res);
					return;
				}

				/***************************************************************************/
				memberVO = memberSvc.updateProfile(profilepic, name, gender, birthday, address, education, occupation,
						ig, fb, twt, userid, username);

				/***************************************************************************/

				req.setAttribute("memberVO", memberVO);
				String url = "/member/profile.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/member/profile.jsp");
				failureView.forward(req, res);
			}
		}


		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String username = req.getParameter("username");
				String usernameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (username == null || username.trim().length() == 0) {
					errorMsgs.add("會員名稱請勿空白");
				} else if (!username.trim().matches(usernameReg)) {
					errorMsgs.add("會員名稱只能英文 , 數字和_ , 且長度必須在2到10之間");
				}

				String email = req.getParameter("email");
				String emailReg = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
				if (email == null || (email.trim()).length() == 0) {
					errorMsgs.add("請輸入email");
				} else if (!email.trim().matches(emailReg)) {
					errorMsgs.add("email格式錯誤");
				}

				String password = req.getParameter("password");
				String password2 = req.getParameter("password2");
				if (password == null || password.trim().length() == 0) {
					errorMsgs.add("密碼請勿空白");
				} else if (!password.equals(password2)) {
					errorMsgs.add("兩次密碼不一樣");
				}

				MemberVO memberVO = new MemberVO();

				memberVO.setUsername(username);
				memberVO.setEmail(email);
				memberVO.setPassword(password);

				if (!errorMsgs.isEmpty()) {
					/* req.setAttribute("memberVO", memberVO); */
					RequestDispatcher failureView = req.getRequestDispatcher("/member/sign_up.jsp");
					failureView.forward(req, res);
					return;
				}

				MemberService memberSvc = new MemberService();
				memberVO = memberSvc.addMember(username, email, password);

				String url = "/member/log_in.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/member/sign_up.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				Integer userid = new Integer(req.getParameter("userid"));

				MemberService memberSvc = new MemberService();
				memberSvc.deleteMember(userid);

				String url = "/member/listAllMember.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/member/listAllMember.jsp");
				failureView.forward(req, res);
			}

		}
		
		if ("getCreditCard".equals(action)) {
			String userId = req.getParameter("userId");
			PrintWriter out = res.getWriter();
			if (userId != null) {
				CreditCardService ccSvc = new CreditCardService();
				CreditCardVO ccVO = ccSvc.getOneCreditCard(Integer.valueOf(userId));
				Gson gson = new Gson();
				String jsonStr = gson.toJson(ccVO);
				System.out.println(jsonStr);
				out.println(jsonStr);
			} else {
				out.println("");
			}
		}
		
		
		if ("deleteCard".equals(action)) {
			
			Integer creditid = new Integer(req.getParameter("creditid"));

			CreditCardService ccSvc = new CreditCardService();
			ccSvc.deleteCreditCard(creditid);

			/*
			 * String url = "/member/listAllMember.jsp"; RequestDispatcher successView =
			 * req.getRequestDispatcher(url); successView.forward(req, res);
			 */


		}

	}

}
