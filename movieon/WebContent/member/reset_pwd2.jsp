<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="../css/reset_pwd2.css" type="text/css" rel="stylesheet" >
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
						<label>�s�K�X</label>
					</div>
					<div id="answer">
						<input type="password" " name="password" id="password"
							minlength="8" maxlength="16">
					</div>
				</div>
				<div class="row">
					<div id="question">
						<label>�T�{�s�K�X</label>
					</div>
					<div id="answer">
						<input type="password" name="password" id="password" minlength="8"
							maxlength="16">
					</div>
				</div>
				<div>
					<hr>
					<button type="submit" id="check">�T�{</button>
				</div>
		</div>
		</form>
	</div>
	</div>
</body>
</html>