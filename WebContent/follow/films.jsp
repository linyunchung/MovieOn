<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.review.model.*"%>

<%
	Integer id = new Integer(request.getParameter("id"));
	pageContext.setAttribute("id", id);
%>

<%
	ReviewService reviewSvc = new ReviewService();
	List<ReviewVO> list = reviewSvc.getUserReview(id);
	pageContext.setAttribute("list", list);
%>

<jsp:useBean id="rvwSvc" scope="page"
	class="com.review.model.ReviewService" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>里維阿卡曼兵長的電影。Movieon -</title>

<!-- font-awesome script -->
<script src="https://use.fontawesome.com/b0a5afcff9.js"></script>


<!-- CDN for bootstrap -->
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->

<!-- font awesome links -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/v4-shims.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Serif+TC&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
	rel="stylesheet">

<!-- CSS stylesheet -->
<link href="${pageContext.request.contextPath}/follow/css/films.css" rel="stylesheet" />

<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/films.js"></script>

</head>
<body class="films films-rated">
	<header class="header">header</header>

	<div class="site-body" id="content">
		<div class="content-wrap">
			<section class="profile_header">

				<nav class="profile-navigation">
					<div class="profile-mini-person">
						<a href="${pageContext.request.contextPath}/profile?id=${id}" class="avatar"> <img
							src="https://static.wikia.nocookie.net/shingekinokyojin/images/b/b1/Levi_Ackermann_%28Anime%29_character_image.png"
							alt="里維阿卡曼兵長" width="24" height="24">
						</a>
						<h1 class="title-3">
							<a href="">里維阿卡曼兵長</a>
						</h1>
					</div>
					<ul class="navlist">
						<li class="navitem"><a class="navlink navprofile"
							href="${pageContext.request.contextPath}/profile?id=${id}"> 個人檔案 </a></li>
						<li class="navitem"><a class="navlink navfilms"
							href="${pageContext.request.contextPath}/profile?id=${id}&action=films"> 我看過的 </a></li>
						<li class="navitem"><a class="navlink navreviews"
							href="${pageContext.request.contextPath}/profile?id=${id}&action=reviews"> 影評 </a></li>
						<li class="navitem"><a class="navlink navfollowers"
							href="${pageContext.request.contextPath}/profile?id=${id}&action=followers"> 粉絲 </a></li>
						<li class="navitem"><a class="navlink navfollowing"
							href="${pageContext.request.contextPath}/profile?id=${id}&action=following"> 追蹤中 </a></li>
						<li class="navitem"><a class="navlink navnetwork" href="">
								動態牆 </a></li>
						<li class="navitem -orders"><a class="navlink navorders"
							href=""> 購買清單 <i class="fa fa-clipboard-list"></i>
						</a></li>
					</ul>
				</nav>

			</section>

			<div class="cols-2 overflow">

				<section class="section col-main">
					<div id="content-nav" class="tabbed">
						<section class="sub-nav-wrapper">
							<ul class=sub-nav>
								<li class="selected"><a href="films.jsp?id=${id}">我看過的</a>
								</li>
								<li class=""><a href="reviews.jsp?id=${id}">影評</a></li>
								<!-- <li class="">
                                    <a href="">評分</a>
                                </li> -->
								<!-- <li class=""></li> -->
							</ul>
						</section>
						<div class="sorting-selects has-hide-toggle">
							<section class="smenu-wrapper">
								<strong class="smenu-label">排序:</strong>
								<div class=smenu>
									<label> 評分時間 <i class="fas fa-chevron-down"></i>
									</label>
								</div>
							</section>
							<section class="smenu-wrapper">
								<div class=smenu>
									<label> 評分 <i class="fas fa-chevron-down"></i>
									</label>
								</div>
							</section>
							<section class="smenu-wrapper">
								<div class=smenu>
									<label> 類型 <i class="fas fa-chevron-down"></i>
									</label>
								</div>
							</section>
							<section class="smenu-wrapper">
								<div class=smenu>
									<label> 年份 <i class="fas fa-chevron-down"></i>
									</label>
								</div>
							</section>
						</div>
					</div>
<%@ include file="pages/page1Films.file" %> 
					<ul class="poster-list -grid">
					<c:forEach var="reviewVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
						<li class="poster-container film-watched">
							<div class="poster film-poster">
								<div>
									<img class="image"
										src="${pageContext.request.contextPath}/DBGifReaderProfile?movieId=${reviewVO.movieId}"
										width="150" height="225" alt="I Kill Giants"> <a
										class="frame" href=""> <!-- <span class = "frame-title">殺死巨人的女孩(2017)</span> -->
										<span class="overlay"></span>
									</a>
								</div>
							</div>
							<p class="poster-viewingdata">
								<span class="rating rated-5">${reviewVO.starRate}</span>
								<time datetime="">${rvwSvc.getMonthDate(reviewVO.postedAt)}</time>
							</p>
						</li>
						</c:forEach>
					</ul>
<%@ include file="pages/page2Films.file" %> 
					<div class="pagination"></div>

				</section>

			</div>



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
		<span>© MovieOn. Made by programming students in Taipei,
			Taiwan. For learning purposes only.</span>
		</div>
	</footer>
	<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script> -->
</body>
</html>