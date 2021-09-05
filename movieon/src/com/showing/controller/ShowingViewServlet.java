package com.showing.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.history.model.HistoryService;
import com.history.model.HistoryVO;
import com.member.model.MemberVO;
import com.showing.model.ShowingService;
import com.showing.model.ShowingVO;

public class ShowingViewServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");

		/************************************�d�X�ɨ��********************************************/

		if ("getShowingTime".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				Integer theaterId = new Integer(req.getParameter("theaterId"));
				Integer movieId = new Integer(req.getParameter("movieId"));
				String showingDateStr = req.getParameter("showingDate");
				Date showingDate = Date.valueOf(showingDateStr);

				ShowingService showingSvc = new ShowingService();
				List<ShowingVO> showingVO = showingSvc.getShowingTime(theaterId, movieId, showingDate);

				req.setAttribute("showingVO", showingVO);
				String url = "/showing/showing_search.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("�d�ߥ���" + e.getMessage());
				RequestDispatcher failur = req.getRequestDispatcher("/showing/showing_search.jsp");
				failur.forward(req, res);
			}

		}

		/************************************* �x�s���v����********************************************/

		if ("saveShowingTime".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

//			try {

				HttpSession session = req.getSession();
				MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
				
				// ����d�߹L������
				List<ShowingVO> list = (List<ShowingVO>) session.getAttribute("showingVO");
				
				//�S�n�J���B�z
				if (memberVO == null) {
					req.setAttribute("message", "�Х��n�J !");
					req.setAttribute("showingVO", list);
					RequestDispatcher failur = req.getRequestDispatcher("/showing/showing_search.jsp");
					failur.forward(req, res);
					return;
				}


				Integer userId = memberVO.getUserid();

				HistoryService historySvc = new HistoryService();
				HistoryVO historyVO = new HistoryVO();
				historyVO.setUserId(userId);

				for (ShowingVO showingVO : list) {
					historyVO.setShowingId(showingVO.getShowingId());
					historyVO = historySvc.addHistory(userId, showingVO.getShowingId());
				}

				/*********************�s�W���\��^����************************/
				
				req.setAttribute("message", "�x�s���\");
				req.setAttribute("showingVO", list);
				String url = "/showing/showing_search.jsp";
				RequestDispatcher success = req.getRequestDispatcher(url);
				success.forward(req, res);

//			} catch (Exception e) {
//				errorMsgs.add("����" + e.getMessage());
//				RequestDispatcher failur = req.getRequestDispatcher("/showing/showing_search.jsp");
//				failur.forward(req, res);
//			}
		}

	}

}
