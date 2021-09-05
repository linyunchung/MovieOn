<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>後台管理員</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/movieDataSearch.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">
<body>
	<%@ include file="header.file"%>

	<div class="main">


		<h1 class="title">電影管理</h1>
		<h4 class="title2">已上架電影管理</h4>

		<div class="error">
				<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: #ACA9A9">查詢失敗:
				<c:forEach var="message" items="${errorMsgs}">
				<pstyle="color: #ACA9A9">${message}</p>	</c:forEach>
				</font>
			</c:if>
		</div>

		<li class="li1">
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do">
				<input id="Search" class="input" autofocus placeholder='電影編號搜尋'  type='text' name="movieId"> 
				<input type="hidden" name="action" value="getOne_For_Display">
				<button class="send" type="submit">送出</button>
			</FORM><br>
			
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do">
				<input id="Search" class="input" autofocus placeholder='電影名稱關鍵字搜尋'  type='text' name="movieName"> 
				<input type="hidden" name="action" value="getAll_By_Name">
				<button class="send" type="submit">送出</button>
			</FORM><br>
			
			
				<span>查詢所有電影資訊</span>
				<button class="send1" onclick="window.location.href='movieDataGetAll.jsp'">查詢</button>
			
			
		</li>

	
	</div>








	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../js/nav.js"></script>
</body>
</html>