<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>

<%@ page import="com.orderInfo.model.*"%>
<%@ page import="com.item.model.*"%>

<%
	OrderInfoVO orderInfoVO = (OrderInfoVO) request.getAttribute("orderInfoVO");
%>



<%
	itemService itemSvc = new itemService();
	pageContext.setAttribute("itemSvc", itemSvc);
%>



<%
	 //  MEMVO mem = (MEMVO)session.getAttribute("mem");
	 //  String mem_no = mem.getMem_no();
	 
	 OrderInfoService orderInfoSvc = new OrderInfoService();
	 List<OrderInfoVO> orderInfolist = orderInfoSvc.getMyOrderInfo(1);
	 pageContext.setAttribute("orderInfolist", orderInfolist);
%>



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>訂單完成確認</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/orderCheck.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">

</head>

<body>
	<!--Start wrapper-->
	<div id="wrapper">

		<!--Start Header & nav-->
		<div id="header">
			<nav>
				<div class="logo">
					<img src="<%=request.getContextPath()%>/images/logo/logo.png" alt="">
				</div>

				<ul>
					<li class="dropdown"><a href="">電影探索</a>
						<ul>
							<li><a href="#">查詢電影類型</a></li>
							<li><a href="#">電影推薦</a></li>
							<li><a href="#">留下影評</a></li>
							<li><a href="#">影評中心</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="">交友</a>
						<ul>
							<li><a href="#">媒合配對</a></li>
							<li><a href="#">即時訊息</a></li>
							<li><a href="#">好友名單</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="">電影時刻表</a>
						<ul>
							<li><a href="#">場次查詢</a></li>
							<li><a href="#">歷史紀錄</a></li>
						</ul>
					</li>

					<li class="dropdown"><a
						href="<%=request.getContextPath()%>/shop/shopPage.jsp">商城</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/shop/shopItem.jsp">商品列表</a></li>
							<li><a href="<%=request.getContextPath()%>/shop/shopCart.jsp">購物車</a></li>
							<li><a href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="">會員中心</a>
						<ul>
							<li><a href="#">我的評分</a></li>
							<li><a href="#">我的影評</a></li>
							<li><a href="#">我追蹤的作者</a></li>
							<li><a href="<%=request.getContextPath()%>/shop/shopSearch.jsp">我的訂單</a></li>
							<li><a href="#">動態牆</a></li>
						</ul>
					</li>
				</ul>

				<form class="search" action="search.php">
					<input name="q" placeholder="Search..." type="search">
				</form>

				<button class="signin">
					<a href="#">會員登入</a>
				</button>
			</nav>
		</div>
		<!--Close Header & nav-->


		<!--Start Main-->
		<main>
			<div id="content">
				<p class="title_text">訂單完成確認</p>
				<p class="p_text">親愛的Movie On會員，以下為您的訂單明細，感謝您的訂購!</p>
				<hr>

				<!-- 訂單明細 -->
				<div class="order">

					<%-- 錯誤表列 --%>
					<div class="msgs">
						<c:if test="${not empty errorMsgs}">
							<ul style="list-style: none;">
								<c:forEach var="message" items="${errorMsgs}">
									<li>${message}</li>
								</c:forEach>
							</ul>
						</c:if>
					</div>

					<p class="c_text">訂單資訊</p>
					<table class="order_no">
						<tr>
							<th>訂單編號</th>
							<th>訂單日期</th>
							<th>總金額</th>
							<th>付款方式</th>
							<th>發票類型</th>
							<th>送貨方式</th>
						</tr>
						<tr>
							<td>${orderInfoVO.orderId}</td>
							<td>
                            	<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${orderInfoVO.orderDate}" />
                            </td>
							<td>$${orderTotal}</td>
							<td>${orderInfoVO.paymentMethodId}</td>
							<td>${orderInfoVO.invoiceId}</td>
							<td>${orderInfoVO.deliveryMethodId}</td>
						</tr>
					</table>


					<p class="c_text">收件人資料</p>
					<table class="order_con">
						<tr>
							<th>收件人</th>
							<th>電話</th>
							<th>地址</th>
						</tr>
						<tr>
							<td>${orderInfoVO.consignee}</td>
							<td>${orderInfoVO.mobile}</td>
							<td>${orderInfoVO.address}</td>
						</tr>
					</table>


					<p class="c_text">訂單明細</p>
					<table class="order_item">
						<tr>
							<th>商品編號</th>
							<th>商品名稱</th>
							<th>商品數量</th>
							<th>商品單價</th>
							<th>小計金額</th>
						</tr>
						
						<c:forEach var="itemVO" items="${shoppingCart}">
						<tr>
							<td>${itemVO.itemId}</td>
							<td>${itemVO.itemName}</td>
							<td>${itemVO.itemQty}</td>
							<td>$${itemVO.price}</td>
							<td>$${itemVO.itemQty * itemVO.price}</td>
						</tr>
						</c:forEach>	
					</table>

					
				</div>



				<div class="last_btn">
					<a href="#"><button class="btn1">回到首頁</button></a> 
					<a href="<%=request.getContextPath()%>/shop/shopSearch.jsp">
						<button class="btn2">我的訂單</button>
					</a>
				</div>

			</div>
		</main>
		<!--Close Main-->

	</div>
	<!--Close wrapper-->



	<!--Start Footer -->
	<div class="footer">
		<div class="footer_inner">
			<ul>
				<li><a href="">回到首頁</a></li>
				<li><a href="">關於我們</a></li>
				<li><a href="">服務說明</a></li>
				<li><a href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
				<li><a href="">聯絡我們</a></li>
			</ul>
		</div>

		<div class="footer_p">
			<span>© MovieOn. Made by programming students in Taipei,Taiwan. For learning purposes only.</span>
		</div>
	</div>
	<!--Close Footer -->


</body>
</html>