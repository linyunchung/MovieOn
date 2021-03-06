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
						<h3>所有會員資料 - listAllMember.jsp</h3>
						<h4>
							<a href="<%=request.getContextPath()%>/member/select_page.jsp">回首頁</a>
						</h4>
					</td>
				</tr>
			</table>

			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			<table>
				<tr>
					<th>會員ID</th>
					<th>會員名稱</th>
					<th>電子郵件</th>
					<th>密碼</th>
					<th>地址</th>
					<th>電話</th>
					<th>註冊日期</th>
					<th>大頭貼</th>
					<th>姓名</th>
					<th>性別</th>
					<th>生日</th>
					<th>教育程度</th>
					<th>職業</th>
					<th>Instagram</th>
					<th>Facebook</th>
					<th>Twitter</th>
					<th>admin</th>
				</tr>
				<%@ include file="pages/page1.file"%>
				<c:forEach var="memberVO" items="${list}" begin="<%=pageIndex%>"
					end="<%=pageIndex+rowsPerPage-1%>">
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
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/member/member.do"
								style="margin-bottom: 0px;">
								<input type="submit" value="修改"> <input type="hidden"
									name="userid" value="${memberVO.userid}"> <input
									type="hidden" name="action" value="getOne_For_Update">
							</FORM>
						</td>
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/member/member.do"
								style="margin-bottom: 0px;">
								<input type="submit" value="刪除"> <input type="hidden" name="userid" value="${memberVO.userid}"> 
								<input type="hidden" name="action" value="delete">
							</FORM>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="page">
				<%@ include file="pages/page2.file"%>
			</div>
		</div>
	</div>
</body>
</html>