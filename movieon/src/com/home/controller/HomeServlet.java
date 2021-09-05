package com.home.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.model.*;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("getSearchResult".equals(action)) {	// �Ӧ�Home.jsp�BsearchResult.jsp���ШD
			try {
				String search = req.getParameter("search").trim(); //����user�btextbox��J����r�L�o�e��ť�
				
				if(search!=null && search.length() > 0) {
					MovieService movieSvc = new MovieService();
					List<MovieVO> list = movieSvc.getAll();
//				List<MovieVO> resultList = movieSvc.getAllByMovieName(search); //�I�s���ت���k
					List<MovieVO> resultList = list.stream()
											   	   .filter(m -> m.getMovieName().contains(search))
											   	   .collect(Collectors.toList());
//				for(MovieVO movie:list) {
//					System.out.println(movie.getMovieName());
//				}
//				System.out.println("-------------------------------");
//				for(MovieVO movie:resultList) {
//					System.out.println(movie.getMovieName());
//				}
				
				req.setAttribute("resultList", resultList);
				String url ="/moviesHome/searchResult.jsp"; //
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� searchResult.jsp
				successView.forward(req, res);
				}else {
					List<MovieVO> resultList2 = new ArrayList<MovieVO>();
					req.setAttribute("resultList", resultList2);
					String url ="/moviesHome/searchResult.jsp"; //
					RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� searchResult.jsp
					successView.forward(req, res);
				}
			}catch(Exception e) {
				RequestDispatcher failureView = req.getRequestDispatcher("/Home.jsp");
				failureView.forward(req, res);
			}
		}
		
	}
}
