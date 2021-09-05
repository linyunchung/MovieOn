<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>	



<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/change_password.css"
	type="text/css" rel="stylesheet">
	
<%
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>	
	
</head>
<body>
	<div class="header"><jsp:include page="index.jsp" /></div>
	<div class="body">
		<div class="p">
			<p>更換密碼</p>
			<div class="nav">
				<ul id="menu">
					<li><a
						href="${pageContext.request.contextPath}/member/acct_info.jsp">帳號資訊</a></li>
					<li><a>更換密碼</a></li>
					<li><a
						href="${pageContext.request.contextPath}/member/profile.jsp">個人資料</a></li>
					<li><a
						href="${pageContext.request.contextPath}/member/add_cc.jsp">帳戶設定</a></li>
				</ul>
			</div>
			<form action="<%=request.getContextPath()%>/changePasswordServlet" method="post" id="c_password" >
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
					<input type="hidden" name="userid" id="userid" value="${memberVO.userid}">
				<div class="row">
					<div id="question">
						<label>舊密碼</label>
					</div>
					<div id="answer">
						<input type="password" name="password" id="password" minlength="8"
							maxlength="16">
					</div>
					<div id="remind">
						<span>*必填</span>
					</div>
				</div>
				<div class="row">
					<div id="question">
						<label>新密碼</label>
					</div>
					<div id="answer">
						<input type="password" name="newpassword" id="new_password"
							minlength="8" maxlength="16">
					</div>
					<div id="remind">
						<span>*長度8個字元以上不含空白</span>
					</div>
				</div>
				<div class="row">
					<div id="question">
						<label>確認新密碼</label>
					</div>
					<div id="answer">
						<input type="password" name="newpassword2" id="c_new_password"
							minlength="8" maxlength="16">
					</div>
					<div id="remind">
						<span>*再輸入一次新密碼</span>
					</div>
				</div>
				<div>
					<hr>
					<button type="submit" id="cancel">取消</button>
 					<input type="hidden" name="action" value="changepwd">
<%--  					<input type="hidden" name="password" value="${memberVO.password}"> --%>
					<input type="submit" value="儲存" id="save">
				</div>
			</form>
		</div>
	</div>
</body>
</html>