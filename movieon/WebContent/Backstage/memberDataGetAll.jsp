<%@page import="java.util.stream.Collectors"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
	MemberService memberSvc = new MemberService();
	List<MemberVO> list = memberSvc.getAll();
	pageContext.setAttribute("list", list);
%>


<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>��x�޲z��</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/Backstage/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/Backstage/css/memberDataGetAll.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">

</head>

<%@ include file="header.file"%>

<div class="table-center">
<table>
<!-- 	<div class="flip1"> -->

		<tr>
			<th>�|��ID</th>
			<th>�|���W��</th>
			<th>�q�l�l��</th>
			<th>�`�U���</th>
			<th>�m�W</th>
		</tr>
		<%@ include file="pages/page1.file"%>
		<c:forEach var="memberVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<tr>
				<td>${memberVO.userid}</td>
				<td>${memberVO.username}</td>
				<td>${memberVO.email}</td>
				<td>${memberVO.joindate}</td>
				<td>${memberVO.name}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/member/member.do">
	
						<input type="hidden" name="userid" value="${memberVO.userid}">
						<input type="hidden" name="action" value="getOne_For_Display">
						<button class="send" type="submit">�d�ݸԲӸ��</button>
					</FORM>			
				</td>
			</tr>
<!-- 	</div> -->

	</c:forEach>
<!-- 	<div>
		<br>
		<br>
		<hr type="hidden">
	</div> -->

</table>
			<div class="page">
				<%@ include file="pages/page2.file"%>
	<button class="back"
		onclick="window.location.href='memberDataSearch.jsp'">�^��W�@��</button>
			</div>
</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/index.js"></script>


</body>
</html>