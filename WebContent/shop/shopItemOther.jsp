<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.* "%>


<%@ page import="com.item.model.*"%>
<%@ page import="com.ProductImage.model.*"%>


<%
	itemService itemSvc = new itemService();
	itemVO itemlist = itemSvc.getOneItem(new Integer (request.getParameter("itemId")));
	pageContext.setAttribute("itemlist", itemlist);
%>




<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>商品明細</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/itemContext2.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">

  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">

  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">

  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">
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
        <a href="#">會員登入</a>
      </button>
    </nav>
  </div>
<!--Close Header & nav-->


<!--Start Main-->
<main>
  <div id="content">
  
<!--Start 上半部圖片及標題文字說明 -->
  <div class="top_main">
    
    <!-- 圖片區塊 -->
    <div class="top_img">
      
      <!-- 大圖 -->
      <div class="large_box">
      
        <ul>
        
            <li>
              <img src="<%=request.getContextPath()%>/shop/ItemPic1?itemId=${itemlist.itemId}">
            </li>

            <li>
              <img src="<%=request.getContextPath()%>/shop/ItemPic2?itemId=${itemlist.itemId}">
            </li>
            
            <li>
              <img src="<%=request.getContextPath()%>/shop/ItemPic3?itemId=${itemlist.itemId}">
            </li>
        </ul>
      </div>
	  
	  
	  
      <!-- 縮圖 -->
      <div class="small_box">
          <span class="btns lefts_btn" onclick="left_btn()" style="background-image:url(<%=request.getContextPath()%>/images/icon/left.png)"></span>
              <div class="small_list">
                  <ul>
                      <li class="on">
                          <img src="<%=request.getContextPath()%>/shop/ItemPic1?itemId=${itemlist.itemId}">
                          <div class="bun_bg"></div>
                      </li>
                      
                      <li class="">
                          <img src="<%=request.getContextPath()%>/shop/ItemPic2?itemId=${itemlist.itemId}">
                          <div class="bun_bg"></div>
                      </li>
                      
                      <li class="">
                          <img src="<%=request.getContextPath()%>/shop/ItemPic3?itemId=${itemlist.itemId}">
                          <div class="bun_bg"></div>
                      </li>
                  </ul>
              </div>
          <span class="btns rights_btn" onclick="right_btn()" style="background-image:url(<%=request.getContextPath()%>/images/icon/right.png)"></span>
      </div>
    </div>



    <!-- 文字區塊 -->
    <div class="top_text">
    
      <div><span class="title_t">商品明細 </span></div>
      <div class="instock_img"><img src="<%=request.getContextPath()%>/images/icon/stock.jpg"></div><br>
      
      
    	 <form name="shoppingForm" action="orderInfo.do" method="POST">
 
		  <div class="item_cname">${itemlist.itemName}</div>
		  <input type="hidden" name="itemName" value="${itemlist.itemName}">
		      
		  <div class="price">NT$${itemlist.price}</div>
	      <input type="hidden" name="price" value="${itemlist.price}">
	      
	      <br>
	      <br>
	      <br>
	    
	      <div class="item_context">
	        
	        <p>商品編號：${itemlist.itemId}</p> 
	        <input type="hidden" name="itemId" value="${itemlist.itemId}">       
	        
	        <p>付款方式：信用卡 / 貨到付款 / ATM轉帳 </p>
	        <p>配送方式：宅配到府 / 超商取貨</p>
	      </div>
	      
		    <div class="item_qty"><p>數量：<input class="qty" type="text" name="itemQty" size="3" value=1></p></div>
		    <br>
		    <input type="submit" class="btn3" data-bs-container="body" data-bs-toggle="popover" data-bs-placement="top" data-bs-content="品項已放入購物車" value="放入購物車">
		    <input type="hidden" name="action" value="ADD">

		    <input type="submit" class="btn1" value="直接購買">
		</form>  
		    
		  
	 </div>

  </div>
<!--Close 上半部圖片及標題文字說明 -->


<br>
<br>
<hr>

<!--Start 下半部圖片文字說明 -->
    <br>
    <p class="b_title">商品介紹</p>
    <br>
    <br>
    <div class="bottom_main">

      <div class="bottom_pic"> 
        <div class="bottom_p2">
          <img src="<%=request.getContextPath()%>/shop/ItemPic2?itemId=${itemlist.itemId}">
        </div>  
        
    	<br>
   		<br>
    
        <div class="bottom_p3">
          <img src="<%=request.getContextPath()%>/shop/ItemPic3?itemId=${itemlist.itemId}">
        </div>  
      </div>


      <div class="bottom_text">
	    ${itemlist.introduction}
        <br>
        <br>
        <br>
        <br>
        <br>
	    ${itemlist.productSpecifications}
      </div>

    </div>


<!--Close 下半部圖片文字說明 -->
    <div class="m_text_bottom">
      <a href="<%=request.getContextPath()%>/shop/shopItem.jsp">回商品列表</a>
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





<script src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.bundle.min.js"></script>
<script>
         
  function left_btn(){
    var i;
    var l = $(".small_list").find("ul li").length;
    $(".small_list").find("ul li").each(function(index){
      if($(this).hasClass("on")){
        i = index;
      }
    });

        i--;
        if(i < 0){
            i = l - 1;
        }
        t = i;
        Img(i)
    };


    function right_btn(){
        var i;
        var l = $(".small_list").find("ul li").length;
        $(".small_list").find("ul li").each(function(index){
            if($(this).hasClass("on")){
                i = index;
            }
        });
        
        i++;
        if(i > l-1){
            i = 0;
        }
        t = i;
        Img(i);
    };


    function Img(i){
        var l = $(".small_list").find("ul li").length;
        var l_mean;
        if(l < 5){
            l_mean = 0;
        }else{
            l_mean = ((parseInt(l / 5) - 1) * 5) + (l % 5);
        }
        var w = 110;
        $(".large_box").find("ul li").eq(i).fadeIn().siblings().hide();
        $(".small_list").find("ul li").eq(i).addClass("on").siblings().removeClass("on");
        var ml = i * w;
        if(ml <= l_mean * w){
            $(".small_list").find("ul").stop().animate({
                marginLeft: -ml + "px"
            })
        }else{
            $(".small_list").find("ul").stop().animate({
            marginLeft: -(l_mean * w) + "px"
            })
        }
    }
    
    var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
    var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
      return new bootstrap.Popover(popoverTriggerEl)
    })
    
    
    function add(){
    	alert('品項已放入購物車!');
    }
</script>


  
</body>
</html>