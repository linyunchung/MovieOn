package com.item.controller;

import java.io.*;
import java.sql.Blob;
import java.sql.Date;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.item.model.*;
import com.movie.model.MovieService;

@MultipartConfig
public class ItemServlet extends HttpServlet {

//	public void doGet(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//		doPost(req, res);
//	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

		try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("itemId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�ӫ~�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/itemSearch.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer itemId = null;
				try {
					itemId = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�ӫ~�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/itemSearch.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				itemService itemSvc = new itemService();
				itemVO itemVO = itemSvc.getOneItem(itemId);
				if (itemVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/itemSearch.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("itemVO", itemVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/Backstage/item.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/itemSearch.jsp");
				failureView.forward(req, res);
			}
		}
//		
//		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer itemId = new Integer(req.getParameter("itemId"));
				
				/***************************2.�}�l�d�߸��****************************************/
				itemService itemSvc = new itemService();
				itemVO itemVO = itemSvc.getOneItem(itemId);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("itemVO", itemVO); 
				String url = "/Backstage/itemUpdata.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
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
			if ("update".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer itemId = new Integer(req.getParameter("itemId").trim());
				
				String itemName = req.getParameter("itemName");
				if (itemName == null || itemName.trim().length() == 0) {
					errorMsgs.add("�ж�J�ӫ~�W��");
				} 
	            
				Integer price = new Integer(req.getParameter("price").trim());
				if (price == null) {
					errorMsgs.add("�ж�J�w�s�q");
				} 
				Integer inventory = new Integer(req.getParameter("inventory").trim());
				if (inventory == null) {
					errorMsgs.add("�ж�J�w�s�q");
				} 
				
				String productSpecifications = req.getParameter("productSpecifications").trim();
				if (productSpecifications == null || productSpecifications.trim().length() == 0) {
					errorMsgs.add("�ж�J�ӫ~�W��");
				}	
				String introduction = req.getParameter("introduction").trim();
				if (introduction == null || introduction.trim().length() == 0) {
					errorMsgs.add("�ж�J�ӫ~²��");
				}	
				
				String itemTag = req.getParameter("itemTag").trim();
				if (itemTag == null) {
					errorMsgs.add("�п�ܰӫ~���O");
				}	
				
				itemService itemSvc = new itemService();
				
				InputStream in = req.getPart("itemPic").getInputStream();
				byte[] itemPic = null;
				if(in.available()!=0) {
					itemPic = new byte[in.available()];
					in.read(itemPic);
					in.close();
				}else {
					itemPic = itemSvc.getOneItem(itemId).getItemPic();
				}
				
				InputStream in1 = req.getPart("pic1").getInputStream();
				byte[] pic1 = null;
				if(in1.available()!=0) {
					pic1 = new byte[in1.available()];
					in1.read(pic1);
					in1.close();
				}else {
					pic1 = itemSvc.getOneItem(itemId).getItemPic();
				}
				
				InputStream in2 = req.getPart("pic2").getInputStream();
				byte[] pic2 = null;
				if(in2.available()!=0) {
					pic2 = new byte[in2.available()];
					in2.read(pic2);
					in2.close();
				}else {
					pic2 = itemSvc.getOneItem(itemId).getItemPic();
				}
				
				InputStream in3 = req.getPart("pic3").getInputStream();
				byte[] pic3 = null;
				if(in3.available()!=0) {
					pic3 = new byte[in3.available()];
					in3.read(pic3);
					in3.close();
				}else {
					pic3 = itemSvc.getOneItem(itemId).getItemPic();
				}
				

				
			
				itemVO itemVO = new itemVO();
				
				itemVO.setItemName(itemName);
				itemVO.setPrice(price);
				itemVO.setInventory(inventory);
				itemVO.setProductSpecifications(productSpecifications);
				itemVO.setIntroduction(introduction);
				itemVO.setItemTag(itemTag);
				itemVO.setItemPic(itemPic);
				itemVO.setPic1(pic1);
				itemVO.setPic2(pic2);
				itemVO.setPic3(pic3);
				
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("itemVO", itemVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/itemUpdata.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				
				itemVO = itemSvc.updateItem(itemId, itemName, price, 
						introduction, productSpecifications, inventory,  
						itemPic, itemTag, pic1, pic2, pic3);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("itemVO", itemVO); 
				String url = "/Backstage/item.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/itemSearch.jsp");
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
				String itemName = req.getParameter("itemName");
				if (itemName == null || itemName.trim().length() == 0) {
					errorMsgs.add("�п�J�ӫ~�W��");
				} 
				
				Integer price = new Integer(req.getParameter("price"));
				if (price == null ) {
					errorMsgs.add("�ж�J����");
				} 
				
				String introduction = req.getParameter("introduction");
				if (introduction == null || introduction.trim().length() == 0) {
					errorMsgs.add("�п�J�ӫ~²��");
				} 
				
				String productSpecifications = req.getParameter("productSpecifications");
				if (productSpecifications == null || productSpecifications.trim().length() == 0) {
					errorMsgs.add("�п�J�ӫ~�W��");
				} 
				
				Integer inventory = new Integer(req.getParameter("inventory"));
				if (inventory == null ) {
					errorMsgs.add("�ж�J�w�s�q");
				} 
				
				java.sql.Date shelfDate = null;
				try {
					shelfDate = java.sql.Date.valueOf(req.getParameter("shelfDate").trim());
				} catch (IllegalArgumentException e) {
					shelfDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���");
				}
							
				String itemTag = req.getParameter("itemTag").trim();
				if (itemTag == null || itemTag.trim().length() == 0) {
					errorMsgs.add("�п�ܰӫ~���O");
				}	
				
				InputStream in = req.getPart("itemPic").getInputStream();
				byte[] itemPic = null;
				if(in.available()!=0) {
					itemPic = new byte[in.available()];
					in.read(itemPic);
					in.close();
					
				}
				
				InputStream in1 = req.getPart("pic1").getInputStream();
				byte[] pic1 = null;
				if(in1.available()!=0) {
					pic1 = new byte[in1.available()];
					in1.read(pic1);
					in1.close();
					
				}
				InputStream in2 = req.getPart("pic2").getInputStream();
				byte[] pic2 = null;
				if(in2.available()!=0) {
					pic2 = new byte[in2.available()];
					in2.read(pic2);
					in2.close();
					
				}
				InputStream in3 = req.getPart("pic3").getInputStream();
				byte[] pic3 = null;
				if(in3.available()!=0) {
					pic3 = new byte[in3.available()];
					in3.read(pic3);
					in3.close();
					
				}

				itemVO itemVO = new itemVO();
				
				itemVO.setItemName(itemName);
				itemVO.setPrice(price);
				itemVO.setIntroduction(introduction);
				itemVO.setProductSpecifications(productSpecifications);
				itemVO.setInventory(inventory);
				itemVO.setItemPic(itemPic);
				itemVO.setItemTag(itemTag);
				itemVO.setPic1(pic1);
				itemVO.setPic2(pic2);
				itemVO.setPic3(pic3);
				
				
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("itemVO", itemVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/itemInsert.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				itemService itemSvc = new itemService();
				itemVO = itemSvc.addItem(itemName, price, introduction,
						productSpecifications, inventory,
						shelfDate, itemPic, itemTag, pic1, pic2, pic3);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				
				String url = "/Backstage/itemInsertFinish.html";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/itemInsert.jsp");
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
