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
			<p>�ӤH���</p>
			<div class="nav">
				<ul id="menu">
					<li><a href="acct_info.jsp">�b����T</a></li>
					<li><a href="change_password.jsp">�󴫱K�X</a></li>
					<li><a>�ӤH���</a></li>
					<li><a href="add_cc.jsp">�b��]�w</a></li>
				</ul>
			</div>
			<form action="#" method="post" id="profile">
				<div class="ziliao">
					<div class="box"></div>
					<hr id="u_hr">
					<div class="row">
						<div id="question">
							<label>�ӤH�ϥ�</label>
						</div>
						<div id="answer">
							<div id="preview">
								<span class="text">�w��</span>
							</div>
							<div id="photo_btn">
								<input type="file" id="p_file">
							</div>

						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>�m�W</label>
						</div>
						<div id="answer">
							<input type="text" name="username" id="username">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>�ʧO</label>
						</div>
						<div id="answer">
							<input type="radio" name="gender" id="man"><label
								id="gender" for="man">�k</label> <input type="radio"
								name="gender" id="woman"><label id="gender" for="woman">�k</label>
							<input type="radio" name="gender" id="secret"><label
								id="gender" for="secret">���K</label>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>�ͤ�</label>
						</div>
						<div id="answer-date">
							<input type="date" id="date">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>�a�}</label>
						</div>
						<div id="answer">
							<select id="city">
								<option>����</option>
								<option>�x�_��</option>
								<option>�s�_��</option>
								<option>��饫</option>
								<option>�x����</option>
								<option>�x�n��</option>
								<option>������</option>
								<option>�򶩥�</option>
								<option>�s�˥�</option>
								<option>�Ÿq��</option>
								<option>�s�˿�</option>
								<option>�]�߿�</option>
								<option>���ƿ�</option>
								<option>�n�뿤</option>
								<option>���L��</option>
								<option>�Ÿq��</option>
								<option>�̪F��</option>
								<option>�y����</option>
								<option>�Ὤ��</option>
								<option>�O�F��</option>
								<option>���</option>
							</select> <input type="text" name="address" id="address"
								placeholder="�п�J�a�}">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>�Ш|�{��</label>
						</div>
						<div id="answer-edu">
							<select>
								<option>��p</option>
								<option>�ꤤ</option>
								<option>����¾</option>
								<option>�j��</option>
								<option>�Ӥh</option>
								<option>�դh</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>¾�~</label>
						</div>
						<div id="answer-job">
							<select>
								<option>���ķ~</option>
								<option>�|�p�v</option>
								<option>�u�{�v</option>
								<option>��F�H��</option>
								<option>�߮v</option>
								<option>��v</option>
								<option>��v</option>
								<option>�ǥ�</option>
								<option>�ۥѷ~</option>
								<option>�L�~</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>���w���q�v����</label>
						</div>
						<div id="answer-movie">
							<input type="checkbox" name="movie" value="action"><label
								id="mv" for="action">�ʧ@��</label> <input type="checkbox"
								name="movie" value="sci-fi"><label id="mv" for="sci-fi">��ۤ�</label>
							<input type="checkbox" name="movie" value="war"><label
								id="mv" for="war">�Ԫ���</label> <input type="checkbox"
								name="movie" value="comedy"><label id="mv" for="comedy">�߼@��</label>
							<input type="checkbox" name="movie" value="horror"><label
								id="mv" for="horror">���Ƥ�</label> <input type="checkbox"
								name="movie" value="romance"><label id="mv"
								for="romance">�R����</label> <input type="checkbox" name="movie"
								value="drama"><label id="mv" for="drama">�@����</label> <input
								type="checkbox" name="movie" value="historical"><label
								id="mv" for="historical">���v��</label> <input type="checkbox"
								name="movie" value="animation"><label id="mv"
								for="animation">�ʵe��</label>
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>�̳��w���q�v</label>
						</div>
						<div id="answer">
							<input type="text" name="favorite" id="favorite">
						</div>
					</div>
					<div class="row">
						<div id="question">
							<label>���s�s��</label>
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
						<button type="submit" id="cancel">����</button>
						<button type="submit" id="save">�x�s</button>
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
			var reader = new FileReader(); // �Ψ�Ū���ɮ�
			reader.addEventListener("load", function() {
				console.log(reader.result);
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
	</script>
</body>
</html>