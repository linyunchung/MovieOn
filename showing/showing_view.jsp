<%@page import="com.member.model.MemberVO"%>
<%@page import="com.member.model.MemberService"%>
<%@page import="java.sql.Date"%>
<%@page import="com.movie.model.MovieVO"%>
<%@page import="com.movie.model.MovieService"%>
<%@page import="com.theater.model.TheaterVO"%>
<%@page import="com.theater.model.TheaterService"%>
<%@page import="com.showing.model.ShowingVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	List<ShowingVO> list = (List<ShowingVO>) request.getAttribute("showingVO");
%>

<!-- ����n�J���ϥΪ� -->
<%
    Object memberVO = session.getAttribute("memberVO");
%>



<!-- ��X�������v���B�q�v�B��� -->
<%!int theaterId;%>
<%!int movieId;%>
<%!Date showingDate;%>
<%
	for (ShowingVO showingVO : list) {
		theaterId = showingVO.getTheaterId();
		movieId = showingVO.getMovieId();
		showingDate = showingVO.getShowingDate();
	}
%>

<%
	TheaterService theaterSvc = new TheaterService();
	TheaterVO theaterVO = theaterSvc.getOneTheater(theaterId);

	MovieService movieSvc = new MovieService();
	MovieVO movieVO = movieSvc.getOneMovie(movieId);
%>


<html>
<head>
<meta charset="BIG5">
<title>�����d��</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/showing_time.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/showing.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
</head>
<body>
	
		<%session.setAttribute("showingVO", list);%>
		
		<div class="show_time">

			<div class="show_time_poster">
				<div class="poster_title">
					<span><%=movieVO.getMovieName()%></span> <span>/</span> 
					<span class="poster_theater"><%=theaterVO.getTheaterName()%></span>
				</div>

				<img class="poster"
					src="<%=request.getContextPath()%>/DBGifReaderMovie?movieId=<%=movieVO.getMovieId()%>">

				<button class="intro_btn" onclick="location.href='<%=request.getContextPath()%>/Links_Controller?movieId=<%=movieVO.getMovieId()%>&action=getOneMovie_From_Home'">
				�q�v����
				</button>

			</div>

			<div class="show_time_right">
			<form method="post" action="<%=request.getContextPath()%>/showing/showingview.do">
				<div class="timesave">
					<input type="hidden" name="action" value="saveShowingTime">
					<button class="timesave_btn">�x�s�d��</button>
					<span class="save_success"></span>
				</div>
			</form>

				<div class="time_title">

					<p><%=showingDate%></p>
					<table class="time">

						<tbody>

							<%for (ShowingVO showingVO : list) {%>
							<tr>
								<td><%=showingVO.getShowingTime()%></td>
							</tr>
							<%}%>

						</tbody>
					</table>

				</div>
			</div>
		</div>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://use.fontawesome.com/b0a5afcff9.js"></script>

<!-- �x�s���\�P���Ѵ��ܮ� -->
<%
	Object message = request.getAttribute("message");
	if (message != null) {
%>

<script>
			$(".save_success").text("<%=message%>");
			$(".save_success").css("display", "block");
			setTimeout(function() {
				$(".save_success").css("display", "none");
			}, 3000);
</script>

<%}%>


</html>