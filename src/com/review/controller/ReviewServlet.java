package com.review.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.ReviewService;
import com.review.model.ReviewVO;

public class ReviewServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		//新增
		if ("insert".equals(action)) { // 來自addReview.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs); // "errorMsgs"對應${errorMsgs}
			
			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				Integer userId = new Integer(req.getParameter("userId")); // 會員名稱
				
				String reviewTitle = req.getParameter("reviewTitle");
				if (reviewTitle == null || reviewTitle.trim().length() == 0) {
					errorMsgs.add("影評標題: 請勿空白");
				}

				Integer movieId = new Integer(req.getParameter("movieId").trim()); // 電影下拉選單

				String postedAt = req.getParameter("postedAt"); // 發布日期

				String ratingStr = req.getParameter("rating");
				System.out.println(ratingStr);
				Double starRate = null;
				if (ratingStr == null) {
					errorMsgs.add("影評評分: 請給予分數");
				} else {
					starRate = new Double(ratingStr);
				}

				String review = req.getParameter("review");
				if (review == null || review.trim().length() == 0) {
					errorMsgs.add("影評內文: 請勿空白");
				}else {
					if(review.trim().length() < 100) {
						errorMsgs.add("影評內文: 要超過100個字!!!");
					}
				}
				
				StringBuffer text = new StringBuffer(req.getParameter("review"));
				int loc= (new String(text).indexOf('\n'));
				while(loc > 0) {
					text.replace(loc, loc+1, "<br>");
					loc = (new String(text)).indexOf('\n');
				}
				req.setAttribute("review", text);
				RequestDispatcher rd = req.getRequestDispatcher("/review/addReview.jsp");
				System.out.println(text); //StringBuffer型態
				
				
				ReviewVO reviewVO = new ReviewVO();
				reviewVO.setUserId(userId);
				reviewVO.setMovieId(movieId);
				reviewVO.setReviewTitle(reviewTitle);
				reviewVO.setStarRate(starRate);
				reviewVO.setReview(review);
				reviewVO.setPostedAt(Timestamp.valueOf(postedAt));

//				System.out.println(errorMsgs.size());

				// 若上述有任一欄位沒填或填的格式錯誤, 都要返回到原來的頁面addReview.jsp
				// 輸入驗證有通過就不會進到if, 會跑到步驟2開始新增資料
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("reviewVO", reviewVO); // 含有輸入格式錯誤的reviewVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/review/addReview.jsp"); //forward
					failureView.forward(req, res);
					return;
				}

				/********************************** 2.開始新增資料 ***************************************/
				ReviewService revSvc = new ReviewService();
				reviewVO = revSvc.addReview(userId, movieId, reviewTitle, starRate, review,
						Timestamp.valueOf(postedAt));

				/*************************** 3.新增完成,引導至影評中心頁面讓使用者確認有新增成功 ***********/
				String url = "/review/listAllReview_byDAO.jsp";
				String url2 = "/review/reviewCenter.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url2); // 新增成功後轉交listAllReview_byDAO.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/review/addReview.jsp");
				failureView.forward(req, res);
			}
		} // insert

		
		//刪除
		if ("delete".equals(action)) { // 來自listAllReview_byDAO.java的請求 (影評清單)
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/****** Step 1.接收請求參數, 因為使用者不用輸入文字按按鈕而已, 所以不用格式驗證 ******/
				Integer reviewId = new Integer(req.getParameter("reviewId"));

				/****** Step 2.開始刪資料, 建立service object, 去呼叫ReviewDAO的delete() ********/
				ReviewService revSvc = new ReviewService();
				revSvc.deleteReview(reviewId); // reviewId放到service, 去呼叫ReviewDAO的delete()

				/****** Step 3.刪除完成,準備轉交 ***************/
				String url = "/review/listAllReview_byDAO.jsp";
//				String url2 = "/review/reviewCenter.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功後,轉交回送出刪除的來源網頁listAllReview_byDAO.jsp
				successView.forward(req, res);
				System.out.println("刪除成功");
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/review/listAllReview_byDAO.jsp");
				failureView.forward(req, res);
			}
		}//delete

		
		if ("getOne_For_Update".equals(action)) { // 來自listAllReview_byDAO.java的請求 (影評清單)
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/****** Step 1.接收請求參數,*****/
				Integer reviewId = new Integer(req.getParameter("reviewId")); //抓到要修改(編輯)文章的文章id
				
				/****** Step 2.開始查詢資料, 建立service object, 去呼叫ReviewDAO的getOneReview(放reviewId) ********/
				ReviewService revSvc = new ReviewService();
				ReviewVO reviewVO=revSvc.getOneReview(reviewId);
				
				/****** Step 3.查詢完成,準備引導到編輯影評的頁面 ***************/
				req.setAttribute("reviewVO", reviewVO); //包了現有的資料, 為何可以這樣寫.....?
				String url = "/review/update_review_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_review_input.jsp
				successView.forward(req, res);
			}catch(Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/review/reviewCenter.jsp");
				failureView.forward(req, res);
			}
		} // getOne_For_Update
		
		
		//修改
		if ("update".equals(action)) { // 來自update_review_input.jsp的請求
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer reviewId = new Integer(req.getParameter("reviewId")); 
				Integer userId = new Integer(req.getParameter("userId"));
				String reviewTitle = req.getParameter("reviewTitle");
				if (reviewTitle == null || reviewTitle.trim().length() == 0) {
					errorMsgs.add("影評標題: 請勿空白");
				}

				Integer movieId = new Integer(req.getParameter("movieId").trim()); // 電影下拉選單

				String postedAt = req.getParameter("postedAt"); // 發布日期

				String ratingStr = req.getParameter("rating");
				System.out.println(ratingStr);
				Double starRate = null;
				if (ratingStr == null) {
					errorMsgs.add("影評評分: 請給予分數");
				} else {
					starRate = new Double(ratingStr);
				}

				String review = req.getParameter("review");
				if (review == null || review.trim().length() == 0) {
					errorMsgs.add("影評內文: 請勿空白");
				}else {
					if(review.length() < 100) {
						errorMsgs.add("影評內文: 要超過100個字!!!");
					}
				}
				
				ReviewVO reviewVO = new ReviewVO();
				reviewVO.setReviewId(reviewId);
				reviewVO.setUserId(userId);
				reviewVO.setMovieId(movieId);
				reviewVO.setReviewTitle(reviewTitle);
				reviewVO.setStarRate(starRate);
				reviewVO.setReview(review);
				reviewVO.setPostedAt(Timestamp.valueOf(postedAt));
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("reviewVO", reviewVO); // 含有輸入格式錯誤的reviewVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/review/update_review_input.jsp"); //forward
					failureView.forward(req, res);
					return;
				}

				/********************************** 2.開始修改資料 ***************************************/
				ReviewService revSvc = new ReviewService();
				revSvc.updateReview(reviewId, userId, movieId, reviewTitle, starRate, review, Timestamp.valueOf(postedAt));
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("reviewVO", reviewVO);
				String url = "/review/listOneReview2.jsp"; //轉交給單一查詢
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneReview2.jsp
				successView.forward(req, res);
				
				
			}catch(Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/review/update_review_input.jsp");
				failureView.forward(req, res);
			}
				
		}//update
		
		
		
	}// doPost
}
