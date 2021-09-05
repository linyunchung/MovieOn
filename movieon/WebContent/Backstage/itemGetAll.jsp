<%@page import="java.util.stream.Collectors"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.item.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    itemService itemSvc = new itemService();
    List<itemVO> list = itemSvc.getAll();
//     list = list.stream().filter(m -> m.getItemId().equals(3016)).collect(Collectors.toList());
    pageContext.setAttribute("list",list);
%>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>後台管理員</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/itemGetAll.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap" rel="stylesheet">
	
</head>

 <%@ include file="header.file"%>

<table>
	
			<c:forEach var="itemVO"  items="${list}" >
				
					
					       
					<div id="cover" class="coverflow">
        
					        <a href='#'><img class="img"  src="<%=request.getContextPath()%>/shop/ItemPic1?itemId=${itemVO.itemId}"></a>
					        <a href='#'><img class="img"  src="<%=request.getContextPath()%>/shop/ItemPic2?itemId=${itemVO.itemId}"></a>
					        <a href='#'><img class="img"  src="<%=request.getContextPath()%>/shop/ItemPic3?itemId=${itemVO.itemId}"></a>
					        <a href='#'><img class="img"  src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}" ></a>
					       
					        <div class="panel">商品編號：${itemVO.itemId }<br>
					        								${itemVO.itemName }<br>
					        								<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/item.do">
																 
																<input type="hidden" name="itemId" value="${itemVO.itemId }">
																<input type="hidden" name="action" value="getOne_For_Display">
																<button class="send" type="submit">查看詳細資料</button>
															</FORM>
					        </div>
				        
			   		 </div>
		   		 
	  		 </c:forEach>
	  		 <button class="back" onclick="window.location.href='itemSearch.jsp'">回到上一頁</button>
			<div><br><br><hr type="hidden"></div>
	
</table>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script src="./js/index.js"></script>


</body>
</html>