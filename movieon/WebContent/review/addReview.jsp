<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.Locale"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.sql.Date"%>
<%@ page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page import="com.review.model.*"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="com.member.model.*"%> 
<jsp:useBean id="userId" scope="page" class="com.member.model.MemberService" />
<jsp:useBean id="userName" scope="page" class="com.member.model.MemberService" />
<jsp:useBean id="movieSvc" scope="page" class="com.movie.model.MovieService" />

<%
	// 	MemberVO memberNameVO = userName.getoneMember(2); //id先寫死, 2要改成變數
	// 	String memberName = memberNameVO.getUsername();
	MemberVO memberIdVO = userId.getOneMember(3); //會員id要自己改
	Integer memberId = memberIdVO.getUserid();

	ReviewVO reviewVO = (ReviewVO) request.getAttribute("reviewVO"); //裝你原先填的資料

	MovieVO movieVO = (MovieVO) request.getAttribute("movieVO");
	//取日期時間
	Locale locale = request.getLocale();
	Calendar calendar = Calendar.getInstance(locale);
	Date dateNow = new Date(calendar.getInstance().getTimeInMillis()); //拿到yyyy-mm-dd的日期格式 -> 2021-08-18

	Timestamp timeNow_before = new Timestamp(dateNow.getTime()); //拿到2021-08-18 05:23:53.621 包含毫秒的格式
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String strDateTime = dateFormat.format(timeNow_before); //拿到字串的格式-> 2021-08-18 05:23:53

	//要將String轉成Timestamp -> Timestamp.valueOf(strDateTime); 才可存到mysql
%>

<%	
if (session.getAttribute("memberVO") == null) {	//尚未登入
    RequestDispatcher dispatcher = request.getRequestDispatcher("/member/log_in.jsp"); //引導至登入頁面
	dispatcher.forward(request,response);
}

//已登入就不用轉交
MemberVO memberVO = (MemberVO)request.getSession().getAttribute("memberVO"); //取得memberVO
pageContext.setAttribute("memberVO",memberVO);


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
<!-- jQuery 的 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
/* 導入評分星星的font-awesome */
@import
	url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);

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
/* 	height:36px; */
/* } */

/* button.btn-outline-secondary { */
/* 	border-top-left-radius: 0; */
/* 	border-bottom-left-radius: 0; */
/* 	height:36px; */
/* } */

/* button.btn-login { */
/* 	color: black; */
/* 	background: #FFBE0B; */
/* 	margin-left: 30px; */
/* 	/*會員登入跟搜尋圖示隔開一點*/ */
/* 	font-size:.9em; */
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

/* div.navbar-collapse>ul.navbar-nav li.nav-item a{ */
/* 	font-size:.9em; */
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

/* ****************************************留下影評的表單*************************************** */
div.review-container {
	/* border: 2px solid red; */
	margin-top: 20px;
}
div.errormsg-container{
/* 	border: 2px solid red; */
	width: 600px;
	margin:0 auto;
}
div.errormsg-container > h4.errormsg-title,
div.errormsg-container > ul > li.errormsg-content{
	font-size: 0.9em;
	color:#FFBE0B;
}
form.review {
	/* margin: 200px; */
	width: 600px;
	/*  */
	margin: auto;
	border: 1px solid white;
	padding: 10px 0;
	border-radius: 10px;
	background-color: black;
	/* box-shadow: 5px 2px 10px #888888; */
}

form.review h4 {
	color: white;
	text-align: center;
}

form.review>label {
	margin: 15px 0;
	color: white;
	display: inline-block;
	text-align: right;
	width: 7em;
	font-size: 1.1em;
}

form.review input[type="text"] {
	margin: 5px;
	font-size: large;
	width: 400px;
	background: #EDF2f4;
	border: 1px solid white;
}

textarea {
	/* max-height: 800px; */
	min-height: 400px;
	width: 400px;
	/* max-width: 300px; */
	resize: vertical;
	background: #EDF2f4;
}

div.rate {
	/* border: 1px solid red; */
	display: inline-block;
}

div.rate>input {
	display: none;
}

div.rate>label {
	float: right;
}

div.rate>label:before {
	display: inline-block;
	font-size: 1.5rem;
	padding: 0 .2rem;
	margin: 0;
	cursor: pointer;
	font-family: FontAwesome;
	content: "\f005 ";
	/* color: white; */
	/* full star */
}

div.rate .half:before {
	content: "\f089 ";
	/* half star no outline */
	position: absolute;
	padding-right: 0;
}

div.rate label.half {
	background: white;
}

div.rate>input:checked ~label,
	/* color current and previous stars on checked */ div.rate>label:hover,
	div.rate>label:hover ~label {
	color: #006BB6;
}

input[type="radio"]:checked+label:hover,
	/* highlight current and previous stars */ input[type="radio"]:checked
	 ~label:hover ~label,
	/* highlight previous selected stars for new rating */ div.rate label:hover
	 ~input[type="radio"]:checked ~label
	/* highlight previous selected stars */ {
	color: #006BB6;
}

p.counter{
    color:#AABBCC;
	margin:0 auto;
    text-align: center;
    font-weight:600;
}

div.button {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 50px;
	/* border: 3px solid green; */
}

#reset {
	margin-right: 40px;
	background: black;
	color: white;
	border: 2px solid white;
}

#reset:hover {
	background: white;
	color: black;
}

#submit {
	background: black;
	color: white;
	border: 2px solid white;
}

#submit:hover {
	background: #FFBE0B;
	color: black;
}

div.button button {
	font-size: 1.1em;
	padding: 5px 30px;
	border-radius: 5px;
	border: none;
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
<title>留下影評</title>
<link href="<%=request.getContextPath()%>/css/profile_header.css" rel="stylesheet" />
</head>

<body>
	<%@include file="/header.file"%>
	<!--------------------------------------------- 導覽列 navbar -------------------------------------------------------------->
<!-- 	<nav class="navbar navbar-expand-lg  navbar-dark" -->
<!-- 		style="background-color: #000000;"> -->
<!-- 		<div class="container"> -->
<%-- 			<a href="<%=request.getContextPath() %>/Home.jsp" class="navbar-brand"><img --%>
<%-- 				src="<%=request.getContextPath() %>/images/logo.png" alt="" width="100" height="50"></a> --%>

<!-- 			<div class="collapse navbar-collapse"> -->
<!-- 				<ul class="navbar-nav ms-auto"> -->
<!-- 					<li class="nav-item dropdown"><a class="nav-link" href="#" -->
<!-- 						id="navbarDropdown" role="button" data-bs-toggle="dropdown" -->
<!-- 						aria-expanded="false"> 電影探索 </a> -->
<!-- 						<ul class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<%-- 							<li><a class="dropdown-item" href="<%=request.getContextPath() %>/moviesHome/movies_home.jsp">電影推薦</a></li> --%>
<%-- 							<li><a class="dropdown-item" href="<%=request.getContextPath() %>/moviesHome/movieGenre.jsp">電影類型</a></li> --%>
<%-- 							<li><a class="dropdown-item" href="<%=request.getContextPath() %>/review/addReview.jsp">留下影評</a></li> --%>
<%-- 							<li><a class="dropdown-item" href="<%=request.getContextPath() %>/review/reviewCenter.jsp">影評中心</a></li> --%>
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
<!-- 							<li><a class="dropdown-item" href="#">客服中心</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">聯絡客服</a></li> -->
<!-- 						</ul></li> -->
<!-- 					<li class="nav-item dropdown"><a class="nav-link" href="#" -->
<!-- 						id="navbarDropdown" role="button" data-bs-toggle="dropdown" -->
<!-- 						aria-expanded="false"> 會員中心 </a> -->
<!-- 						<ul class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<!-- 							<li><a class="dropdown-item" href="#">我的評分</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">我的影評</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">我的粉絲</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">追蹤中</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">動態牆</a></li> -->
<!-- 							<li><a class="dropdown-item" href="#">我的訂單</a></li> -->
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


	<!--------------------------------------------- 留下影評form表單 -------------------------------------------------------------->
	
	
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<div class="errormsg-container">
			<h4 class="errormsg-title">請修正以下錯誤:</h4>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li class="errormsg-content">${message}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	
	<div class="container review-container">
		<div class="row">
			<div class="col">
				<form method="POST" action="ReviewServlet" class="review" name="form1" autocomplete="off">
					<h4>留下影評</h4>
<!-- 					<label>會員編號</label>  -->
					<input type="hidden" name="userId" readonly value="${memberVO.userid}"> <br>
					<%-- <td>會員名稱:<%= memberName %></td> --%>
					<%-- <td>${reviewVO.getUserId(2)}</td> 	//id先寫死, 2要改成變數 --%>
					<label>會員名稱</label> 
					<input type="TEXT" name="username" readonly value="${memberVO.username}"> <br>
					<label>標題<b>*</b></label> <input type="TEXT" name="reviewTitle"
						value="<%=(reviewVO == null) ? "" : reviewVO.getReviewTitle()%>">
					<br> 
					<label>片名</label> 
					<select size="1" name=movieId>
						<c:forEach var="movieVO" items="${movieSvc.all}">
							<c:if test="${param.movieId == movieVO.movieId}">
								<option value="${movieVO.movieId}"  selected>${movieVO.movieName}
							</c:if>
							<option value="${movieVO.movieId}"
								${(reviewVO.movieId == movieVO.movieId)? 'selected' : '' }>${movieVO.movieName}
						</c:forEach>
					</select> 
					<br> 
					<label>推薦程度<b>*</b></label>
					<div class="rate">
						<input type="radio" id="rating10" name="rating" value="5"><label
							class="full" for="rating10" title="5 分"></label> <input
							type="radio" id="rating9" name="rating" value="4.5"><label
							class="half" for="rating9" title="4.5 分"></label> <input
							type="radio" id="rating8" name="rating" value="4"><label
							class="full" for="rating8" title="4 分"></label> <input
							type="radio" id="rating7" name="rating" value="3.5"><label
							class="half" for="rating7" title="3.5 分"></label> <input
							type="radio" id="rating6" name="rating" value="3"><label
							class="full" for="rating6" title="3 分"></label> <input
							type="radio" id="rating5" name="rating" value="2.5"><label
							class="half" for="rating5" title="2.5 分"></label> <input
							type="radio" id="rating4" name="rating" value="2"><label
							class="full" for="rating4" title="2 分"></label> <input
							type="radio" id="rating3" name="rating" value="1.5"><label
							class="half" for="rating3" title="1.5 分"></label> <input
							type="radio" id="rating2" name="rating" value="1"><label
							class="full" for="rating2" title="1 分"></label> <input
							type="radio" id="rating1" name="rating" value="0.5"><label
							class="half" for="rating1" title="0.5 分"></label>
					</div>
					<br> 
					<label>發佈日期</label> 
					<input type="TEXT" name="postedAt" readonly value="<%=strDateTime%>"> 
					<label>寫影評<b>*</b></label>
					<textarea class="status-box" name="review" id="word_count" oninput="countWord()">${reviewVO.review}</textarea>
					<p class="counter"></p>
					<br>
					<div class="button">
						<div class="btn_reset">
							<button type="reset" id="reset">清空</button>
						</div>
						<div class="btn_submit">
							<input type="hidden" name="action" value="insert">
							<button type="submit" id="submit">送出</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


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
	
	
	<script>
        var main = function () {
            //counter
            $('.status-box').keyup(function () {
                var postLength = $(this).val().length;
                $('.counter').text('輸入了 '+postLength+' 個字');

                if (postLength < 100) {
                    $('.btn_submit').addClass('disabled');
                }else {
                    $('.btn_submit').removeClass('disabled');
                }
            });

            $('.btn_submit').addClass('disabled');
        };

        $(document).ready(main);
    </script>
	
	<!-- Bootstrap 的 JS 官方CDN路徑 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
		crossorigin="anonymous">
		
	</script>
</body>

</html>