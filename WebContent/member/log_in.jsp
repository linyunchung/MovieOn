<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>log_in</title>
<link rel="stylesheet" type="text/css" href="css/log_in.css">
</head>
<body>
	<div class="p">
		<p>會員登入</p>
		<div class="login">
			<div class="login-form">
				<div class="formRow">
					<label class="formep">電子郵件</label> <input type="text"
						placeholder="Email">
				</div>
				<div class="formRow">
					<label class="formep">登入密碼</label> <input type="password"
						placeholder="Password" minlength="8" maxlength="16">
				</div>
				<div class="formRow">
					<a href="sign_up.jsp" id="new">註冊新帳號</a> <a
						href="reset_pwd1.jsp" id="forget">忘記密碼?</a>
				</div>
				<div class="formRow">
					<hr class="c_hr">
				</div>
				<div class="formRow">
					<button type="submit" id="btn">登入</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>