<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="css/sign_up.css" type="text/css" rel="stylesheet" >
</head>
<body>
	<div class="p">
		<p>會員注冊</p>
		<div class="register">
			<div class="formRow">
				<div class="formRow2">
					<label class="name">會員名稱</label> <input type="text" id="rg">
				</div>
				<div class="formRow2">
					<label class="email">電子郵件</label> <input type="text" id="rg">
				</div>
				<div class="formRow2">
					<label class="password">登入密碼</label> <input type="password" id="rg"
						minlength="8" maxlength="16">
				</div>
				<div class="formRow2">
					<label class="password">確認密碼</label> <input type="password" id="rg"
						minlength="8" maxlength="16">
				</div>
			</div>
			<div class="formRow">
				<hr class="c_hr">
			</div>
			<div class="formRow">
				<button type="submit" value="submit" class="btn">確認</button>
			</div>
		</div>
	</div>
</body>
</html>