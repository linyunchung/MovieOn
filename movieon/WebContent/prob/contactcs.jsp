<%@page import="java.sql.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.prob.model.*"%>
<%@ page import="java.util.*"%>

<%
	Locale locale = request.getLocale();
	Calendar calendar = Calendar.getInstance(locale);
	Date dateNow = new Date(calendar.getInstance().getTimeInMillis());
%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>聯絡客服。MovieOn-</title>
<!--     <link rel="stylesheet" href="/css/style.css"> -->
<link href="${pageContext.request.contextPath}/css/userid.css"
	rel="stylesheet" />

<link href="<%=request.getContextPath()%>/css/profile_header.css"
	rel="stylesheet" />
<style>

div {
	display: block;
}

body {
	background-color: #FFFF;
}

.wrapper{
	margin-top: 30px;
	margin-bottom: 30px;
	color: blue;
	font-size: 16px;
	font-family: 'Noto Sans TC', sans-serif !important;
	font-weight: 600;
}

.wrapper #qtype {
	font-size: 14px;
	border-radius: 5px;
}

.wrapper #content {
	resize: none;
	font-size: 16px;
	width: 592px;
	height: 380px;
	margin: 0;
	border-radius: 5px;
	background-color: #EDF2F4;
	border: 1px solid black;
}

.wrapper .box {
	display: block;
	margin: 0px auto;
	width: 600px;
}

form{
    margin: 0;
}

.wrapper #send {
	width: 80px;
	height: 20px;
	border: 1px solid blue;
	background-color: blue;
	border-radius: 5px;
	color: white;
	position: relative;
	font-size: 14px;
	font-family: 'Noto Sans TC', sans-serif !important;
}

.wrapper #send:active {
	left: 1.1px;
	bottom: -1.1px;
}

.wrapper #email {
	border-radius: 5px;
	border: 1px solid black;
	background-color: #EDF2F4;
	
#
}
</style>
</head>
<body>


	<%@include file="/header.file"%>

	<div class="wrapper">
		<div class="box">
			<form action="<%=request.getContextPath()%>/prob/prob.do"
				method="post" name="form1" id=form1>
				<label for="question-type">問題類型</label><br> <select
					name="probtype" id="probtype" class="qa-select">
					<option value="帳號" selected="selected">帳號問題</option>
					<option value="訂單">訂單問題</option>
					<option value="發票">發票問題</option>
					<option value="商品">商品問題</option>
					<option value="其他">其他問題</option>
				</select><br> <br> <input value="<%=dateNow%>" type="hidden"
					id="probtime" name="probtime"> <label
					for="question-content">問題內容</label><br>
				<textarea required id="content" placeholder="" name="content"
					rows="20" cols="80" class="qa-textarea"></textarea>
				<br> <br> <label for="email">E-mail信箱</label> <input
					required type="email" id="email" name="email"><br> <br>
				<input type="submit" value="送出問題" id="send"> <input
					type="hidden" name="action" value="insert">
			</form>
		</div>
	</div>

	<footer class="footer">

		<div class="footer_inner">
			<ul>
				<li>回到首頁</li>
				<li>關於我們</li>
				<li>服務說明</li>
				<li>客服</li>
				<li>聯絡我們</li>
				<li><i class="fa fa-instagram"></i></li>
				<li><i class="fa fa-facebook"></i></li>
			</ul>
			<span>© MovieOn. Made by programming students in Taipei,
				Taiwan. For learning purposes only.</span>
		</div>
	</footer>
</body>
</html>