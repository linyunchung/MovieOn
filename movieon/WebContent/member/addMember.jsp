<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>

<% 
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>�|����Ʒs�W</title>
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
<body bgcolor="white">
<div class="table-center">
		<div class="table-t">
			<table id="table-1">
				<tr>
					<td>
						<h3>�|����Ʒs�W - addMember.jsp</h3>
						<h4>
							<a href="<%=request.getContextPath()%>/member/select_page.jsp">�^����</a>
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
			
			<FORM METHOD="post" ACTION="member.do" name="form1">
			<table>
			<tr>
				<td>�|���W��:</td>
				<td><input type="TEXT" name="username" size="45" 
					value="<%= (memberVO==null)? "sony" : memberVO.getUsername()%>" /></td>
			</tr>
			<tr>
				<td>�q�l�l��:</td>
				<td><input type="TEXT" name="email" size="45" ${memberVO.email} /></td>
			</tr>
			<tr>
				<td>�K�X:</td>
				<td><input type="TEXT" name="password" size="45" value="${memberVO.password}" /></td>
			</tr>
			<tr>
				<td>�a�}:</td>
				<td><input type="TEXT" name="address" size="45" value="${memberVO.address}" /></td>
			</tr>
			<tr>
				<td>�q��:</td>
				<td><input type="TEXT" name="mobile" size="45" value="${memberVO.mobile}" /></td>
			</tr>
			<tr>
				<td>���U���:</td>
				<td><input type="TEXT" name="joindate" size="45" ${memberVO.joindate} /></td>
			</tr>
			<tr>
				<td>�j�Y�K:</td>
				<td><img src="../DBGifReader?userid=${memberVO.userid}"></td>
			</tr>
			<tr>
				<td>�m�W:</td>
				<td><input type="TEXT" name="name" size="45" value="${memberVO.name}" /></td>
			</tr>
			<tr>
				<td>�ʧO:</td>
				<td><input type="TEXT" name="gender" size="45" value="${memberVO.gender}" /></td>
			</tr>
			<tr>
				<td>�ͤ�:</td>
				<td><input type="TEXT" name="birthday" size="45" value="${memberVO.birthday}" /></td>
			</tr>
			<tr>
				<td>�Ш|�{��:</td>
				<td><input type="TEXT" name="education" size="45" value="${memberVO.education}" /></td>
			</tr>
			<tr>
				<td>¾�~:</td>
				<td><input type="TEXT" name="occupation" size="45" value="${memberVO.occupation}" /></td>
			</tr>
			<tr>
				<td>Instagram:</td>
				<td><input type="TEXT" name="ig" size="45" value="${memberVO.ig}" /></td>
			</tr>
			<tr>
				<td>Facebook:</td>
				<td><input type="TEXT" name="fb" size="45" value="${memberVO.fb}" /></td>
			</tr>
			<tr>
				<td>Twitter:</td>
				<td><input type="TEXT" name="twt" size="45" value="${memberVO.twt}" /></td>
			</tr>
			<tr>
				<td>admin:</td>
				<td><input type="TEXT" name="admin" size="45" ${memberVO.admin} /></td>
			</tr>

			</table>
			<br>
			<input type="hidden" name="action" value="update">
			<input type="submit" value="�e�X�s�W">
			</FORM>

		</div>
	</div>
</body>

</html>