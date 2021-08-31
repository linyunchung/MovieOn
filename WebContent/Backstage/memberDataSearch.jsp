<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>後台管理員</title>
  <link rel="stylesheet" href="css/header.css">
  <link rel="stylesheet" href="css/memberDataSearch.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap" rel="stylesheet">
</head>


<body>
 <div id="header">
        <a href="backstage.html" class="logo">
            <img src="img/logo.png" alt="">
        </a>
        <nav>

            <ul>

                <li class="dropdown">
                    <a href="">會員管理</a>
                    	<ul>
	                        <li><a href="#">會員資料查詢</a></li>
	                    </ul>
                </li>

                

                <li class="dropdown">
                    <a href="">電影管理</a>
                    <ul>
                        <li><a href="movieDataSearch.jsp">已上架電影管理</a></li>
                        <li><a href="movieDataInsert.jsp">上架新電影</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">商品管理</a>
                    <ul>
                        <li><a href="itemSearch.jsp">已上架商品管理</a></li>
                        <li><a href="itemInsert.jsp">上架新商品</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">電影時刻表</a>
                    <ul>
                        <li><a href="#">上架新電影時刻表</a></li>
                    </ul>
                </li>


            </ul>

            <button class="signin">
                <a href="backstage.html">回到首頁</a>
            </button>

        </nav>

    </div>

  <div class="main">
    <h1 class="title">會員資料管理</h1>

    <li class="li1">
      <FORM METHOD="post" ACTION="emp.do" >
        <input id="idSearch" class="input" autofocus placeholder='會員編號搜尋' type='text' name="memberId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <button class="send1" type="submit">送出</button>
      </FORM>

      


    </li>

    <!-- <input id="idSearch" class="input" autofocus placeholder='會員編號搜尋' type='text' name="memberId">
    <button class="send1" type="submit">送出</button>
    <input id="tagSearch" class="input" autofocus placeholder='喜好類別搜尋' type='text'>
    <button class="send2">送出</button> -->

    

  </div>








  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="../js/nav.js"></script>
</body>
</html>