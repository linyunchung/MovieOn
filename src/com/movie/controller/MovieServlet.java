package com.movie.controller;

import java.io.*;
import java.sql.Blob;

import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.movie.model.*;

@MultipartConfig
public class MovieServlet extends HttpServlet {

//	public void doGet(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//		doPost(req, res);
//	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

		try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("movieId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入電影編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer movieId = null;
				try {
					movieId = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("電影編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				MovieService movieSvc = new MovieService();
				MovieVO movieVO = movieSvc.getOneMovie(movieId);
				if (movieVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("movieVO", movieVO); // 資料庫取出的empVO物件,存入req
				String url = "/Backstage/movieData.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getAll_By_Name".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
//			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("movieName");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入電影名稱關鍵字");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				String movieName = req.getParameter("movieName");
				
				
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				MovieService movieSvc = new MovieService();
				
//				MovieVO movieVO = (MovieVO) movieSvc.getAllByMovieName(movieName);
				List<MovieVO> movieList = movieSvc.getAllByMovieName(movieName);
				
				if (movieList == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("movieList", movieList); 
				String url = "/Backstage/movieDataByName.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("無法取得資料:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
//				failureView.forward(req, res);
//			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer movieId = new Integer(req.getParameter("movieId"));
				
				/***************************2.開始查詢資料****************************************/
				MovieService movieSvc = new MovieService();
				MovieVO movieVO = movieSvc.getOneMovie(movieId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("movieVO", movieVO);         // 資料庫取出的empVO物件,存入req
				String url = "/Backstage/movieDataUpdata.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
				failureView.forward(req, res);
			}
		}
//		
//		
			if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer movieId = new Integer(req.getParameter("movieId").trim());
				
				String movieName = req.getParameter("movieName");
				
				if (movieName == null || movieName.trim().length() == 0) {
					errorMsgs.add("請填入電影名稱");
				} 
	            
				
				String movieEName = req.getParameter("movieEName").trim();
				if (movieEName == null || movieEName.trim().length() == 0) {
					errorMsgs.add("請填入英文名稱");
				}	
				
				java.sql.Date releaseDate = null;
				try {
					releaseDate = java.sql.Date.valueOf(req.getParameter("releaseDate").trim());
				} catch (IllegalArgumentException e) {
					releaseDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期");
				}
				Integer mins = new Integer(req.getParameter("mins"));
				
				if (mins == null ) {
					errorMsgs.add("請填入片長");
				} 

				String studio = req.getParameter("studio").trim();
				if (studio == null || studio.trim().length() == 0) {
					errorMsgs.add("請填入發行公司");
				}	
				String plot = req.getParameter("plot").trim();
				if (plot == null || plot.trim().length() == 0) {
					errorMsgs.add("請填入電影簡介");
				}	
				String actor = req.getParameter("actor").trim();
				if (actor == null || actor.trim().length() == 0) {
					errorMsgs.add("請填入電影主演");
				}	
				String director = req.getParameter("director").trim();
				if (director == null || director.trim().length() == 0) {
					errorMsgs.add("請填入導演");
				}	
				
				
				MovieService movieSvc = new MovieService();
				InputStream in = req.getPart("poster").getInputStream();
				byte[] poster = null;
				if(in.available()!=0) {
					poster = new byte[in.available()];
					in.read(poster);
					in.close();
				}else {
					poster = movieSvc.getOneMovie(movieId).getPoster();
				}
				
				
				
				String movieTag = req.getParameter("movieTag").trim();
				if (movieTag == null) {
					errorMsgs.add("請選擇電影類別");
				}	

				MovieVO movieVO = new MovieVO();
				
				movieVO.setMovieName(movieName);
				movieVO.setMovieEName(movieEName);
				movieVO.setReleaseDate(releaseDate);
				movieVO.setMins(mins);
				movieVO.setStudio(studio);
				movieVO.setPlot(plot);
				movieVO.setPoster(poster);
				movieVO.setActor(actor);
				movieVO.setDirector(director);
				movieVO.setMovieTag(movieTag);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("movieVO", movieVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataUpdata.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				
				movieVO = movieSvc.updateMovie(movieId, movieName, movieEName, releaseDate,
						 mins, studio, plot, poster, actor, director, movieTag);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("movieVO", movieVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/Backstage/movieData.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
				failureView.forward(req, res);
			}
		}
//
        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String movieName = req.getParameter("movieName");
				
				if (movieName == null || movieName.trim().length() == 0) {
					errorMsgs.add("請輸入電影名稱");
				} 
				
				String movieEName = req.getParameter("movieEName").trim();
				if (movieEName == null || movieEName.trim().length() == 0) {
					errorMsgs.add("請輸入英文名稱");
				}
				
				java.sql.Date releaseDate = null;
				try {
					releaseDate = java.sql.Date.valueOf(req.getParameter("releaseDate").trim());
				} catch (IllegalArgumentException e) {
					releaseDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期");
				}
							
			   Integer mins = new Integer(req.getParameter("mins"));
				
				if (mins == null ) {
					errorMsgs.add("請填入片長");
				} 

				String studio = req.getParameter("studio").trim();
				if (studio == null || studio.trim().length() == 0) {
					errorMsgs.add("請填入發行公司");
				}	
				String plot = req.getParameter("plot").trim();
				if (plot == null || plot.trim().length() == 0) {
					errorMsgs.add("請填入電影簡介");
				}	
				String actor = req.getParameter("actor").trim();
				if (actor == null || actor.trim().length() == 0) {
					errorMsgs.add("請填入電影主演");
				}	
				String director = req.getParameter("director").trim();
				if (director == null || director.trim().length() == 0) {
					errorMsgs.add("請填入導演");
				}	
				InputStream in = req.getPart("poster").getInputStream();
				byte[] poster = null;
				if(in.available()!=0) {
					poster = new byte[in.available()];
					in.read(poster);
					in.close();
					
				}
				
				String movieTag = req.getParameter("movieTag").trim();
				if (movieTag == null || movieTag.trim().length() == 0) {
					errorMsgs.add("請選擇電影類別");
				}	

				MovieVO movieVO = new MovieVO();
				
				movieVO.setMovieName(movieName);
				movieVO.setMovieEName(movieEName);
				movieVO.setReleaseDate(releaseDate);
				movieVO.setMins(mins);
				movieVO.setStudio(studio);
				movieVO.setPlot(plot);
				movieVO.setPoster(poster);
				movieVO.setActor(actor);
				movieVO.setDirector(director);
				movieVO.setMovieTag(movieTag);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("movieVO", movieVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataInsert.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				MovieService movieSvc = new MovieService();
				movieVO = movieSvc.addMovie(movieName, movieEName, releaseDate,
						 mins, studio, plot, poster, actor, director, movieTag);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/Backstage/movieInsertFinish.html";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/movieDataInsert.jsp");
				failureView.forward(req, res);
			}
		}
//		
//		
//		if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.接收請求參數***************************************/
//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.開始刪除資料***************************************/
//				EmpService empSvc = new EmpService();
//				empSvc.deleteEmp(empno);
//				
//				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//				successView.forward(req, res);
//				
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("刪除資料失敗:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
	}
}
