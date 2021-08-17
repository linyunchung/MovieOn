<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>��x�޲z��</title>
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

	<div class="main">


		<h1 class="title">�q�v�޲z</h1>
		<h4 class="title2">�w�W�[�q�v�޲z</h4>

		<div class="error">
				<%-- ���~��C --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: #ACA9A9">�d�ߥ���:
				<c:forEach var="message" items="${errorMsgs}">
				<pstyle="color: #ACA9A9">${message}</p>	</c:forEach>
				</font>
			</c:if>
		</div>

		<li class="li1">
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do">
				<input id="Search" class="input" autofocus placeholder='�q�v�s���j�M'  type='text' name="movieId"> 
				<input type="hidden" name="action" value="getOne_For_Display">
				<button class="send" type="submit">�e�X</button>
			</FORM>




		</li>

		<!-- <input id="Search" class="input" autofocus placeholder='����r/���ҷj�M' type='text'>
    <button class="send">�e�X</button> -->
	</div>








	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../js/nav.js"></script>
</body>
</html>