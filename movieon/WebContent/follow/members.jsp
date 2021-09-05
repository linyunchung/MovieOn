<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.member.model.*"%>
<%@ page import="com.review.model.*"%>
<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Services -->
<jsp:useBean id="followService" scope="page"
	class="com.follow.model.FollowService" />
<jsp:useBean id="rvwSvc" scope="page"
	class="com.review.model.ReviewService" />
<jsp:useBean id="movieSvc" scope="page"
	class="com.movie.model.MovieService" />

<%
	MemberService memSvc = new MemberService();

	// get users with most reviews this month
	List<MemberVO> alllist = memSvc.getAll();
	pageContext.setAttribute("alllist", alllist);
	
	// get newest registered users
	List<MemberVO> newestlist = memSvc.getNewest();
	pageContext.setAttribute("newestlist", newestlist);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>加入成為用戶。MovieOn -</title>

<!-- font-awesome script -->
<script src="https://use.fontawesome.com/b0a5afcff9.js"></script>

<!-- font awesome links -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/v4-shims.css" />

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Serif+TC&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
	rel="stylesheet" />

<!-- CSS stylesheet -->
<!-- <link href="./css/userid.css" rel="stylesheet" /> -->


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/css/profile_header.css"
	rel="stylesheet" />

</head>

<body class="memebrs">
	<style>
* {
	box-sizing: border-box;
	/* border: solid tomato 1px; */
}

html {
	font-size: 100%;
}

body {
	margin: 0;
	background-color: #262626;
}

a {
	color: white;
	text-decoration: none;
}

footer.footer {
	background-color: black;
	color: #edf2f4;
	margin: 0;
	height: 250px;
	width: 100%;
	overflow: auto;
	display: block;
	float: left;
}

footer.footer ul {
	max-width: 950px;
	margin-left: auto;
	margin-right: auto;
	position: relative;
	left: 15px;
}

footer.footer li {
	font-weight: bold;
	list-style-type: none;
	display: inline-block;
	margin-top: 10px;
	margin-right: 30px;
	margin-bottom: 30px;
	overflow: auto;
}

footer.footer span {
	display: block;
	font-size: 10px;
	max-width: 950px;
	margin-left: auto;
	margin-right: auto;
	position: relative;
	left: 15px;
	font-family: "Montserrat", sans-serif;
}

.content-wrap {
	height: auto;
	color: white;
	width: 950px;
	margin: 0 auto;
}

.welcometext {
	text-align: center;
	font-family: sans-serif;
	font-size: 40px;
	margin: 100px 80px 0px 80px;
}

.signupnow {
	text-align: center;
	font-family: sans-serif;
	font-size: 20px;
	margin: 50px auto 0px auto;
	width: 100px;
	color: white;
	border: 1px solid white;
	padding: 5px;
	border-radius: 3px;
	font-weight:600;
	cursor:pointer;
	position: relative;
}
.signupnow a{
	display:block;
	width:100px;
	height: 35px;
	position: absolute;
	bottom: 2px;
	left:2px;	
}

.signupnow:hover {
	color: black;
	background: white;
	border: 1px solid black;
	font-weight:600;
}

.headlinemember {
/* 	border: 1px solid red; */
	width: 920px;
	margin: 0 auto;
	margin-top: 50px;
}

.bigmember {
/* 	border: 1px solid red; */
	height: 280px;
	width: 250px;
	margin: 20px;
	display: inline-block;
	/* border-radius: 125px; */
}

.bigmembericon img{
/* 	border: 1px solid red; */
	height: 200px;
	width: 200px;
	display: inline-block;
	border-radius: 100px;
	margin-left: 25px;
	border: 1px solid #678;
	
}

.bigmembericon img:hover {
	border: 3px solid #ffbe0b;
}
.smallmembericon img:hover {
	border: 3px solid #ffbe0b;
}

.bigmembericon img{
	height: 200px;
	width: 200px;
	border-radius: 100px;
	object-fit: cover;
}

.smallmember {
/* 	border: 1px solid red; */
	height: 200px;
	width: 140px;
	margin: 20px 20px 80px 20px;
	display: inline-block;
}

.smallmembericon {
/* 	border: 1px solid red; */
	height: 140px;
	width: 140px;
	display: inline-block;
	border-radius: 70px;
}

.smallmembericon img{
	height: 140px;
	width: 140px;
	border-radius: 70px;
	border: 1px solid #678;
}

.popular {
	border-bottom: 1px solid #aabbcc;
}

.newcommers {
	border-bottom: 1px solid #aabbcc;
}

.membername {
/* 	border: 1px solid blue; */
	color: #aabbcc;
	position: relative;
	text-align: center;
	margin-top: 15px;
	font-size: 18px;
	font-family: sans-serif;
	font-weight:600;
}

.reviewactivity {
	font-size: 13px;
	color: #ffbe0b;
	text-align: center;
	font-family: "Montserrat", sans-serif;
	font-weight: 600;
	margin-top: 10px;
}

.reviewactivity span{
	color: #006BB6;
	background-color:#ffbe0b;
	border-radius: 3px;
	padding: 2px;
	font-weight: 700;
}

</style>

	<%@include file="/header.file"%>
	<div class="content-wrapper">
		<div class="welcometext">
			<a>在MovieOn，找到和你同樣熱愛電影的影評人！</a>
		</div>
		<div class="signupnow">
				立即登入
			<a href="${pageContext.request.contextPath}/member/log_in.jsp">
			</a>
		</div>
		<div class="headlinemember">
			<div class="popular">
				<a>本月最夯用戶</a>
			</div>
<c:forEach var="memberVO" items="${alllist}" begin="0" end="2">
			<div class="bigmember">
				<div class="bigmembericon">
					<a href="${pageContext.request.contextPath}/profile?id=${memberVO.userid}"> 
						<img src="${pageContext.request.contextPath}/DBGifReaderFollow?userid=${memberVO.userid}" alt="" width="200" height="200" />
					</a>
				</div>
				<div class="membername">${memberVO.username}</div>
				<div class="reviewactivity"><span>最近看了</span> ${rvwSvc.getNewestReviewName(memberVO.userid)}</div>
			</div>
</c:forEach>
<!-- 			<div class="bigmember"> -->
<!-- 				<div class="bigmembericon"> -->
<!-- 					<a href="#"> <img src="" alt="" /> -->
<!-- 					</a> -->
<!-- 				</div> -->
<!-- 				<div class="membername">MembernameXXX</div> -->
<!-- 				<div class="reviewactivity">剛剛評論了：</div> -->
<!-- 			</div> -->
<!-- 			<div class="bigmember"> -->
<!-- 				<div class="bigmembericon"> -->
<!-- 					<a href="#"> <img src="" alt="" /> -->
<!-- 					</a> -->
<!-- 				</div> -->
<!-- 				<div class="membername">MembernameXXX</div> -->
<!-- 				<div class="reviewactivity">剛剛評論了：</div> -->
<!-- 			</div> -->

			<div class="newcommers">
				<a>新加入的小夥伴</a>
			</div>
<c:forEach var="memberVO" items="${newestlist}" begin="0" end="4">
			<div class="smallmember">
				<div class="smallmembericon">
					<a href="${pageContext.request.contextPath}/profile?id=${memberVO.userid}"> 
						<img src="${pageContext.request.contextPath}/DBGifReaderFollow?userid=${memberVO.userid}" alt="" width="140" height="140"/>
					</a>
				</div>
				<div class="membername">${memberVO.username}</div>
			</div>
</c:forEach>
		</div>
	</div>
	<footer class="footer">
		<div class="footer_inner"></div>
		<ul>
			<li>回到首頁</li>
			<li>關於我們</li>
			<li>服務說明</li>
			<li>客服</li>
			<li>聯絡我們</li>
			<li><i class="fa fa-instagram"></i></li>
			<li><i class="fa fa-facebook"></i></li>
		</ul>
		<span>© MovieOn. Made by programming students in
			Taipei, Taiwan. For learning purposes only.</span>
	</footer>
	<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script> -->
</body>
<script src="${pageContext.request.contextPath}/js/nav.js"></script>
</html>
