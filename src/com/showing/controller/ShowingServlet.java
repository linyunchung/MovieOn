package com.showing.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.showing.model.ShowingService;
import com.showing.model.ShowingVO;
import com.theater.model.TheaterVO;

public class ShowingServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		/******************************�s�W****************************/
		
		if("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			String successMsg = "";
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				Integer theaterId = new Integer (req.getParameter("theaterId"));
				Integer movieId = new Integer(req.getParameter("movieId"));
				
				java.sql.Date showingDate = null;
				try {
					showingDate = java.sql.Date.valueOf(req.getParameter("showingDate").trim());
				} catch (IllegalArgumentException e) {
					showingDate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�ܤ��");
				}
				
				
				java.sql.Time showingTime = null;
				try {
					 showingTime = java.sql.Time.valueOf(req.getParameter("showingTime").trim());
				} catch (IllegalArgumentException e) {
					showingTime = new java.sql.Time(1000*60*60*24);
					errorMsgs.add("�п�ܮɶ�");
				}
				
				/******************�h���ɶ��]�w***********************/
				
				java.sql.Time showingTime2 = null;
				try {
					showingTime2 = java.sql.Time.valueOf(req.getParameter("showingTime2").trim());
				} catch (Exception e) {
					
				}
				
		
				java.sql.Time showingTime3 = null;
				try {
					showingTime3 = java.sql.Time.valueOf(req.getParameter("showingTime3").trim());
				} catch (Exception e) {
					// TODO: handle exception
				}

				
				java.sql.Time showingTime4 = null;
				try {
					showingTime4 = java.sql.Time.valueOf(req.getParameter("showingTime4").trim());
				} catch (Exception e) {
					// TODO: handle exception
				}
				/*******************************************/
		
				
				ShowingVO showingVO = new ShowingVO();
				showingVO.setTheaterId(theaterId);
				showingVO.setMovieId(movieId);
				showingVO.setShowingDate(showingDate);
				showingVO.setShowingTime(showingTime);
				
				
				if(!errorMsgs.isEmpty()) {
					req.setAttribute("showingVO", showingVO);
					RequestDispatcher failurView = req.getRequestDispatcher("/Backstage/backstage_add_time.jsp");
					failurView.forward(req, res);
					return;
				}
				
				/****************************�}�l�s�W**************************************/
				
				ShowingService showingSvc = new ShowingService();
				showingSvc.addShowing(theaterId, movieId, showingDate, showingTime);
				
				if(showingTime2!=null) {
					showingSvc.addShowing(theaterId, movieId, showingDate, showingTime2);
				}
				if(showingTime3!=null) {
					showingSvc.addShowing(theaterId, movieId, showingDate, showingTime3);
				}
				if(showingTime4!=null) {
					showingSvc.addShowing(theaterId, movieId, showingDate, showingTime4);
				}
				
				
				/**************************��^����*********************************/
				String url = "/Backstage/backstage_add_time.jsp";
				successMsg = "�s�W���\";
				req.setAttribute("successMsg", successMsg);
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failurView = req.getRequestDispatcher("/Backstage/backstage_add_time.jsp");
				failurView.forward(req, res);
			}
			
		}
		
		/*********************************��ܼv���P�q�v�d��**************************************/
		
		if("getBy_Movie_Theater".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				Integer theaterId = new Integer(req.getParameter("theaterId"));
				Integer movieId = new Integer (req.getParameter("movieId"));
				
				
				/***********************************************************************/
				ShowingService showingSvc = new ShowingService();
				List<ShowingVO> showingVO =  showingSvc.getByTheaterAndMovie(theaterId,movieId);
				if(showingVO.isEmpty()) {
					errorMsgs.add("�d�L���");
				}
				
			
				if(!errorMsgs.isEmpty()) {
					
					RequestDispatcher failurView = req.getRequestDispatcher("/Backstage/backstage_showing_select.jsp");
					failurView.forward(req, res);
					return;
				}
				/*************************************************************************/
				req.setAttribute("showingVO", showingVO);
				String url = "/Backstage/backstage_showing_select.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
			
			
			
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���"+e.getMessage());
				RequestDispatcher failurView = req.getRequestDispatcher("/Backstage/backstage_showing_select.jsp");
				failurView.forward(req, res);
			}
		
		}
		
		/*******************************��ܤ@����s*************************************/
		
		if("getOne_For_Update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				Integer showingId = new Integer (req.getParameter("showingId"));
				
				
				ShowingService showingSvc = new ShowingService();
				ShowingVO showingVO = showingSvc.getOneShowing(showingId);
				
				req.setAttribute("showingVO", showingVO);
				String url = "/Backstage/backstage_showing_update.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���"+e.getMessage());
				RequestDispatcher failurView = req.getRequestDispatcher("/Backstage/backstage_showing_view");
				failurView.forward(req, res);
			}
		}
		
		/**********************************��s*****************************************/
		
		if("update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			String successMsg = "";
			req.setAttribute("errorMsgs", errorMsgs);
			
		
			try {
				
			
			Integer showingId = new Integer(req.getParameter("showingId"));
			Integer theaterId = new Integer(req.getParameter("theaterId"));
			Integer movieId = new Integer(req.getParameter("movieId"));
			
			java.sql.Date showingDate = null;
			try {
				showingDate = java.sql.Date.valueOf(req.getParameter("showingDate").trim());
			} catch (IllegalArgumentException e) {
				showingDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("�п�ܤ��");
			}
			
			java.sql.Time showingTime = null;
			try {
				showingTime = java.sql.Time.valueOf(req.getParameter("showingTime").trim());
			} catch (IllegalArgumentException e) {
				showingTime = new java.sql.Time(1000*60*60*24);
				errorMsgs.add("�п�ܮɶ�");
			}
			
			
			ShowingVO  showingVO = new ShowingVO();
			showingVO.setShowingId(showingId);
			showingVO.setTheaterId(theaterId);
			showingVO.setMovieId(movieId);
			showingVO.setShowingDate(showingDate);
			showingVO.setShowingTime(showingTime);
			
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("showingVO", showingVO);
				RequestDispatcher failurView = req.getRequestDispatcher("/Backstage/backstage_showing_update.jsp");
				failurView.forward(req, res);
				return;
			}
			
			/****************************************************************************/
			
			ShowingService showingSvc = new ShowingService();
			showingVO = showingSvc.updaShowing(theaterId, movieId, showingDate, showingTime, showingId);
			
			successMsg = "�ק令�\";
			req.setAttribute("successMsg", successMsg);
			req.setAttribute("showingVO", showingVO);
			String url = "/Backstage/backstage_showing_update.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
			
			
			
			} catch (Exception e) {
				errorMsgs.add("�L�k��s���"+e.getMessage());
				RequestDispatcher failurView = req.getRequestDispatcher("/Backstage/backstage_showing_update.jsp");
				failurView.forward(req, res);
			}
		}
		
		/****************************************�R��*******************************************/
		
		if("delete".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				Integer showingId = new Integer(req.getParameter("showingId"));
				
				ShowingService showingSvc = new ShowingService();
				showingSvc.deleteShowing(showingId);
				
				String url = "/backstage/backstage_showing_select.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				
			} catch (Exception e) {
				errorMsgs.add("�R������"+e.getMessage());
				RequestDispatcher failurView = req.getRequestDispatcher("/Backstage/backstage_showing_select.jsp");
				failurView.forward(req, res);
			}
		}
			
		
		
	}

}
