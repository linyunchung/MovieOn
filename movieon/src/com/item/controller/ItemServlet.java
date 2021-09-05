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
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("itemId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入商品編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/itemSearch.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer itemId = null;
				try {
					itemId = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("商品編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/itemSearch.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				itemService itemSvc = new itemService();
				itemVO itemVO = itemSvc.getOneItem(itemId);
				if (itemVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/itemSearch.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("itemVO", itemVO); // 資料庫取出的empVO物件,存入req
				String url = "/Backstage/item.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/itemSearch.jsp");
				failureView.forward(req, res);
			}
		}
//		
//		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer itemId = new Integer(req.getParameter("itemId"));
				
				/***************************2.開始查詢資料****************************************/
				itemService itemSvc = new itemService();
				itemVO itemVO = itemSvc.getOneItem(itemId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("itemVO", itemVO); 
				String url = "/Backstage/itemUpdata.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
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
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer itemId = new Integer(req.getParameter("itemId").trim());
				
				String itemName = req.getParameter("itemName");
				if (itemName == null || itemName.trim().length() == 0) {
					errorMsgs.add("請填入商品名稱");
				} 
	            
				Integer price = new Integer(req.getParameter("price").trim());
				if (price == null) {
					errorMsgs.add("請填入庫存量");
				} 
				Integer inventory = new Integer(req.getParameter("inventory").trim());
				if (inventory == null) {
					errorMsgs.add("請填入庫存量");
				} 
				
				String productSpecifications = req.getParameter("productSpecifications").trim();
				if (productSpecifications == null || productSpecifications.trim().length() == 0) {
					errorMsgs.add("請填入商品規格");
				}	
				String introduction = req.getParameter("introduction").trim();
				if (introduction == null || introduction.trim().length() == 0) {
					errorMsgs.add("請填入商品簡介");
				}	
				
				String itemTag = req.getParameter("itemTag").trim();
				if (itemTag == null) {
					errorMsgs.add("請選擇商品類別");
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
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				
				itemVO = itemSvc.updateItem(itemId, itemName, price, 
						introduction, productSpecifications, inventory,  
						itemPic, itemTag, pic1, pic2, pic3);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("itemVO", itemVO); 
				String url = "/Backstage/item.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/itemSearch.jsp");
				failureView.forward(req, res);
			}
		}
//
        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String itemName = req.getParameter("itemName");
				if (itemName == null || itemName.trim().length() == 0) {
					errorMsgs.add("請輸入商品名稱");
				} 
				
				Integer price = new Integer(req.getParameter("price"));
				if (price == null ) {
					errorMsgs.add("請填入價錢");
				} 
				
				String introduction = req.getParameter("introduction");
				if (introduction == null || introduction.trim().length() == 0) {
					errorMsgs.add("請輸入商品簡介");
				} 
				
				String productSpecifications = req.getParameter("productSpecifications");
				if (productSpecifications == null || productSpecifications.trim().length() == 0) {
					errorMsgs.add("請輸入商品規格");
				} 
				
				Integer inventory = new Integer(req.getParameter("inventory"));
				if (inventory == null ) {
					errorMsgs.add("請填入庫存量");
				} 
				
				java.sql.Date shelfDate = null;
				try {
					shelfDate = java.sql.Date.valueOf(req.getParameter("shelfDate").trim());
				} catch (IllegalArgumentException e) {
					shelfDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期");
				}
							
				String itemTag = req.getParameter("itemTag").trim();
				if (itemTag == null || itemTag.trim().length() == 0) {
					errorMsgs.add("請選擇商品類別");
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
					req.setAttribute("itemVO", itemVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Backstage/itemInsert.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				itemService itemSvc = new itemService();
				itemVO = itemSvc.addItem(itemName, price, introduction,
						productSpecifications, inventory,
						shelfDate, itemPic, itemTag, pic1, pic2, pic3);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				
				String url = "/Backstage/itemInsertFinish.html";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Backstage/itemInsert.jsp");
				failureView.forward(req, res);
			}
		}
//		
//		
//		if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.接收請求參數***************************************/
//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.開始刪除資料***************************************/
//				EmpService empSvc = new EmpService();
//				empSvc.deleteEmp(empno);
//				
//				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//				successView.forward(req, res);
//				
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("刪除資料失敗:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
	}
}
