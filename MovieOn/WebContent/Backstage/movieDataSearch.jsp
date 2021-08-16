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
	<div id="header">
		<a href="" class="logo"> <img src="img/logo.png" alt="">
		</a>
		<nav>

			<ul>

				<li class="dropdown"><a href="">會員資料管理</a></li>

				<li class="dropdown"><a href="">商城報表</a></li>

				<li class="dropdown"><a href="">電影管理</a>
					<ul>
						<li><a href="#">已上架電影管理</a></li>
						<li><a href="#">上架新電影</a></li>
					</ul></li>

				<li class="dropdown"><a href="">商品管理</a>
					<ul>
						<li><a href="#">已上架商品管理</a></li>
						<li><a href="#">上架新商品</a></li>
					</ul></li>

				<li class="dropdown"><a href="">電影時刻表</a>
					<ul>
						<li><a href="#">已上架電影時刻表管理</a></li>
						<li><a href="#">上架新電影時刻表</a></li>
					</ul></li>

				<li class="dropdown"><a href="">客服回覆</a></li>

				<li class="dropdown"><a href="">訂單管理</a></li>

			</ul>

			<button class="signin">
				<a href="">回到首頁</a>
			</button>

		</nav>

	</div>

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
			</FORM>




		</li>

		<!-- <input id="Search" class="input" autofocus placeholder='關鍵字/標籤搜尋' type='text'>
    <button class="send">送出</button> -->
	</div>








	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../js/nav.js"></script>
</body>
</html>