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

		// 在Console印出前端傳回值
		Map<String, String[]> params = req.getParameterMap();
		Set<String> keys = params.keySet();
		System.out.println("=================進入OrderInfoServlet=================");
		for (String key : keys) {
			String[] values = params.get(key);
			String s = Arrays.toString(values);
			// 因為 Arrays.toString()方法會回傳包含[]的一個列表，所以必須使用 substring 去頭去尾。
			s = s.substring(1, s.length() - 1);
			System.out.println(key + " : " + s);
		}
		System.out.println("=================結束OrderInfoServlet==取得參數==========");
		// 在Console印出前端傳回值-結束

		@SuppressWarnings("unchecked")
		Vector<ShopOrderItem> shoppingCart = (Vector<ShopOrderItem>) session.getAttribute("shoppingCart");
		String action = req.getParameter("action");

		
		// 新增品項至購物車(shopCart.jsp請求)
		if (action.equals("ADD")) {
			// 判斷錯誤訊息
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

				if (action.equals("ADD")) {

					boolean match = false;

					// 取得後來新增的品項
					String itemId = req.getParameter("itemId");
					Integer itemQty = null;
					try {
						itemQty = new Integer(req.getParameter("itemQty"));
					} catch (NumberFormatException e) {
						errorMsgs.add("數量請輸入數字");
					}
					itemService itemSvc = new itemService();
					itemVO itemVO = itemSvc.getOneItem((new Integer(itemId)).intValue());
					ShopOrderItem aOrderItem = new ShopOrderItem(itemVO, itemQty);

					// 新增第一種品項至購物車時
					if (shoppingCart == null) {
						shoppingCart = new Vector<ShopOrderItem>();
						if (itemQty > 0) {
							shoppingCart.add(aOrderItem);
						}
					} else {
						for (int i = 0; i < shoppingCart.size(); i++) {
							ShopOrderItem orderItem = shoppingCart.get(i);

							// 若新增的品項和購物車的品項一樣時
							if (orderItem.getItemId().equals(aOrderItem.getItemId())) {
								if (itemQty <= 0) {
									shoppingCart.removeElementAt(i);
								} else {
									orderItem.setItemQty(aOrderItem.getItemQty());
								}

								match = true;
							}
						}

						// 若新增的品項和購物車的品項不一樣時
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
				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				System.out.println("修改");
				errorMsgs.add("修改資料失敗:" + e.getMessage());

				RequestDispatcher failureView = req.getRequestDispatcher("/shop/shopItemOther.jsp");
				failureView.forward(req, res);
			}
		}

		
		// 刪除購物車品項(shopCart.jsp請求)
		if (action.equals("DELETE")) {
			// 判斷錯誤訊息
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				// 刪除購物車中的品項
				if (action.equals("DELETE")) {
					String del = req.getParameter("del");
					int d = Integer.parseInt(del);
					shoppingCart.removeElementAt(d);
				}
				session.setAttribute("shoppingCart", shoppingCart);
				String url = "/shop/shopCart.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				System.out.println("修改");
				errorMsgs.add("修改資料失敗:" + e.getMessage());

				RequestDispatcher failureView = req.getRequestDispatcher("/shop/shopItemOther.jsp");
				failureView.forward(req, res);
			}
		}

		
		// 計算購物車價錢總數(shopCart.jsp請求 -> shopBuy.jsp)
		if ("CONFIRM".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String requestURL = req.getParameter("requestURL");

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

				int total = 0;
				if (shoppingCart != null) {
					total = getSum(shoppingCart);
				}
				String orderTotal = String.valueOf(total);
				req.setAttribute("orderTotal", orderTotal);

				
				// 確認會員登入
				MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
				Integer userid = getUserid(memberVO);

					if (memberVO != null) {
						userid = memberVO.getUserid();
					} else {
						errorMsgs.add("請先登入會員");
						String loginUrl = "/member/log_in.jsp";
						RequestDispatcher failureView = req.getRequestDispatcher(loginUrl);
						failureView.forward(req, res);
						return;
					}
					
				String url = "/shop/shopBuy.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);

			} catch (Exception e) {
				System.out.println("修改");
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/shop/shopBuy.jsp");
				failureView.forward(req, res);
			}
		}

		
		
		// 結帳(shopBuy.jsp請求 -> shopOrderCheck.jsp)
		if ("CHECKOUT".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
					
				List<OrderListVO> orderListVOList = new ArrayList<>();

				if (shoppingCart != null && shoppingCart.size() != 0) {

					//會員編號
					MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
					Integer userid = memberVO.getUserid();
							
					Integer orderTotal = getSum(shoppingCart);
					
					String orderStatus = new String("訂單成立");

					Date date = new Date(System.currentTimeMillis());
					Timestamp orderDate = new Timestamp(date.getTime());

					String paymentMethodId = req.getParameter("paymentMethodId");
					if (paymentMethodId == null || paymentMethodId.trim().length() == 0) {
						errorMsgs.add("付款方式：請選擇");
					}

					String deliveryMethodId = req.getParameter("deliveryMethodId");
					if (deliveryMethodId == null || deliveryMethodId.trim().length() == 0) {
						errorMsgs.add("寄送方式：請選擇");
					}

					String consignee = req.getParameter("consignee");
					if (consignee == null || consignee.trim().length() == 0) {
						errorMsgs.add("收件人：請勿空白");
					}

					String mobile = req.getParameter("mobile");
					if (mobile == null || mobile.trim().length() == 0) {
						errorMsgs.add("電話：請勿空白");
					}

					String address = req.getParameter("address");
					if (address == null || address.trim().length() == 0) {
						errorMsgs.add("地址：請勿空白");
					}

					String invoiceId = req.getParameter("invoiceId");
					if (invoiceId == null || invoiceId.trim().length() == 0) {
						errorMsgs.add("發票資料：請選填");
					}

					String payStatus = new String("待付款");

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
				/*************************** 其他可能的錯誤處理 **********************************/
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