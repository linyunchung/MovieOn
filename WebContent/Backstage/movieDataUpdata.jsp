<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="com.MovieTag.model.*"%>

<%
	MovieVO movieVO = (MovieVO) request.getAttribute("movieVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>
<%
	MovieTagVO movieTagVO = (MovieTagVO) request.getAttribute("movieTagVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>後台管理員</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/movieDataUpdata.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">

</head>

<body>
	<div id="header">
		<a href="" class="logo"> <img src="img/logo.png" alt="">
		</a>
		<nav>

			<ul>

				<li class="dropdown"><a href="">會員資料管理</a></li>

				<li class="dropdown"><a href="">商城報表</a></li>

				<li class="dropdown"><a href="">電影管理</a>
					<ul>
						<li><a href="#">已上架電影管理</a></li>
						<li><a href="#">上架新電影</a></li>
					</ul></li>

				<li class="dropdown"><a href="">商品管理</a>
					<ul>
						<li><a href="#">已上架商品管理</a></li>
						<li><a href="#">上架新商品</a></li>
					</ul></li>

				<li class="dropdown"><a href="">電影時刻表</a>
					<ul>
						<li><a href="#">已上架電影時刻表管理</a></li>
						<li><a href="#">上架新電影時刻表</a></li>
					</ul></li>

				<li class="dropdown"><a href="">客服回覆</a></li>

				<li class="dropdown"><a href="">訂單管理</a></li>

			</ul>

			<button class="signin">
				<a href="">回到首頁</a>
			</button>

		</nav>

	</div>
	<jsp:useBean id="movieTagSvc" scope="page"
		class="com.MovieTag.model.MovieTagService" />
	<jsp:useBean id="TagCategorySvc" scope="page"
		class="com.TagCategory.model.TagCategoryService" />

	<div class="main">
		<h1 class="title">電影資料管理</h1>
		<h2 class="title2">電影資料修改</h2>

		<li class="li1">
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do" enctype="multipart/form-data">
				<table class="table">
					<tr>
						<th>電影編號：${movieVO.movieId }</th>

					</tr>
					<tr>
						<th>電影名稱：<input class="text" type="TEXT" name="movieName"
							size="45" value="${movieVO.movieName } " /></th>
					</tr>
					<tr>
						<th>英文名稱：<input class="text" type="TEXT" name="movieEName"
							size="45" value="${movieVO.movieEName }" /></th>
					</tr>
					<tr>
						<th>上映日期：<input id="f_date1" class="text" type="TEXT"
							name="releaseDate" size="45" value="${movieVO.releaseDate }" /></th>
					</tr>
					<tr>
						<th>片長：<input class="text" type="TEXT" name="mins" size="45"
							style="left: 31px;" value="${movieVO.mins }" /></th>
					</tr>
					<tr>
						<th>發行公司：<input class="text" type="TEXT" name="studio"
							size="45" value="${movieVO.studio}" /></th>
					</tr>
					<tr>
						<th>導演：</th>
						<br>

					</tr>
					<tr>
						<td><textarea name="director" class="director_text" cols="30"
								rows="10">${movieVO.director} </textarea></td>
					</tr>
					<tr>
						<th>主演：</th>
						<br>

					</tr>
					<tr>
						<td><textarea name="actor" class="actor_text" cols="30"
								rows="10">${movieVO.actor}</textarea></td>
					</tr>
					<tr>
						<th>電影介紹：</th>
						<br>
					</tr>
					<tr>
						<td><textarea name="plot" class="plot_text" cols="30"
								rows="10">${movieVO.plot} </textarea></td>
					</tr>
					<tr>
						<th>標籤類別：<br> <input type="checkbox" id="tag1"
							name="tag1" class="tag" value="10"><label for="tag1">動作片</label>
							<input type="checkbox" id="tag2" name="tag2" class="tag"
							value="20"><label for="tag1">喜劇片</label> <input
							type="checkbox" id="tag3" name="tag3" class="tag" value="30"><label
							for="tag1">愛情片</label><br> <input type="checkbox" id="tag4"
							name="tag4" class="tag" value="40"><label for="tag1">科幻片</label>
							<input type="checkbox" id="tag5" name="tag5" class="tag"
							value="50"><label for="tag1">恐怖片</label> <input
							type="checkbox" id="tag6" name="tag7" class="tag" value="60"><label
							for="tag1">劇情片</label><br> <input type="checkbox" id="tag7"
							name="tag7" class="tag" value="70"><label for="tag1">戰爭片</label>
							<input type="checkbox" id="tag8" name="tag8" class="tag"
							value="80"><label for="tag1">動畫片</label> <input
							type="checkbox" id="tag9" name="tag9" class="tag" value="90"><label
							for="tag1">歷史片</label>
						</th>

					</tr>


				</table>

				<div class="pic" id="preview">
					<img src="/MovieOn/DBGifReaderMovie?movieId= ${movieVO.movieId }"">

				</div>
				<input type="file" id="p_file" name="poster" size="50" /> 
				
				<input type="hidden" name="action" value="update"> 
				<input type="hidden" name="movieId" value="${movieVO.movieId }">
				<button class="confirm" type="submit">修改完成</button>
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