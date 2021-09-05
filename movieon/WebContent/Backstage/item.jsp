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
    <link rel="stylesheet" href="css/item.css">
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
                <th>�ӫ~�W�١G${itemVO.itemName}</th>
            </tr>
            <tr>
                <th>����GNT$ ${itemVO.price}</th>
            </tr>
            <tr>
                <th>�w�s�q�G${itemVO.inventory}</th>
            </tr>
            <tr>
                <th>�W�[��� �G${itemVO.shelfDate}</th>
            </tr>

            <tr>
                <th>�W�� �G</th><br>

            </tr>
            <tr>
                <td>
                	<div class="productSpecifications_div">${itemVO.productSpecifications}</div>
                </td>
            </tr>
            <tr>
                <th>²���G</th><br>
            </tr>
            <tr>
                <td>
                	<div class="introduction_div">${itemVO.introduction}</div>
                </td>
            </tr>
            <tr>
                <th>�ӫ~���O�G${itemVO.itemTag}<br>
                    

             </th>

            </tr>


        </table>

        <div class="pic" id="preview">
            <img src="<%=request.getContextPath()%>/shop/ItemPic?itemId=${itemVO.itemId}" >
        </div>
        

        <div class="pic1" id="preview1">
            <img src="<%=request.getContextPath()%>/shop/ItemPic1?itemId=${itemVO.itemId}">
        </div>

        <div class="pic2" id="preview2">
            <img src="<%=request.getContextPath()%>/shop/ItemPic2?itemId=${itemVO.itemId}">
        </div>
        

        <div class="pic3" id="preview3">
            <img src="<%=request.getContextPath()%>/shop/ItemPic3?itemId=${itemVO.itemId}">
        </div>

			<button class="modification" type="submit" >�ק�ӫ~���</button> 
			<input type="hidden" name="itemId"  value="${itemVO.itemId}">
			<input type="hidden" name="action"	value="getOne_For_Update">
			</FORM>
			<button class="back" onclick="window.location.href='itemSearch.jsp'">�^��W�@��</button>
			
		</li>
    </div>








    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../js/nav.js"></script>

    
</body>

</html>