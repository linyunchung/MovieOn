<%@page import="com.review.model.*"%>
<%@page import="com.movie.model.*"%> 
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--用DAO去create object,要用來串電影基本資料跟該電影有關的影評 --%>

<%	MovieVO movieVO = (MovieVO) request.getAttribute("movieVO"); %>
<%	ReviewVO reviewVO = (ReviewVO) request.getAttribute("reviewVO"); %>
<%	ReviewService revSvc = new ReviewService();
	List<ReviewVO> reviewList = revSvc.getAll();
	pageContext.setAttribute("list", reviewList); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
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

<style>
/* 導入星星 */
@import
	url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);

body {
	background-color: #131313;
}

/* *********************************************最上方導覽列的CSS************************************************* */
/* 讓header可以集中一點 */
nav.navbar>div.container {
	/* border: 1px solid orangered; */
	max-width: 1200px;
}

/* 移除logo的預設margin跟padding */
a.navbar-brand {
	margin: 0;
	padding: 0;
}

/* 移除nav預設padding */
nav.navbar {
	padding: 0;
}

/* 導覽列的間距不要太密集 */
a.nav-link {
	margin-right: 16px;
}

input.form-control {
	border-top-right-radius: 0;
	border-bottom-right-radius: 0;
}

button.btn-outline-secondary {
	border-top-left-radius: 0;
	border-bottom-left-radius: 0;
}

button.btn-login {
	color: black;
	background: #FFBE0B;
	margin-left: 30px;
	/*會員登入跟搜尋圖示隔開一點*/
}

button.btn-login:hover {
	color: white;
	font-weight: 900;
	border: 2px solid white;
	/* background-color: rgb(124, 170, 195); */
	background: black;
}

/* 第一層清單 */
#navbarDropdown {
	color: white;
}

div.navbar-collapse>ul.navbar-nav li.nav-item a {
	font-size: .9em;
}

div.navbar-collapse>ul.navbar-nav li.nav-item a:hover {
	/* padding:0; */
	background-color: black;
	color: white;
}

ul.dropdown-menu {
	padding: 0;
}

ul.dropdown-menu>li a.dropdown-item {
	border-top: 1px solid rgb(207, 207, 207);
	padding: 6px 2px;
}

.wrap {
	/* width: 910px; */
	margin: 0 auto;
	/* background-color: #37523d; */
	font-weight: bold;
	max-width: 1000px;
	/* border: 1px solid blue; */
}

.content {
	padding: 0 10px;
}

.header {
	background-color: #e7eeea;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 2px 33px;
}

/*content , header end */
.menu {
	/* background-color: #fff; */
	padding: 0px 45px;
	padding-top: 30px;
	padding-bottom: 25px;
	display: flex;
	border: 1px dotted #343a40;
}

.menu img {
	height: 353px;
}

.menu-detail {
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	padding-left: 50px;
}

.introduction h2 {
	font-size: 1.2em;
}

.introduction h4.movie-name {
	font-size: 1.2em;
	color: white;
	font-weight: 600;
}

.introduction p {
	font-size: .95em;
	letter-spacing: 1.5px;
	line-height: 1.5;
	color: #ced4da;
}

div.introduction label {
	color: white;
	font-size: 1em;
}

div.introduction span {
	color: #ced4da;
	font-size: .95em;
}

.menu-detail ul {
	/* display: flex; */
	
}

.menu-detail li a {
	font-size: 18px;
	color: #37523d;
}

div.btn-container {
	display: flex;
	margin-top: 1em;
}

div.score-container{
	margin-top:1em;
}
div.score-container > label,
span.total{
	color:white;
}
        
span.total-score{
	color: #FFBE0B;
	font-size: 2em;
}

div.total-score span{
	font-size:1em;
}

#write-review {
	width: 110px;
	border: 2px solid #006BB6;
	border-radius: 1em;
	margin-right: 1em;
	text-decoration: none;
	text-align: center;
	padding: .2em;
	color: white;
	background: #006BB6;
}

#write-review:hover {
	color: #006BB6;
	font-weight: 700;
	border: 3px solid #006BB6;
	background: white;
}

#starRate {
	width: 110px;
	border-radius: 1em;
	margin-right: 1em;
	text-decoration: none;
	text-align: center;
	padding: .2em;
	border: 2px solid #AABBCC;
	color: white;
	background: #AABBCC;
}

#starRate:hover {
	color: #AABBCC;
	font-weight: 900;
	border: 3px solid #AABBCC;
	background: white;
}

/* 特殊按鈕 */

/* Modal Content/Box */
.modal-content {
	background-color: white;
	margin: 10% auto;
	/* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	max-width: 18%;
	/* Could be more or less, depending on screen size */
}

/* The Close Button */
.close {
	color: #aaa;
	float: right;
	font-size: 2em;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: white;
	text-decoration: none;
	cursor: pointer;
}

/* Modal Header */
.modal-header {
	padding: 2px 10px;
	background-color: #293241;
	color: white;
}

.popup-title {
	font-size: 1.2em;
}

/* Modal Body */
.modal-body {
	padding: 2px 10px;
}

/* Modal Footer */
.modal-footer {
	padding: 2px 16px;
	background-color: black;
	color: white;
}

/* star */
div.modal-body>div.rate {
	/* border: 1px solid red; */
	display: inline-block;
}

div.modal-body>div.rate>input {
	display: none;
}

div.modal-body>div.rate>label {
	float: right;
}

div.modal-body>div.rate>label:before {
	display: inline-block;
	font-size: 1.9rem;
	padding: 0 .2rem;
	margin: 0;
	cursor: pointer;
	font-family: FontAwesome;
	content: "\f005 ";
	/* color: white; */
	/* full star */
}

div.modal-body>div.rate .half:before {
	content: "\f089 ";
	/* half star no outline */
	position: absolute;
	padding-right: 0;
}

div.modal-body>div.rate label.half {
	background: white;
}

div.modal-body>div.rate>input:checked ~label,
	/* color current and previous stars on checked */ div.modal-body>div.rate>label:hover,
	div.modal-body>div.rate>label:hover ~label {
	color: #FFBE0B;
}

input[type="radio"]:checked+label:hover,
	/* highlight current and previous stars */ input[type="radio"]:checked
	 ~label:hover ~label,
	/* highlight previous selected stars for new rating */ div.modal-body>div.rate label:hover
	 ~input[type="radio"]:checked ~label
	/* highlight previous selected stars */ {
	color: #FFBE0B;
}

/******************************** 相關影評 ******************************/
div.relative-review {
	/* border: 1px solid red; */
	max-width: 1000px;
	margin: 0 auto;
	margin-top: 2em;
}

div.relative-review>h4.title {
	color: white;
	margin-bottom: 1em;
}

article.article-container {
	border: 1px solid gray;
	margin: 1em 0;
}

article.article-container>a.article-title {
	/* border: 1px solid blue; */
	display: inline-block;
	text-decoration: none;
	font-size: 1.1em;
	padding: .5em;
	color: #AABBCC;
	margin: 0;
}

article.article-container>a.article-title:hover {
	color: #efefef;
	text-decoration: underline;
	cursor: pointer;
}

a.article-author {
	color: gray;
	text-decoration: none;
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
	font-size: 16px;
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
}

.nav>.nav-links>a:hover {
	color: white;
}

.nav>#nav-check {
	display: none;
}
</style>

<title>片單基本資料</title>
</head>
<body>
	<!--------------------------------------------- 導覽列 navbar -------------------------------------------------------------->
	<nav class="navbar navbar-expand-lg  navbar-dark"
		style="background-color: #000000;">
		<div class="container">
			<a href="<%=request.getContextPath()%>/Home.jsp"
				class="navbar-brand"><img
				src="<%=request.getContextPath()%>/images/logo.png" alt=""
				width="100" height="50"></a>

			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> 電影探索 </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item"
								href="<%=request.getContextPath()%>/moviesHome/movies_home.jsp">電影推薦</a></li>
							<li><a class="dropdown-item"
								href="<%=request.getContextPath()%>/moviesHome/movieGenre.jsp">電影類型</a></li>
							<li><a class="dropdown-item"
								href="<%=request.getContextPath()%>/review/addReview.jsp">留下影評</a></li>
							<li><a class="dropdown-item"
								href="<%=request.getContextPath()%>/review/reviewCenter.jsp">影評中心</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> 交友 </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">媒合配對</a></li>
							<li><a class="dropdown-item" href="#">即時訊息</a></li>
							<li><a class="dropdown-item" href="#">好友名單</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> 會員中心 </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">我的影評</a></li>
							<li><a class="dropdown-item" href="#">追蹤清單</a></li>
							<li><a class="dropdown-item" href="#">歷史購物紀錄</a></li>
							<li><a class="dropdown-item" href="#">動態牆</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> 電影時刻表 </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">場次查詢</a></li>
							<li><a class="dropdown-item" href="#">歷史搜尋紀錄</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> 商城 </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">商品列表</a></li>
							<li><a class="dropdown-item" href="#">購物車</a></li>
							<li><a class="dropdown-item" href="#">購物流程</a></li>
							<li><a class="dropdown-item" href="#">訂單查詢</a></li>
							<li><a class="dropdown-item" href="#">客服中心</a></li>
						</ul></li>
					<form method="post" action="<%=request.getContextPath() %>/HomeServlet" class="d-flex" autocomplete="off">
                        <input class="form-control" type="text" name="search" placeholder="Search" aria-label="Search">
						<input type="hidden" name="action" value="getSearchResult">
						<button class="btn btn-outline-secondary" type="submit" >
							<i class="fas fa-search"></i>
						</button>
                    </form>
					<li class="nav-item">
						<!-- <a href="#instruction" class="nav-link" style="color:#FFBE0B">會員登入</a> -->
						<button class="btn btn-login" type="submit">會員登入</button>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	
	
	<!--------------------------------------------- 電影基本資料 --------------------------------------------->
	<div class="wrap">
		<div class="content">
			<div class="menu">
				<img src="DBGifReader_home?movieId=${movieVO.movieId}" alt="海報" class="poster">
				<div class="menu-detail">
					<div class="introduction">
						<h4 class="movie-name"><%=movieVO.getMovieName()%></h4>
						<p><%=movieVO.getPlot()%></p>
						<label class="release-date">上映日期: </label> <span
							class="release-date"><%=movieVO.getReleaseDate()%></span> <br>
						<label class="duration">片長: </label> <span class="duration"><%=movieVO.getMins()%>
							分鐘</span> <br> <label class="duration">導演: </label> <span
							class="duration"><%=movieVO.getDirector()%></span> <br> <label
							class="duration">主要演員: </label> <span class="duration"><%=movieVO.getActor()%></span>
					</div>

					<div class="btn-container">
						<a class="button" id="write-review" href="<%=request.getContextPath() %>/review/addReview.jsp">我要寫影評</a> 
						<a class="button" id="starRate" href="#">我要評分</a>
						<!-- <button id="write-review" class="btn btn-info">我要寫影評</button> -->
						<!-- <button id="starRate" class="btn btn-info">我要評分</button> -->
					</div>
					<div class="score-container">
                        <label>網友總評價:</label><br>
                        <span class="total-score">${average}</span>
                        <span class="total">(共${amount}人投票)</span>
                        
                    </div>
	
					<!------------------------------- The Modal ------------------------------>
					<div id="myModal" class="modal">

						<!-- Modal content -->
						<div class="modal-content">

							<div class="modal-header">
								<span class="close">x</span>
								<h4 class="popup-title">為這部電影評分</h4>
							</div>
							<div class="modal-body">
								<div class="rate">
									<input type="radio" id="rating10" name="rating" value="10"><label
										class="full" for="rating10" title="5 分"></label> <input
										type="radio" id="rating9" name="rating" value="9"><label
										class="half" for="rating9" title="4.5 分"></label> <input
										type="radio" id="rating8" name="rating" value="8"><label
										class="full" for="rating8" title="4 分"></label> <input
										type="radio" id="rating7" name="rating" value="7"><label
										class="half" for="rating7" title="3.5 分"></label> <input
										type="radio" id="rating6" name="rating" value="6"><label
										class="full" for="rating6" title="3 分"></label> <input
										type="radio" id="rating5" name="rating" value="5"><label
										class="half" for="rating5" title="2.5 分"></label> <input
										type="radio" id="rating4" name="rating" value="4"><label
										class="full" for="rating4" title="2 分"></label> <input
										type="radio" id="rating3" name="rating" value="3"><label
										class="half" for="rating3" title="1.5 分"></label> <input
										type="radio" id="rating2" name="rating" value="2"><label
										class="full" for="rating2" title="1 分"></label> <input
										type="radio" id="rating1" name="rating" value="1"><label
										class="half" for="rating1" title="0.5 分"></label>
								</div>
							</div>
							<div class="modal-footer">
								<button type="submit" form="form1" value="Submit">送出</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!---------------------------------------------- 相關影評----------------------------------------------------->
	<div class="container-fluid relative-review">
		<h4 class="title">相關影評</h4>
		<c:forEach var="reviewVO" items="${list}">
			<c:if test="${reviewVO.movieId==movieVO.movieId}">
				<article class="article-container">
					<a class="article-title" href="Links_Controller?reviewId=${reviewVO.reviewId}&action=getOne_From_Home">
						〔${movieVO.movieName}〕${reviewVO.reviewTitle}
					</a>
				</article>
			</c:if>
		</c:forEach>
	</div>

	
	
	
	
	<!------------------------------------------------------ 頁尾 -------------------------------------------------------------->
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



	
	<script>
		// Get the modal
		var modal = document.getElementById('myModal');

		// Get the button that opens the modal
		var btn = document.getElementById('starRate');

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks the button, open the modal 
		btn.onclick = function() {
			modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>


	<!-- Bootstrap 的 JS 官方CDN路徑 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
		crossorigin="anonymous">
		
	</script>
</body>
</html>