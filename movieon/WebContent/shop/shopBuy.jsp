<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.orderInfo.model.*"%>
<%@ page import="com.item.model.*"%>
<%@ page import="com.ProductImage.model.*"%>

<%
	OrderInfoVO orderInfoVO = (OrderInfoVO) request.getAttribute("orderInfoVO");
%>


<%
	itemService itemSvc = new itemService();
	pageContext.setAttribute("itemSvc", itemSvc);
%>

<%--
	 //  MEMVO mem = (MEMVO)session.getAttribute("mem");
	 //  String mem_no = mem.getMem_no();
	 
	 OrderInfoService orderInfoSvc = new OrderInfoService();
	 List<OrderInfoVO> orderInfolist = orderInfoSvc.getMyOrderInfo(1);
	 pageContext.setAttribute("orderInfolist", orderInfolist);
--%>



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>確認訂單</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/buy.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap"
	rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap"
	rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap"
	rel="stylesheet">
</head>


<body>
	<!--Start wrapper-->
	<div id="wrapper">

		<!--Start Header & nav-->
		<div id="header">
			<nav>
				<div class="logo">
					<a href="<%=request.getContextPath()%>/Home.jsp" class="logo">
						<img src="<%=request.getContextPath()%>/images/logo/logo.png"
						alt="">
					</a>
				</div>

				<ul>
					<li class="dropdown"><a
						href="${pageContext.request.contextPath}/Home.jsp">電影探索</a>
						<ul>
							<li><a href="#">查詢電影類型</a></li>
							<li><a href="#">電影推薦</a></li>
							<li><a href="#">留下影評</a></li>
							<li><a href="#">影評中心</a></li>
						</ul></li>


					<li class="dropdown"><a
						href="<%=request.getContextPath()%>/showing/showing_search.jsp">電影時刻表</a>
						<ul>
							<li><a href="#">場次查詢</a></li>
							<li><a href="#">歷史紀錄</a></li>
						</ul></li>

					<li class="dropdown"><a
						href="<%=request.getContextPath()%>/shop/shopPage.jsp">商城</a>
						<ul>
							<li><a
								href="<%=request.getContextPath()%>/shop/shopItem.jsp">商品列表</a></li>
							<li><a
								href="<%=request.getContextPath()%>/shop/shopCart.jsp">購物車</a></li>
							<li><a
								href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
							<li><a
								href="<%=request.getContextPath()%>/prob/contactcs.jsp">聯絡客服</a></li>
						</ul>
					</li>

					<li class="dropdown">
						<c:if test="${empty memberVO.username}">
							<a href="<%=request.getContextPath()%>/profile">會員中心 </a>
						</c:if> 
						<c:if test="${not empty memberVO.username}">
							<a href="<%=request.getContextPath()%>/profile">${memberVO.username} </a>
							<ul>
								<li><a href="${pageContext.request.contextPath}/profile?action=myfilms">我的評分</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=myreviews">我的影評</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=myfollowers">我的粉絲</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=myfollowing">追蹤中</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=mynetwork">動態牆</a></li>
            <li><a href="${pageContext.request.contextPath}/shop/shopSearch.jsp">我的訂單</a></li>
							</ul>
						</c:if>
					</li>
				</ul>

				<form class="search" action="search.php">
					<input name="q" placeholder="Search..." type="search">
				</form>

				<button class="signin">
					<a href="<%=request.getContextPath()%>/member/log_in.jsp">會員登入</a>
				</button>
			</nav>
		</div>
		<!--Close Header & nav-->


		<!--Start Main-->
		<main>
			<div id="content">
				<p class="title_text">確認訂單</p>

				<form METHOD="post" ACTION="orderInfo.do">
					<!-- 表頭 -->
					<table style="border: 1px solid rgb(230, 230, 230)">
						<tr>
							<th style="border: 1px solid rgb(230, 230, 230)">商品編號</th>
							<th style="border: 1px solid rgb(230, 230, 230)">商品圖片</th>
							<th style="border: 1px solid rgb(230, 230, 230)">商品名稱</th>
							<th style="border: 1px solid rgb(230, 230, 230)">商品數量</th>
							<th style="border: 1px solid rgb(230, 230, 230)">商品單價</th>
							<th style="border: 1px solid rgb(230, 230, 230)">小計金額</th>
						</tr>


						<!--Start 商品項目 -->
						<c:forEach var="itemVO" items="${shoppingCart}">
							<tr>
								<td style="border: 1px solid rgb(230, 230, 230)">${itemVO.itemId}</td>

								<td style="border: 1px solid rgb(230, 230, 230)"><img
									src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}">
								</td>

								<td style="border: 1px solid rgb(230, 230, 230)">
									<p class="itemName">${itemVO.itemName}</p>
								</td>

								<td style="border: 1px solid rgb(230, 230, 230)">${itemVO.itemQty}</td>
								<td style="border: 1px solid rgb(230, 230, 230)">$${itemVO.price}</td>
								<td style="border: 1px solid rgb(230, 230, 230)">$${itemVO.itemQty
									* itemVO.price}</td>
							</tr>
						</c:forEach>

					</table>

					<!-- 總計金額 -->
					<table style="border: 1px solid rgb(230, 230, 230)">
						<tr>
							<td style="border: 1px solid rgb(230, 230, 230)"><p
									class="total">Total：$${orderTotal}</p></td>
						</tr>
					</table>


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


					<!-- 收件資訊 -->
					<div class="consignee">
						<table class="tconsignee">
							<tr>
								<p class="c_textname">收件人資料</p>
							</tr>
							<tr>
								<td style="text-align: right">收件人*：</td>
								<td style="text-align: left"><input type="text" id="u_name"
									name="consignee"
									value="<%=(orderInfoVO == null) ? "" : orderInfoVO.getConsignee()%>" /></td>
							</tr>

							<tr>
								<td style="text-align: right">電話*：</td>
								<td style="text-align: left"><input type="tel" id="phone"
									name="mobile"
									value="<%=(orderInfoVO == null) ? "" : orderInfoVO.getMobile()%>" /></td>
							</tr>

							<tr>
								<td style="text-align: right">地址*：</td>
								<td style="text-align: left"><input type="text" id="addr"
									name="address"
									value="<%=(orderInfoVO == null) ? "" : orderInfoVO.getAddress()%>" /></td>
							</tr>
						</table>
					</div>


					<!-- 發票資訊 -->
					<div class="invoice">
						<p class="c_text">發票資料</p>
						<input type="radio" id="personal" name="invoiceId" value='個人'>
						<label for="personal">個人</label><br> <input type="radio"
							id="company" name="invoiceId" value='公司'><label
							for="company">公司</label>
						<p class="u_nump">
							統一編號：<input type="text" id="u_numbers" name="u_numbers"
								maxlength="8" size="8">
						</p>
					</div>


					<!-- 付款方式 -->
					<div class="pay">
						<p class="c_text">付款方式</p>
						<div class="pay_form">
							<input type="radio" id="credit_card" name="paymentMethodId"
								value='信用卡'> <label for="credit_card">信用卡付款</label> <br>
							<label id="card">信用卡卡號：</label> <input type="text" class="card"
								maxlength="4"> <input type="text" class="card"
								maxlength="4"> <input type="text" class="card"
								maxlength="4"> <input type="text" class="card"
								maxlength="4"> <label class="datetime">有效日期：</label> <input
								type="month" id="datetime" name="datetime"> <label
								for="pin" class="pin">背面末三碼:</label> <input type="text" id="pin"
								name="pin" size="1"> <br> <input type="radio"
								id="cash_home" name="paymentMethodId" value='貨到付款'> <label
								for="cash_home">貨到付款</label> <br> <input type="radio"
								id="atm" name="paymentMethodId" value='ATM轉帳'> <label
								for="atm">ATM轉帳</label> <br> <input type="radio"
								id="e_shop" name="paymentMethodId" value='超商付款'> <label
								for="e_shop">超商付款</label>
						</div>
					</div>

					<!-- 送貨方式 -->
					<div class="deliver">
						<p class="c_text">送貨方式</p>
						<div class="d_form">
							<input type="radio" id="d_home" name="deliveryMethodId"
								value='宅配到府'> <label for="d_home">宅配到府</label> <br>
							<input type="radio" id="d_shop" name="deliveryMethodId"
								value='超商取貨'> <label for="d_shop">超商取貨</label>
						</div>
					</div>


					<div class="last_button">
						<input type="hidden" name="action" value="CHECKOUT"> <input
							type="submit" value="確認結帳" class="btn1">
					</div>


				</form>
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
				<li><a
					href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
				<li><a href="">聯絡我們</a></li>
			</ul>
		</div>

		<div class="footer_p">
			<span>© MovieOn. Made by programming students in Taipei,
				Taiwan. For learning purposes only.</span>
		</div>
	</div>
	<!--Close Footer -->





	<!-- 載入 JavaScript & jQuery-->
	<script
		src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.6.0.min.js"></script>
	<script>
		// 信用卡卡號
		$("input.card").on("keydown", function(e) {
			if ((e.which >= 48 && e.which <= 57) || e.which == 8) {
				if (e.target.value.length == 0 && e.which == 8) {
					$(this).prev().focus();
				}
			} else {
				e.preventDefault();
			}
		});

		$("input.card").on("keyup", function(e) {
			let str = (e.target.value).replace(/\D/g, "");
			$(this).val(str);
			if (str.length == 4) {
				$(this).next().focus();
			}
		});
	</script>




</body>
</html>