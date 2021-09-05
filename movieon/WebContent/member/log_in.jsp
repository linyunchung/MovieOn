<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>log_in</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/log_in.css">
</head>
<body>
	<div class="header"><jsp:include page="/member/index.jsp" /></div>
	<div class="p">
		<p>�|���n�J</p>
		<div class="login">
			<FORM class="login-form" method="post"
				action="<%=request.getContextPath()%>/LoginServlet">
				<div class="formRow">
					<c:if test="${not empty errorMsgs}">
						<font style="color: red">�Эץ��H�U���~:</font>
						<ul>
							<c:forEach var="message" items="${errorMsgs}">
								<li id="error" style="color: red">${message}</li>
							</c:forEach>
						</ul>
					</c:if>
				</div>
				<div class="formRow">
					<label class="formep">�q�l�l��</label> <input type="text" name="email"
						placeholder="Email">
				</div>
				<div class="formRow">
					<label class="formep">�n�J�K�X</label> <input type="password"
						name="password" placeholder="Password" minlength="8"
						maxlength="16">
				</div>
				<div class="formRow">
					<a href="${pageContext.request.contextPath}/member/sign_up.jsp"
						id="new">���U�s�b��</a> <a
						href="${pageContext.request.contextPath}/member/reset_pwd1.jsp"
						id="forget">�ѰO�K�X?</a>
				</div>
				<div class="formRow">
					<hr class="c_hr">
				</div>
				<div class="formRow">
					<input type="hidden" name="action" value="getOne">
					<input type="submit" id="btn" value="�n�J   ">
				</div>

			</FORM>
		</div>
	</div>
</body>
</html>