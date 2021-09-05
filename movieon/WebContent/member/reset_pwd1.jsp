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
			<p>���m�K�X</p>

			<form method="post" id="c_password" action="<%=request.getContextPath()%>/ResetPwdServlet">
				<div class="ch_pwd">
					<div class="box"></div>
					<hr id="u_hr">
				</div>
				<div class="row">
					<c:if test="${not empty errorMsgs}">
						<font style="color: red">�Эץ��H�U���~:</font>
						<ul>
							<c:forEach var="message" items="${errorMsgs}">
								<li id="error" style="color: red">${message}</li>
							</c:forEach>
						</ul>
					</c:if>
				</div>
				<div class="row">
					<div id="question">
						<label>�q�l�l��</label>
					</div>
					<div id="answer">
						<input type="text" name="email" id="email">
					</div>
					<div id="remind">
						<span>*��g��ɥӽЮɩҥΪ��q�l�l��</span>
					</div>
				</div>
				<div>
					<hr>
					<input type="hidden" name="action" value="reset">
					<input type="submit" value="�T�{" id="check">
				</div>
			</form>
		</div>
	</div>
</body>
</html>