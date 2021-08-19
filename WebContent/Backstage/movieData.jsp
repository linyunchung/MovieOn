<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="com.MovieTag.model.*"%>

<%
	MovieVO movieVO = (MovieVO) request.getAttribute("movieVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>
<%
	MovieTagVO movieTagVO = (MovieTagVO) request.getAttribute("movieTagVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>��x�޲z��</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/movieData.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">
</head>
<body>
	<div id="header">
		<a href="" class="logo"> <img src="img/logo.png" alt="">
		</a>
		<nav>

			<ul>

				<li class="dropdown"><a href="">�|����ƺ޲z</a></li>

				<li class="dropdown"><a href="">�ӫ�����</a></li>

				<li class="dropdown"><a href="">�q�v�޲z</a>
					<ul>
						<li><a href="#">�w�W�[�q�v�޲z</a></li>
						<li><a href="#">�W�[�s�q�v</a></li>
					</ul></li>

				<li class="dropdown"><a href="">�ӫ~�޲z</a>
					<ul>
						<li><a href="#">�w�W�[�ӫ~�޲z</a></li>
						<li><a href="#">�W�[�s�ӫ~</a></li>
					</ul></li>

				<li class="dropdown"><a href="">�q�v�ɨ��</a>
					<ul>
						<li><a href="#">�w�W�[�q�v�ɨ��޲z</a></li>
						<li><a href="#">�W�[�s�q�v�ɨ��</a></li>
					</ul></li>

				<li class="dropdown"><a href="">�ȪA�^��</a></li>

				<li class="dropdown"><a href="">�q��޲z</a></li>

			</ul>

			<button class="signin">
				<a href="">�^�쭺��</a>
			</button>

		</nav>

	</div>

	<jsp:useBean id="movieTagSvc" scope="page"
		class="com.MovieTag.model.MovieTagService" />
	<jsp:useBean id="TagCategorySvc" scope="page"
		class="com.TagCategory.model.TagCategoryService" />

	<div class="main">
		<h1 class="title">�q�v��ƺ޲z</h1>
		<h2 class="title2">�q�v���</h2>

		<table class="table">
			<tr>
				<th>�q�v�s���G<%=movieVO.getMovieId()%></th>
			</tr>
			<tr>
				<th>�q�v�W�١G<%=movieVO.getMovieName()%></th>
			</tr>
			<tr>
				<th>�^��W�١G<%=movieVO.getMovieEName()%></th>
			</tr>
			<tr>
				<th>�W�M����G<%=movieVO.getReleaseDate()%></th>
			</tr>
			<tr>
				<th>�����G<%=movieVO.getMins()%> ����
				</th>
			</tr>
			<tr>
				<th>�o�椽�q�G<%=movieVO.getStudio()%></th>
			</tr>
			<tr>
				<th>�ɺt�G<%=movieVO.getDirector()%></th>
			</tr>
			<tr>
				<th>�D�t�G</th>
			</tr>
			<tr>
				<td><div class="Actor_div"><%=movieVO.getActor()%></div></td>
			</tr>
			<tr>
				<th>�q�v���СG</th>
			</tr>
			<tr>
				<td><div class="Plot_div"><%=movieVO.getPlot()%></div></td>
			</tr>
			<tr>
				<th>�������O�G <br>
				


				
				

				<c:set var="b"
						value="${movieTagSvc.getOneMovieTag(movieVO.movieId).movieId}" />
					<c:forEach var="movieTagVO" items="${movieTagSvc.getAll() }">
						<c:if test="${b == movieTagVO.movieId }">
						
						<c:set var="c" value="${movieTagVO.genreId }" />
						
						
						<c:forEach var="TagCategoryVO" items="${TagCategorySvc.getAll()}">
							<c:if test="${c == TagCategoryVO.genreId }">
									${TagCategoryVO.genreTag }
							
							</c:if>
						</c:forEach>
               		 
               		
                		</c:if>
					</c:forEach>
		</table>

		<div class="pic">
			<img src="/MovieOn/DBGifReaderMovie?movieId= ${movieVO.movieId }"">
		</div>
		
		
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do">
			     <button class="modification" type="submit" >�ק�q�v���</button>
			     
			     <input type="hidden" name="movieId"  value="${movieVO.movieId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
		
		<button class="back">�^��W�@��</button>

	</div>








	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../js/nav.js"></script>
</body>
</html>