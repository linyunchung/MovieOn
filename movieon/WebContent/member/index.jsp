<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css'
	rel='stylesheet'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />
<title>MovieOn</title>
</head>
<body>
	<nav>
		<div class="navbar">
			<i class='bx bx-menu'></i>
			<div class="logo">
				<a href="${pageContext.request.contextPath}/Home.jsp"><img
					src="${pageContext.request.contextPath}/img/logo.png"></a>
			</div>
			<div class="nav-links">
				<div class="sidebar-logo">
					<span class="logo_name">MovieOn</span> <i class='bx bx-x'></i>
				</div>
				<ul class="links">
					<li><a class="tansuo" href="${pageContext.request.contextPath}/Home.jsp">電影探索</a> <i
						class='bx bx-chevron-down arrow tan-arrow'></i>
						<ul class="tansuo-sub-menu sub-menu">
							<li><a href="<%=request.getContextPath()%>/moviesHome/movieGenre.jsp">查詢電影類型</a></li>
							<li><a href="<%=request.getContextPath()%>/moviesHome/movies_home.jsp">電影推薦</a></li>
							<li><a href="<%=request.getContextPath()%>/review/addReview.jsp">留下影評</a></li>
							<li><a href="<%=request.getContextPath()%>/review/reviewCenter.jsp">影評中心</a></li>
						</ul></li>
					<li><a class="shike" href="<%=request.getContextPath()%>/showing/showing_search.jsp">電影時刻</a> <i
						class='bx bx-chevron-down arrow shike-arrow'></i>
						<ul class="shike-sub-menu sub-menu">
							<li><a href="#">場次查詢</a></li>
							<li><a href="#">歷史記錄</a></li>
						</ul></li>
<!-- 					<li><a class="jiaoyou" href="#">交友</a> <i -->
<!-- 						class='bx bx-chevron-down arrow jiaoyou-arrow'></i> -->
<!-- 						<ul class="jiaoyou-sub-menu sub-menu"> -->
<!-- 							<li><a href="#">媒合配對</a></li> -->
<!-- 							<li><a href="#">即時訊息</a></li> -->
<!-- 							<li><a href="#">好友名單</a></li> -->
<!-- 						</ul></li> -->
					<li><a class="shangcheng" href="${pageContext.request.contextPath}/shop/shopPage.jsp">商城</a> <i
						class='bx bx-chevron-down arrow shangcheng-arrow'></i>
						<ul class="shangcheng-sub-menu sub-menu">
							<li><a href="<%=request.getContextPath()%>/shop/shopItem.jsp">商品列表</a></li>
							<li><a href="<%=request.getContextPath()%>/shop/shopCart.jsp">購物車</a></li>
<!-- 							<li><a href="#">訂單查詢</a></li> -->
							<li><a href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
							<li><a href="<%=request.getContextPath()%>/prob/contactcs.jsp">聯絡客服</a></li>
						</ul></li>
					<c:if test="${empty memberVO.username}">
						<li id="sign">
							<a id="sign_in" href="${pageContext.request.contextPath}/member/log_in.jsp">會員登入</a>
						</li>
					</c:if> 
					<c:if test="${not empty memberVO.username}">
						<li><a class="zhongxin" href="<%=request.getContextPath()%>/profile"> <span class="um_span">${memberVO.username}</span></a>
							<i class='bx bx-chevron-down arrow zhongxin-arrow'></i>
							<ul class="zhongxin-sub-menu sub-menu">
					            <li><a href="${pageContext.request.contextPath}/profile?action=myfilms">我的評分</a></li>
					            <li><a href="${pageContext.request.contextPath}/profile?action=myreviews">我的影評</a></li>
					            <li><a href="${pageContext.request.contextPath}/profile?action=myfollowers">我的粉絲</a></li>
					            <li><a href="${pageContext.request.contextPath}/profile?action=myfollowing">追蹤中</a></li>
					            <li><a href="${pageContext.request.contextPath}/profile?action=mynetwork">動態牆</a></li>
					            <li><a href="${pageContext.request.contextPath}/shop/shopSearch.jsp">我的訂單</a></li>
								<li><a href="${pageContext.request.contextPath}/member/acct_info.jsp">會員資料</a></li>
								<li><a href="<%=request.getContextPath()%>/LogoutServlet">登出</a></li>
							</ul>
						</li>
					</c:if>
				</ul>
			</div>
			<div class="search-box">
				<i class='bx bx-search'></i>
				<div class="input-box">
					<input type="text" placeholder="Search...">
				</div>
			</div>
		</div>
	</nav>
	<script src="${pageContext.request.contextPath}/js/script.js"></script>


</body>
</html>