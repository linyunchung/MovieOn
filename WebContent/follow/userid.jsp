<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- Member login authentication??	 -->
<%
	String id = request.getParameter("id");
	pageContext.setAttribute("id", id);
%>	

<!-- MemberService -->
<jsp:useBean id="memSvc" scope="page"
	class="com.member.model.MemberService" />
<jsp:useBean id="followService" scope="page"
	class="com.follow.model.FollowService" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${memSvc.getoneMember(id).username}的個人檔案。Movieon -</title>
	
	<!-- font-awesome script -->
	<script src="https://use.fontawesome.com/b0a5afcff9.js"></script>
	
	
	<!-- font awesome links -->
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.15.3/css/v4-shims.css">
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link
		href="https://fonts.googleapis.com/css2?family=Noto+Serif+TC&display=swap"
		rel="stylesheet">
	<link
		href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
		rel="stylesheet">
	
	<!-- CSS stylesheet -->
	<link href="./css/userid.css" rel="stylesheet" />
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="./js/userid.js"></script>
</head>

<body class = "userid">
    <header class="header">header</header>

    <div class = "site-body">
        <div class="content-wrap">
            <div class = "profile_header">
                <div class = "profile_summary">
                    <div class = "profile-avatar">
                        <span class="avatar" id="avatar">
                            <img src="${pageContext.request.contextPath}/DBGifReaderFollow?userid=${id}" alt="里維阿卡曼兵長" width="100" height="100">
                        </span>
                    </div>
                    <div class = "profile-name">
                        <h1>${memSvc.getoneMember(id).username}</h1>
                    </div>
                    <div class = "profile-info">
                        <div class = "profile-social">
                            <a class = "account" href="">
                                <i class="fa fa-instagram"></i>
                                <span>CptLevi666</span>
                            </a>
                            <a class = "account" href="">
                                <i class="fa fa-facebook"></i>
                                <span>Facebook</span>
                            </a>
                        </div>
                        <div class = "profile-stats">
                            <h4 class = "profile-statistic">
                                <a href="films.jsp?id=${id}">
                                    <span class = "value">1234</span>
                                    <span class = "definition">看過</span>
                                </a>
        
                            </h4>
                            <h4 class = "profile-statistic">
                                <a href="films.jsp?id=${id}">
                                    <span class = "value">56</span>
                                    <span class = "definition">今年</span>
                                </a>
        
                            </h4>
                            <h4 class = "profile-statistic">
                                <a href="">
                                    <span class = "value">78</span>
                                    <span class = "definition">影評</span>
                                </a>
        
                            </h4>
                            <h4 class = "profile-statistic">
                                <a href="followers.jsp?id=${id}">
                                    <span class = "value">${followService.followerCount(id)}</span>
                                    <span class = "definition">粉絲</span>
                                </a>
        
                            </h4>
                            <h4 class = "profile-statistic">
                                <a href="following.jsp?id=${id}">
                                    <span class = "value">${followService.followingCount(id)}</span>
                                    <span class = "definition">追蹤中</span>
                                </a>
        
                            </h4>
                        </div>
                        <div class = "profile-button">
                            <a class="button">編輯個人檔案</a>
                            <!-- <a class = "button nofollow" href="">
                                追蹤
                            </a>
                            <a class = "button" href="">
                                取消追蹤
                            </a> -->
                        </div>
                    </div>
                </div>
    
                
                
                <nav class = "profile-navigation">
                    <ul class = "navlist">
                        <li class = "navitem">
                            <a class = "navlink navuserid" href="userid.jsp?id=${id}">
                                個人檔案
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink" href="films.jsp?id=${id}">
                                我看過的
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink" href="">
                                影評
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink" href="followers.jsp?id=${id}">
                                粉絲
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink" href="following.jsp?id=${id}">
                                追蹤中
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink" href="">
                                動態牆
                            </a>
                        </li>
                        <li class = "navitem">
                            <a class = "navlink" href="">
                                購買清單<i class="fa fa-clipboard-list"></i>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <section id = "favorite" class = "section">
                <h2 class = "section-h2">
                    最愛電影
                </h2>
                <ul class = "poster-list -horizontal">
                    <li class = "poster-container">
                        <div class = "poster">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/i/o/production/movies/January2019/gUAASOn2Bx3qiaCcb0RN-1984x2835.JPG" width="150" height="225" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">殺死巨人的女孩(2017)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class = "poster-container">
                        <div class = "poster">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/public/index.php/y/r/w420/vu/movies/fp/mpost/63/55/6355.jpg" width="150" height="225" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">吹夢巨人(2016)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class = "poster-container">
                        <div class = "poster">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/public/index.php/y/r/w420/vu/movies/fp/mpost/26/05/2605.jpg" width="150" height="225" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">無敵浩克(2008)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class = "poster-container">
                        <div class = "poster">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/public/index.php/y/r/w420/vu/movies/fp/mpost/03/96/396.jpg" width="150" height="225" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">綠巨人浩克(2003)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                    </li>
                </ul>
            </section>
    
            <section id = "recent" class = "section">
                <h2 class = "section-h2">
                    <a href="films.jsp?id=${id}">近期觀看</a>
                </h2>
                <a href="films.jsp?id=${id}" class = "all-link">全部</a>
                <ul class = "poster-list -horizontal">
                    <li class = "poster-container">
                        <div class = "poster">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/public/index.php/y/r/w420/vu/movies/fp/mpost/57/83/5783.jpg" width="150" height="225" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">進擊的巨人(2015)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class = "poster-container">
                        <div class = "poster">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/public/index.php/y/r/w420/vu/movies/fp/mpost/59/13/5913.jpg" width="150" height="225" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">進擊的巨人2：世界終結(2015)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class = "poster-container">
                        <div class = "poster">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/public/index.php/y/r/w420/vu/movies/fp/mpost/56/23/5623.jpg" width="150" height="225" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">進擊的巨人劇場版—前編《紅蓮的弓矢》(2015)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class = "poster-container">
                        <div class = "poster">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/public/index.php/y/r/w420/vu/movies/fp/mpost/58/60/5860.jpg" width="150" height="225" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">進擊的巨人劇場版—後編《自由之翼》(2015)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                    </li>
                </ul>
            </section>
    
            <section class = "section">
                <h2 class = "section-h2">
                    <a href="">最新影評</a>
                </h2>
                <a href="" class = "all-link">更多</a>
                <ul class = "film-details-list poster-list">
                    <li class = "film-detail film-watched">
                        <div class = "poster film-poster poster-container">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/i/o/production/movies/June2021/WK6XHAWkYYNqsEi1gKiH-767x1080.jpg" width="70" height="105" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">黑寡婦 (2021)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                        <div class = "film-detail-content">
                            <h2 class = "headline-2">
                                <a href="">黑寡婦</a>
                                <small class = "metadata">
                                    <a href="">2021</a>
                                </small>
                            </h2>
                            <div class = "attribution-block">
                                <p class = attribution>
                                    <span class = "rating -blue rated-9">★★★★½</span>
                                    <span class = "content-metadata">
                                        <span class = "date">
                                            <a class = "context" href="">
                                                Watched by
                                                <strong class = "name">里維阿卡曼兵長</strong>
                                            </a>
                                            <span class = "_nobr">2021-07-09</span>
                                        </span>
                                    </span>
                                </p>
                            </div>
                            <div class = "body-text">
                                <p>沒有巨人先100分。建議黑寡婦操作立體機動裝置。</p>
                            </div>
                            <p class = "like-link-target">
                                <span class = "like-link">
                                    <a href="">
                                        <i class="fa fa-heart"></i>
                                        <span>還沒有人按讚</span>
                                    </a>
                                </span>
                            </p>
                        </div>

                    </li>
                    <li class = "film-detail film-watched">

                        <div class = "poster film-poster poster-container">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/x/r/w420/i/o/production/movies/April2021/ioMQiF4y2C06xWh1DUM2-1024x1516.jpg" width="70" height="105" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">尚氣與十環傳奇 (2021)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                        <div class = "film-detail-content">
                            <h2 class = "headline-2">
                                <a href="">尚氣與十環傳奇</a>
                                <small class = "metadata">
                                    <a href="">2021</a>
                                </small>
                            </h2>
                            <div class = "attribution-block">
                                <p class = attribution>
                                    <span class = "rating -blue rated-9">★★★★½</span>
                                    <span class = "content-metadata">
                                        <span class = "date">
                                            <a class = "context" href="">
                                                Watched by
                                                <strong class = "name">里維阿卡曼兵長</strong>
                                            </a>
                                            <span class = "_nobr">2021-07-09</span>
                                        </span>
                                    </span>
                                </p>
                            </div>
                            <div class = "body-text">
                                <p>建議尚氣也來操作立體機動裝置。</p>
                            </div>
                            <p class = "like-link-target">
                                <span class = "like-link">
                                    <a href="">
                                        <i class="fa fa-heart"></i>
                                        <span>還沒有人按讚</span>
                                    </a>
                                </span>
                            </p>
                        </div>  
                    </li>
                </ul>
            </section>
    
            <section class = "section">
                <h2 class = "section-h2">
                    <a href="">熱門影評</a>
                </h2>
                <a href="" class = "all-link">更多</a>
                <ul class = "film-details-list poster-list">
                    <li class = "film-detail film-watched">
                        <div class = "poster film-poster poster-container">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/i/o/production/movies/July2021/tDAKOcY2jZvGxxZI3gcp-1024x1463.jpg" width="70" height="105" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">玩命關頭9 (2021)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                        <div class = "film-detail-content">
                            <h2 class = "headline-2">
                                <a href="">玩命關頭9</a>
                                <small class = "metadata">
                                    <a href="">2021</a>
                                </small>
                            </h2>
                            <div class = "attribution-block">
                                <p class = attribution>
                                    <span class = "rating -blue rated-9">★★★★½</span>
                                    <span class = "content-metadata">
                                        <span class = "date">
                                            <a class = "context" href="">
                                                Watched by
                                                <strong class = "name">里維阿卡曼兵長</strong>
                                            </a>
                                            <span class = "_nobr">2021-07-09</span>
                                        </span>
                                    </span>
                                </p>
                            </div>
                            <div class = "body-text">
                                <p>我開立體機動裝置，絕對是比唐老大開的車還快。</p>
                            </div>
                            <p class = "like-link-target">
                                <span class = "like-link">
                                    <a href="">
                                        <i class="fa fa-heart"></i>
                                        <span>還沒有人按讚</span>
                                    </a>
                                </span>
                            </p>
                        </div>

                    </li>
                    <li class = "film-detail film-watched">

                        <div class = "poster film-poster poster-container">
                            <div>
                                <img class = "image" src="https://movies.yahoo.com.tw/i/o/production/movies/July2020/hFH7arAJqBIZaUdOGiuC-1182x1691.jpg" width="70" height="105" alt="I Kill Giants">
                                <a class = "frame" href="">
                                    <span class = "frame-title">鬼滅之刃劇場版 無限列車篇 (2021)</span>
                                    <span class = "overlay"></span>
                                </a>
                            </div>
                        </div>
                        <div class = "film-detail-content">
                            <h2 class = "headline-2">
                                <a href="">鬼滅之刃劇場版 無限列車篇                                </a>
                                <small class = "metadata">
                                    <a href="">2020</a>
                                </small>
                            </h2>
                            <div class = "attribution-block">
                                <p class = attribution>
                                    <span class = "rating -blue rated-9">★★★★½</span>
                                    <span class = "content-metadata">
                                        <span class = "date">
                                            <a class = "context" href="">
                                                Watched by
                                                <strong class = "name">里維阿卡曼兵長</strong>
                                            </a>
                                            <span class = "_nobr">2021-07-09</span>
                                        </span>
                                    </span>
                                </p>
                            </div>
                            <div class = "body-text">
                                <p>殺鬼和殺巨人，不知道哪個比較難？</p>
                            </div>
                            <p class = "like-link-target">
                                <span class = "like-link">
                                    <a href="">
                                        <i class="fa fa-heart"></i>
                                        <span>還沒有人按讚</span>
                                    </a>
                                </span>
                            </p>
                        </div>  
                    </li>
                </ul>
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