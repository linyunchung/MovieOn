<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="css/profile.css" type="text/css" rel="stylesheet" >
</head>
<body>
	<div class="body">
		<div class="p">
			<p>個人資料</p>
			<div class="nav">
				<ul id="menu">
					<li><a href="acct_info.jsp">帳號資訊</a></li>
					<li><a href="change_password.jsp">更換密碼</a></li>
					<li><a>個人資料</a></li>
					<li><a href="add_cc.jsp">帳戶設定</a></li>
				</ul>
			</div>
			<form action="#" method="post" id="profile">
				<div class="ziliao">
					<div class="box"></div>
					<hr id="u_hr">
					<div class="row">
						<div id="question">
							<label>個人圖示</label>
						</div>
						<div id="answer">
							<div id="preview">
								<span class="text">預覽</span>
							</div>
							<div id="photo_btn">
								<input type="file" id="p_file">
							</div>

						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>姓名</label>
						</div>
						<div id="answer">
							<input type="text" name="username" id="username">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>性別</label>
						</div>
						<div id="answer">
							<input type="radio" name="gender" id="man"><label
								id="gender" for="man">男</label> <input type="radio"
								name="gender" id="woman"><label id="gender" for="woman">女</label>
							<input type="radio" name="gender" id="secret"><label
								id="gender" for="secret">秘密</label>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>生日</label>
						</div>
						<div id="answer-date">
							<input type="date" id="date">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>地址</label>
						</div>
						<div id="answer">
							<select id="city">
								<option>縣市</option>
								<option>台北市</option>
								<option>新北市</option>
								<option>桃園市</option>
								<option>台中市</option>
								<option>台南市</option>
								<option>高雄市</option>
								<option>基隆市</option>
								<option>新竹市</option>
								<option>嘉義市</option>
								<option>新竹縣</option>
								<option>苗栗縣</option>
								<option>彰化縣</option>
								<option>南投縣</option>
								<option>雲林縣</option>
								<option>嘉義縣</option>
								<option>屏東縣</option>
								<option>宜蘭縣</option>
								<option>花蓮縣</option>
								<option>臺東縣</option>
								<option>澎湖縣</option>
							</select> <input type="text" name="address" id="address"
								placeholder="請輸入地址">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>教育程度</label>
						</div>
						<div id="answer-edu">
							<select>
								<option>國小</option>
								<option>國中</option>
								<option>高中職</option>
								<option>大學</option>
								<option>碩士</option>
								<option>博士</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>職業</label>
						</div>
						<div id="answer-job">
							<select>
								<option>金融業</option>
								<option>會計師</option>
								<option>工程師</option>
								<option>行政人員</option>
								<option>律師</option>
								<option>醫師</option>
								<option>醫師</option>
								<option>學生</option>
								<option>自由業</option>
								<option>無業</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>喜歡的電影類型</label>
						</div>
						<div id="answer-movie">
							<input type="checkbox" name="movie" value="action"><label
								id="mv" for="action">動作片</label> <input type="checkbox"
								name="movie" value="sci-fi"><label id="mv" for="sci-fi">科幻片</label>
							<input type="checkbox" name="movie" value="war"><label
								id="mv" for="war">戰爭片</label> <input type="checkbox"
								name="movie" value="comedy"><label id="mv" for="comedy">喜劇片</label>
							<input type="checkbox" name="movie" value="horror"><label
								id="mv" for="horror">恐怖片</label> <input type="checkbox"
								name="movie" value="romance"><label id="mv"
								for="romance">愛情片</label> <input type="checkbox" name="movie"
								value="drama"><label id="mv" for="drama">劇情片</label> <input
								type="checkbox" name="movie" value="historical"><label
								id="mv" for="historical">歷史片</label> <input type="checkbox"
								name="movie" value="animation"><label id="mv"
								for="animation">動畫片</label>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>最喜歡的電影</label>
						</div>
						<div id="answer">
							<input type="text" name="favorite" id="favorite">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>社群連結</label>
						</div>
						<div id="answer">
							<input type="text" name="username" id="social"
								placeholder="Instagram"> <input type="text"
								name="username" id="social2" placeholder="Facebook"> <input
								type="text" name="username" id="social2" placeholder="Twitter">
						</div>
					</div>
					<div>
						<hr>
						<button type="submit" id="cancel">取消</button>
						<button type="submit" id="save">儲存</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		var preview_el = document.getElementById("preview");
		var p_file_el = document.getElementById("p_file");

		var preview_img = function(file) {
			//   var img_node = document.createElement("img");
			var reader = new FileReader(); // 用來讀取檔案
			reader.addEventListener("load", function() {
				console.log(reader.result);
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
	</script>
</body>
</html>