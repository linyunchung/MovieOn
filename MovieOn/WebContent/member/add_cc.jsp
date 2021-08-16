<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="css/add_cc.css" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		var dialog, form,

		cn1 = $("#cn1"), cn2 = $("#cn2"), cn3 = $("#cn3"), cn4 = $("#cn4"), expdate = $("#expdate"), name = $("#name"), ss = $("#ss"), allFields = $(
				[]).add(cn1).add(cn2).add(cn3).add(cn4).add(expdate).add(name)
				.add(ss);
		tips = $(".validateTips");

		function updateTips(t) {
			tips.text(t).addClass("ui-state-highlight");
			setTimeout(function() {
				tips.removeClass("ui-state-highlight", 1500);
			}, 500);
		}

		function checkLength(o, n, min, max) {
			if (o.val().length > max || o.val().length < min) {
				o.addClass("ui-state-error");
				updateTips("Length of " + n + " must be between " + min
						+ " and " + max + ".");
				return false;
			} else {
				return true;
			}
		}

		function checkRegexp(o, regexp, n) {
			if (!(regexp.test(o.val()))) {
				o.addClass("ui-state-error");
				updateTips(n);
				return false;
			} else {
				return true;
			}
		}

		function addUser() {
			var valid = true;
			allFields.removeClass("ui-state-error");

			valid = valid && checkLength(cn1, "cn1", 4);
			valid = valid && checkLength(cn2, "cn2", 4);
			valid = valid && checkLength(cn3, "cn3", 4);
			valid = valid && checkLength(cn4, "cn4", 4);
			valid = valid && checkLength(ss, "ss", 3);

			valid = valid && checkRegexp(cn1, /^([0-9])+$/);
			valid = valid && checkRegexp(cn2, /^([0-9])+$/);
			valid = valid && checkRegexp(name, /^([a-zA-Z ''])+$/);
			// valid = valid && checkRegexp(expdate,/^([''])+$/);

			if (valid) {
				let task_text = ($("#cn1").val());
				let task_text2 = ($("#cn2").val());
				let task_text3 = ($("#cn3").val());
				let task_text4 = ($("#cn4").val());
				let date = ($("#expdate").val());
				if (task_text != "") {
					let list_html = "";
					list_html += '<li class="task2">'
					list_html += '<div id="number">';
					list_html += '<a>�����O</a>';
					list_html += '<a id="cc_number">' + task_text4 + '</a>';
					list_html += '</div>';
					list_html += '<div id="exp">';
					list_html += '<a id="expd">' + date + '</a>';
					list_html += '</div>';
					list_html += '<button type="button" class="btn_delete">����</button>';
					list_html += '</li>'

					$("ul.task_list").prepend(list_html);
					$("input.task.task_name").val("");
				}

				dialog.dialog("close");
			}
			return valid;

		}
		$("ul.task_list").on("click", "button.btn_delete", function() {
			let r = confirm("�T�{����?")
			if (r) {
				$(this).closest("li").animate({
					"opacity" : 0
				}, 1000, "swing", function() {
					$(this).remove();
				});
			}
		})

		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 485,
			width : 350,
			modal : true,
			buttons : {
				"�T�w" : addUser,
				"����" : function() {
					dialog.dialog("close");
				}
			},
			close : function() {
				form[0].reset();
				allFields.removeClass("ui-state-error");
			}
		});

		form = dialog.find("form").on("submit", function(event) {
			event.preventDefault();
			addUser();
		});

		$("#create-user").button().on("click", function() {
			dialog.dialog("open");
		});
	});
</script>
</head>
<body>
	<div class="body">
		<div class="p">
			<p>�b��]�w</p>
			<div class="nav">
				<ul id="menu">
					<li><a href="acct_info.jsp">�b����T</a></li>
					<li><a href="change_password.jsp">�󴫱K�X</a></li>
					<li><a href="profile.jsp">�ӤH���</a></li>
					<li><a>�b��]�w</a></li>
				</ul>
			</div>
			<form action="" method="post" id="cc_set">
				<div class="cc">
					<div class="box"></div>
					<hr id="u_hr">
				</div>
				<div class="row">
					<div id="question">
						<label>�z���H�Υd</label>
					</div>
					<div id="answer">
						<label>�����</label>
					</div>
				</div>
				<div class="task">
					<ul class="task_list">
						<hr id="hr2">
						<button type="button" id="create-user">�s�W�H�Υd</button>
					</ul>
				</div>
			</form>

		</div>
	</div>

	<div id="dialog-form" title="�s�W�H�Υd">
		<!-- <p class="validateTips"></p> -->
		<form>
			<fieldset>
				<label id="popfont" for="ccnb">�H�Υd�d��</label> <input type="text"
					name="name" id="cn1" value="1234" maxlength="4"
					class="text ui-widget-content ui-corner-all"> <input
					type="text" name="name" id="cn2" value="1234" maxlength="4"
					class="text ui-widget-content ui-corner-all"> <input
					type="text" name="name" id="cn3" value="1234" maxlength="4"
					class="text ui-widget-content ui-corner-all"> <input
					type="text" name="name" id="cn4" value="1234" maxlength="4"
					class="text ui-widget-content ui-corner-all"> <label
					id="popfont" for="expdate">�H�Υd�����</label> <input type="month"
					name="expdate" id="expdate" value=""
					class="text ui-widget-content ui-corner-all"> <label
					id="popfont" for="name">���d�H�m�W</label> <input type="text"
					name="name" id="name" value="roger"
					class="text ui-widget-content ui-corner-all"> <label
					id="popfont" for="csc">�w���X</label> <input type="text" name="ss"
					id="ss" value="789" maxlength="3"
					class="text ui-widget-content ui-corner-all"> <input
					type="submit" tabindex="-1"
					style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>

</body>
</html>