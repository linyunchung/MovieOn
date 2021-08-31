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
		
		//�s�W
		if ("insert".equals(action)) { // �Ӧ�addReview.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs); // "errorMsgs"����${errorMsgs}
			
			try {
				/*********************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z *************************/
				Integer userId = new Integer(req.getParameter("userId")); // �|���W��
				
				String reviewTitle = req.getParameter("reviewTitle");
				if (reviewTitle == null || reviewTitle.trim().length() == 0) {
					errorMsgs.add("�v�����D: �ФŪť�");
				}

				Integer movieId = new Integer(req.getParameter("movieId").trim()); // �q�v�U�Կ��

				String postedAt = req.getParameter("postedAt"); // �o�����

				String ratingStr = req.getParameter("rating");
				System.out.println(ratingStr);
				Double starRate = null;
				if (ratingStr == null) {
					errorMsgs.add("�v������: �е�������");
				} else {
					starRate = new Double(ratingStr);
				}

				String review = req.getParameter("review");
				if (review == null || review.trim().length() == 0) {
					errorMsgs.add("�v������: �ФŪť�");
				}else {
					if(review.trim().length() < 100) {
						errorMsgs.add("�v������: �n�W�L100�Ӧr!!!");
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
				System.out.println(text); //StringBuffer���A
				
				
				ReviewVO reviewVO = new ReviewVO();
				reviewVO.setUserId(userId);
				reviewVO.setMovieId(movieId);
				reviewVO.setReviewTitle(reviewTitle);
				reviewVO.setStarRate(starRate);
				reviewVO.setReview(review);
				reviewVO.setPostedAt(Timestamp.valueOf(postedAt));

//				System.out.println(errorMsgs.size());

				// �Y�W�z�����@���S��ζ񪺮榡���~, ���n��^���Ӫ�����addReview.jsp
				// ��J���Ҧ��q�L�N���|�i��if, �|�]��B�J2�}�l�s�W���
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("reviewVO", reviewVO); // �t����J�榡���~��reviewVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/review/addReview.jsp"); //forward
					failureView.forward(req, res);
					return;
				}

				/********************************** 2.�}�l�s�W��� ***************************************/
				ReviewService revSvc = new ReviewService();
				reviewVO = revSvc.addReview(userId, movieId, reviewTitle, starRate, review,
						Timestamp.valueOf(postedAt));

				/*************************** 3.�s�W����,�޾ɦܼv�����߭������ϥΪ̽T�{���s�W���\ ***********/
				String url = "/review/listAllReview_byDAO.jsp";
				String url2 = "/review/reviewCenter.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url2); // �s�W���\�����listAllReview_byDAO.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/review/addReview.jsp");
				failureView.forward(req, res);
			}
		} // insert

		
		//�R��
		if ("delete".equals(action)) { // �Ӧ�listAllReview_byDAO.java���ШD (�v���M��)
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/****** Step 1.�����ШD�Ѽ�, �]���ϥΪ̤��ο�J��r�����s�Ӥw, �ҥH���ή榡���� ******/
				Integer reviewId = new Integer(req.getParameter("reviewId"));

				/****** Step 2.�}�l�R���, �إ�service object, �h�I�sReviewDAO��delete() ********/
				ReviewService revSvc = new ReviewService();
				revSvc.deleteReview(reviewId); // reviewId���service, �h�I�sReviewDAO��delete()

				/****** Step 3.�R������,�ǳ���� ***************/
				String url = "/review/listAllReview_byDAO.jsp";
//				String url2 = "/review/reviewCenter.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �R�����\��,���^�e�X�R�����ӷ�����listAllReview_byDAO.jsp
				successView.forward(req, res);
				System.out.println("�R�����\");
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/review/listAllReview_byDAO.jsp");
				failureView.forward(req, res);
			}
		}//delete

		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllReview_byDAO.java���ШD (�v���M��)
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/****** Step 1.�����ШD�Ѽ�,*****/
				Integer reviewId = new Integer(req.getParameter("reviewId")); //���n�ק�(�s��)�峹���峹id
				
				/****** Step 2.�}�l�d�߸��, �إ�service object, �h�I�sReviewDAO��getOneReview(��reviewId) ********/
				ReviewService revSvc = new ReviewService();
				ReviewVO reviewVO=revSvc.getOneReview(reviewId);
				
				/****** Step 3.�d�ߧ���,�ǳƤ޾ɨ�s��v�������� ***************/
				req.setAttribute("reviewVO", reviewVO); //�]�F�{�������, ����i�H�o�˼g.....?
				String url = "/review/update_review_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_review_input.jsp
				successView.forward(req, res);
			}catch(Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/review/reviewCenter.jsp");
				failureView.forward(req, res);
			}
		} // getOne_For_Update
		
		
		//�ק�
		if ("update".equals(action)) { // �Ӧ�update_review_input.jsp���ШD
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer reviewId = new Integer(req.getParameter("reviewId")); 
				Integer userId = new Integer(req.getParameter("userId"));
				String reviewTitle = req.getParameter("reviewTitle");
				if (reviewTitle == null || reviewTitle.trim().length() == 0) {
					errorMsgs.add("�v�����D: �ФŪť�");
				}

				Integer movieId = new Integer(req.getParameter("movieId").trim()); // �q�v�U�Կ��

				String postedAt = req.getParameter("postedAt"); // �o�����

				String ratingStr = req.getParameter("rating");
				System.out.println(ratingStr);
				Double starRate = null;
				if (ratingStr == null) {
					errorMsgs.add("�v������: �е�������");
				} else {
					starRate = new Double(ratingStr);
				}

				String review = req.getParameter("review");
				if (review == null || review.trim().length() == 0) {
					errorMsgs.add("�v������: �ФŪť�");
				}else {
					if(review.length() < 100) {
						errorMsgs.add("�v������: �n�W�L100�Ӧr!!!");
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
					req.setAttribute("reviewVO", reviewVO); // �t����J�榡���~��reviewVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/review/update_review_input.jsp"); //forward
					failureView.forward(req, res);
					return;
				}

				/********************************** 2.�}�l�ק��� ***************************************/
				ReviewService revSvc = new ReviewService();
				revSvc.updateReview(reviewId, userId, movieId, reviewTitle, starRate, review, Timestamp.valueOf(postedAt));
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("reviewVO", reviewVO);
				String url = "/review/listOneReview2.jsp"; //��浹��@�d��
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneReview2.jsp
				successView.forward(req, res);
				
				
			}catch(Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/review/update_review_input.jsp");
				failureView.forward(req, res);
			}
				
		}//update
		
		
		
	}// doPost
}
