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
		
		
		
		
        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);

//			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
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
//					req.setAttribute("empVO", empVO); // �t����J�榡���~��empVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/addEmp.jsp");
//					failureView.forward(req, res);
//					return;
//				}
				
				/***************************2.�}�l�s�W���***************************************/
				ProbJDBCDAO dao = new ProbJDBCDAO();
//				empVO = empSvc.addEmp(ename, job, hiredate, sal, comm, deptno);
				dao.insert(probVO);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/prob/contactcs.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
//			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/addEmp.jsp");
//				failureView.forward(req, res);
//			}
        }		
        if ("getType_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String probtype = req.getParameter("probtype");
				
				if("����".equals(probtype)) {
					ProbJDBCDAO dao = new ProbJDBCDAO();
					List<ProbVO> list = dao.getAll();
					req.setAttribute("list",list); // ��Ʈw���X��empVO����,�s�Jreq
					String url = "/Backstage/result1.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
					successView.forward(req, res);
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				ProbJDBCDAO dao = new ProbJDBCDAO();
				List<ProbVO> list = dao.findByType(probtype);
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("list",list); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/Backstage/result1.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);
				

				/***************************��L�i�઺���~�B�z*************************************/
		}	
	}
}
