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
		
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

		try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("movieId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�q�v�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer movieId = null;
				try {
					movieId = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�q�v�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				MovieService movieSvc = new MovieService();
				MovieVO movieVO = movieSvc.getOneMovie(movieId);
				if (movieVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("movieVO", movieVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/Backstage/movieData.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
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
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("movieName");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�q�v�W������r");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				String movieName = req.getParameter("movieName");
				
				
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				MovieService movieSvc = new MovieService();
				
//				MovieVO movieVO = (MovieVO) movieSvc.getAllByMovieName(movieName);
				List<MovieVO> movieList = movieSvc.getAllByMovieName(movieName);
				
				if (movieList == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("movieList", movieList); 
				String url = "/Backstage/movieDataByName.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("�L�k���o���:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
//				failureView.forward(req, res);
//			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer movieId = new Integer(req.getParameter("movieId"));
				
				/***************************2.�}�l�d�߸��****************************************/
				MovieService movieSvc = new MovieService();
				MovieVO movieVO = movieSvc.getOneMovie(movieId);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("movieVO", movieVO);         // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/Backstage/movieDataUpdata.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
				failureView.forward(req, res);
			}
		}
//		
//		
			if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer movieId = new Integer(req.getParameter("movieId").trim());
				
				String movieName = req.getParameter("movieName");
				
				if (movieName == null || movieName.trim().length() == 0) {
					errorMsgs.add("�ж�J�q�v�W��");
				} 
	            
				
				String movieEName = req.getParameter("movieEName").trim();
				if (movieEName == null || movieEName.trim().length() == 0) {
					errorMsgs.add("�ж�J�^��W��");
				}	
				
				java.sql.Date releaseDate = null;
				try {
					releaseDate = java.sql.Date.valueOf(req.getParameter("releaseDate").trim());
				} catch (IllegalArgumentException e) {
					releaseDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���");
				}
				Integer mins = new Integer(req.getParameter("mins"));
				
				if (mins == null ) {
					errorMsgs.add("�ж�J����");
				} 

				String studio = req.getParameter("studio").trim();
				if (studio == null || studio.trim().length() == 0) {
					errorMsgs.add("�ж�J�o�椽�q");
				}	
				String plot = req.getParameter("plot").trim();
				if (plot == null || plot.trim().length() == 0) {
					errorMsgs.add("�ж�J�q�v²��");
				}	
				String actor = req.getParameter("actor").trim();
				if (actor == null || actor.trim().length() == 0) {
					errorMsgs.add("�ж�J�q�v�D�t");
				}	
				String director = req.getParameter("director").trim();
				if (director == null || director.trim().length() == 0) {
					errorMsgs.add("�ж�J�ɺt");
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
					errorMsgs.add("�п�ܹq�v���O");
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
					req.setAttribute("movieVO", movieVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataUpdata.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				
				movieVO = movieSvc.updateMovie(movieId, movieName, movieEName, releaseDate,
						 mins, studio, plot, poster, actor, director, movieTag);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("movieVO", movieVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/Backstage/movieData.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/movieDataSearch.jsp");
				failureView.forward(req, res);
			}
		}
//
        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				String movieName = req.getParameter("movieName");
				
				if (movieName == null || movieName.trim().length() == 0) {
					errorMsgs.add("�п�J�q�v�W��");
				} 
				
				String movieEName = req.getParameter("movieEName").trim();
				if (movieEName == null || movieEName.trim().length() == 0) {
					errorMsgs.add("�п�J�^��W��");
				}
				
				java.sql.Date releaseDate = null;
				try {
					releaseDate = java.sql.Date.valueOf(req.getParameter("releaseDate").trim());
				} catch (IllegalArgumentException e) {
					releaseDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���");
				}
							
			   Integer mins = new Integer(req.getParameter("mins"));
				
				if (mins == null ) {
					errorMsgs.add("�ж�J����");
				} 

				String studio = req.getParameter("studio").trim();
				if (studio == null || studio.trim().length() == 0) {
					errorMsgs.add("�ж�J�o�椽�q");
				}	
				String plot = req.getParameter("plot").trim();
				if (plot == null || plot.trim().length() == 0) {
					errorMsgs.add("�ж�J�q�v²��");
				}	
				String actor = req.getParameter("actor").trim();
				if (actor == null || actor.trim().length() == 0) {
					errorMsgs.add("�ж�J�q�v�D�t");
				}	
				String director = req.getParameter("director").trim();
				if (director == null || director.trim().length() == 0) {
					errorMsgs.add("�ж�J�ɺt");
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
					errorMsgs.add("�п�ܹq�v���O");
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
					req.setAttribute("movieVO", movieVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/movieDataInsert.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				MovieService movieSvc = new MovieService();
				movieVO = movieSvc.addMovie(movieName, movieEName, releaseDate,
						 mins, studio, plot, poster, actor, director, movieTag);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/Backstage/movieInsertFinish.html";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/movieDataInsert.jsp");
				failureView.forward(req, res);
			}
		}
//		
//		
//		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.�����ШD�Ѽ�***************************************/
//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.�}�l�R�����***************************************/
//				EmpService empSvc = new EmpService();
//				empSvc.deleteEmp(empno);
//				
//				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
//				successView.forward(req, res);
//				
//				/***************************��L�i�઺���~�B�z**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("�R����ƥ���:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
	}
}
