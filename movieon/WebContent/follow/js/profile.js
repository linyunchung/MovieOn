// This will run once JavaScript is ready
$(document).ready(function(e) {
	console.log("Helloxx");
});

// Turns number ratings to stars
$(document).ready(function(e) {
	$(".rated-5").each(function(i, obj) {
		console.log(this.innerHTML);

		switch (this.innerHTML) {
		case "0.5":
			$(this).html("½");
			break;
		case "1.0":
			$(this).html("★");
			break;
		case "1.5":
			$(this).html("★½");
			break;
		case "2.0":
			$(this).html("★★");
			break;
		case "2.5":
			$(this).html("★★½");
			break;
		case "3.0":
			$(this).html("★★★");
			break;
		case "3.5":
			$(this).html("★★★½");
			break;
		case "4.0":
			$(this).html("★★★★");
			break;
		case "4.5":
			$(this).html("★★★★½");
			break;
		case "5.0":
			$(this).html("★★★★★");
			break;
		}
	});
});

// follw button changes display on hover and click
$(function() {
	$(".context").mouseover(function() {
		$(this).css("color", "#AABBCC");
		$(this).find(".name").css("color", "white");
	});

	$(".context").mouseleave(function() {
		$(this).css("color", "#678");
		$(this).find(".name").css("color", "#AABBCC");
	});
});

// ajax update follow table
var followbtn;
var target;
$(function() {
	$(".button.-compact.-following").click(function() {
		followbtn = this;
		target = $(this).closest("tr").attr("data-id");
		console.log("following clicked");

		if (!$(this).hasClass("-notfollowing")) {

			var action = "removeFollow"
			updateFollow(action);
			console.log("target = " + target);
			console.log("called for removeFollow");

		} else {
			var action = "addFollow"
			updateFollow(action);
			console.log("target = " + target);
			console.log("called for addFollow");
		}
	});
});

// Seperate function for repeated usage.
function updateFollow(action) {
	var actionText = "";
	if (action == "addFollow") {
		actionText = "追蹤"
	}
	if (action == "removeFollow") {
		actionText = "取消追蹤"
	}

	$.ajax({
		type : "post",
		url : "http://localhost:8081/MovieOnClone/profile",
		dataType : "json",
		data : {
			action : action,
			targetId : target,
		},
		success : function(response) {
			if (true === response) {
				$(".alert").fadeIn(300).delay(1500).fadeOut(400);
				$(".alert .alertmsg").text("已成功" + actionText);
				$(followbtn).toggleClass("-notfollowing");
				// location.reload();
			} else if (false === response) {
				$(".alert").fadeIn(300).delay(1500).fadeOut(400);
				$(".alert .alertmsg").text(actionText + "失敗");
			} else {
				$(".alert").fadeIn(300).delay(1500).fadeOut(400);
				$(".alert .alertmsg").text(response);
			}
		},
		error : function(thrownerror) {
			$(".alert").fadeIn(300).delay(1500).fadeOut(400);
			$(".alert .alertmsg").text("請登入會員");
		},
	});
}

$(function() {

	$(".table-stats").click(function() {
		console.log('clicked')
		$(".alert").fadeIn(300).delay(1500).fadeOut(400);
		$(".alert .alertmsg").text("請登入會員");
	})

	$(".closebtn").click(function() {
		console.log(this + " clicked")
		$(".alert").stop(true, true).fadeOut(200);
	})

})
