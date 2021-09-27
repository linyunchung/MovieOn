<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="com.MovieTag.model.*"%>

<%
	MovieVO movieVO = (MovieVO) request.getAttribute("movieVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>
<%
	MovieTagVO movieTagVO = (MovieTagVO) request.getAttribute("movieTagVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>


<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>��x�޲z��</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/movieDataUpdata.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">

</head>

<body>
	 <%@ include file="header.file"%>
	<jsp:useBean id="movieTagSvc" scope="page"
		class="com.MovieTag.model.MovieTagService" />
	<jsp:useBean id="TagCategorySvc" scope="page"
		class="com.TagCategory.model.TagCategoryService" />

	<div class="main">
		<h1 class="title">�q�v��ƺ޲z</h1>
		<h2 class="title2">�q�v��ƭק�</h2>

		<li class="li1">
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do" enctype="multipart/form-data">
				<table class="table">
					<tr>
						<th>�q�v�s���G${movieVO.movieId }</th>

					</tr>
					<tr>
						<th>�q�v�W�١G<input class="text" type="TEXT" name="movieName"
							size="45" value="${movieVO.movieName } " /></th>
					</tr>
					<tr>
						<th>�^��W�١G<input class="text" type="TEXT" name="movieEName"
							size="45" value="${movieVO.movieEName }" /></th>
					</tr>
					<tr>
						<th>�W�M����G<input id="f_date1" class="text" type="TEXT"
							name="releaseDate" size="45" value="${movieVO.releaseDate }" /></th>
					</tr>
					<tr>
						<th>�����G<input class="text" type="TEXT" name="mins" size="45"
							style="left: 31px;" value="${movieVO.mins }" /></th>
					</tr>
					<tr>
						<th>�o�椽�q�G<input class="text" type="TEXT" name="studio"
							size="45" value="${movieVO.studio}" /></th>
					</tr>
					<tr>
						<th>�ɺt�G</th>
						<br>

					</tr>
					<tr>
						<td><textarea name="director" class="director_text" cols="30"
								rows="10">${movieVO.director} </textarea></td>
					</tr>
					<tr>
						<th>�D�t�G</th>
						<br>

					</tr>
					<tr>
						<td><textarea name="actor" class="actor_text" cols="30"
								rows="10">${movieVO.actor}</textarea></td>
					</tr>
					<tr>
						<th>�q�v���СG</th>
						<br>
					</tr>
					<tr>
						<td><textarea name="plot" class="plot_text" cols="30"
								rows="10">${movieVO.plot} </textarea></td>
					</tr>
					<tr>
						<th>�������O�G ${movieVO.movieTag}<br>
							<input type="radio" id="tag1" name="movieTag" class="tag" value="�ʧ@��" 
								<c:if test="${movieVO.movieTag== '�ʧ@��'}">checked</c:if>><label for="tag1">�ʧ@��</label> 
								
							<input type="radio" id="tag2" name="movieTag" class="tag" value="�߼@��" 
								<c:if test="${movieVO.movieTag == '�߼@��'}">checked</c:if>><label for="tag2">�߼@��</label> 
								
							<input type="radio" id="tag3" name="movieTag" class="tag" value="�R����" 
								<c:if test="${movieVO.movieTag == '�R����'}">checked</c:if>><label for="tag3">�R����</label><br>
								
							<input type="radio" id="tag4" name="movieTag" class="tag" value="��ۤ�" 
								<c:if test="${movieVO.movieTag == '��ۤ�'}">checked</c:if>><label for="tag4">��ۤ�</label> 
								
							<input type="radio" id="tag5" name="movieTag" class="tag" value="���Ƥ�" 
								<c:if test="${movieVO.movieTag == '���Ƥ�'}">checked</c:if>><label for="tag5">���Ƥ�</label> 
								
							<input type="radio" id="tag6" name="movieTag" class="tag" value="�@����"
								<c:if test="${movieVO.movieTag == '�@����'}">checked</c:if>><label for="tag6">�@����</label><br>
								
							<input type="radio" id="tag7" name="movieTag" class="tag" value="�Ԫ���"
								<c:if test="${movieVO.movieTag == '�Ԫ���'}">checked</c:if>><label for="tag7">�Ԫ���</label> 
								
							<input type="radio" id="tag8" name="movieTag" class="tag" value="�ʵe��"
								<c:if test="${movieVO.movieTag == '�ʵe��'}">checked</c:if>><label for="tag8">�ʵe��</label> 
								
							<input type="radio" id="tag9" name="movieTag" class="tag" value="���v��"
								<c:if test="${movieVO.movieTag == '���v��'}">checked</c:if>><label for="tag9">���v��</label>
						</th>

					</tr>


				</table>

				<div class="pic" id="preview">
					<img src="<%=request.getContextPath()%>/DBGifReaderMovie?movieId=${movieVO.movieId }"">

				</div>
				<label class="buttem">����ɮ� 
					<input type="file" id="p_file" name="poster" size="50" /> 
				</label>
				
				
				<input type="hidden" name="action" value="update"> 
				<input type="hidden" name="movieId" value="${movieVO.movieId }">
				<button class="confirm" type="submit">�ק粒��</button>
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
		var reader = new FileReader(); // �Ψ�Ū���ɮ�
		reader.addEventListener("load", function() {
			//console.log(reader.result);
			let img_node = document.createElement("img");
			img_node.setAttribute("src", reader.result); // <img src="abdafaewre">
			img_node.setAttribute("class", "preview_img"); // <img src="abdafaewre" class="preview_img">
			preview_el.innerHTML = '';
			preview_el.append(img_node);
		});
		reader.readAsDataURL(file); // Ū���ɮ�
	};

	p_file_el.addEventListener("change", function(e) {
		if (this.files.length > 0) {
			preview_img(this.files[0]);
		} else {
			preview_el.innerHTML = '<span class="text">�w����</span>';
		}
	});

	$.datetimepicker.setLocale('zh');
	$('#f_date1').datetimepicker({
		theme : '', //theme: 'dark',
		timepicker : false, //timepicker:true,
		step : 1, //step: 60 (�o�Otimepicker���w�]���j60����)
		format : 'Y-m-d', //format:'Y-m-d H:i:s',
		value : '${movieVO.releaseDate }', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
	//startDate:	            '2017/07/10',  // �_�l��
	//minDate:               '-1970-01-01', // �h������(���t)���e
	//maxDate:               '+1970-01-01'  // �h������(���t)����
	});

	// ----------------------------------------------------------�H�U�ΨӱƩw�L�k��ܪ����-----------------------------------------------------------

	//      1.�H�U���Y�@�Ѥ��e������L�k���
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

	//      2.�H�U���Y�@�Ѥ��᪺����L�k���
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

	//      3.�H�U����Ӥ�����~������L�k��� (�]�i���ݭn������L���)
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