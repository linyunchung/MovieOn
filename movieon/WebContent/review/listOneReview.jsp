<%@page import="com.review.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    
<% ReviewVO reviewVO = (ReviewVO)request.getAttribute("reviewVO");%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<style>
  table {
	width: 1000px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>
<title>��@�v�����</title>
</head>
<body>
	<table>
		<tr>
			<th>�v���s��</th>
			<th>�|���s��</th>
			<th>�q�v�s��</th>
			<th>���D</th>
			<th>����</th>
			<th>�v��</th>
			<th>�峹���</th>
		</tr>
		<tr>
			<td><%=reviewVO.getReviewId()%></td>
			<td><%=reviewVO.getUserId() %></td>
			<td><%=reviewVO.getMovieId() %></td>
			<td><%=reviewVO.getReviewTitle() %></td>
			<td><%=reviewVO.getStarRate() %></td>
			<td><%=reviewVO.getReview() %></td>
			<td><%=reviewVO.getPostedAt() %></td>
		</tr>
	</table>
</body>
</html>