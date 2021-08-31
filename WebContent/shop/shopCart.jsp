<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.*"%>
<%@page import="com.item.model.ShopOrderItem"%>
<%@page import="com.item.model.itemService"%>
<%@page import="com.ProductImage.model.ProductImageVO"%>
<%@page import="com.ProductImage.model.ProductImageService"%>
<%@page import="com.orderList.model.*"%>

<%
	itemService itemSvc = new itemService();
	pageContext.setAttribute("itemSvc", itemSvc);
%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>我的購物車</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cart.css">

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
						</ul></li>

					<li class="dropdown"><a href="">交友</a>
						<ul>
							<li><a href="#">媒合配對</a></li>
							<li><a href="#">即時訊息</a></li>
							<li><a href="#">好友名單</a></li>
						</ul></li>

					<li class="dropdown"><a href="">電影時刻表</a>
						<ul>
							<li><a href="#">場次查詢</a></li>
							<li><a href="#">歷史紀錄</a></li>
						</ul></li>

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
				<p class="title_text">我的購物車</p>
				<form name="deleteForm" action="orderInfo.do" method="POST">
					<table>
						<tr>
							<th>商品編號</th>
							<th>商品圖片</th>
							<th>商品名稱</th>
							<th>商品數量</th>
							<th>商品單價</th>
							<th>小計金額</th>
							<th>刪除商品</th>
						</tr>


						<c:forEach var="itemVO" items="${shoppingCart}" varStatus="s">
							<tr>
								<td>${itemVO.itemId}</td>
								<td><img src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}"></td>
								<td><p class="itemName">${itemVO.itemName}</p></td>
								<td>${itemVO.itemQty}</td>
								<td>$${itemVO.price}</td>
								<td>$${itemVO.itemQty * itemVO.price}</td>
								<td><input type="hidden" name="action" value="DELETE">
									<input type="hidden" name="del" value="${s.index}"> 
<!-- 									<input type="submit" value="刪除" id="deleteItem"> -->
									<button class="delb"><a href="orderInfo.do?action=DELETE&del=${s.index}" class="del">刪除</a></button>
								</td>
							</tr>
						</c:forEach>
					</table>
				</form>

					<!-- 總計金額 -->
					<!-- 				<table> -->
					<!-- 					<tr> -->
					<!-- 						<td><p class="total">Total：$${totalAmount}</p></td> -->
					<!-- 					</tr> -->
					<!-- 				</table> -->


					<div class="last_button">

						<a href="<%=request.getContextPath()%>/shop/shopItem.jsp">
							<button class="btn1">繼續購物</button>
						</a>

						<form METHOD="post" ACTION="orderInfo.do">
							<input type="hidden" name="action" value="CONFIRM">
							<input type="submit" value="結帳" class="btn2">
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
				<li><a href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
				<li><a href="">聯絡我們</a></li>
			</ul>
		</div>

		<div class="footer_p">
			<span>© MovieOn. Made by programming students in Taipei, Taiwan. For learning purposes only.</span>
		</div>
	</div>
	<!--Close Footer -->



</body>
</html>