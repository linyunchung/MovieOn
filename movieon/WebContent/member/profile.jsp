<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>	

<%
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>個人資訊修改</title>
<link href="${pageContext.request.contextPath}/css/profile.css" type="text/css" rel="stylesheet" >
</head>
<body>
<div class="header"><jsp:include page="/member/index.jsp" /></div>
	<div class="body">
		<div class="p">


			<p>個人資料</p>
			<div class="nav">
				<ul id="menu">
					<li><a href="${pageContext.request.contextPath}/member/acct_info.jsp">帳號資訊</a></li>
					<li><a href="${pageContext.request.contextPath}/member/change_password.jsp">更換密碼</a></li>
					<li><a>個人資料</a></li>
					<li><a href="${pageContext.request.contextPath}/member/add_cc.jsp">帳戶設定</a></li>
				</ul>
			</div>
			<form action="member.do" method="post" id="profile" enctype="multipart/form-data" >
			<div>
								<c:if test="${not empty errorMsgs}">
						<font style="color: red">請修正以下錯誤:</font>
						<ul>
							<c:forEach var="message" items="${errorMsgs}">
								<li id="error" style="color: red">${message}</li>
							</c:forEach>
						</ul>
					</c:if>
			</div>
				<div class="ziliao">
					<div class="box"></div>
					<hr id="u_hr">
					<div class="row">
						<div id="question">
							<label>個人圖示</label>
						</div>
						<div id="answer">
							<div id="preview">
								<img id="pic" src="../DBGifReader?userid=${memberVO.userid}"><span class="text" >預覽</span>
							</div>
							<div id="photo_btn">
								<input type="file" id="p_file" name="upload" >
							</div>

						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>姓名</label>
						</div>
						<div id="answer">
							<input type="hidden" name="username" value="${memberVO.username}">
							<input type="text" name="name" id="name" value="${memberVO.name}">
							<input type="hidden" name="userid" id="userid" value="${memberVO.userid}">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>性別</label>
						</div>
						<div id="answer">
							<input type="radio" name="gender" id="man" value="男" <c:if test="${memberVO.gender == '男' }">checked</c:if>>
							<label id="gender" for="man">男</label> 
							<input type="radio" name="gender" id="woman" value="女" <c:if test="${memberVO.gender == '女' }">checked</c:if>>
							<label id="gender" for="woman">女</label>
							<input type="radio" name="gender" id="secret" value="秘密" <c:if test="${memberVO.gender == '秘密' }">checked</c:if>>
							<label id="gender" for="secret">秘密</label>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>生日</label>
						</div>
						<div id="answer-date">
							<input type="date" id="date" value="${memberVO.birthday}"
							 name="birthday">
						</div> 
					</div>
					<div class="row">
						<div id="question">
							<label>地址</label>
						</div>
						<div id="answer">
							<input type="text" name="address" id="address"
								placeholder="請輸入地址" value="${memberVO.address}">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>教育程度</label>
						</div>
						<div id="answer-edu">
							<select size="1" name="education">
								<option value="國小" ${(memberVO.education=='國小')?'selected':''}>國小</option>
								<option value="國中" ${(memberVO.education=='國中')?'selected':''}>國中</option>
								<option value="高中" ${(memberVO.education=='高中')?'selected':''}>高中職 </option>
								<option value="大學" ${(memberVO.education=='大學')?'selected':''}>大學</option>
								<option value="碩士" ${(memberVO.education=='碩士')?'selected':''}>碩士</option>
								<option value="博士" ${(memberVO.education=='博士')?'selected':''}>博士</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>職業</label>
						</div>
						<div id="answer-job">
							<select name="occupation">
								<option value="金融業" ${(memberVO.occupation=='金融業')?'selected':''}>金融業</option>
								<option value="會計師" ${(memberVO.occupation=='會計師')?'selected':''}>會計師</option>
								<option value="工程師" ${(memberVO.occupation=='工程師')?'selected':''}>工程師 </option>
								<option value="行政" ${(memberVO.occupation=='行政人員')?'selected':''}>行政人員</option>
								<option value="律師" ${(memberVO.occupation=='律師')?'selected':''}>律師</option>
								<option value="醫師" ${(memberVO.occupation=='醫師')?'selected':''}>醫師</option>
								<option value="老師" ${(memberVO.occupation=='老師')?'selected':''}>老師</option>
								<option value="學生" ${(memberVO.occupation=='學生')?'selected':''}>學生</option>
								<option value="自由業" ${(memberVO.occupation=='自由業')?'selected':''}>自由業</option>
								<option value="無業" ${(memberVO.occupation=='無業')?'selected':''}>無業</option>
							</select>
						</div>
					</div>
	<!-- 				<div class="row">
						<div id="question">
							<label>喜歡的電影類型</label>
						</div>
						<div id="answer-movie">
							<input type="checkbox" name="movie" value="10">
							<label id="mv" for="action">動作片</label> 
							
							<input type="checkbox" name="movie" value="20">
							<label id="mv" for="sci-fi">科幻片</label>
							
							<input type="checkbox" name="movie" value="30">
							<label id="mv" for="war">戰爭片</label>
							
							<input type="checkbox" name="movie" value="40">
							<label id="mv" for="comedy">喜劇片</label>
							
							<input type="checkbox" name="movie" value="50">
							<label id="mv" for="horror">恐怖片</label> 
							
							<input type="checkbox" name="movie" value="60">
							<label id="mv" for="romance">愛情片</label>
							
							<input type="checkbox" name="movie" value="70">
							<label id="mv" for="drama">劇情片</label>
							
							<input type="checkbox" name="movie" value="80">
							<label id="mv" for="historical">歷史片</label>
							
							<input type="checkbox" name="movie" value="90">
							<label id="mv" for="animation">動畫片</label>
						</div>
					</div> -->
					<div class="row">
						<div id="question">
							<label>Instagram</label>
							<label id="fb">Facebook</label>
							<label id="twt">Twitter</label>
						</div>
						<div id="answer">
							<input type="text" name="ig" id="social" placeholder="Instagram" value="${memberVO.ig}"> 
							<input type="text" name="fb" id="social2" placeholder="Facebook" value="${memberVO.fb}"> 
							<input type="text" name="twt" id="social2" placeholder="Twitter" value="${memberVO.twt}">
						</div>
					</div>
					<div>
						<hr>
						<button type="submit" id="cancel">取消</button>
 						<input type="hidden" name="action" value="updateProfile">
<%-- 						<input type="hidden" name="email" value="${memberVO.email}"> --%>
						<input type="submit" id="save" value="儲存">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script> --%>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

	<script>
		var preview_el = document.getElementById("preview");
		var p_file_el = document.getElementById("p_file");

		var preview_img = function(file) {
			var reader = new FileReader(); // 用來讀取檔案
			reader.addEventListener("load", function() {
				console.log(reader.result);
				let img_node = document.createElement("img");
				img_node.setAttribute("src", reader.result); 
				img_node.setAttribute("class", "preview_img");
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
 		
<%--         $.datetimepicker.setLocale('zh');
        $('#date').datetimepicker({
           theme: '',              //theme: 'dark',
 	       timepicker:false,       //timepicker:true,
 	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=memberVO.getBirthday()%>', // value:   new Date(),
        });  --%>
	</script>
</html>