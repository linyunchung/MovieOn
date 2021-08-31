<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.* "%>

<%@ page import="com.item.model.*"%>
<%@ page import="com.ProductImage.model.*"%>
<%@ page import="com.ItemTagMapping.model.*"%>
<%@ page import="com.ItemTag.model.*"%>
<%@ page import="com.ItemTagMapping.model.ItemTagMappingService"%>


<%
	itemService itemSvc = new itemService();
	List<itemVO> list = itemSvc.getAll();
	pageContext.setAttribute("list", list);
%>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>商品列表</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/item.css">
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@500&display=swap" rel="stylesheet">
</head>

<body>
<!--Start wrapper-->
<div id="wrapper">

<!--Start Header & nav-->
  <div id="header">
    <nav>
      <div class="logo">
        <img src="<%=request.getContextPath()%>/images/logo/logo.png" alt="">
      </div>
      <ul>
        <li class="dropdown">
          <a href="">電影探索</a>
          <ul>
            <li><a href="#">查詢電影類型</a></li>
            <li><a href="#">電影推薦</a></li>
            <li><a href="#">留下影評</a></li>
            <li><a href="#">影評中心</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="">交友</a>
          <ul>
            <li><a href="#">媒合配對</a></li>
            <li><a href="#">即時訊息</a></li>
            <li><a href="#">好友名單</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="">電影時刻表</a>
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
          </ul>
        </li>
        <li class="dropdown">
          <a href="">會員中心</a>
          <ul>
            <li><a href="#">我的評分</a></li>
            <li><a href="#">我的影評</a></li>
            <li><a href="#">我追蹤的作者</a></li>
            <li><a href="<%=request.getContextPath()%>/shop/shopSearch.jsp">我的訂單</a></li>
            <li><a href="#">動態牆</a></li>
          </ul>
        </li>
      </ul>
      <form class="search" action="search.php">
        <input name="q" placeholder="Search..." type="search">
      </form>
      <button class="signin">
        <a href="">會員登入</a>
      </button>
    </nav>
  </div>
<!--Close Header & nav-->

<!--Start Main-->
<main>
  <div id="content">
    <p class="title_text">商品列表</p>
    <h4>商品分類</h4>
    <div class="aside">
      
      <ul class="menu">
        <li class="item">DVD影集</li>
        <li>電影海報</li>
        <li>玩偶裝飾</li>
        <li>桌遊玩具</li>
        <li>其他商品</li>
      </ul>
    </div>


    <div class="main_item">

      <!-- DVD影集-->
      <div class="main_item_a" style="display:block">
        <div class="container">
          <h3 class="h3_title">DVD影集</h3>
          <div class="row">  
                
          	<c:forEach var="itemVO" items="${list}">
	          	<c:if test="${(itemVO.itemTag == 'DVD影集')}">
	          	<c:if test="${(itemVO.inventory > 0)}">
		  			<div class="col">
		  				<a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><img src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}"></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p>${itemVO.itemName}</p></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p class="price_text">NT$${itemVO.price}</p></a>
		            </div>
	             </c:if>
	             </c:if>   
            </c:forEach> 
            
          </div>
        </div>
	</div>


      <!-- 電影海報 -->
      <div class="main_item_a" style="display:none">
        <div class="container">
          <h3 class="h3_title">電影海報</h3>
          <div class="row">  
             
            <c:forEach var="itemVO" items="${list}">
	          	<c:if test="${(itemVO.itemTag == '電影海報')}">
	          	<c:if test="${(itemVO.inventory > 0)}">
		  			<div class="col">
		  				<a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><img src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}"></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p>${itemVO.itemName}</p></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p class="price_text">NT$${itemVO.price}</p></a>
		            </div>
	             </c:if>
	             </c:if>   
            </c:forEach> 

          </div>
        </div>
      </div>      
      
      
      
      
      <!-- 玩偶裝飾 -->
      <div  class="main_item_a" style="display:none">
        <div class="container">
          <h3 class="h3_title">玩偶裝飾</h3>
          <div class="row">  

            <c:forEach var="itemVO" items="${list}">
	          	<c:if test="${(itemVO.itemTag == '玩偶裝飾')}">
	          	<c:if test="${(itemVO.inventory > 0)}">
		  			<div class="col">
		  				<a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><img src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}"></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p>${itemVO.itemName}</p></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p class="price_text">NT$${itemVO.price}</p></a>
		            </div>
	             </c:if>
	             </c:if>   
            </c:forEach> 

          </div>
        </div>  
      </div>




      <!-- 桌遊玩具 -->
      <div class="main_item_a" style="display:none">
        <div class="container">
          <h3 class="h3_title">桌遊玩具</h3>
           <div class="row">  

            <c:forEach var="itemVO" items="${list}">
	          	<c:if test="${(itemVO.itemTag == '桌遊玩具')}">
	          	<c:if test="${(itemVO.inventory > 0)}">
		  			<div class="col">
		  				<a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><img src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}"></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p>${itemVO.itemName}</p></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p class="price_text">NT$${itemVO.price}</p></a>
		            </div>
	             </c:if>
	             </c:if>   
            </c:forEach> 
         
          </div>
        </div>
      </div>




      <!-- 其他商品 -->
      <div class="main_item_a" style="display:none">
        <div class="container">
          <h3 class="h3_title">其他商品</h3>
          <div class="row">  
          
            <c:forEach var="itemVO" items="${list}">
	          	<c:if test="${(itemVO.itemTag == '其他商品')}">
	          	<c:if test="${(itemVO.inventory > 0)}">
		  			<div class="col">
		  				<a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><img src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}"></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p>${itemVO.itemName}</p></a>
		                <a href="<%=request.getContextPath()%>/shop/shopItemOther.jsp?itemId=${itemVO.itemId}"><p class="price_text">NT$${itemVO.price}</p></a>
		            </div>
	             </c:if>
	             </c:if>   
            </c:forEach> 
          
          
            </div>
          </div>
      </div>
      

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




<script type="text/javascript" src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.6.0.min.js"></script>
<script>
  $(function(){
    $('.menu li').click(function(){
      $(this).addClass('item').siblings().removeClass('item')
      $('.main_item_a').eq($(this).index()).show().siblings().hide();
    })
  })
</script>




</body>
</html>