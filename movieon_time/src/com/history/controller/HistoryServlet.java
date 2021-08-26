package com.history.controller;

import java.io.IOException;
import java.util.ArrayList;
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

public class HistoryServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				HttpSession session = req.getSession();
				MemberVO member = (MemberVO)session.getAttribute("memberVO");
				Integer userId = member.getUserid();
			
				HistoryService historySvc = new HistoryService();
				List<HistoryVO> historyVO = historySvc.getByUser(userId);
				
//				for(HistoryVO historyVO2 : historyVO) {
//					System.out.println(historyVO2.getShowingId());
//				}
				
				
				ShowingService showingSvc = new ShowingService();
				ShowingVO showingVO = null;
				List<ShowingVO> showingVO1 = new ArrayList<ShowingVO>();

				
				 	for(HistoryVO historyVO2 : historyVO){ 
				 		showingVO = new ShowingVO();
				 		showingVO.setShowingId(historyVO2.getShowingId());
				 		showingVO1.add(showingVO);
				  	} 
				
//				for(ShowingVO showingVO2 : showingVO1) {
//					System.out.println(showingVO2.getShowingId());
//				}
				
				
				
				
				req.setAttribute("showingVO1", showingVO1);
				String url = "/showing/history.jsp";
				RequestDispatcher success = req.getRequestDispatcher(url);
				success.forward(req, res);
			
			} catch (Exception e) {
				errorMsgs.add("查無資料"+e.getMessage());
				RequestDispatcher failur = req.getRequestDispatcher("/showing/showing_search.jsp");
				failur.forward(req, res);
			}

		
		
		
		
	}

}
