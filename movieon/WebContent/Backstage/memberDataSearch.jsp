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
<link rel="stylesheet" href="css/memberSearch.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">
<body>
	<%@ include file="header.file"%>

	<div class="main">

		<h1 class="title">�|����Ƭd��</h1>

		<div class="error">
			<%-- ���~��C --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: #ACA9A9">�d�ߥ���: <c:forEach var="message"
						items="${errorMsgs}">
						<pstyle="color:#ACA9A9">${message}</p>
					</c:forEach>
				</font>
			</c:if>
		</div>

		<li class="li1">
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/member/member.do">
				<b>��J�|��ID(�p3):</b> 
				<input type="text" name="userid" id="inputtext">
				<input type="hidden" name="action" value="getOne_For_Display"> 
				<button type="submit" value="�e�X" class="send">�e�X</button>
			</FORM>

			 <br> 
			 
			 <span>�d�ߩҦ��|����T</span>
			<button class="send1"
				onclick="window.location.href='memberDataGetAll.jsp'">�d��</button>


		</li>


	</div>








	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../js/nav.js"></script>
</body>
</html>