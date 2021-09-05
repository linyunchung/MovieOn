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

		if ("getOne_From_Home".equals(action)) { // �ݯS�w�@�g"�v��"
			try {
				
				/*
				HttpSession session = req.getSession();
				MemberVO memVO = (MemberVO)session.getAttribute("memberVO");
				if (memVO == null) {	//�S�n�J,�N�S��memberVO
					RequestDispatcher successView = req.getRequestDispatcher("/member/log_in.jsp"); // forward��n�J����
					successView.forward(req, res);
					return;
				}
				*/
				Integer reviewId = new Integer(req.getParameter("reviewId"));
				
				ReviewDAO dao = new ReviewDAO();
				ReviewVO reviewVO = dao.findByPrimaryKey(reviewId); // �ھگS�w���v���s�����ӵ����(reviewVO����)

				BufferedReader br = new BufferedReader(new StringReader(reviewVO.getReview()));
				String text = br.lines()
							    .collect(Collectors.joining("<br>"));
				
				reviewVO.setReview(text);
				
				req.setAttribute("reviewVO", reviewVO); // �A�N�q��Ʈw���X��reviewVO����,�s�Jreq
				
				
				// �N���X��reviewVO forward �� �ӽg�v������
				RequestDispatcher successView = req.getRequestDispatcher("/review/listOneReview2.jsp"); // forward���@�d��
				successView.forward(req, res);
				return;
				
				

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}

		
		
		if ("getOneMovie_From_Home".equals(action)) { // �ݯS�w"����"
			try {
				Integer movieId = new Integer(req.getParameter("movieId"));

				MovieJDBCDAO dao = new MovieJDBCDAO();
				MovieVO movieVO = dao.findByPrimaryKey(movieId); // �ھڹq�v�s�����ӵ����(movieVO����)
				
				ReviewDAO rDao = new ReviewDAO();
				Map<Integer, List<ReviewVO>> map = rDao.getAll().stream()
							 .collect(Collectors.groupingBy(ReviewVO::getMovieId));
				
				List<ReviewVO> list = map.get(movieId); //�S�H�g�v���N�L�k��movieId�h�쨺��ReviewVO object
				if (list == null) {
					req.setAttribute("average", 0.0); //0.0��
					req.setAttribute("amount", 0);	//0�H
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
				
				req.setAttribute("movieVO", movieVO); // �A�N�q��Ʈw���X��movieVO����,�s�Jreq

				// �N���X��reviewVO forward ��Ӽv�����򥻸��
				RequestDispatcher successView = req.getRequestDispatcher("/moviesHome/oneMovie.jsp"); // forward���@�d��
				successView.forward(req, res);
				return;

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}
}
