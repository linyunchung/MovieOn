<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>里維阿卡曼兵長的電影。Movieon - </title>

	<!-- font-awesome script -->
    <script src="https://use.fontawesome.com/b0a5afcff9.js"></script>

    
    <!-- CDN for bootstrap -->
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
    
    <!-- font awesome links -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/v4-shims.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Serif+TC&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">

    <!-- CSS stylesheet -->
    <link href="./css/films.css" rel="stylesheet" />
</head>

<body class = "films">
    <header class="header">header</header>

    <div class = "site-body" id = "content">
        <div class="content-wrap">
            <section class = "profile_header">
                          
                <nav class = "profile-navigation">
                    <div class = "profile-mini-person">
                        <a href="" class="avatar">
                            <img src="https://static.wikia.nocookie.net/shingekinokyojin/images/b/b1/Levi_Ackermann_%28Anime%29_character_image.png" alt="里維阿卡曼兵長" width="24" height="24">
                        </a>
                        <h1 class="title-3">
                            <a href="">里維阿卡曼兵長</a>
                        </h1>
                    </div>
                    <ul class = "navlist">
                        <li class = "navitem">
                            <a class = "navlink navprofile" href="userid.jsp">
                                個人檔案
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink navfilms" href="films.jsp">
                                我看過的
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink navreviews" href="">
                                影評
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink navfollowers" href="followers.jsp">
                                粉絲
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink navfollowing" href="following.jsp">
                                追蹤中
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink navnetwork" href="">
                                動態牆
                            </a>
                        </li>
                        <li class = "navitem -orders">
                            <a class = "navlink navorders" href="">
                                購買清單
                                <i class="fa fa-clipboard-list"></i>
                            </a>
                        </li>
                    </ul>
                </nav>

            </section>
    
            <section class = "section">
                <h2 class = "section-h2">
                    <a href="">評分</a>
                </h2>
                <a href="" class = "all-link">全部</a>
            </section>

    

        </div>
    </div>


    <footer class="footer">
        
        <div class="footer_inner"></div>
        <ul>
            <li>回到首頁</li>
            <li>關於我們</li>
            <li>服務說明</li>
            <li>客服</li>
            <li>聯絡我們</li>
            <li><i class="fa fa-instagram"></i></li>
            <li><i class="fa fa-facebook"></i></li>
            
        </ul>
            <span>© MovieOn. Made by programming students in Taipei, Taiwan. For learning purposes only.</span>
        </div>
    </footer>
    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script> -->
</body>

</html>