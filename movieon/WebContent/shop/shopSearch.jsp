<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.* "%>

<%@ page import="com.orderInfo.model.*"%>
<%@ page import="com.orderList.model.*"%>
<%@ page import="com.item.model.*"%>
<%@ page import="com.member.model.*"%>


<%
	MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
	if (memberVO == null) {
		response.sendRedirect(request.getContextPath() + "/member/log_in.jsp"); 
		return;
	}
	Integer userid = memberVO.getUserid();
	OrderInfoService orderInfoSvc = new OrderInfoService();
	List<OrderInfoVO> orderInfolist = orderInfoSvc.getMyOrderInfo(userid);
	pageContext.setAttribute("orderInfolist", orderInfolist);

%>

<%
	OrderListService OrderListSvc = new OrderListService();
	List<OrderListVO> orderList = OrderListSvc.getAll();
	pageContext.setAttribute("orderList", orderList);
%>

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
<title>訂單查詢</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/orderSearch.css">

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
					<img src="<%=request.getContextPath()%>/images/logo/logo.png" alt="">
				</a>
				</div>

				<ul>
					<li class="dropdown"><a href="${pageContext.request.contextPath}/Home.jsp">電影探索</a>
						<ul>
							<li><a href="#">查詢電影類型</a></li>
							<li><a href="#">電影推薦</a></li>
							<li><a href="#">留下影評</a></li>
							<li><a href="#">影評中心</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="<%=request.getContextPath()%>/showing/showing_search.jsp">電影時刻表</a>
						<ul>
							<li><a href="#">場次查詢</a></li>
							<li><a href="#">歷史紀錄</a></li>
						</ul>
					</li>

					<li class="dropdown"><a
						href="<%=request.getContextPath()%>/shop/shopPage.jsp">商城</a>
						<ul>
							<li><a
								href="<%=request.getContextPath()%>/shop/shopItem.jsp">商品列表</a></li>
							<li><a
								href="<%=request.getContextPath()%>/shop/shopCart.jsp">購物車</a></li>
							<li><a
								href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
								<li><a href="<%=request.getContextPath()%>/prob/contactcs.jsp">聯絡客服</a></li>
						</ul>
					</li>

					<li class="dropdown">
<!-- 					<a href="">會員中心</a> -->
<%-- 						<c:if test="${empty memberVO.username}"> --%>
<%-- 							<a href="<%=request.getContextPath()%>/profile">會員中心 </a> --%>
<%-- 						</c:if>  --%>
<%-- 						<c:if test="${not empty memberVO.username}"> --%>
							<a href="<%=request.getContextPath()%>/profile">${memberVO.username} </a>
						<ul>
<!-- 							<ul> -->
			<li><a href="${pageContext.request.contextPath}/profile?action=myfilms">我的評分</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=myreviews">我的影評</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=myfollowers">我的粉絲</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=myfollowing">追蹤中</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=mynetwork">動態牆</a></li>
            <li><a href="${pageContext.request.contextPath}/shop/shopSearch.jsp">我的訂單</a></li>
							</ul>
<%-- 						</c:if> --%>
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
				<p class="title_text">我的訂單</p>


				<!-- 條件判斷 -->
				<c:if test="${not empty orderInfolist}">
					<div class="order">

						<c:forEach var="orderInfoVO" items="${orderInfolist}">
							<table class="order_no">
								<tr>
									<th>訂單編號</th>
									<th>訂單時間</th>
									<th>收件人</th>
									<th>付款方式</th>
									<th>付款狀態</th>
									<th>送貨方式</th>
									<th>訂單狀態</th>
									<th>發票類型</th>
									<th>訂單明細</th>
								</tr>
								<tr>
									<td>${orderInfoVO.orderId}</td>
									<td><fmt:formatDate type="both" dateStyle="medium"
											timeStyle="medium" value="${orderInfoVO.orderDate}" /></td>
									<td>${orderInfoVO.consignee}</td>
									<td>${orderInfoVO.paymentMethodId}</td>
									<td>${orderInfoVO.payStatus}</td>
									<td>${orderInfoVO.deliveryMethodId}</td>
									<td>${orderInfoVO.orderStatus}</td>
									<td>${orderInfoVO.invoiceId}</td>
								</tr>
							</table>

							<button class="accordion">展開</button>

							<div class="panel">
								<table class="order_item">
									<tr>
										<th>商品編號</th>
										<th>商品名稱</th>
										<th>商品數量</th>
										<th>商品單價</th>
										<th>小計金額</th>
									</tr>

									<c:forEach var="orderListVO" items="${orderList}">
										<c:set var="price" value="${orderListVO.price}" />
										<c:set var="itemQty" value="${orderListVO.itemQty}" />
										<c:set var="itemVO"
											value="${itemSvc.getOneItem(orderListVO.itemId)}"></c:set>

										<c:if test="${orderListVO.orderId == orderInfoVO.orderId}">
											<tr>
												<td>${orderListVO.itemId}</td>
												<td>${itemVO.itemName}</td>
												<td>${orderListVO.itemQty}</td>
												<td>${orderListVO.price}</td>
												<td>${price*itemQty}</td>
											</tr>
										</c:if>


									</c:forEach>

								</table>
							</div>
							<br>
							<hr>
						</c:forEach>

					</div>
				</c:if>



				<div class="last_btn">
					<a href="<%=request.getContextPath()%>/shop/shopPage.jsp"><button
							class="btn1">回到首頁</button></a> <a
						href="<%=request.getContextPath()%>/shop/shopItem.jsp"><button
							class="btn2">繼續購物</button></a>
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
		var acc = document.getElementsByClassName("accordion");
		var i;

		for (i = 0; i < acc.length; i++) {
			acc[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var panel = this.nextElementSibling;
				if (panel.style.display === "block") {
					panel.style.display = "none";
				} else {
					panel.style.display = "block";
				}
			});
		}
	</script>


</body>
</html>