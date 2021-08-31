<%@page import="com.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.follow.model.*"%>

<!--How to get current userID? Using "1" as placeholder below-->
<%
	// 	String id = request.getParameter("id");
	Integer id = new Integer(request.getParameter("id"));
	pageContext.setAttribute("id", id);
%>

<%
	FollowService followSvc = new FollowService();
	List<FollowVO> list = followSvc.findFollowing(id);
	pageContext.setAttribute("list", list);
%>

<%
	if (session.getAttribute("memberVO") != null) {
		MemberVO loginMember = (MemberVO) session.getAttribute("memberVO");
		String loginMemberId = "" + loginMember.getUserid();
		pageContext.setAttribute("loginMemberId", loginMemberId);
	}
%>

<jsp:useBean id="memSvc" scope="page"
	class="com.member.model.MemberService" />
<jsp:useBean id="followService" scope="page"
	class="com.follow.model.FollowService" />
<jsp:useBean id="rvwSvc" scope="page"
	class="com.review.model.ReviewService" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${memSvc.getoneMember(id).username}的追蹤中。Movieon-</title>

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
<link
	href="${pageContext.request.contextPath}/follow/css/following.followers.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/follow/js/profile.js"></script>

</head>

<body class="following">

	<script>
		
	</script>

	<header class="header">header</header>

	<div class="site-body" id="content">
		<div class="content-wrap">
			<section class="profile_header">

				<nav class="profile-navigation">
					<div class="profile-mini-person">
						<a href="${pageContext.request.contextPath}/profile?id=${id}"
							class="avatar"> <img
							src="${pageContext.request.contextPath}/DBGifReaderFollow?userid=${id}"
							alt="${memSvc.getoneMember(id).username}" width="24" height="24">
						</a>
						<h1 class="title-3">
							<a href="${pageContext.request.contextPath}/profile?id=${id}">${memSvc.getoneMember(id).username}</a>
						</h1>
					</div>
					<ul class="navlist">
						<li class="navitem"><a class="navlink navprofile"
							href="${pageContext.request.contextPath}/profile?id=${id}">
								個人檔案 </a></li>
						<li class="navitem"><a class="navlink navfilms"
							href="${pageContext.request.contextPath}/profile?id=${id}&action=films">
								我看過的 </a></li>
						<li class="navitem"><a class="navlink navreviews"
							href="${pageContext.request.contextPath}/profile?id=${id}&action=reviews">影評
						</a></li>
						<li class="navitem"><a class="navlink navfollowers"
							href="${pageContext.request.contextPath}/profile?id=${id}&action=followers">
								粉絲 </a></li>
						<li class="navitem"><a class="navlink navfollowing"
							href="${pageContext.request.contextPath}/profile?id=${id}&action=following">
								追蹤中 </a></li>
						<li class="navitem"><a class="navlink navnetwork" href="${pageContext.request.contextPath}/profile?id=${id}&action=network">
								動態牆 </a></li>
                      <c:if test="${param.id==loginMemberId}">
                        <li class = "navitem">
                            <a class = "navlink" href="">
                                我的訂單<i class="fa fa-clipboard-list"></i>
                            </a>
                        </li>
                        </c:if>
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
				<%@ include file="pages/page1.file"%>
				<table class="person-table">
					<thead>
						<tr>
							<th class="left-th">名字</th>
							<th>看過</th>
							<th>粉絲</th>
							<th>追蹤中</th>
							<c:if test="${param.id==loginMemberId}">
								<th>狀態</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="followVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
							<tr data-id="${followVO.targetID}">
								<td class="table-person">
									<div class="person-summary">
										<a class="avatar"
											href="${pageContext.request.contextPath}/profile?id=${followVO.targetID}">
											<img
											src="${pageContext.request.contextPath}/DBGifReaderFollow?userid=${followVO.targetID}"
											alt="">
										</a>
										<h3 class="title-3">
											<a class="name"
												href="${pageContext.request.contextPath}/profile?id=${followVO.targetID}">${memSvc.getoneMember(followVO.targetID).username}
											</a>
										</h3>
										<small class="metadata"> <a
											href="userid.jsp?id=${followVO.targetID}">followed since
												${followService.updatedDate(followVO.updatedAt)}</a>
										</small>
									</div>
								</td>
								<td class="table-stats"><a class="icon-watched"
									href="films.jsp?id=${followVO.targetID}"> <span> <i
											class="fas fa-eye"></i>
											${rvwSvc.userReviewCount(followVO.targetID)}
									</span>
								</a></td>
								<td class="table-stats"><a class="icon-followers"
									href="followers.jsp?id=${followVO.targetID}"> <span>
											<i class="fas fa-th-large"></i>
											${followService.followerCount(followVO.targetID)}
									</span>
								</a></td>
								<td class="table-stats"><a class="icon-following"
									href="following.jsp?id=${followVO.targetID}"> <span>
											<i class="fas fa-user-friends"></i>
											${followService.followingCount(followVO.targetID)}
									</span>
								</a></td>

								<c:if test="${param.id==loginMemberId}">
									<td class="table-follow-status">
										<div class="follow-button-wrapper">
											<a class="button -compact -following " href="#"> <span
												class="icon"> <!-- <i class='fas fa-check-circle'></i> -->
											</span>
											</a>
										</div>
									</td>
								</c:if>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<%@ include file="pages/page2.file"%>
			</section>



		</div>
	</div>
	<div class="alert ">
		<span class="closebtn">&times;</span>
		<span class="alertmsg">xxx</span>
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
		<span> MovieOn. Made by programming students in Taipei, Taiwan.
			For learning purposes only.</span>
		</div>
	</footer>
	<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script> -->
</body>

</html>