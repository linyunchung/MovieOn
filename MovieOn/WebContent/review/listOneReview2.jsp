<%@page import="com.member.model.*"%>
<%@page import="com.review.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% ReviewVO reviewVO = (ReviewVO)request.getAttribute("reviewVO");%>

<%-- 透過MemberService抓Username--%>
<% MemberService memberSvc = new MemberService();
	MemberVO memberVO = memberSvc.getoneMember(reviewVO.getUserId());
%>
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

/* *********************************************文章************************************************* */
div#page {
	border: 1px dotted #404040;
	margin: 0 auto;
	padding: 0 30px;
	max-width: 700px;
}

div.content-area {
	/* border: 1px solid red; */
	
}

main.site-main {
	margin: auto;
	max-width: 700px;
	/* border: 1px solid blue; */
}

main.site-main h1.entry-title, main.site-main div.entry-meta {
	text-align: center;
}

h1.entry-title {
	margin: 60px 0 5px 0;
	font-size: 1.5em;
	font-weight: 500;
	letter-spacing: 1px;
	color: white;
}

div.entry-meta a.article-author {
	color: #006BB6;
	font-size:.9em;
}

div.entry-meta a.article-author:hover {
	cursor: pointer;
}

div.entry-meta button {
	padding: 1px 8px;
	color: black;
	background: white;
	font-size:.8em;
}

div.entry-meta button:hover {
	color: black;
	background: white;
	font-size: .9em;
}

div.entry-meta .posted-on {
	margin: 0;
	color: #64625C;
	font-size: 0.8em;
}

div.entry-content {
	margin-top: 60px;
	font-size: 1em;
	color: #AABBCC;
}

div.comments-area {
	margin: 90px 0;
	/* border:1px solid green; */
}

h2.comment-title {
	color: white;
	font-size: 1.4em;
	font-weight: 400;
	letter-spacing: 2px;
	text-align: center;
}

h2.comment-title:after {
	display: block;
	content: '';
	margin: 30px auto 60px;
	max-width: 400px;
	border-bottom: 1px solid #D6CCC7;
}

ul.comment-list {
	margin: 0;
	padding: 0;
}

ul.comment-list li {
	margin-bottom: 50px;
	list-style-type: none;
}

ul.comment-list li a {
	display: inline-block;
	padding-bottom: 0px;
	margin-bottom: 5px;
}

.comment-author {
	font-size: 1em;
	font-weight: bold;
	color: #AABBCC;
}

div.comment-meta {
	font-size: .8em;
	color: gray;
}

div.comment-meta>a {
	color: #AABBCC;
}

.comment-content {
	color: #EDF2F4;
	font-size: 1em;
}

.comment-respond {
	margin-top: 90px;
	color: white;
}

.comment-reply-title, .comment-respond input[type="text"] {
	display: block;
	margin-bottom: 5px;
}

.comment-reply-title {
	color: #006BB6;
}

.comment-respond > h2{
	font-size:1.5em;
}
.comment-respond textarea {
	width: 100%;
	padding: 10px;
	height: 100px;
	background: #EDF2F4;
	border-radius: 0.5em;
}

.comment-respond button {
	margin-top: 20px;
	padding: 10px 20px;
	background: transparent;
	border: 1px solid #EDF2F4;
	border-radius: 0.5em;
	font-size: 1em;
	line-height: 1.5;
	color: #EDF2F4;
	cursor: pointer;
}

.comment-respond button:hover {
	background: #EDF2F4;
	color: black;
	font-weight:900;
}

.nav-links {
	margin-top: 150px;
	font-size: 24px;
	font-weight: bold;
	letter-spacing: 1px;
	overflow: auto;
	zoom: 1;
}

.nav-links a {
	padding-bottom: 10px;
	color: #433F3F;
	text-decoration: none;
	border-bottom: none;
}

.nav-links a:hover {
	color: white;
}

.previous-post, .next-post {
	display: block;
	width: 50%;
}

.previous-post {
	float: left;
	text-align: left;
}

.next-post {
	float: right;
	text-align: right;
}

@media screen and (max-width: 680px) {
	#page {
		margin: 60px auto 30px;
	}
	.previous-post, .next-post {
		width: 100%;
		float: none;
		text-align: center;
	}
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

<title>單一影評頁面</title>
</head>
<body>
	<!--------------------------------------------- 導覽列 navbar -------------------------------------------------------------->
    <nav class="navbar navbar-expand-lg  navbar-dark" style="background-color: #000000;">
        <div class="container">
            <a href="Home.jsp" class="navbar-brand"><img src="images/logo.png" alt="" width="100" height="50"></a>

            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            電影探索
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/MOVIEON/moviesHome/movies_home.jsp">電影推薦</a></li>
                            <li><a class="dropdown-item" href="/MOVIEON/moviesHome/movieGenre.jsp">查詢電影類型</a></li>
                            <li><a class="dropdown-item" href="/MOVIEON/review/addReview.jsp">留下影評</a></li>
                            <li><a class="dropdown-item" href="/MOVIEON/review/reviewCenter.jsp">影評中心</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            交友
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
                    <form class="d-flex">
                        <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-secondary" type="submit"><i class="fas fa-search"></i></button>
                    </form>
                    <li class="nav-item">
                        <!-- <a href="#instruction" class="nav-link" style="color:#FFBE0B">會員登入</a> -->
                        <button class="btn btn-login" type="submit">會員登入</button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!--------------------------------------------- 影評全文，最底有留言區 -------------------------------------------------------------->
    <div id="page">
        <div class="content-area">
            <main class="site-main" role="main">
                <article class="post">
                    <h1 class="entry-title"><%=reviewVO.getReviewTitle() %></h1>
                    <div class="entry-meta">
                        <a class="article-author"><%=memberVO.getUsername() %></a>
                        <button type="button" class="btn btn-outline-dark btn-sm"><i class="fas fa-plus">追蹤</i></button>
                        <span class="posted-on"><%=reviewVO.getPostedAt() %></span>
                    </div>
                    <div class="entry-content">
                        <p><%=reviewVO.getReview() %></p>
                    </div>
                </article>

                
                <div class="comments-area">
                    <h2 class="comment-title">留言</h2>
                    <ul class="comment-list">
                        <li class="comment">
                            <div class="comment-author"><span>吳XX</span></div>
                            <div class="comment-meta"><span>2021/08/01 at 10:33pm</span>
                            </div>
                            <div class="comment-content">
                                <p>寫得很讚!!</p>
                            </div>
                        </li>
                    </ul>

                    <div class="comment-respond">
                        <h2>Leave a Reply</h2>
                        <label class="comment-reply-title" for="message">*要先登入才能發布留言</label>
                        <textarea id="message"></textarea>
                        <button>發佈留言</button>
                    </div>
                </div>
            </main>
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