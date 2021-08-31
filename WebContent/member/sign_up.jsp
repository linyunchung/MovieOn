<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>

<%
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/sign_up.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="header"><jsp:include page="index.jsp" /></div>
	<div class="p">
		<p>�|���`�U</p>
		<div class="register">
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/member/member.do" name="form1">
				<div class="formRow">
                    <div class="formRow2">
                        <c:if test="${not empty errorMsgs}">
                            <font style="color: red">�Эץ��H�U���~:</font>
                            <ul>
                                <c:forEach var="message" items="${errorMsgs}">
                                    <li class="error" style="color: red">${message}</li>
                                </c:forEach>
                            </ul>
                        </c:if>
					</div>
					<div class="formRow2">
						<label class="name">�|���W��</label> <input name="username" value="${memberVO.name}"
							type="text" id="rg">
					</div>
					<div class="formRow2">
						<label class="email">�q�l�l��</label> <input name="email" type="text"
							id="rg">
					</div>
					<div class="formRow2">
						<label class="password">�n�J�K�X</label> <input name="password"
							type="password" id="rg" minlength="8" maxlength="16">
					</div>
					<div class="formRow2">
						<label class="password">�T�{�K�X</label> <input name="password2"
							type="password" id="rg" minlength="8" maxlength="16">
					</div>
				</div>
				<div class="formRow">
					<hr class="c_hr">
				</div>
				<div class="formRow">
					<input type="hidden" name="action" value="insert"> <input
						type="submit" value="�T�{" class="btn">
				</div>
			</FORM>
		</div>
	</div>
</body>
</html>