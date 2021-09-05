package com.home.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberVO;
import com.movie.model.*;
import com.review.model.*;

@WebServlet("/Links_Controller")
public class Links_Controller extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_From_Home".equals(action)) { // 看特定一篇"影評"
			try {
				
				/*
				HttpSession session = req.getSession();
				MemberVO memVO = (MemberVO)session.getAttribute("memberVO");
				if (memVO == null) {	//沒登入,就沒有memberVO
					RequestDispatcher successView = req.getRequestDispatcher("/member/log_in.jsp"); // forward到登入頁面
					successView.forward(req, res);
					return;
				}
				*/
				Integer reviewId = new Integer(req.getParameter("reviewId"));
				
				ReviewDAO dao = new ReviewDAO();
				ReviewVO reviewVO = dao.findByPrimaryKey(reviewId); // 根據特定的影評編號找到該筆資料(reviewVO物件)

				BufferedReader br = new BufferedReader(new StringReader(reviewVO.getReview()));
				String text = br.lines()
							    .collect(Collectors.joining("<br>"));
				
				reviewVO.setReview(text);
				
				req.setAttribute("reviewVO", reviewVO); // 再將從資料庫取出的reviewVO物件,存入req
				
				
				// 將取出的reviewVO forward 到 該篇影評全文
				RequestDispatcher successView = req.getRequestDispatcher("/review/listOneReview2.jsp"); // forward到單一查詢
				successView.forward(req, res);
				return;
				
				

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}

		
		
		if ("getOneMovie_From_Home".equals(action)) { // 看特定"片單"
			try {
				Integer movieId = new Integer(req.getParameter("movieId"));

				MovieJDBCDAO dao = new MovieJDBCDAO();
				MovieVO movieVO = dao.findByPrimaryKey(movieId); // 根據電影編號找到該筆資料(movieVO物件)
				
				ReviewDAO rDao = new ReviewDAO();
				Map<Integer, List<ReviewVO>> map = rDao.getAll().stream()
							 .collect(Collectors.groupingBy(ReviewVO::getMovieId));
				
				List<ReviewVO> list = map.get(movieId); //沒人寫影評就無法用movieId去抓那筆ReviewVO object
				if (list == null) {
					req.setAttribute("average", 0.0); //0.0分
					req.setAttribute("amount", 0);	//0人
				} else {
					OptionalDouble average = list.stream()
												 .mapToDouble(r -> r.getStarRate())
												 .average();
				
					if (average.isPresent()) {
						NumberFormat nf = new DecimalFormat();
						nf.setMaximumFractionDigits(1);
						req.setAttribute("average", nf.format(average.getAsDouble()));
						req.setAttribute("amount", map.get(movieId).size());
					}
				}
				
				req.setAttribute("movieVO", movieVO); // 再將從資料庫取出的movieVO物件,存入req

				// 將取出的reviewVO forward 到該影片的基本資料
				RequestDispatcher successView = req.getRequestDispatcher("/moviesHome/oneMovie.jsp"); // forward到單一查詢
				successView.forward(req, res);
				return;

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}
}
