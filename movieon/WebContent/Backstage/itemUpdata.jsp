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
    <title>��x�޲z��</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/itemUpdata.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap" rel="stylesheet">

</head>

<body>
     <%@ include file="header.file"%>

    <div class="main">
        <h1 class="title">�ӫ~�޲z</h1>
        <h2 class="title2">�W�[�s�ӫ~</h2>


	<li class="li1">
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/item.do" enctype="multipart/form-data">
        <table class="table">

            <tr>
                <th>�ӫ~�s���G${itemVO.itemId}</th>
            </tr>
            <tr>
                <th>�ӫ~�W�١G<input class="text" type="TEXT" name="itemName"
							size="45" value="${itemVO.itemName} " /></th>
            </tr>
            <tr>
                <th>����GNT$ <input class="text" type="TEXT" name="price"
							size="45" value="${itemVO.price} " /></th>
            </tr>
            <tr>
                <th>�w�s�q�G&emsp;<input class="text" type="TEXT" name="inventory"
							size="45" value="${itemVO.inventory}" /></th>
            </tr>
            <tr>
                <th>�W�[��� �G${itemVO.shelfDate}</th>
            </tr>

            <tr>
                <th>�W�� �G</th><br>
            </tr>
            <tr>
                <td>
                	<textarea name="productSpecifications" class="productSpecifications_text" cols="30"
								rows="10">${itemVO.productSpecifications} </textarea>
                </td>
            </tr>
            <tr>
                <th>²���G</th><br>
            </tr>
            <tr>
                <td>
                	<textarea name="introduction" class="introduction_text" cols="30"
								rows="10">${itemVO.introduction} </textarea>
                </td>
            </tr>
            <tr>
                <th>�ӫ~���O�G<br>
                	<input type="radio" id="tag1" name="itemTag" class="tag" value="DVD�v��"
                		<c:if test="${itemVO.itemTag== 'DVD�v��'}">checked</c:if>><label for="tag1">DVD�v��</label>
                    <input type="radio" id="tag2" name="itemTag" class="tag" value="�q�v����"
                    	<c:if test="${itemVO.itemTag== '�q�v����'}">checked</c:if>><label for="tag2">�q�v����</label>
                    <input type="radio" id="tag3" name="itemTag" class="tag" value="�����˹�"
                    	<c:if test="${itemVO.itemTag== '�����˹�'}">checked</c:if>><label for="tag3">�����˹�</label>
                    <input type="radio" id="tag4" name="itemTag" class="tag" value="��C����"
                    	<c:if test="${itemVO.itemTag== '��C����'}">checked</c:if>><label for="tag4">��C����</label>
                    <input type="radio" id="tag5" name="itemTag" class="tag" value="��L�ӫ~"
                    	<c:if test="${itemVO.itemTag== '��L�ӫ~'}">checked</c:if>><label for="tag5">��L�ӫ~</label>
                    

             </th>

            </tr>


        </table>

        <div class="pic" id="preview">
            <img src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}" >
        </div>
        <label class="buttem">����ɮ�
            <input type="file" id="p_file" name="itemPic" size="50" />
        </label>
        

        <div class="pic1" id="preview1">
            <img src="<%=request.getContextPath()%>/shop/ItemPic1?itemId=${itemVO.itemId}"">
        </div>
        <label class="buttem1">����ɮ�
            <input type="file" id="p_file1" name="pic1" size="50" />
        </label>

        <div class="pic2" id="preview2">
            <img src="<%=request.getContextPath()%>/shop/ItemPic2?itemId=${itemVO.itemId}"">
        </div>
        <label class="buttem2">����ɮ�
            <input type="file" id="p_file2" name="pic2" size="50" />
        </label>
        

        <div class="pic3" id="preview3">
            <img src="<%=request.getContextPath()%>/shop/ItemPic3?itemId=${itemVO.itemId}"">
        </div>
        <label class="buttem3">����ɮ�
            <input type="file" id="p_file3" name="pic3" size="50" />
        </label>

			<button class="modification" type="submit" >�ק�q�v���</button> 
			<input type="hidden" name="itemId"  value="${itemVO.itemId}">
			<input type="hidden" name="action"	value="update">
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
            var reader = new FileReader(); // �Ψ�Ū���ɮ�
            reader.addEventListener("load", function () {
                //console.log(reader.result);
                let img_node = document.createElement("img");
                img_node.setAttribute("src", reader.result); // <img src="abdafaewre">
                img_node.setAttribute("class", "preview_img"); // <img src="abdafaewre" class="preview_img">
                preview_el.innerHTML = '';
                preview_el.append(img_node);
            });
            reader.readAsDataURL(file); // Ū���ɮ�
        };

        p_file_el.addEventListener("change", function (e) {
            if (this.files.length > 0) {
                preview_img(this.files[0]);
            } else {
                preview_el.innerHTML = '<span class="text">�w����</span>';
            }
        });

        var preview1_el = document.getElementById("preview1");
        var p_file1_el = document.getElementById("p_file1");
        var preview1_img = function (file) {
            var img1_node = document.createElement("img");
            var reader1 = new FileReader(); // �Ψ�Ū���ɮ�
            reader1.addEventListener("load", function () {
                //console.log(reader.result);
                let img1_node = document.createElement("img");
                img1_node.setAttribute("src", reader1.result); // <img src="abdafaewre">
                img1_node.setAttribute("class", "preview1_img"); // <img src="abdafaewre" class="preview_img">
                preview1_el.innerHTML = '';
                preview1_el.append(img1_node);
            });
            reader1.readAsDataURL(file); // Ū���ɮ�
        };

        p_file1_el.addEventListener("change", function (e) {
            if (this.files.length > 0) {
                preview1_img(this.files[0]);
            } else {
                preview1_el.innerHTML = '<span class="text">�w����</span>';
            }
        });


        var preview2_el = document.getElementById("preview2");
        var p_file2_el = document.getElementById("p_file2");
        var preview2_img = function (file) {
            var img2_node = document.createElement("img");
            var reader2 = new FileReader(); // �Ψ�Ū���ɮ�
            reader2.addEventListener("load", function () {
                //console.log(reader.result);
                let img2_node = document.createElement("img");
                img2_node.setAttribute("src", reader2.result); // <img src="abdafaewre">
                img2_node.setAttribute("class", "preview2_img"); // <img src="abdafaewre" class="preview_img">
                preview2_el.innerHTML = '';
                preview2_el.append(img2_node);
            });
            reader2.readAsDataURL(file); // Ū���ɮ�
        };

        p_file2_el.addEventListener("change", function (e) {
            if (this.files.length > 0) {
                preview2_img(this.files[0]);
            } else {
                preview2_el.innerHTML = '<span class="text">�w����</span>';
            }
        });


        var preview3_el = document.getElementById("preview3");
        var p_file3_el = document.getElementById("p_file3");
        var preview3_img = function (file) {
            var img3_node = document.createElement("img");
            var reader3 = new FileReader(); // �Ψ�Ū���ɮ�
            reader3.addEventListener("load", function () {
                //console.log(reader.result);
                let img3_node = document.createElement("img");
                img3_node.setAttribute("src", reader3.result); // <img src="abdafaewre">
                img3_node.setAttribute("class", "preview3_img"); // <img src="abdafaewre" class="preview_img">
                preview3_el.innerHTML = '';
                preview3_el.append(img3_node);
            });
            reader3.readAsDataURL(file); // Ū���ɮ�
        };

        p_file3_el.addEventListener("change", function (e) {
            if (this.files.length > 0) {
                preview3_img(this.files[0]);
            } else {
                preview3_el.innerHTML = '<span class="text">�w����</span>';
            }
        });


        


    </script>
</body>

</html>