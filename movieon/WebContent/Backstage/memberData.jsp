<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>

<%
	MemberService memberSvc = new MemberService();
	List<MemberVO> list = memberSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>��x�޲z��</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/Backstage/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/Backstage/css/memberData.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">
</head>
<body>
	 <%@ include file="header.file"%>


	<div class="main">
		<h1 class="title">�|����ƺ޲z</h1>
		<h2 class="title2">�|�����</h2>

		<table class="table">
			<tr>
				<th>�|���s���G${memberVO.userid}</th>
			</tr>
			<tr>
				<th>�|���W�١G${memberVO.username}</th>
			</tr>
			<tr>
				<th>�q�l�l��G${memberVO.email}</th>
			</tr>
			<tr>
				<th>�K�X�G${memberVO.password}</th>
			</tr>
			<tr>
				<th>�a�}�G${memberVO.address}</th>
			</tr>
			<tr>
				<th>�`�U����G${memberVO.joindate}</th>
			</tr>
			<tr>
				<th>�m�W�G${memberVO.name}</th>
			</tr>
			<tr>
				<th>�ʧO�G${memberVO.gender}</th>
			</tr>
			<tr>
				<th>�ͤ�G${memberVO.birthday}</th>
			</tr>
			<tr>
				<th>�Ш|�{�סG${memberVO.education}</th>
			</tr>
			<tr>
				<th>¾�~�G${memberVO.occupation}</th>
			</tr>
			<tr>
				<th>Instagram�G${memberVO.ig}</th>
			</tr>
			<tr>
				<th>Facebook�G${memberVO.fb}</th>
			</tr>
			<tr>
				<th>Twitter�G${memberVO.twt}</th>
			</tr>
				
<%--   				<c:set var="b"  value="${movieTagSvc.getOneMovieTag(movieVO.movieId).movieId}" />   --%>
<%--   				<c:forEach var="movieTagVO" items="${movieTagSvc.getAll() }">   --%>
<%--   					<c:if test="${b == movieTagVO.movieId }">   --%>
<%--   						<c:set var="c" value="${movieTagVO.genreId }" />   --%>
<%--   						<c:forEach var="TagCategoryVO" items="${TagCategorySvc.getAll()}">   --%>
<%--   							<c:if test="${c == TagCategoryVO.genreId }">   --%>
<%--   								${TagCategoryVO.genreTag }   --%>
<%--   							</c:if>   --%>
<%--   						</c:forEach>   --%>
<%--                   	</c:if>   --%>
<%--   				</c:forEach>  </th> --%>
		</table>

		<div class="pic">
			<img src="<%=request.getContextPath()%>/DBGifReader?userid=${memberVO.userid}">
		</div>
		
		
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/member/member.do"
				style="margin-bottom: 0px;">
				<button type="submit" value="�R��" class="deletemember">�R��</button>
				<input type="hidden" name="userid" value="${memberVO.userid}"> 
				<input type="hidden" name="action" value="delete">
			</FORM>
		
		<button class="back" onclick="window.location.href='<%=request.getContextPath()%>/Backstage/memberDataSearch.jsp'">�^��W�@��</button>

	</div>








	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../js/nav.js"></script>
</body>
</html>