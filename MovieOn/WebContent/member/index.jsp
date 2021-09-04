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
<link href="${pageContext.request.contextPath}/member/css/style.css"
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
				<a href="${pageContext.request.contextPath}/member/index.jsp"><img
					src="${pageContext.request.contextPath}/member/img/logo.png"></a>
			</div>
			<div class="nav-links">
				<div class="sidebar-logo">
					<span class="logo_name">MovieOn</span> <i class='bx bx-x'></i>
				</div>
				<ul class="links">
					<li><a class="tansuo" href="#">電影探索</a> <i
						class='bx bx-chevron-down arrow tan-arrow'></i>
						<ul class="tansuo-sub-menu sub-menu">
							<li><a href="#">查詢電影類型</a></li>
							<li><a href="#">電影推薦</a></li>
							<li><a href="#">留下影評</a></li>
							<li><a href="#">影評中心</a></li>
						</ul></li>
					<li><a class="shike" href="#">電影時刻</a> <i
						class='bx bx-chevron-down arrow shike-arrow'></i>
						<ul class="shike-sub-menu sub-menu">
							<li><a href="#">場次查詢</a></li>
							<li><a href="#">歷史記錄</a></li>
						</ul></li>
					<li><a class="shangcheng" href="#">商城</a> <i
						class='bx bx-chevron-down arrow shangcheng-arrow'></i>
						<ul class="shangcheng-sub-menu sub-menu">
							<li><a href="#">商品列表</a></li>
							<li><a href="#">購物車</a></li>
							<li><a href="#">訂單查詢</a></li>
							<li><a href="#">客服中心</a></li>
						</ul></li>
					<c:if test="${sessionScope.memberVO.username == null}">
						<li id="sign">
							<a id="sign_in" href="${pageContext.request.contextPath}/member/log_in.jsp">會員登入</a>
						</li>
					</c:if> 
					<c:if test="${sessionScope.memberVO.username != null}">
						<li><a class="zhongxin" href="#"> <span class="um_span">${memberVO.username}</span></a>
							<i class='bx bx-chevron-down arrow zhongxin-arrow'></i>
							<ul class="zhongxin-sub-menu sub-menu">
								<li><a href="#">我的評分</a></li>
								<li><a href="#">我的影評</a></li>
								<li><a href="#">我追蹤的作者</a></li>
								<li><a href="#">購物記錄</a></li>
								<li><a href="#">動態墻</a></li>
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
	<script src="${pageContext.request.contextPath}/member/js/script.js"></script>


</body>
</html>