package com.orderInfo.controller;

import java.io.*;
import java.util.*;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.*;
import javax.servlet.http.*;

import com.orderInfo.model.*;
import com.item.model.*;

import com.member.model.*;
import com.orderList.model.*;

public class OrderInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		// �bConsole�L�X�e�ݶǦ^��
		Map<String, String[]> params = req.getParameterMap();
		Set<String> keys = params.keySet();
		System.out.println("=================�i�JOrderInfoServlet=================");
		for (String key : keys) {
			String[] values = params.get(key);
			String s = Arrays.toString(values);
			// �]�� Arrays.toString()��k�|�^�ǥ]�t[]���@�ӦC��A�ҥH�����ϥ� substring �h�Y�h���C
			s = s.substring(1, s.length() - 1);
			System.out.println(key + " : " + s);
		}
		System.out.println("=================����OrderInfoServlet==���o�Ѽ�==========");
		// �bConsole�L�X�e�ݶǦ^��-����

		@SuppressWarnings("unchecked")
		Vector<ShopOrderItem> shoppingCart = (Vector<ShopOrderItem>) session.getAttribute("shoppingCart");
		String action = req.getParameter("action");

		
		// �s�W�~�����ʪ���(shopCart.jsp�ШD)
		if (action.equals("ADD")) {
			// �P�_���~�T��
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/

				if (action.equals("ADD")) {

					boolean match = false;

					// ���o��ӷs�W���~��
					String itemId = req.getParameter("itemId");
					Integer itemQty = null;
					try {
						itemQty = new Integer(req.getParameter("itemQty"));
					} catch (NumberFormatException e) {
						errorMsgs.add("�ƶq�п�J�Ʀr");
					}
					itemService itemSvc = new itemService();
					itemVO itemVO = itemSvc.getOneItem((new Integer(itemId)).intValue());
					ShopOrderItem aOrderItem = new ShopOrderItem(itemVO, itemQty);

					// �s�W�Ĥ@�ث~�����ʪ�����
					if (shoppingCart == null) {
						shoppingCart = new Vector<ShopOrderItem>();
						if (itemQty > 0) {
							shoppingCart.add(aOrderItem);
						}
					} else {
						for (int i = 0; i < shoppingCart.size(); i++) {
							ShopOrderItem orderItem = shoppingCart.get(i);

							// �Y�s�W���~���M�ʪ������~���@�ˮ�
							if (orderItem.getItemId().equals(aOrderItem.getItemId())) {
								if (itemQty <= 0) {
									shoppingCart.removeElementAt(i);
								} else {
									orderItem.setItemQty(aOrderItem.getItemQty());
								}

								match = true;
							}
						}

						// �Y�s�W���~���M�ʪ������~�����@�ˮ�
						if (!match) {
							if (itemQty > 0) {
								System.out.println(itemQty);
								shoppingCart.add(aOrderItem);
							}
						}
					}
				}
				session.setAttribute("shoppingCart", shoppingCart);
				String url = "/shop/shopItemOther.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				System.out.println("�ק�");
				errorMsgs.add("�ק��ƥ���:" + e.getMessage());

				RequestDispatcher failureView = req.getRequestDispatcher("/shop/shopItemOther.jsp");
				failureView.forward(req, res);
			}
		}

		
		// �R���ʪ����~��(shopCart.jsp�ШD)
		if (action.equals("DELETE")) {
			// �P�_���~�T��
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				// �R���ʪ��������~��
				if (action.equals("DELETE")) {
					String del = req.getParameter("del");
					int d = Integer.parseInt(del);
					shoppingCart.removeElementAt(d);
				}
				session.setAttribute("shoppingCart", shoppingCart);
				String url = "/shop/shopCart.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				System.out.println("�ק�");
				errorMsgs.add("�ק��ƥ���:" + e.getMessage());

				RequestDispatcher failureView = req.getRequestDispatcher("/shop/shopItemOther.jsp");
				failureView.forward(req, res);
			}
		}

		
		// �p���ʪ��������`��(shopCart.jsp�ШD -> shopBuy.jsp)
		if ("CONFIRM".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String requestURL = req.getParameter("requestURL");

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/

				int total = 0;
				if (shoppingCart != null) {
					total = getSum(shoppingCart);
				}
				String orderTotal = String.valueOf(total);
				req.setAttribute("orderTotal", orderTotal);

				
				// �T�{�|���n�J
				MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
				Integer userid = getUserid(memberVO);

					if (memberVO != null) {
						userid = memberVO.getUserid();
					} else {
						errorMsgs.add("�Х��n�J�|��");
						String loginUrl = "/member/log_in.jsp";
						RequestDispatcher failureView = req.getRequestDispatcher(loginUrl);
						failureView.forward(req, res);
						return;
					}
					
				String url = "/shop/shopBuy.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);

			} catch (Exception e) {
				System.out.println("�ק�");
				errorMsgs.add("�ק��ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/shop/shopBuy.jsp");
				failureView.forward(req, res);
			}
		}

		
		
		// ���b(shopBuy.jsp�ШD -> shopOrderCheck.jsp)
		if ("CHECKOUT".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
					
				List<OrderListVO> orderListVOList = new ArrayList<>();

				if (shoppingCart != null && shoppingCart.size() != 0) {

					//�|���s��
					MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
					Integer userid = memberVO.getUserid();
							
					Integer orderTotal = getSum(shoppingCart);
					
					String orderStatus = new String("�q�榨��");

					Date date = new Date(System.currentTimeMillis());
					Timestamp orderDate = new Timestamp(date.getTime());

					String paymentMethodId = req.getParameter("paymentMethodId");
					if (paymentMethodId == null || paymentMethodId.trim().length() == 0) {
						errorMsgs.add("�I�ڤ覡�G�п��");
					}

					String deliveryMethodId = req.getParameter("deliveryMethodId");
					if (deliveryMethodId == null || deliveryMethodId.trim().length() == 0) {
						errorMsgs.add("�H�e�覡�G�п��");
					}

					String consignee = req.getParameter("consignee");
					if (consignee == null || consignee.trim().length() == 0) {
						errorMsgs.add("����H�G�ФŪť�");
					}

					String mobile = req.getParameter("mobile");
					if (mobile == null || mobile.trim().length() == 0) {
						errorMsgs.add("�q�ܡG�ФŪť�");
					}

					String address = req.getParameter("address");
					if (address == null || address.trim().length() == 0) {
						errorMsgs.add("�a�}�G�ФŪť�");
					}

					String invoiceId = req.getParameter("invoiceId");
					if (invoiceId == null || invoiceId.trim().length() == 0) {
						errorMsgs.add("�o����ơG�п��");
					}

					String payStatus = new String("�ݥI��");

					for (ShopOrderItem shopOrderItem : shoppingCart) {
						OrderListVO orderListVO = new OrderListVO();
						orderListVO.setItemId(shopOrderItem.getItemId());
						orderListVO.setPrice(shopOrderItem.getPrice());
						orderListVO.setItemQty(shopOrderItem.getItemQty());
						orderListVOList.add(orderListVO);
					}

					OrderInfoVO orderInfoVO = new OrderInfoVO();

					orderInfoVO.setUserId(userid);
					orderInfoVO.setOrderStatus(orderStatus);
					orderInfoVO.setOrderDate(orderDate);
					orderInfoVO.setPaymentMethodId(paymentMethodId);
					orderInfoVO.setDeliveryMethodId(deliveryMethodId);
					orderInfoVO.setConsignee(consignee);
					orderInfoVO.setMobile(mobile);
					orderInfoVO.setAddress(address);
					orderInfoVO.setInvoiceId(invoiceId);
					orderInfoVO.setOrderTotal(orderTotal);
					orderInfoVO.setPayStatus(payStatus);

					if (!errorMsgs.isEmpty()) {
						req.setAttribute("orderTotal", orderTotal);
						req.setAttribute("orderInfoVO", orderInfoVO);
						RequestDispatcher failureView = req.getRequestDispatcher("/shop/shopBuy.jsp");
						failureView.forward(req, res);
						return;
					}

					OrderInfoService orderInfoSvc = new OrderInfoService();
					
					orderInfoSvc.addOrderListVO(orderInfoVO, orderListVOList);


					req.setAttribute("orderInfoVO", orderInfoVO);
					req.setAttribute("orderTotal", orderTotal);
					String url = "/shop/shopOrderCheck.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
					session.removeAttribute("shoppingCart");

				}
				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/shop/shopBuy.jsp");
				failureView.forward(req, res);
			}
		}

	}

	private Integer getUserid(MemberVO memberVO) {
		return null;
	}

	private Integer getSum(Vector<ShopOrderItem> shoppingCart) {
		return shoppingCart.stream().mapToInt(i -> i.getItemQty() * i.getPrice()).sum();
	}
}