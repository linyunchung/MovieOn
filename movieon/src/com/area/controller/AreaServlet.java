package com.area.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.area.model.AreaService;
import com.area.model.AreaVO;
import com.theater.model.TheaterService;
import com.theater.model.TheaterVO;

public class AreaServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		/*************************�s�W�a�ϻP�v��*******************************/
		if("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			String successMsg = "";
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
			
			String city = req.getParameter("city");
			String cityReg = "^[(\u4e00-\u9fa5)]{0,3}$"; //���h��F��
			
			if(!city.trim().matches(cityReg)) {
				errorMsgs.add("�a�����u��O����A�B���׬��̦h��3");
			}
			
			
			String theaterName = req.getParameter("theaterName");
			String theaterNameReg = "^[(\u4e00-\u9fa5)]{3,10}$";
			
			if(theaterName==null || theaterName.trim().length()==0) {
				errorMsgs.add("�v����줣�i�ť�");
			}else if(!theaterName.trim().matches(theaterNameReg)) {
				errorMsgs.add("�v�����u��O����");
			}
			
			Integer areaNum = new Integer(req.getParameter("area").trim());
			
			AreaVO areaVO = new AreaVO();
			
			//�Y�s�W�a����쬰�ūh���i��Ʈw
			if(city.trim().length()!=0) {
				areaVO.setCity(city);
			}
			
			
			TheaterVO theaterVO = new TheaterVO();
			theaterVO.setAreaNum(areaNum);
			theaterVO.setTheaterName(theaterName);
			
			if(!errorMsgs.isEmpty()) {
				if(city.trim().length()!=0) {
					req.setAttribute("areaVO", areaVO);
				}
				req.setAttribute("theaterVO", theaterVO);
				RequestDispatcher failurview = req.getRequestDispatcher("/Backstage/backstage_add_theater.jsp");
				failurview.forward(req,res);
				return;
			}
			
			/*************************�}�l�s�W*******************************/
			
			//�Y�s�W�a����쬰�ūh���i��Ʈw
			if(city.trim().length()!=0) {
				AreaService areaSvc = new AreaService();
				areaSvc.addArea(city);
			}
		
			
			TheaterService theaterSvc = new TheaterService();
			theaterSvc.addTheater(areaNum, theaterName);
			
			/*************************�s�W�����A��^����*******************************/
			successMsg = "�s�W���\";
			req.setAttribute("successMsg", successMsg);
			String url = "/Backstage/backstage_add_theater.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
			
			}catch(Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failurview = req.getRequestDispatcher("/Backstage/backstage_add_theater.jsp");
				failurview.forward(req, res);
			}

		}
		
		/******************************************************************/
		
		
		
		
		
		
	}

}
