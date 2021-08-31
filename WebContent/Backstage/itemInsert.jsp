<%@page import="java.sql.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Locale"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.item.model.*"%>

<%
	itemVO itemVO = (itemVO) request.getAttribute("itemVO");
%>
<%
	Locale locale = request.getLocale();
	Calendar calendar = Calendar.getInstance(locale);
	Date dateNow = new Date(calendar.getInstance().getTimeInMillis());
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>後台管理員</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/itemInsert.css">
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
        <h1 class="title">商品管理</h1>
        <h2 class="title2">上架新商品</h2>


	<li class="li1">
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/item.do" enctype="multipart/form-data">
        <table class="table">

            <tr>
                <th>商品名稱：<input class="text" type="TEXT" name="itemName" size="45" 
                	value="<%= (itemVO==null)? "" :itemVO.getItemName()%>"  
					autofocus placeholder='請輸入商品名稱'/></th>
            </tr>
            <tr>
                <th>售價：NT$&nbsp;<input class="text" type="TEXT" name="price" size="45" 
                	value="<%= (itemVO==null)? "" :itemVO.getPrice()%>"  
					autofocus placeholder='請輸入售價'/></th>
            </tr>
            <tr>
                <th>庫存量：&emsp;<input class="text" type="TEXT" name="inventory" size="45" 
                	value="<%= (itemVO==null)? "" :itemVO.getInventory()%>"  
					autofocus placeholder='請輸入庫存量' /></th>
            </tr>
            <tr>
                <th><input class="text" type="hidden" name="shelfDate" size="45" 
                	value="<%=dateNow%>"  
					autofocus placeholder='請輸入上架日期'/></th>
            </tr>

            <tr>
                <th>規格 ：</th><br>

            </tr>
            <tr>
                <td>
                		<textarea name="productSpecifications" class="productSpecifications_text" cols="30"
						rows="10" autofocus placeholder='請輸入商品規格' ><%= (itemVO==null)? "" : itemVO.getProductSpecifications()%></textarea></td>
            </tr>
            <tr>
                <th>簡介：</th><br>
            </tr>
            <tr>
                <td>
                		<textarea name="introduction" class="introduction_text" cols="30"
						rows="10" autofocus placeholder='請輸入商品簡介' ><%= (itemVO==null)? "" : itemVO.getIntroduction()%></textarea></td>
            </tr>
            <tr>
                <th>商品類別：<br>
                    <input type="radio" id="tag1" name="itemTag" class="tag" value="DVD影集"><label for="tag1">DVD影集</label>
                    <input type="radio" id="tag2" name="itemTag" class="tag" value="電影海報"><label for="tag2">電影海報</label>
                    <input type="radio" id="tag3" name="itemTag" class="tag" value="玩偶裝飾"><label for="tag3">玩偶裝飾</label>
                    <input type="radio" id="tag4" name="itemTag" class="tag" value="桌遊玩具"><label for="tag4">桌遊玩具</label>
                    <input type="radio" id="tag5" name="itemTag" class="tag" value="其他商品"><label for="tag5">其他商品</label>

                </th>

            </tr>


        </table>

        <div class="pic" id="preview">
            <p>上傳商品首圖</p>
        </div>
        <label class="buttem">選擇檔案
            <input type="file" id="p_file" name="itemPic" size="50" />
        </label>

        <div class="pic1" id="preview1">
            <p>上傳商品圖片1</p>
        </div>
        <label class="buttem1">選擇檔案
            <input type="file" id="p_file1" name="pic1" size="50" />
        </label>

        <div class="pic2" id="preview2">
            <p>上傳商品圖片2</p>
        </div>
        <label class="buttem2">選擇檔案
            <input type="file" id="p_file2" name="pic2" size="50" />
        </label>

        <div class="pic3" id="preview3">
            <p>上傳商品圖片3</p>
        </div>
        <label class="buttem3">選擇檔案
            <input type="file" id="p_file3" name="pic3" size="50" />
        </label>

		<input type="hidden" name="action" value="insert">
        <button class="confirm">確定新增</button>



		</FORM>
			
			
		</li>
    </div>








    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../js/nav.js"></script>

    <script>
        var preview_el = document.getElementById("preview");
        var p_file_el = document.getElementById("p_file");
        var preview_img = function (file) {
            var img_node = document.createElement("img");
            var reader = new FileReader(); // 用來讀取檔案
            reader.addEventListener("load", function () {
                //console.log(reader.result);
                let img_node = document.createElement("img");
                img_node.setAttribute("src", reader.result); // <img src="abdafaewre">
                img_node.setAttribute("class", "preview_img"); // <img src="abdafaewre" class="preview_img">
                preview_el.innerHTML = '';
                preview_el.append(img_node);
            });
            reader.readAsDataURL(file); // 讀取檔案
        };

        p_file_el.addEventListener("change", function (e) {
            if (this.files.length > 0) {
                preview_img(this.files[0]);
            } else {
                preview_el.innerHTML = '<span class="text">預覽圖</span>';
            }
        });

        var preview1_el = document.getElementById("preview1");
        var p_file1_el = document.getElementById("p_file1");
        var preview1_img = function (file) {
            var img1_node = document.createElement("img");
            var reader1 = new FileReader(); // 用來讀取檔案
            reader1.addEventListener("load", function () {
                //console.log(reader.result);
                let img1_node = document.createElement("img");
                img1_node.setAttribute("src", reader1.result); // <img src="abdafaewre">
                img1_node.setAttribute("class", "preview1_img"); // <img src="abdafaewre" class="preview_img">
                preview1_el.innerHTML = '';
                preview1_el.append(img1_node);
            });
            reader1.readAsDataURL(file); // 讀取檔案
        };

        p_file1_el.addEventListener("change", function (e) {
            if (this.files.length > 0) {
                preview1_img(this.files[0]);
            } else {
                preview1_el.innerHTML = '<span class="text">預覽圖</span>';
            }
        });


        var preview2_el = document.getElementById("preview2");
        var p_file2_el = document.getElementById("p_file2");
        var preview2_img = function (file) {
            var img2_node = document.createElement("img");
            var reader2 = new FileReader(); // 用來讀取檔案
            reader2.addEventListener("load", function () {
                //console.log(reader.result);
                let img2_node = document.createElement("img");
                img2_node.setAttribute("src", reader2.result); // <img src="abdafaewre">
                img2_node.setAttribute("class", "preview2_img"); // <img src="abdafaewre" class="preview_img">
                preview2_el.innerHTML = '';
                preview2_el.append(img2_node);
            });
            reader2.readAsDataURL(file); // 讀取檔案
        };

        p_file2_el.addEventListener("change", function (e) {
            if (this.files.length > 0) {
                preview2_img(this.files[0]);
            } else {
                preview2_el.innerHTML = '<span class="text">預覽圖</span>';
            }
        });


        var preview3_el = document.getElementById("preview3");
        var p_file3_el = document.getElementById("p_file3");
        var preview3_img = function (file) {
            var img3_node = document.createElement("img");
            var reader3 = new FileReader(); // 用來讀取檔案
            reader3.addEventListener("load", function () {
                //console.log(reader.result);
                let img3_node = document.createElement("img");
                img3_node.setAttribute("src", reader3.result); // <img src="abdafaewre">
                img3_node.setAttribute("class", "preview3_img"); // <img src="abdafaewre" class="preview_img">
                preview3_el.innerHTML = '';
                preview3_el.append(img3_node);
            });
            reader3.readAsDataURL(file); // 讀取檔案
        };

        p_file3_el.addEventListener("change", function (e) {
            if (this.files.length > 0) {
                preview3_img(this.files[0]);
            } else {
                preview3_el.innerHTML = '<span class="text">預覽圖</span>';
            }
        });


        


    </script>
</body>

</html>