package com.prob.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.prob.model.ProbJDBCDAO;
import com.prob.model.ProbVO;

public class ProbServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		
		
        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);

//			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String probtype = req.getParameter("probtype");
				java.sql.Date probtime = java.sql.Date.valueOf(req.getParameter("probtime").trim());;
				String content = req.getParameter("content");
				String email = req.getParameter("email");

				ProbVO probVO = new ProbVO();
				probVO.setProbtype(probtype);
				probVO.setProbtime(probtime);
				probVO.setContent(content);
				probVO.setEmail(email);
				

				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/addEmp.jsp");
//					failureView.forward(req, res);
//					return;
//				}
				
				/***************************2.開始新增資料***************************************/
				ProbJDBCDAO dao = new ProbJDBCDAO();
//				empVO = empSvc.addEmp(ename, job, hiredate, sal, comm, deptno);
				dao.insert(probVO);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/prob/contactcs.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/addEmp.jsp");
//				failureView.forward(req, res);
//			}
        }		
        if ("getType_For_Display".equals(action)) { // 來自select_page.jsp的請求

			
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String probtype = req.getParameter("probtype");
				
				if("全部".equals(probtype)) {
					ProbJDBCDAO dao = new ProbJDBCDAO();
					List<ProbVO> list = dao.getAll();
					req.setAttribute("list",list); // 資料庫取出的empVO物件,存入req
					String url = "/Backstage/result1.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
					successView.forward(req, res);
				}
				
				/***************************2.開始查詢資料*****************************************/
				ProbJDBCDAO dao = new ProbJDBCDAO();
				List<ProbVO> list = dao.findByType(probtype);
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("list",list); // 資料庫取出的empVO物件,存入req
				String url = "/Backstage/result1.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
				

				/***************************其他可能的錯誤處理*************************************/
		}	
	}
}
