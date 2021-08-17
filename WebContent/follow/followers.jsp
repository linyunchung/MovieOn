<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.follow.model.*"%>
<%@ page import="com.member.model.*"%>

<!--How to get current userID? Using "1" as placeholder below-->
<%
	FollowService followSvc = new FollowService();
	List<FollowVO> list = followSvc.findFollowers(1);
	pageContext.setAttribute("list", list);
%>

<jsp:useBean id="memSvc" scope="page"
	class="com.member.model.MemberService" />
<jsp:useBean id="followService" scope="page"
	class="com.follow.model.FollowService" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>里維阿卡曼兵長的粉絲。Movieon -</title>

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
<link href="./css/following.followers.css" rel="stylesheet" />

</head>

<body class="followers">
	<header class="header">header</header>

	<div class="site-body" id="content">
		<div class="content-wrap">
			<section class="profile_header">

				<nav class="profile-navigation">
					<div class="profile-mini-person">
						<a href="userid.jsp" class="avatar"> <img
							src="https://static.wikia.nocookie.net/shingekinokyojin/images/b/b1/Levi_Ackermann_%28Anime%29_character_image.png"
							alt="里維阿卡曼兵長" width="24" height="24">
						</a>
						<h1 class="title-3">
							<a href="userid.jsp">里維阿卡曼兵長</a>
						</h1>
					</div>
					<ul class="navlist">
						<li class="navitem"><a class="navlink navprofile"
							href="userid.jsp"> 個人檔案 </a></li>
						<li class="navitem"><a class="navlink navfilms"
							href="films.jsp"> 我看過的 </a></li>
						<li class="navitem"><a class="navlink navreviews" href="">
								影評 </a></li>
						<li class="navitem"><a class="navlink navfollowers"
							href="followers.jsp"> 粉絲 </a></li>
						<li class="navitem"><a class="navlink navfollowing"
							href="following.jsp"> 追蹤中 </a></li>
						<li class="navitem"><a class="navlink navnetwork" href="">
								動態牆 </a></li>
						<li class="navitem -orders"><a class="navlink navorders"
							href=""> 購買清單 <i class="fa fa-clipboard-list"></i>
						</a></li>
					</ul>
				</nav>

			</section>

			<section class="section">

				<%-- HIDDEN: switch between followers/following/blocked --%>
				<div id="content-nav" class="tabbed">
					<section class="sub-nav-wrapper">
						<!-- <ul class = "sub-nav">
                            <li>
                                <a href="followers.html">粉絲</a>
                            </li>
                            <li>
                                <a href="following.html">追蹤中</a>
                            </li>
                            <li>
                                <a href="">已封鎖</a>
                            </li>
                        </ul> -->
					</section>
				</div>
				<!--<a href="" class = "all-link">全部</a>-->

				<%-- Error Handling --%>
				<c:if test="${not empty errorMsgs}">
					<font style="color: red">Oops: </font>
					<ul>
						<c:forEach var="message" items="${errorMsgs}">
							<li style="color: red">${message}</li>
						</c:forEach>
					</ul>
				</c:if>

				<%-- Table Starts --%>
				<table class="person-table">
					<thead>
						<tr>
							<th class="left-th">名字</th>
							<th>看過</th>
							<th>粉絲</th>
							<th>追蹤中</th>
							<th>狀態</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="followVO" items="${list}">
							<tr>
								<td class="table-person">
									<div class="person-summary">
										<a class="avatar" href=""> <img
											src="/MovieOn3/DBGifReaderFollow?userid=${followVO.sourceID}"
											alt="">
										</a>
										<h3 class="title-3">
											<a class="name" href="">${memSvc.getoneMember(followVO.sourceID).username}
											</a>
										</h3>
										<small class="metadata"> <a href="">followed since
												${followVO.updatedAt}</a>
										</small>
									</div>
								</td>
								<td class="table-stats"><a class="icon-watched" href="">
										<span> <i class="fas fa-eye"></i> 123
									</span>
								</a></td>
								<td class="table-stats"><a class="icon-followers" href="">
										<span> <i class="fas fa-th-large"></i>
											${followService.followerCount(followVO.sourceID)}
									</span>
								</a></td>
								<td class="table-stats"><a class="icon-following" href="">
										<span> <i class="fas fa-user-friends"></i>
											${followService.followingCount(followVO.sourceID)}
									</span>
								</a></td>
								<td class="table-follow-status">
									<div class="follow-button-wrapper">
										<a class="-following" href=""> <span class="icon-text">
												<i class="fas fa-check-circle"></i>
										</span>
										</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pagination">
					<div class=paginate-nextprev>
						<a class="previous" href="">往前</a>
					</div>
					<div class=paginate-nextprev>
						<a class="next" href="">往後</a>
					</div>
				</div>
			</section>



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
			<span> MovieOn. Made by programming students in Taipei,
				Taiwan. For learning purposes only.</span>
		</div>
	</footer>
	<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script> -->
</body>

</html>