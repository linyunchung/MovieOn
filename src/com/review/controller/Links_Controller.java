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

		if ("getOne_From_Home".equals(action)) {	//接收從首頁過來的請求, 看特定一篇影評
			try {
				Integer reviewId=new Integer(req.getParameter("reviewId"));
				
				ReviewDAO dao= new ReviewDAO();
				ReviewVO reviewVO=dao.findByPrimaryKey(reviewId); //根據特定的影評編號找到該筆資料(reviewVO物件)
				
				req.setAttribute("reviewVO", reviewVO);	// 再將從資料庫取出的reviewVO物件,存入req
				
				// 將取出的reviewVO forward 到 該篇影評全文
				RequestDispatcher successView = req
						.getRequestDispatcher("/review/listOneReview2.jsp"); //forward到單一查詢
				successView.forward(req, res);
				return;
				
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
	}
}
