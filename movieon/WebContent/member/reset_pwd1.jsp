<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>		
	
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/reset_pwd1.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<div class="header"><jsp:include page="index.jsp" /></div>
	<div class="body">
		<div class="p">
			<p>重置密碼</p>

			<form method="post" id="c_password" action="<%=request.getContextPath()%>/ResetPwdServlet">
				<div class="ch_pwd">
					<div class="box"></div>
					<hr id="u_hr">
				</div>
				<div class="row">
					<c:if test="${not empty errorMsgs}">
						<font style="color: red">請修正以下錯誤:</font>
						<ul>
							<c:forEach var="message" items="${errorMsgs}">
								<li id="error" style="color: red">${message}</li>
							</c:forEach>
						</ul>
					</c:if>
				</div>
				<div class="row">
					<div id="question">
						<label>電子郵件</label>
					</div>
					<div id="answer">
						<input type="text" name="email" id="email">
					</div>
					<div id="remind">
						<span>*填寫當時申請時所用的電子郵件</span>
					</div>
				</div>
				<div>
					<hr>
					<input type="hidden" name="action" value="reset">
					<input type="submit" value="確認" id="check">
				</div>
			</form>
		</div>
	</div>
</body>
</html>