<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="com.MovieTag.model.*"%>

<%
	MovieVO movieVO = (MovieVO) request.getAttribute("movieVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>
<%
	MovieTagVO movieTagVO = (MovieTagVO) request.getAttribute("movieTagVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>後台管理員</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/movieData.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">
</head>
<body>
	<%@ include file="header.file"%>

	<jsp:useBean id="movieTagSvc" scope="page"
		class="com.MovieTag.model.MovieTagService" />
	<jsp:useBean id="TagCategorySvc" scope="page"
		class="com.TagCategory.model.TagCategoryService" />

	<div class="main">
		<h1 class="title">電影資料管理</h1>
		<h2 class="title2">電影資料</h2>

		<table class="table">
			<tr>
				<th>電影編號：${movieVO.movieId}</th>
			</tr>
			<tr>
				<th>電影名稱：${movieVO.movieName}</th>
			</tr>
			<tr>
				<th>英文名稱：${movieVO.movieEName}</th>
			</tr>
			<tr>
				<th>上映日期：${movieVO.releaseDate}</th>
			</tr>
			<tr>
				<th>片長：${movieVO.mins} 分鐘
				</th>
			</tr>
			<tr>
				<th>發行公司：${movieVO.studio}</th>
			</tr>
			<tr>
				<th>導演：${movieVO.director}</th>
			</tr>
			<tr>
				<th>主演：</th>
			</tr>
			<tr>
				<td><div class="Actor_div">${movieVO.actor}</div></td>
			</tr>
			<tr>
				<th>電影介紹：</th>
			</tr>
			<tr>
				<td><div class="Plot_div">${movieVO.plot}</div></td>
			</tr>
			<tr>
				<th>標籤類別： ${movieVO.movieTag}<br>
				
<%--   				<c:set var="b"  value="${movieTagSvc.getOneMovieTag(movieVO.movieId).movieId}" />   --%>
<%--   				<c:forEach var="movieTagVO" items="${movieTagSvc.getAll() }">   --%>
<%--   					<c:if test="${b == movieTagVO.movieId }">   --%>
<%--   						<c:set var="c" value="${movieTagVO.genreId }" />   --%>
<%--   						<c:forEach var="TagCategoryVO" items="${TagCategorySvc.getAll()}">   --%>
<%--   							<c:if test="${c == TagCategoryVO.genreId }">   --%>
<%--   								${TagCategoryVO.genreTag }   --%>
<%--   							</c:if>   --%>
<%--   						</c:forEach>   --%>
<%--                   	</c:if>   --%>
<%--   				</c:forEach>  </th> --%>
		</table>

		<div class="pic">
			<img src="<%=request.getContextPath()%>/DBGifReaderMovie?movieId=${movieVO.movieId }"">
		</div>
		
		
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do">
			     <button class="modification" type="submit" >修改電影資料</button>
			     
			     <input type="hidden" name="movieId"  value="${movieVO.movieId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
		
		<button class="back" onclick="window.location.href='movieDataSearch.jsp'">回到上一頁</button>

	</div>








	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../js/nav.js"></script>
</body>
</html>