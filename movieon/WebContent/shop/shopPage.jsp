<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>商城首頁</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/shop.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">

  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Archivo+Black&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Archivo+Black&family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap" rel="stylesheet">
</head>

<body>
<!--Start wrapper-->
<div id="wrapper">

<!--Start Header & nav-->
  <div id="header">
    <nav>
    <div class="logo">
				<a href="<%=request.getContextPath()%>/Home.jsp" class="logo">
					<img src="<%=request.getContextPath()%>/images/logo/logo.png" alt="">
				</a>
    </div>
    
      <ul>
        <li class="dropdown">
          <a href="${pageContext.request.contextPath}/Home.jsp">電影探索</a>
          <ul>
            <li><a href="#">查詢電影類型</a></li>
            <li><a href="#">電影推薦</a></li>
            <li><a href="#">留下影評</a></li>
            <li><a href="#">影評中心</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="<%=request.getContextPath()%>/showing/showing_search.jsp">電影時刻表</a>
          <ul>
            <li><a href="#">場次查詢</a></li>
            <li><a href="#">歷史紀錄</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="<%=request.getContextPath()%>/shop/shopPage.jsp">商城</a>
          <ul>
            <li><a href="<%=request.getContextPath()%>/shop/shopItem.jsp">商品列表</a></li>
            <li><a href="<%=request.getContextPath()%>/shop/shopCart.jsp">購物車</a></li>
            <li><a href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
            <li><a href="<%=request.getContextPath()%>/prob/contactcs.jsp">聯絡客服</a></li>
          </ul>
        </li>
        <li class="dropdown">
						<c:if test="${empty memberVO.username}">
							<a href="<%=request.getContextPath()%>/profile">會員中心 </a>
						</c:if> 
						<c:if test="${not empty memberVO.username}">
							<a href="<%=request.getContextPath()%>/profile">${memberVO.username} </a>
							<ul>
								<li><a href="${pageContext.request.contextPath}/profile?action=myfilms">我的評分</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=myreviews">我的影評</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=myfollowers">我的粉絲</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=myfollowing">追蹤中</a></li>
            <li><a href="${pageContext.request.contextPath}/profile?action=mynetwork">動態牆</a></li>
            <li><a href="${pageContext.request.contextPath}/shop/shopSearch.jsp">我的訂單</a></li>
							</ul>
						</c:if>
        </li>
      </ul>
      <form class="search">
        <input type="text" id="myImput" onkeyup="myFunction()" placeholder="Search...">
      </form>
      <button class="signin">
        <a href="<%=request.getContextPath()%>/member/log_in.jsp">會員登入</a>
      </button>
    </nav>
  </div>
<!--Close Header & nav-->


<!--Start Banner-->
<div id="banner">
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="<%=request.getContextPath()%>/images/banner/B_01.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
          <img src="<%=request.getContextPath()%>/images/banner/B_03.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
          <img src="<%=request.getContextPath()%>/images/banner/B_02.png" class="d-block w-100" alt="...">
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden"></span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden"></span>
      </button>
    </div>
</div>
<!--Close Banner-->


<!--Start Main-->
<main>
  <div id="content">
    <div class="m_text_top">New  Drops</div>

    <div class="card">
      <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3033"><img src="<%=request.getContextPath()%>/images/item/Shopping/01.png" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <p class="card-text"><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3033">小小兵</a></p>
        <p><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3033">小小兵周邊發售中</a></p>
      </div>
    </div>

    <div class="card">
      <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3028"><img src="<%=request.getContextPath()%>/images/item/Shopping/02.jpg" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <p class="card-text"><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3028">星際大戰</a></p>
        <p><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3028">經典周邊商品發售中</a></p>
      </div>
    </div>

    <div class="card">
      <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3030"><img src="<%=request.getContextPath()%>/images/item/Shopping/03.png" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <p class="card-text"><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3030">鬼娃恰吉</a></p>
        <p><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3030">周邊商品新發售</a></p>
      </div>
    </div>

    <div class="card">
      <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3019"><img src="<%=request.getContextPath()%>/images/item/Shopping/04.png" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <p class="card-text"><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3019">玩具總動員</a></p>
        <p><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3019">絕對要收藏的周邊玩具</a></p>
      </div>      
    </div>

    <div class="card">
      <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId="><img src="<%=request.getContextPath()%>/images/item/Shopping/05.jpg" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <p class="card-text"><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=">阿拉丁</a></p>
        <p><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=">玩偶發售中</a></p>
      </div>
    </div>


    <div class="card">
      <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId="><img src="<%=request.getContextPath()%>/images/item/Shopping/06.png" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <p class="card-text"><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=">哈利波特</a></p>
        <p><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=">光輪2000 限量販售</a></p>
      </div>
    </div>

    <div class="card">
      <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3029"><img src="<%=request.getContextPath()%>/images/item/Shopping/07.jpg" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <p class="card-text"><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3029">鬼滅之刃</a></p>
        <p><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3029">"限定"毛毯新發售</a></p>
      </div>
    </div>

    <div class="card">
      <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3025"><img src="<%=request.getContextPath()%>/images/item/Shopping/08.jpg" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <p class="card-text"><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3025">靈魂急轉彎</a></p>
        <p><a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=3025">周邊玩偶發售中</a></p>
      </div>      
    </div>

    <div class="m_text_bottom">
      <a href="<%=request.getContextPath()%>/shop/shopItem.jsp">Shop All</a>
    </div>

  </div>

</main>
<!--Close Main-->


</div>
<!--Close wrapper-->



<!--Start Footer -->
<div class="footer">
  <div class="footer_inner">
    <ul>
      <li><a href="">回到首頁</a></li>
      <li><a href="">關於我們</a></li>
      <li><a href="">服務說明</a></li>
      <li><a href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
      <li><a href="">聯絡我們</a></li>
    </ul>
  </div> 

  <div class="footer_p">
    <span>© MovieOn. Made by programming students in Taipei, Taiwan. For learning purposes only.</span>
  </div>
</div>
<!--Close Footer -->
  

<!-- 載入 JavaScript & jQuery-->
<script src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.6.0.min.js"></script>
<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.bundle.min.js"></script>



</body>
</html>