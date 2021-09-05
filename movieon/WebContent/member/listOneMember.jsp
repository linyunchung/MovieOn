<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>


<%
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>



<html>
<head>
<meta charset="BIG5">
<title>�|����� - listOneMember.jsp</title>
<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
	width: 1800px;
}

th, td {
	padding: 5px;
	text-align: center;
	width: auto;
}

.table-center {
	width: 100vw;
}

.table-t {
	position: relative;
	width: 1800px;
	left: calc(50% - 900px);
}

.page {
	text-align: center;
}
</style>
</head>
<body bgcolor='white'>
	<div class="table-center">
		<div class="table-t">
			<table id="table-1">
				<tr>
					<td>
						<h3>�|����� - listOneMember.jsp</h3>
						<h4>
							<a href="<%=request.getContextPath()%>/member/select_page.jsp">�^����</a>
						</h4>
					</td>
				</tr>
			</table>

			<table>
				<tr>
					<th>�|��ID</th>
					<th>�|���W��</th>
					<th>�q�l�l��</th>
					<th>�K�X</th>
					<th>�a�}</th>
					<th>�q��</th>
					<th>���U���</th>
					<th>�j�Y�K</th>
					<th>�m�W</th>
					<th>�ʧO</th>
					<th>�ͤ�</th>
					<th>�Ш|�{��</th>
					<th>¾�~</th>
					<th>Instagram</th>
					<th>Facebook</th>
					<th>Twitter</th>
					<th>admin</th>
				</tr>
				<tr>
					<td>${memberVO.userid}</td>
					<td>${memberVO.username}</td>
					<td>${memberVO.email}</td>
					<td>${memberVO.password}</td>
					<td>${memberVO.address}</td>
					<td>${memberVO.mobile}</td>
					<td>${memberVO.joindate}</td>
					<td><img src="../DBGifReader?userid=${memberVO.userid}"></td>
					<td>${memberVO.name}</td>
					<td>${memberVO.gender}</td>
					<td>${memberVO.birthday}</td>
					<td>${memberVO.education}</td>
					<td>${memberVO.occupation}</td>
					<td>${memberVO.ig}</td>
					<td>${memberVO.fb}</td>
					<td>${memberVO.twt}</td>
					<td>${memberVO.admin}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>