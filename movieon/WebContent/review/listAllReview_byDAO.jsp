<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.review.model.*"%>

<%--DAO寫法
	ReviewDAO dao = new ReviewDAO();
	List<ReviewVO> list = dao.getAll();
	pageContext.setAttribute("list", list);
--%>
 
<% 
	/*Service寫法*/
 	ReviewService revSvc = new ReviewService();
	List<ReviewVO> list = revSvc.getAll();
	pageContext.setAttribute("list", list);
	/*限制影評的文字數量*/
%>

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
<title>所有影評資料</title>
</head>
<body>
	<table>
		<tr>
			<th>影評編號</th>
			<th>會員編號</th>
			<th>電影編號</th>
			<th>標題</th>
			<th>評分</th>
			<th>影評</th>
			<th>文章日期</th>
			<th>編輯</th>
			<th>刪除</th>
		</tr>
		 <%@ include file="page1.file"  %>
<%-- 		<c:forEach var="reviewVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>
		<c:forEach var="reviewVO" items="${list}">
		
			<tr>
				<td>${reviewVO.reviewId}</td>
				<td>${reviewVO.userId}</td>
				<td>${reviewVO.movieId}</td>
				<td>${reviewVO.reviewTitle}</td>
				<td>${reviewVO.starRate}</td>
				<td>${reviewVO.review}</td>
				<td>${reviewVO.postedAt}</td>
				
				<!-- 編輯跟刪除的按鈕, 編輯要返回寫影評的page -->
				<!-- 但是不適用於我們專題的商業邏輯, 會變成每個訪客都可刪除跟修改其他訪客的影評 -->
				<td>
			  		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/review/ReviewServlet" style="margin-bottom: 0px;">
			     		<input type="submit" value="編輯">
			     		<input type="hidden" name="reviewId"  value="${reviewVO.reviewId}">
			     		<input type="hidden" name="action"	value="getOne_For_Update">
			     	</FORM> <!-- 會進到if(action == getOne_For_Update) -->
				</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/review/ReviewServlet" style="margin-bottom: 0px;">
<!-- 			  <FORM METHOD="post" ACTION="ReviewServlet" style="margin-bottom: 0px;"> -->
			     <input type="submit" value="刪除">
			     <input type="hidden" name="reviewId"  value="${reviewVO.reviewId}">
			     <input type="hidden" name="action" value="delete"></FORM>	<!-- 會進到if(action == delete) -->
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>