<%@page import="java.util.List"%>
<%@page import="com.movie.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%	
//     MovieService movieSvc = new MovieService();
// 	List<MovieVO> movieList = movieSvc.getAll();
// 	pageContext.setAttribute("movieList", movieList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<!-- Font Awesome CDN -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

<!--  Bootstrap 的 CSS 官方CDN路徑 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- jQuery的 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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

/************************************************海報區***************************************************/
div.movie-genre {
	max-width: 1200px;
	margin: 0 auto;
	/*border: 1px solid blue;*/
}
div.movie-genre > h3.searchNotFound{
	display: block;
	color:white;
	/*border: 1px solid blue;*/
	text-align:center;
	margin:1em 0 1000px;
}

div.gallery {
	display: flex;
	flex-wrap: wrap;
	/* justify-content: space-between; */
	/* border:1px solid blue; */
	/* margin-bottom: 500px; */
}

div.gallery > h4.title{
	color:white;
}

figure.figure img {
	width: 250px;
	height: 350px;
	/* padding: 5px; */
	/* background-color: gray; */
	/* border: 1px solid #AABBCC; */
	margin: 0;
}

figure.figure img:hover {
	transform: scale(1.02);
}

figure.figure {
	/* border: 1px solid blue; */
	margin: 0.9em;
}

.figure-caption {
	font-size: 1em;
	text-align: center;
	color: ghostwhite;
}

figure.figure p {
	/* display: inline-flex; */
	/* font-style: italic; */
	color: gray;
	font-size: 0.9em;
	/* line-height: 18px;
            margin-top: 10px; */
	text-align: center;
	/* border: 1px solid purple; */
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

<title>搜尋結果</title>
</head>
<body>
	<!--------------------------------------------- 導覽列 navbar -------------------------------------------------------------->
    <nav class="navbar navbar-expand-lg  navbar-dark" style="background-color: #000000;">
        <div class="container">
            <a href="${pageContext.request.contextPath}/Home.jsp" class="navbar-brand"><img src="<%=request.getContextPath() %>/images/logo.png" alt="" width="100" height="50"></a>

            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">電影探索</a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="<%=request.getContextPath() %>/moviesHome/movies_home.jsp">電影推薦</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/moviesHome/movieGenre.jsp">電影類型</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/review/addReview.jsp">留下影評</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/review/reviewCenter.jsp">影評中心</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">交友
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">媒合配對</a></li>
                            <li><a class="dropdown-item" href="#">即時訊息</a></li>
                            <li><a class="dropdown-item" href="#">好友名單</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            會員中心
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">我的影評</a></li>
                            <li><a class="dropdown-item" href="#">追蹤清單</a></li>
                            <li><a class="dropdown-item" href="#">歷史購物紀錄</a></li>
                            <li><a class="dropdown-item" href="#">動態牆</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            電影時刻表
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">場次查詢</a></li>
                            <li><a class="dropdown-item" href="#">歷史搜尋紀錄</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            商城
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">商品列表</a></li>
                            <li><a class="dropdown-item" href="#">購物車</a></li>
                            <li><a class="dropdown-item" href="#">購物流程</a></li>
                            <li><a class="dropdown-item" href="#">訂單查詢</a></li>
                            <li><a class="dropdown-item" href="#">客服中心</a></li>
                        </ul>
                    </li>
                    <form method="post" action="HomeServlet" class="d-flex" autocomplete="off">
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

	
	<div class="container movie-genre">
        <!-- Tab content -->
        <c:if test="${resultList.size()==0}"><h3 class="searchNotFound">查無資料</h3></c:if>
<%-- 		<c:if test="${noinput.equals("1")}"><h3 class="searchNotFound">你又沒輸入?!</h3></c:if> --%>
		        
        <div class="gallery">
        	<c:forEach var="movieVO" items="${resultList}">
        		<figure class="figure">
                	<a href="Links_Controller?movieId=${movieVO.movieId}&action=getOneMovie_From_Home"><img src="DBGifReader_home?movieId=${movieVO.movieId}" class="figure-img img-fluid rounded" alt="photo"></a>
                	<figcaption class="figure-caption">${movieVO.movieName}</figcaption>
                	<p class="release">${movieVO.releaseDate}</p>
            	</figure>
            </c:forEach>
        </div>
    </div>

	
	<!-------------------------------------------------- 頁尾 ------------------------------------------------------------->
    <footer class="footer">
        <div class="nav">
            <div class="nav-links">
                <a href="#" target="">回到首頁</a>
                <a href="#" target="">關於我們</a>
                <a href="#" target="">服務說明</a>
                <a href="#" target="">客服</a>
                <a href="#" target="">聯絡我們</a>
                <br>
                <span>© MovieOn. Made by programming students in Taipei, Taiwan. For learning purposes only.</span>
            </div>
        </div>
    </footer>
    
    <!-- Bootstrap 的 JS 官方CDN路徑 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous">
    </script>
</body>
</html>