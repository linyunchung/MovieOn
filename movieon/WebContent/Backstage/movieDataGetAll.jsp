<%@page import="java.util.stream.Collectors"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    MovieService movieSvc = new MovieService();
    List<MovieVO> list = movieSvc.getAll();
//     list = list.stream().filter(m -> m.getMovieTag().equals(movieTag)).collect(Collectors.toList());
    pageContext.setAttribute("list",list);
%>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>後台管理員</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/movieDataGetAll.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap" rel="stylesheet">
	
</head>

<%@ include file="header.file"%>

<table>
	
	
<!-- 			<div class="tag_div"> -->
<!-- 					<tr> -->
<%-- 						<th class="th">標籤類別： ${movieVO.movieTag} --%>
<!-- 							<input type="radio" id="tag1" name="movieTag" class="tag" value="動作片"  checked> -->
<!-- 								<label for="tag1">動作片</label>  -->
								
<!-- 							<input type="radio" id="tag2" name="movieTag" class="tag" value="喜劇片"> -->
<!-- 								<label for="tag2">喜劇片</label>  -->
								
<!-- 							<input type="radio" id="tag3" name="movieTag" class="tag" value="愛情片"> -->
<!-- 								<label for="tag3">愛情片</label> -->
								
<!-- 							<input type="radio" id="tag4" name="movieTag" class="tag" value="科幻片"> -->
<!-- 								<label for="tag4">科幻片</label>  -->
								
<!-- 							<input type="radio" id="tag5" name="movieTag" class="tag" value="恐怖片"> -->
<!-- 								<label for="tag5">恐怖片</label>  -->
								
<!-- 							<input type="radio" id="tag6" name="movieTag" class="tag" value="劇情片"> -->
<!-- 								<label for="tag6">劇情片</label> -->
								
<!-- 							<input type="radio" id="tag7" name="movieTag" class="tag" value="戰爭片"> -->
<!-- 								<label for="tag7">戰爭片</label>  -->
								
<!-- 							<input type="radio" id="tag8" name="movieTag" class="tag" value="動畫片"> -->
<!-- 								<label for="tag8">動畫片</label>  -->
								
<!-- 							<input type="radio" id="tag9" name="movieTag" class="tag" value="歷史片"> -->
<!-- 								<label for="tag9">歷史片</label> -->
<!-- 						</th> -->

<!-- 					</tr> -->
<!-- 				</div>	 -->
			<c:forEach var="movieVO"  items="${list}" >
				
					<div class="flip1">
						
					        <div class="flip"><img class="img" src="<%=request.getContextPath()%>/DBGifReaderMovie?movieId= ${movieVO.movieId }"></div>
					        <div class="panel">電影編號：${movieVO.movieId }<br>
					        								${movieVO.movieName }<br>
					        								<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do">
																 
																<input type="hidden" name="movieId" value="${movieVO.movieId }">
																<input type="hidden" name="action" value="getOne_For_Display">
																<button class="send" type="submit">查看詳細資料</button>
															</FORM>
					        </div>
				        
			   		 </div>
		   		 
	  		 </c:forEach>
	  		 <button class="back" onclick="window.location.href='movieDataSearch.jsp'">回到上一頁</button>
			<div><br><br><hr type="hidden"></div>
	
</table>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script src="./js/index.js"></script>


</body>
</html>