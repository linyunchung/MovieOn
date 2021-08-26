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
		
		/************************************ 查出時刻表********************************************/

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
				errorMsgs.add("查詢失敗"+e.getMessage());
				RequestDispatcher failur = req.getRequestDispatcher("/showing/showing_search.jsp");
				failur.forward(req, res);
			}

		}

		/************************************儲存歷史紀錄********************************************/
		
		if("saveShowingTime".equals(action)) {
			
			try {
				
			
				HttpSession session = req.getSession();
				MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
				Integer userId = memberVO.getUserid();
				
				List<ShowingVO> list = (List<ShowingVO>)session.getAttribute("showingVO");
				
//				for(ShowingVO showingVO : list) {
//					System.out.println(showingVO.getShowingId());
//				}
				
				
				HistoryService historySvc = new HistoryService();
				HistoryVO historyVO = new HistoryVO();
				historyVO.setUserId(userId);
				
				for(ShowingVO showingVO : list) {
					historyVO.setShowingId(showingVO.getShowingId());
					historyVO = historySvc.addHistory(userId, showingVO.getShowingId());
				}
				
				req.setAttribute("showingVO", list);
				String url = "/showing/showing_search.jsp";
				RequestDispatcher success = req.getRequestDispatcher(url);
				success.forward(req, res);
		
				
			} catch (Exception e) {
				
			}
		}
		
		
	}

}
