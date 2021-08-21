<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.stream.*"%>
<%@ page import="com.review.model.*"%>
<%@ page import="com.movie.model.*"%>
<%-- <jsp:useBean id="movieSvc" scope="page" class="com.movie.model.MovieService" /> --%>

<%
	// 	ReviewDAO dao = new ReviewDAO();
	ReviewService revSvc = new ReviewService();
	List<ReviewVO> reviewList = revSvc.getAll();
	List<ReviewVO> list = reviewList.stream().limit(5).collect(Collectors.toList());
	pageContext.setAttribute("list", list);

	MovieService movieSvc = new MovieService();
	List<MovieVO> movieList = movieSvc.getAll();
	pageContext.setAttribute("movieList", movieList);
%>

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

<title>MOVIEON首頁</title>

<style>
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
	height: 36px;
}

button.btn-outline-secondary {
	border-top-left-radius: 0;
	border-bottom-left-radius: 0;
	height: 36px;
}

button.btn-login {
	color: black;
	background: #FFBE0B;
	margin-left: 30px;
	/*會員登入跟搜尋圖示隔開一點*/
	font-size: .9em;
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

/* *****************************************************預告片的CSS***************************************************** */
main.main-content {
	/* border: 1px solid red; */
	/* background-color: #131313; */
	
}

div.youtube-carousel-wrap {
	width: 100%;
	max-width: 1200px;
	/* 跟導覽列的最大寬度一樣 */
	margin: 0 auto;
	display: flex;
	flex-wrap: nowrap;
}

/* 中間大圖 */
div.youtube-carousel-wrap>div.youtube-carousel-main {
	width: 960px;
	height: 540px;
	/* border:10px solid green; */
}

/* 右邊4張小圖 */
.youtube-carousel-gallery {
	width: 20%;
	height: 540px;
	position: relative;
	margin-left: 5px;
	/* border:10px solid green; */
}

.youtube-carousel-main iframe {
	width: 100%;
	height: 100%;
}

.youtube-control {
	width: 100%;
	height: 135px;
	background-position: center center;
	background-size: cover;
	background-repeat: no-repeat;
	position: relative;
	cursor: pointer;
	/* margin-bottom: 5px; */
	position: relative;
	box-sizing: border-box;
}

p.youtube-caption {
	font-size: 14px;
	color: white;
	background: rgba(0, 0, 0, 0.6);
	position: absolute;
	bottom: 0;
	left: 0;
	width: 100%;
	margin: 0;
	padding: 8px;
	box-sizing: border-box;
}

div.TheSuicideSquad-vid {
	background-image:
		url('https://img.youtube.com/vi/FXsqA85NxrI/hqdefault.jpg');
}

div.BlackWidow-vid {
	background-image:
		url('https://img.youtube.com/vi/-gQHSE7cJg8/hqdefault.jpg');
}

div.JungleCruise-vid {
	background-image:
		url('https://img.youtube.com/vi/NObCpq72nN8/hqdefault.jpg');
}

div.Venom-vid {
	background-image:
		url('http://img.youtube.com/vi/QEPeGW-bxgU/hqdefault.jpg');
}

@media only screen and (max-width: 1210px) {
	.youtube-carousel-wrap {
		flex-wrap: wrap;
	}
	.youtube-carousel-gallery, .youtube-carousel-main {
		width: 100%;
	}
	.youtube-carousel-gallery {
		overflow-y: auto;
		height: auto;
		margin-top: 5px;
		white-space: nowrap;
	}
	.youtube-control {
		width: 260px;
		height: 135px;
		display: inline-block;
	}
}

/******************************************************* 電影海報***************************************************** */
h4.hot-movie, h4.upcoming, h4.recent-post {
	/* border: 1px solid red; */
	border-bottom: 1px solid rgb(179, 179, 179);
	color: white;
}

div.container-poster {
	/* border: 2px solid red; */
	max-width: 1200px;
	margin-top: 3em;
	/*跟導覽列的最大寬度一樣*/
}

div.card-container {
	display: flex;
	/*             flex-wrap: wrap; */
	/* border: 3px solid blue; */
	width: 100%;
	max-width: 1200px;
	/* 跟導覽列的最大寬度一樣 */
	justify-content: space-around;
	margin: 0 auto;
}

div.card-container .card {
	/* border: solid 2px red; */
	/* margin: 2px; */
	border: none;
}

div.card-container .card .card-body {
	padding: 3px 0;
	/* border: solid 2px red; */
}

p.card-text {
	text-align: center;
}

div.card-container div.card img.card-img {
	height: 220px;
	width: 180px;
	object-fit: cover;
}

div.card-container div.card img.card-img:hover {
	opacity: 0.8;
}

/******************************************************* 近期影評***************************************************** */
section.movie-review {
	/* border: 1px solid red; */
	padding: 0 1em;
	max-width: 1200px;
	margin: 0 auto;
	margin-top: 5em;
}

section.movie-review article.blog-post {
	border-bottom: 0.1em gray dotted;
	padding: 1em 0;
}

section.movie-review article.blog-post a.blog-title {
	font-size: 1em;
	font-weight: bold;
	color: #AABBCC;
	text-decoration: none;
}

section.movie-review article.blog-post a.blog-title:hover, section.movie-review article.blog-post a.blog-title:focus
	{
	color: #EDF2F4;
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
</style>

</head>

<body>
	<!--------------------------------------------- 導覽列 navbar -------------------------------------------------------------->
	<nav class="navbar navbar-expand-lg  navbar-dark"
		style="background-color: #000000;">
		<div class="container">
			<a href="#" class="navbar-brand"><img src="images/logo.png"
				alt="" width="100" height="50"></a>

			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item dropdown"><a class="nav-link"
						href="MovieALL.html" id="navbarDropdown" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> 電影探索 </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/MOVIEON/moviesHome/movies_home.jsp">電影推薦</a></li>
							<li><a class="dropdown-item" href="/MOVIEON/moviesHome/movieGenre.jsp">查詢電影類型</a></li>
							<li><a class="dropdown-item"
								href="/MOVIEON/review/addReview.jsp">留下影評</a></li>
							<li><a class="dropdown-item"
								href="/MOVIEON/review/reviewCenter.jsp">影評中心</a></li>
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
					<form class="d-flex">
						<input class="form-control" type="search" placeholder="Search"
							aria-label="Search">
						<button class="btn btn-outline-secondary" type="submit">
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


	<!------------------------------------------------------ 預告片 ------------------------------------------------------------>
	<main class="main-content">
		<div class="youtube-carousel-wrap">
			<div class="youtube-carousel-main">
				<iframe id="main-youtube-video"
					src="https://www.youtube.com/embed/FXsqA85NxrI" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
			<div class="youtube-carousel-gallery" data-simplebar>
				<div class="youtube-control TheSuicideSquad-vid"
					data-source="https://www.youtube.com/embed/FXsqA85NxrI">
					<p class="youtube-caption">自殺突擊隊：集結</p>
				</div>
				<div class="youtube-control BlackWidow-vid"
					data-source="https://www.youtube.com/embed/-gQHSE7cJg8">
					<p class="youtube-caption">黑寡婦</p>
				</div>
				<div class="youtube-control JungleCruise-vid"
					data-source="https://www.youtube.com/embed/NObCpq72nN8">
					<p class="youtube-caption">叢林奇航</p>
				</div>
				<div class="youtube-control Venom-vid"
					data-source="https://www.youtube.com/embed/QEPeGW-bxgU">
					<p class="youtube-caption">猛毒2：血蜘蛛</p>
				</div>

			</div>
		</div>



		<!------------------------------------------------- 電影海報 ----------------------------------------------------------->
		<div class="container container-poster">
			<h4 class="hot-movie">熱門電影</h4>
			<div class="card-container">
				<c:forEach var="movieVO" items="${movieList}" begin="1" end="5">
					<div class="card">
						<a href="#" class="poster-link"><img src="DBGifReader_home?movieId=${movieVO.movieId}" alt="photo" class="card-img"></a>
						<div class="card-body">
							<p class="card-text">${movieVO.movieName}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		

		<div class="container container-poster">
			<!-- <p>Hover over the card to see the drop shadow added</p> -->
			<h4 class="upcoming">即將上映</h4>
			<div class="card-container">
				<c:forEach var="movieVO" items="${movieList}" begin="14" end="18">
					<div class="card">
						<a href="#" class="poster-link"><img src="DBGifReader_home?movieId=${movieVO.movieId}" alt="photo" class="card-img"></a>
						<div class="card-body">
							<p class="card-text">${movieVO.movieName}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>



		<!-------------------------------------------------- 影評 ------------------------------------------------------------->
		<section class="movie-review">
			<h4 class="recent-post">近期影評</h4>
			<c:forEach var="reviewVO" items="${list}">
				<article class="blog-post">
					<%--交給Controller (Links_Controller.java)來處理, controller再透過id引導到該篇文章的全文(單一查詢) --%>
					<a class="blog-title" href="Links_Controller?reviewId=${reviewVO.reviewId}&action=getOne_From_Home" >${reviewVO.reviewTitle}</a>
				</article>
			</c:forEach>
		</section>
	</main>


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


	<!--------------------------------------------- 放自己寫的JS ---------------------------------------------->
	<script>
		var videos = document.getElementsByClassName("youtube-control");
		for (i = 0; i < videos.length; i++) {
			videos[i].addEventListener("click", function() {
				changeSrc(this);
			}, false);
		}

		function changeSrc($this) {
			var source = $this.getAttribute("data-source");
			var mainVideo = document.getElementById("main-youtube-video");
			mainVideo.src = source;
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