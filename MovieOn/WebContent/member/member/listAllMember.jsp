<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>

<%
	MemberService memberSvc = new MemberService();
	List<MemberVO> list = memberSvc.getAll();
	pageContext.setAttribute("list", list);
%>


<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
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
	width:1800px;
	left: calc(50% - 900px);
}
</style>
</head>
<body bgcolor='white'>
	<div class="table-center">
		<div class="table-t">
			<table id="table-1">
				<tr>
					<td>
						<h3>�Ҧ��|����� - listAllMember.jsp</h3>
						<h4>
							<a href="<%=request.getContextPath()%>/select_page.jsp">�^����</a>
						</h4>
					</td>
				</tr>
			</table>

			<c:if test="${not empty errorMsgs}">
				<font style="color: red">�Эץ��H�U���~:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
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
				<%@ include file="pages/page1.file"%>
				<c:forEach var="MemberVO" items="${list}" begin="<%=pageIndex%>"
					end="<%=pageIndex+rowsPerPage-1%>">
					<tr>
						<td>${MemberVO.userid}</td>
						<td>${MemberVO.username}</td>
						<td>${MemberVO.email}</td>
						<td>${MemberVO.password}</td>
						<td>${MemberVO.address}</td>
						<td>${MemberVO.mobile}</td>
						<td>${MemberVO.joindate}</td>
						<td>${MemberVO.profilepic}</td>
						<td>${MemberVO.name}</td>
						<td>${MemberVO.gender}</td>
						<td>${MemberVO.birthday}</td>
						<td>${MemberVO.education}</td>
						<td>${MemberVO.occupation}</td>
						<td>${MemberVO.ig}</td>
						<td>${MemberVO.fb}</td>
						<td>${MemberVO.twt}</td>
						<td>${MemberVO.admin}</td>
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/member/member.do"
								style="margin-bottom: 0px;">
								<input type="submit" value="�ק�"> <input type="hidden"
									name="userid" value="${memberVO.userid}"> <input
									type="hidden" name="action" value="getOne_For_Update">
							</FORM>
						</td>
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/member/member.do"
								style="margin-bottom: 0px;">
								<input type="submit" value="�R��"> <input type="hidden"
									name="userid" value="${memberVO.userid}"> <input
									type="hidden" name="action" value="delete">
							</FORM>
						</td>
					</tr>
				</c:forEach>
			</table>
			<%@ include file="pages/page2.file"%>
		</div>
	</div>
</body>
</html>