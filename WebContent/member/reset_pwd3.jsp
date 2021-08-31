<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/reset_pwd3.css" type="text/css" rel="stylesheet" >
</head>
<body>
<div class="header"><jsp:include page="index.jsp" /></div>
	<div class="body">
		<div class="p">
			<p>重置密碼</p>

			<form action="#" method="post" id="c_password">
				<div class="ch_pwd">
					<div class="box"></div>
					<hr id="u_hr">
				</div>
				<div class="row">
					<div id="question">
						<label>請至信箱收取信件登入</label>
					</div>
				</div>
				<div>
					<hr>
					<a id="return" href="${pageContext.request.contextPath}/member/log_in.jsp">返回</a>
					<!-- <button type="submit" id="return">返回</button> -->
				</div>
		</div>
		</form>
	</div>
	</div>
</body>
</html>