<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.review.model.*"%>
<%@page import="com.member.model.*"%>
<%@page import="com.movie.model.*"%>
 

<%--	ReviewDAO dao = new ReviewDAO();
 	List<ReviewVO> list = dao.getAll();
 	pageContext.setAttribute("list", list);--%>

<%
	ReviewService revSvc = new ReviewService();
	List<ReviewVO> list = revSvc.getAll();
	pageContext.setAttribute("list", list);
	/*限制影評的文字數量*/
%>
<jsp:useBean id="movieSvc" scope="page" class="com.movie.model.MovieService" />
<jsp:useBean id="memeberSvc" scope="page" class="com.member.model.MemberService" />
<%--用useBean去setAttribute再用EL去getAttribute --%>
<%--用MovieService去new object -> movieSvc  --%>
<%--用MemberService去new object -> memeberSvc --%>

<%-- 有錯????
ReviewVO reviewVO = (ReviewVO) request.getAttribute("reviewVO");
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Timestamp postedAt = reviewVO.getPostedAt();
String strPostedAt = dateFormat.format(postedAt);
--%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Font Awesome CDN -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

<!--  Bootstrap 的 CSS 官方CDN路徑 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- jQuery的 CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
body {
	background-color: #131313;
}

/* *********************************************最上方導覽列的CSS************************************************* */
/* 讓header可以集中一點 */
/* nav.navbar>div.container { */
/* 	/* border: 1px solid orangered; */ */
/* 	max-width: 1200px; */
/* } */

/* /* 移除logo的預設margin跟padding */ */
/* a.navbar-brand { */
/* 	margin: 0; */
/* 	padding: 0; */
/* } */

/* /* 移除nav預設padding */ */
/* nav.navbar { */
/* 	padding: 0; */
/* } */

/* /* 導覽列的間距不要太密集 */ */
/* a.nav-link { */
/* 	margin-right: 16px; */
/* } */

/* input.form-control { */
/* 	border-top-right-radius: 0; */
/* 	border-bottom-right-radius: 0; */
/* 	height: 36px; */
/* } */

/* button.btn-outline-secondary { */
/* 	border-top-left-radius: 0; */
/* 	border-bottom-left-radius: 0; */
/* 	height: 36px; */
/* } */

/* button.btn-login { */
/* 	color: black; */
/* 	background: #FFBE0B; */
/* 	margin-left: 30px; */
/* 	/*會員登入跟搜尋圖示隔開一點*/ */
/* 	font-size: .9em; */
/* } */

/* button.btn-login:hover { */
/* 	color: white; */
/* 	font-weight: 900; */
/* 	border: 2px solid white; */
/* 	/* background-color: rgb(124, 170, 195); */ */
/* 	background: black; */
/* } */

/* /* 第一層清單 */ */
/* #navbarDropdown { */
/* 	color: white; */
/* } */

/* div.navbar-collapse>ul.navbar-nav li.nav-item a { */
/* 	font-size: .9em; */
/* } */

/* div.navbar-collapse>ul.navbar-nav li.nav-item a:hover { */
/* 	/* padding:0; */ */
/* 	background-color: black; */
/* 	color: white; */
/* } */

/* ul.dropdown-menu { */
/* 	padding: 0; */
/* } */

/* ul.dropdown-menu>li a.dropdown-item { */
/* 	border-top: 1px solid rgb(207, 207, 207); */
/* 	padding: 6px 2px; */
/* } */

/* *********************************************影評************************************************* */


h4.article-title {
	color: #EDF2F4;
	font-weight: 500;
}

time.postedDate, div#content p {
	color: #AABBCC;
	font-size: .8em;
}

div.container-fluid {
	/* border:1px solid black; */
	max-width: 700px;
	padding: 0;
}

div.article-page2 {
	display: none;
}

article.article-container {
	/* border:1px solid red; */
	border-bottom: 1px dotted gray;
	margin-top: 2em;
	margin-bottom: 4em;
}

div.article-info {
	font-weight: 900;
}

div.article-info h4.article-title {
	font-size: 1.2em;
	font-weight:600;
	color:white;
}

a.article-author {
	font-size: .9em;
	color: #006BB6;
}

a.article-author:hover {
	cursor: pointer;
}

div.article-info>button.btn-sm {
	padding: 1px 8px;
	background: #EDF2F4;
}

div.article-info>button.btn-sm:hover {
	color: black;
	font-size: .91em;
	border:1px solid #006BB6;
}
time.postedDate{
	color: gray;
}
div#content {
	/* border:1px solid blue; */
	margin: 1em 0;
}

div#content p {
	font-size: 1em;
	line-height:2em;
}

div#read-more>a {
	font-family: "Oswald";
	font-size: 1em;
	text-transform: uppercase;
	color: gray;
}

div#read-more>a:hover {
	color: #EDF2F4;
	font-weight:600;
}

a.page-link {
	color: #AABBCC
}

a.page-items {
	color: #EDF2F4;
}

ul.pagination li a {
	background: none;
}

/********************************* 頁碼 ****************************************/
div.pagination {
	margin:0 auto;
	max-width:700px;
	font-size: 1.1em;
	font-weight: bold;
	letter-spacing: 1px;
	display:flex;
	justify-content:space-between;
}

.pagination a {
	color: #433F3F;
	text-decoration: none;
	border-bottom: none;
}

.pagination a:hover {
	color: #FFBE0B;
}

.previous-post, .next-post {
	width: 50%;
}

.previous-post {
	text-align: left;
}

.next-post {
	text-align: right;
}

/******************************************************* 頁尾***************************************************** */
footer.footer {
	margin-top: 100px;
	/* border: 2px solid green; */
	background: black;
}

nav.navbar-footer>div.container {
	/* border: 2px solid green; */
	max-width: 1200px;
	margin: 0 auto;
	display: flex;
	align-items: center;
	justify-content: space-between;
}

nav.navbar-footer>div.container>ul.navbar-nav {
	/* display:inline-block; */
	/* border: 1px solid red; */
	/* display:inline-flex; */
	display: flex;
	flex-wrap: wrap;
}

div.nav {
	height: 100px;
	max-width: 1200px;
	/* background-color: #4d4d4d; */
	position: relative;
	margin: 0 auto;
	/* padding-top: 10px; */
}

div.nav>div.nav-links {
	display: inline;
	font-size: 14px;
	/* border: 1px solid red; */
	margin: 0 auto;
	max-width: 1200px;
}

div.nav>div.nav-links>span {
	color: grey;
}

div.nav>div.nav-links>a {
	display: inline-block;
	padding: 13px 10px 13px 10px;
	text-decoration: none;
	color: #efefef;
	/* border:1px solid blue; */
}

.nav>.nav-links>a:hover {
	/* background-color: rgba(0, 0, 0, 0.3); */
	color: white;
}

.nav>#nav-check {
	display: none;
}

h4 {
	color: white;
}

</style>
<title>影評中心</title>
<link href="<%=request.getContextPath()%>/css/profile_header.css" rel="stylesheet" />
</head>

<body>
	<%@include file="/header.file"%>
	<!--------------------------------------------- 導覽列 navbar -------------------------------------------------------------->
<!-- 	<nav class="navbar navbar-expand-lg  navbar-dark" -->
<!-- 		style="background-color: #000000;"> -->
<!-- 		<div class="container"> -->
<%-- 			<a href="${pageContext.request.contextPath}/Home.jsp" class="navbar-brand"><img --%>
<%-- 				src="<%=request.getContextPath() %>/images/logo.png" alt="" width="100" height="50"></a> --%>

<!-- 			<div class="collapse navbar-collapse"> -->
<!-- 				<ul class="navbar-nav ms-auto"> -->
<!-- 					<li class="nav-item dropdown"><a class="nav-link" href="#" -->
<!-- 						id="navbarDropdown" role="button" data-bs-toggle="dropdown" -->
<!-- 						aria-expanded="false"> 電影探索 </a> -->
<!-- 						<ul class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<%-- 							<li><a class="dropdown-item" href="<%=request.getContextPath() %>/moviesHome/movies_home.jsp">電影推薦</a></li> --%>
<%-- 							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/moviesHome/movieGenre.jsp">查詢電影類型</a></li> --%>
<%-- 							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/review/addReview.jsp">留下影評</a></li> --%>
<%-- 							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/review/reviewCenter.jsp">影評中心</a></li> --%>
<!-- 						</ul></li> -->
<!-- 					<li class="nav-item dropdown"><a class="nav-link" href="#" -->
<!-- 						id="navbarDropdown" role="button" data-bs-toggle="dropdown" -->
<!-- 						aria-expanded="false"> 交友 </a> -->
<!-- 						<ul class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<!-- 							<li><a class="dropdown-item" href="#">媒合配對</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">即時訊息</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">好友名單</a></li> -->
<!-- 						</ul></li> -->
<!-- 					<li class="nav-item dropdown"><a class="nav-link" href="#" -->
<!-- 						id="navbarDropdown" role="button" data-bs-toggle="dropdown" -->
<!-- 						aria-expanded="false"> 會員中心 </a> -->
<!-- 						<ul class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<!-- 							<li><a class="dropdown-item" href="#">我的影評</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">追蹤清單</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">歷史購物紀錄</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">動態牆</a></li> -->
<!-- 						</ul></li> -->
<!-- 					<li class="nav-item dropdown"><a class="nav-link" href="#" -->
<!-- 						id="navbarDropdown" role="button" data-bs-toggle="dropdown" -->
<!-- 						aria-expanded="false"> 電影時刻表 </a> -->
<!-- 						<ul class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<!-- 							<li><a class="dropdown-item" href="#">場次查詢</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">歷史搜尋紀錄</a></li> -->
<!-- 						</ul></li> -->
<!-- 					<li class="nav-item dropdown"><a class="nav-link" href="#" -->
<!-- 						id="navbarDropdown" role="button" data-bs-toggle="dropdown" -->
<!-- 						aria-expanded="false"> 商城 </a> -->
<!-- 						<ul class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<!-- 							<li><a class="dropdown-item" href="#">商品列表</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">購物車</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">購物流程</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">訂單查詢</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">客服中心</a></li> -->
<!-- 						</ul></li> -->
<!-- 					<form class="d-flex"> -->
<!-- 						<input class="form-control" type="search" placeholder="Search" -->
<!-- 							aria-label="Search"> -->
<!-- 						<button class="btn btn-outline-secondary" type="submit"> -->
<!-- 							<i class="fas fa-search"></i> -->
<!-- 						</button> -->
<!-- 					</form> -->
<!-- 					<li class="nav-item"> -->
<!-- 						<a href="#instruction" class="nav-link" style="color:#FFBE0B">會員登入</a> -->
<!-- 						<button class="btn btn-login" type="submit">會員登入</button> -->
<!-- 					</li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</nav> -->



	<!--------------------------------------------- 影評 -------------------------------------------------------------->
	<div class="container-fluid article-page1">
		<h4>影評中心</h4>
		<%@ include file="page1.file"%>
		<c:forEach var="reviewVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<article class="article-container">
				<div class="article-info">
					<h4 class="article-title">
						<c:forEach var="movieVO" items="${movieSvc.all}">
							<c:if test="${reviewVO.movieId==movieVO.movieId}">
	                    		〔${movieVO.movieName}〕${reviewVO.reviewTitle}
                    		</c:if>
						</c:forEach>
					</h4>
					<a class="article-author">
						<c:forEach var="memberVO" items="${memeberSvc.all}">
							<c:if test="${reviewVO.userId==memberVO.userid}">
	                    		${memberVO.username}
                    		</c:if>
						</c:forEach>
					</a>
					
					<time class="postedDate"><fmt:formatDate value="${reviewVO.postedAt}" pattern="yyyy-MM-dd HH:mm:ss"/></time>
				</div>

				<div id="content">
					<p>${reviewVO.review.substring(0, 100)}&hellip;&hellip;&hellip;</p>
				</div>
				<div id="read-more">
					<a href="<%=request.getContextPath() %>/Links_Controller?reviewId=${reviewVO.reviewId}&action=getOne_From_Home" target="_blank">閱讀更多</a>
				</div>
			</article>
		</c:forEach>
	</div>
	
	
	<div class="nav-links pagination">
		<div class="previous">
	  		<%if (rowsPerPage<rowNumber) {%>
    			<%if(pageIndex>=rowsPerPage){%>
        			<a href="<%=request.getRequestURI()%>?whichPage=1">至第一頁</a>&nbsp;
        			<a class="previous-post" href="<%=request.getRequestURI()%>?whichPage=<%=whichPage-1%>" class="previous-post">&laquo;上一頁 </a>&nbsp;
    		<%}%>
  		</div>
  
  		<div class="next">
    	<%if(pageIndex<pageIndexArray[pageNumber-1]){%>
        	<a href="<%=request.getRequestURI()%>?whichPage=<%=whichPage+1%>" class="next-post">下一頁 &raquo;</a>&nbsp;
        	<a href="<%=request.getRequestURI()%>?whichPage=<%=pageNumber%>">至最後一頁</a>&nbsp;
    	<%}%>
    	</div>
  	<%}%>  
	</div>
	
	
<br><br>

  
	

	<!--------------------------------------------- 分頁-------------------------------------------------------------->
	<!-- 	<nav aria-label="Page navigation example" class="pageNav"> -->
	<!-- 		<ul class="pagination justify-content-center"> -->
	<!-- 			<li class="page-item disabled"><a class="page-link" href="#" -->
	<!-- 				tabindex="-1" aria-disabled="true">&laquo;</a></li> -->
	<!-- 			<li class="page-item link1"><a class="page-link" href="#">1</a></li> -->
	<!-- 			<li class="page-item link2"><a class="page-link" href="#">2</a></li> -->
	<!-- 			<li class="page-item link3"><a class="page-link" href="#">3</a></li> -->
	<!-- 			<li class="page-item link4"><a class="page-link" href="#">4</a></li> -->
	<!-- 			<li class="page-item link5"><a class="page-link" href="#">5</a></li> -->
	<!--             <li class="page-item link6"><a class="page-link" href="#">6</a></li> -->
	<!-- 			<li class="page-item"><a class="page-link" href="#">&raquo;</a></li> -->
	<!-- 		</ul> -->
	<!-- 	</nav> -->





	<!-------------------------------------------------- 頁尾 ------------------------------------------------------------->
	<footer class="footer">
		<div class="nav">
			<div class="nav-links">
				<a href="#" target="">回到首頁</a> <a href="#" target="">關於我們</a> <a
					href="#" target="">服務說明</a> <a href="#" target="">客服</a> <a
					href="#" target="">聯絡我們</a> <br> <span>© MovieOn. Made
					by programming students in Taipei, Taiwan. For learning purposes
					only.</span>
			</div>
		</div>
	</footer>


	


	<!-- Bootstrap 的 JS 官方CDN路徑 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
		crossorigin="anonymous">
		
	</script>
</body>

</html>