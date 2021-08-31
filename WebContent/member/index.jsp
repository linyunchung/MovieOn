<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
	content="width=device-width, initial-scale=1.0">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/favicon.ico">
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css'
	rel='stylesheet'>
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>MovieOn</title>
</head>
<script type="text/javascript">
	function getData(pageNeme) {
		var req = new XMLHttpRequest();
		req.open("get", "http://127.0.0.1:5502/" + pageNeme);
		req.onload = function() {
			var content = document.getElementById("test");
			test.innerHTML = this.responseText;
		};
		req.send();
	}
</script>
<body>
    <nav>
        <div class="navbar">
            <i class='bx bx-menu'></i>
            <div class="logo">
				<img src="<%=request.getContextPath() %>/images/logo.png">
			</div>
            <div class="nav-links">
                <div class="sidebar-logo">
                    <span class="logo_name">MovieOn</span>
                    <i class='bx bx-x'></i>
                </div>
                <ul class="links">
                    <li>
                        <a class="tansuo" href="#">電影探索</a>
                        <i class='bx bx-chevron-down arrow tan-arrow'></i>
                        <ul class="tansuo-sub-menu sub-menu">
                            <li><a href="#">查詢電影類型</a></li>
                            <li><a href="#">電影推薦</a></li>
                            <li><a href="#">留下影評</a></li>
                            <li><a href="#">影評中心</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="shike" href="#">電影時刻</a>
                        <i class='bx bx-chevron-down arrow shike-arrow'></i>
                        <ul class="shike-sub-menu sub-menu">
                            <li><a href="#">場次查詢</a></li>
                            <li><a href="#">歷史記錄</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="jiaoyou" href="#">交友</a>
                        <i
						class='bx bx-chevron-down arrow jiaoyou-arrow'></i>
                        <ul class="jiaoyou-sub-menu sub-menu">
                            <li><a href="#">媒合配對</a></li>
                            <li><a href="#">即時訊息</a></li>
                            <li><a href="#">好友名單</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="shangcheng" href="#">商城</a>
                        <i
						class='bx bx-chevron-down arrow shangcheng-arrow'></i>
                        <ul class="shangcheng-sub-menu sub-menu">
                            <li><a href="#">商品列表</a></li>
                            <li><a href="#">購物車</a></li>
                            <li><a href="#">訂單查詢</a></li>
                            <li><a href="#">客服中心</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="zhongxin" href="#">會員中心</a>
                        <i
						class='bx bx-chevron-down arrow zhongxin-arrow'></i>
                        <ul class="zhongxin-sub-menu sub-menu">
                            <li><a href="#">我的評分</a></li>
                            <li><a href="#">我的影評</a></li>
                            <li><a href="#">我追蹤的作者</a></li>
                            <li><a href="#">購物記錄</a></li>
                            <li><a href="#">動態墻</a></li>
                            <li><a href="/acct_info.html">會員資料</a></li>
                        </ul>
                    </li>
                    <li id="sign">
                        <a id="sign_in" onclick="getData('log_in.html')">會員登入</a>
                    </li>
                </ul>
            </div>
            <div class="search-box">
                <i class='bx bx-search'></i>
                <div class="input-box">
                <form method="post" action="<%=request.getContextPath() %>/HomeServlet">
                    <input type="text" name="search" placeholder="Search...">
                    <input type="hidden" name="action" value="getSearchResult">
                </div>
                </form>
            </div>
            
            
            
            
            
        </div>
    </nav>

    <div class="overlay"></div>
    <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="js/script.js"></script>

    <div id="test"></div>

</body>
</html>
</body>
</html>