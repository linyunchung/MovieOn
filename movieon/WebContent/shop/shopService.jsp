<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>客服中心</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/service.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap"
	rel="stylesheet">
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
					<li class="dropdown"><a href="${pageContext.request.contextPath}/Home.jsp">電影探索</a>
						<ul>
							<li><a href="#">查詢電影類型</a></li>
							<li><a href="#">電影推薦</a></li>
							<li><a href="#">留下影評</a></li>
							<li><a href="#">影評中心</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="<%=request.getContextPath()%>/showing/showing_search.jsp">電影時刻表</a>
						<ul>
							<li><a href="#">場次查詢</a></li>
							<li><a href="#">歷史紀錄</a></li>
						</ul>
					</li>
					
					<li class="dropdown"><a
						href="<%=request.getContextPath()%>/shop/shopPage.jsp">商城</a>
						<ul>
							<li><a
								href="<%=request.getContextPath()%>/shop/shopItem.jsp">商品列表</a></li>
							<li><a
								href="<%=request.getContextPath()%>/shop/shopCart.jsp">購物車</a></li>
							<li><a
								href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
								<li><a href="<%=request.getContextPath()%>/prob/contactcs.jsp">聯絡客服</a></li>
						</ul>
					</li>
					
					<li class="dropdown">
						<c:if test="${empty memberVO.username}">
					<a href="">會員中心</a>
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
				<form class="search" action="search.php">
					<input name="q" placeholder="Search..." type="search">
				</form>
				<button class="signin">
					<a href="<%=request.getContextPath()%>/member/log_in.jsp">會員登入</a>
				</button>
			</nav>
		</div>
		<!--Close Header & nav-->



		<!--Start Main-->
		<main>
			<div id="main_content">
				<h2 class="title_text">客服中心</h2>
				<p class="text_tile">FAQ常見說明</p>

				<div class="aside_left">
					<ul class="menu">
						<li class="item">商品購物須知</li>
						<li>付款退款說明</li>
						<li>異動訂單資料</li>
						<li>商品配送說明</li>
						<li>發票開立寄送</li>
					</ul>
				</div>


				<div class="content">
					<!-- 商品購物須知 -->
					<div class="main_item_a" style="display: block">
						<h3 class="h3_title">商品購物須知</h3>
						<div class="toggle">
							<dl>
								<dt>Q1.Movie On網路商店購物流程說明。</dt>
								<dd>
									<ul>
										<li>Ans : 結帳前請先至【會員註冊】加入會員 → 將需要的商品【加入購物車】 → 點選【訂單結帳】 →
											確認訂單購買商品無誤後 → 填寫基本資料、運送方式、結帳方式 → 完成結帳。</li>
									</ul>
								</dd>

								<dt>Q2.訂單送出後於幾日內需付款完成?</dt>
								<dd>
									<ul>
										<li>Ans : 訂單填寫完成後，須於三日內付款完成，超過三日未付款完成，即取消訂單。</li>
									</ul>
								</dd>

								<dt>Q3.退貨相關辦法說明。</dt>
								<dd>
									<ul>
										<li>Ans :
											凡因商品瑕疵、商品不符所需等因素須退、換貨，請於收到商品後7日內，並確認商品未經使用：為全新狀態。</li>
									</ul>
								</dd>

								<dt>Q4.換貨相關辦法說明。</dt>
								<dd>
									<ul>
										<li>Ans :
											請於收到商品後7日內點選與客服聯絡線上對話視窗，告知需申請「換貨」，並提供訂單相關資訊，我們會在收到申請後與您聯繫。<br>
											<br> 超過7日申請者則無法受理，建議收到商品後請立即檢查確認，如有任何不便之處，敬請見諒。<br>
											<br> 換貨僅供更換同一商品編號之商品或同價位之商品，敬請見諒。<br> <br>
											收到退換貨申請後，我們將確認詳細資訊，並以宅配來回件的方式，寄送並收回您須換貨之商品。
										</li>
									</ul>
								</dd>
							</dl>
						</div>
					</div>

					<!-- 付款退款說明 -->
					<div class="main_item_a" style="display: none">
						<h3 class="h3_title">付款退款說明</h3>
						<div class="toggle">
							<dl>
								<dt>Q1.付款方式為何?</dt>
								<dd>
									<ul>
										<li>Ans : 目前提供信用卡付款、ATM轉帳及貨到付款。</li>
									</ul>
								</dd>

								<dt>Q2.退款方式說明。</dt>
								<dd>
									<ul>
										<li>Ans :
											確認收到退貨商品後，我們將主動寄發「退款通知信」給您，請您提供以下退款帳戶資訊，我們將確認資訊並進行退款作業。<br>
											<br> 【非使用信用卡付款消費者】<br> 訂單編號：<br> 帳戶銀行名稱：<br>
											分行名稱：<br> 帳號：<br> 戶名：<br>
										</li>
									</ul>
								</dd>

							</dl>
						</div>
					</div>

					<!-- 異動訂單資料 -->
					<div class="main_item_a" style="display: none">
						<h3 class="h3_title">異動訂單資料</h3>
						<div class="toggle">
							<dl>
								<dt>Q1.如何查詢自己的訂單?</dt>
								<dd>
									<ul>
										<li>Ans : 可於商城列表下的點選會員中心裡查詢「我的訂單」。</li>
									</ul>
								</dd>

								<dt>Q2.如何知道訂單已經成立?</dt>
								<dd>
									<ul>
										<li>Ans : 完成訂單後，系統會在網頁上顯示相關訂購成功訊息。</li>
									</ul>
								</dd>

								<dt>Q3.是否能了解目前訂單的處理狀況呢?</dt>
								<dd>
									<ul>
										<li>Ans : 是的，可以隨時至會員中心裡點選『訂單查詢』功能查詢您的訂單。</li>
									</ul>
								</dd>

								<dt>Q4.在訂單成立後，可以要求更改訂購數量嗎?</dt>
								<dd>
									<ul>
										<li>Ans : 訂單成立後無法更改訂購數量，如需增加訂購品項，請您重新下單選購，再將原訂單辦理退貨即可。</li>
									</ul>
								</dd>

								<dt>Q5.可以在訂單成立後，要求取消該筆訂單嗎？</dt>
								<dd>
									<ul>
										<li>Ans :
											是的，請至我的訂單頁，確認所要取消的訂單後，按下「取消訂單」鍵，則將立即為您取消該筆訂單；若該筆訂單無法線上「消/退」時，則請於網頁上方點選『客服中心』並點選「線上客服」，將由網路客服人員為您服務。</li>
									</ul>
								</dd>

								<dt>Q6.可以在訂單成立後，要求更改送貨地址嗎？</dt>
								<dd>
									<ul>
										<li>Ans : 是的，請於完成訂貨2小時內與我們聯繫。</li>
									</ul>
								</dd>
							</dl>
						</div>
					</div>

					<!-- 商品配送說明 -->
					<div class="main_item_a" style="display: none">
						<h3 class="h3_title">商品配送說明</h3>
						<div class="toggle">
							<dl>
								<dt>Q1.商品配送方式?</dt>
								<dd>
									<ul>
										<li>Ans : 本商店可選擇宅配到府及超商取貨方式寄出商品，於每次出貨時，會寄發出貨通知信，須請會員多加留意。</li>
									</ul>
								</dd>

								<dt>Q2:我要如何查詢配送進度?</dt>
								<dd>
									<ul>
										<li>Ans:您於登入會員後，至會員中心列表下的「訂單查詢」點選查詢訂單可顯示送狀況，
											訂單狀態：配送中-表示已通知廠商出貨；已配送-表示廠商已送交貨運寄送</li>
									</ul>
								</dd>

								<dt>Q3:我可以指定送貨地點嗎?</dt>
								<dd>
									<ul>
										<li>Ans:您可以在填寫訂單資料時的收件人欄位，輸入您指定的送貨地址，
											有「速」標誌的商品皆可離島地區配送，(另有材積及重量限制)</li>
									</ul>
								</dd>

								<dt>Q4.商品配送時間多長?</dt>
								<dd>
									<ul>
										<li>Ans :
											商品配送時間一律為3-7個工作天送達，配送時間以每筆訂單完成付款時間起算，若有時效性的需求，請會員於訂單送出時盡快付款，以利出貨作業。</li>
									</ul>
								</dd>

								<dt>Q5.商品配送包裝方式為何?</dt>
								<dd>
									<ul>
										<li>Ans : 商品皆以紙箱包裝出貨，若有特別需求時，請於下訂單時備註說明，以利出貨作業。</li>
									</ul>
								</dd>

								<dt>Q6:商品配送運費?</dt>
								<dd>
									<ul>
										<li>Ans : 商品配送皆為免運費。</li>
									</ul>
								</dd>

								<dt>Q7:商品配送範圍?</dt>
								<dd>
									<ul>
										<li>Ans : 台灣本島各地各縣市、澎湖部分地區、金門部分地區(大金門、小金門)、小琉球、馬祖全部地區、綠島。
											目前暫不提供海外配送服務。</li>
									</ul>
								</dd>

							</dl>
						</div>
					</div>

					<!-- 發票開立寄送 -->
					<div class="main_item_a" style="display: none">
						<h3 class="h3_title">發票開立寄送</h3>
						<div class="toggle">
							<dl>
								<dt>Q1.發票的寄送方式?</dt>
								<dd>
									<ul>
										<li>Ans : 發票將於商品寄出後隨貨一併寄出，若有其他寄送需求請於訂單備註。</li>
									</ul>
								</dd>

								<dt>Q2.如何選擇開立公司用發票?</dt>
								<dd>
									<ul>
										<li>Ans
											:請在結帳流程中的「發票資料」處，選擇公司用(線上列印)發票並填寫統一編號及發票抬頭即可。發票一經開立，不得更改或改開其他統一編號發票。</li>
									</ul>
								</dd>

								<dt>Q3.收到發票後，可否改開立為多張發票?</dt>
								<dd>
									<ul>
										<li>Ans :為配合請款結帳，故一次出貨對應一張發票，恕無法分別開立多張。</li>
									</ul>
								</dd>
							</dl>
						</div>
					</div>
				</div>
		</main>
		<!--Close Main-->

<!-- 		<div class="box"> -->
<!-- 			<button> -->
<!-- 				<img -->
<%-- 					src="<%=request.getContextPath()%>/images/icon/live-chat (1).jpg" --%>
<!-- 					title="線上諮詢"> -->
<!-- 			</button> -->
<!-- 		</div> -->

	</div>
	<!--Close wrapper-->


	<!--Start Footer -->
	<div class="footer">
		<div class="footer_inner">
			<ul>
				<li><a href="">回到首頁</a></li>
				<li><a href="">關於我們</a></li>
				<li><a href="">服務說明</a></li>
				<li><a
					href="<%=request.getContextPath()%>/shop/shopService.jsp">客服中心</a></li>
				<li><a href="">聯絡我們</a></li>
			</ul>
		</div>

		<div class="footer_p">
			<span>© MovieOn. Made by programming students in Taipei,
				Taiwan. For learning purposes only.</span>
		</div>
	</div>
	<!--Close Footer -->




	<!-- 載入 JavaScript & jQuery-->
	<script
		src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.6.0.min.js"></script>
	<script>
		// 選單
		$(function() {
			$('.menu li').click(function() {
				$(this).addClass('item').siblings().removeClass('item')
				$('.main_item_a').eq($(this).index()).show().siblings().hide();
			})
		})

		// 風琴
		$(function() {
			$(".toggle dl dd").hide();
			$(".toggle dl dt").click(function() {
				$(".toggle dl dd").not($(this).next()).hide();
				$(".toggle dl dt").not($(this).next()).removeClass("current");
				$(this).next().slideToggle(500);
				$(this).toggleClass("current");
			});
		});
	</script>

</body>
</html>