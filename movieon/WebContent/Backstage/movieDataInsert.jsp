<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.movie.model.*"%>

<%
	MovieVO movieVO = (MovieVO) request.getAttribute("empVO");
%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>後台管理員</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/movieDataInsert.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">

</head>

<%@ include file="header.file"%>


	<jsp:useBean id="movieTagSvc" scope="page"
		class="com.MovieTag.model.MovieTagService" />
	<jsp:useBean id="TagCategorySvc" scope="page"
		class="com.TagCategory.model.TagCategoryService" />


	<div class="main">
		<h1 class="title">電影資料管理</h1>
		<h2 class="title2">新增電影資料</h2>
		
		


	<li class="li1">
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do" enctype="multipart/form-data">
		<table class="table">

			<tr>
				<th>電影名稱：<input class="text" type="TEXT" name="movieName"
					size="45" value="<%= (movieVO==null)? "" : movieVO.getMovieName()%>"  
					autofocus placeholder='請輸入電影名稱' /></th>
			</tr>
			<tr>
				<th>英文名稱：<input class="text" type="TEXT" name="movieEName"
					size="45"  value="<%= (movieVO==null)? "" : movieVO.getMovieEName()%>"  
					autofocus placeholder='請輸入英文名稱' /></th>
			</tr>
			<tr>
				<th>上映日期：<input class="text"  id="f_date1"  type="TEXT" name="releaseDate"
					size="45"  style="color:grey" value="<%= (movieVO==null)? "選擇入上映日期" : movieVO.getMovieEName()%>"/></th>
			</tr>
			<tr>
				<th>片長：<input class="text" type="TEXT" name="mins" size="45"
					style="left: 31px;" value="<%= (movieVO==null)? "" : movieVO.getMins()%>"  
					autofocus placeholder='請輸入片長' /></th>
			</tr>
			<tr>
				<th>發行公司：<input class="text" type="TEXT" name="studio"
					size="45"  value="<%= (movieVO==null)? "" : movieVO.getStudio()%>"  
					autofocus placeholder='請輸入片長' /></th>
			</tr>
			<tr>
				<th>導演：</th>
				<br>

			</tr>
			<tr>
				<td><textarea name="director" class="director_text" cols="30"
						rows="10" autofocus placeholder='請輸入導演' ><%= (movieVO==null)? "" : movieVO.getDirector()%></textarea></td>
			</tr>
			<tr>
				<th>主演：</th>
				<br>

			</tr>
			<tr>
				<td><textarea name="actor" class="actor_text" cols="30"
						rows="10" autofocus placeholder='請輸入主演' ><%= (movieVO==null)? "" : movieVO.getActor()%></textarea></td>
			</tr>
			<tr>
				<th>電影介紹：</th>
				<br>
			</tr>
			<tr>
				<td><textarea name="plot" class="plot_text" cols="30" rows="10" 
						autofocus placeholder='請輸入電影介紹' ><%= (movieVO==null)? "" : movieVO.getPlot()%></textarea>
				</td>
			</tr>
			<tr>
				<th>標籤類別：<br> 
					<input type="radio" id="tag1" name="movieTag" class="tag" value="動作片"><label for="tag1">動作片</label> 
					<input type="radio" id="tag2" name="movieTag" class="tag" value="喜劇片"><label for="tag2">喜劇片</label> 
					<input type="radio" id="tag3" name="movieTag" class="tag" value="愛情片"><label for="tag3">愛情片</label><br>
					<input type="radio" id="tag4" name="movieTag" class="tag" value="科幻片"><label for="tag4">科幻片</label> 
					<input type="radio" id="tag5" name="movieTag" class="tag" value="恐怖片"><label for="tag5">恐怖片</label> 
					<input type="radio" id="tag6" name="movieTag" class="tag" value="劇情片"><label for="tag6">劇情片</label><br>
					<input type="radio" id="tag7" name="movieTag" class="tag" value="戰爭片"><label for="tag7">戰爭片</label> 
					<input type="radio" id="tag8" name="movieTag" class="tag" value="動畫片"><label for="tag8">動畫片</label> 
					<input type="radio" id="tag9" name="movieTag" class="tag" value="歷史片"><label for="tag9">歷史片</label>
				</th>

			</tr>


		</table>

		<div class="pic"  id="preview">
			<p>上傳電影海報</p>
		</div>
		<label class="buttem"  > 選擇檔案
			<input type="file" id="p_file"name="poster" size="50" />
		</label>



			<input type="hidden" name="action" value="insert"> 
			<button class="confirm" type="submit">確定新增</button>
			
			<div class="error">
				<%-- 錯誤表列 --%>
				<c:if test="${not empty errorMsgs}">
					<font style="color: #ACA9A9">新增資料失敗:
						<c:forEach var="message" items="${errorMsgs}">
						<pstyle="color: #ACA9A9">${message}</p>	</c:forEach>
					</font>
				</c:if>
			</div>
			
			

		</FORM>
			
			
		</li>

	</div>








	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../js/nav.js"></script>
</body>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
	var preview_el = document.getElementById("preview");
	var p_file_el = document.getElementById("p_file");
	var preview_img = function(file) {
		var img_node = document.createElement("img");
		var reader = new FileReader(); // 用來讀取檔案
		reader.addEventListener("load", function() {
			//console.log(reader.result);
			let img_node = document.createElement("img");
			img_node.setAttribute("src", reader.result); // <img src="abdafaewre">
			img_node.setAttribute("class", "preview_img"); // <img src="abdafaewre" class="preview_img">
			preview_el.innerHTML = '';
			preview_el.append(img_node);
		});
		reader.readAsDataURL(file); // 讀取檔案
	};

	p_file_el.addEventListener("change", function(e) {
		if (this.files.length > 0) {
			preview_img(this.files[0]);
		} else {
			preview_el.innerHTML = '<span class="text">預覽圖</span>';
		}
	});

	$.datetimepicker.setLocale('zh');
	$('#f_date1').datetimepicker({
		theme : '', //theme: 'dark',
		timepicker : false, //timepicker:true,
		step : 1, //step: 60 (這是timepicker的預設間隔60分鐘)
		format : 'Y-m-d', //format:'Y-m-d H:i:s',
		value : '${movieVO.releaseDate }', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	//      1.以下為某一天之前的日期無法選擇
	//      var somedate1 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      2.以下為某一天之後的日期無法選擇
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
	//      var somedate1 = new Date('2017-06-15');
	//      var somedate2 = new Date('2017-06-25');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//		             ||
	//		            date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});
</script>

</html>