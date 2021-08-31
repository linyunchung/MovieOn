package com.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.*;

@WebServlet("/Links_Controller")
public class Links_Controller extends HttpServlet {
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_From_Home".equals(action)) {	//�����q�����L�Ӫ��ШD, �ݯS�w�@�g�v��
			try {
				Integer reviewId=new Integer(req.getParameter("reviewId"));
				
				ReviewDAO dao= new ReviewDAO();
				ReviewVO reviewVO=dao.findByPrimaryKey(reviewId); //�ھگS�w���v���s�����ӵ����(reviewVO����)
				
				req.setAttribute("reviewVO", reviewVO);	// �A�N�q��Ʈw���X��reviewVO����,�s�Jreq
				
				// �N���X��reviewVO forward �� �ӽg�v������
				RequestDispatcher successView = req
						.getRequestDispatcher("/review/listOneReview2.jsp"); //forward���@�d��
				successView.forward(req, res);
				return;
				
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
	}
}
