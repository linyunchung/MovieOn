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
			<p>���m�K�X</p>

			<form action="#" method="post" id="c_password">
				<div class="ch_pwd">
					<div class="box"></div>
					<hr id="u_hr">
				</div>
				<div class="row">
					<div id="question">
						<label>�ЦܫH�c�����H��n�J</label>
					</div>
				</div>
				<div>
					<hr>
					<a id="return" href="${pageContext.request.contextPath}/member/log_in.jsp">��^</a>
					<!-- <button type="submit" id="return">��^</button> -->
				</div>
		</div>
		</form>
	</div>
	</div>
</body>
</html>