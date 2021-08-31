<%@page import="java.util.stream.Collectors"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.item.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
    itemService itemSvc = new itemService();
    List<itemVO> list = itemSvc.getAll();
//     list = list.stream().filter(m -> m.getItemId().equals(3016)).collect(Collectors.toList());
    pageContext.setAttribute("list",list);
%>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>��x�޲z��</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/itemGetAll.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap" rel="stylesheet">
	
</head>

 <div id="header">
        <a href="backstage.html" class="logo">
            <img src="img/logo.png" alt="">
        </a>
        <nav>

            <ul>

                <li class="dropdown">
                    <a href="">�|���޲z</a>
                    	<ul>
	                        <li><a href="#">�|����Ƭd��</a></li>
	                    </ul>
                </li>

                

                <li class="dropdown">
                    <a href="">�q�v�޲z</a>
                    <ul>
                        <li><a href="movieDataSearch.jsp">�w�W�[�q�v�޲z</a></li>
                        <li><a href="movieDataInsert.jsp">�W�[�s�q�v</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">�ӫ~�޲z</a>
                    <ul>
                        <li><a href="itemSearch.jsp">�w�W�[�ӫ~�޲z</a></li>
                        <li><a href="itemInsert.jsp">�W�[�s�ӫ~</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">�q�v�ɨ��</a>
                    <ul>
                        <li><a href="#">�W�[�s�q�v�ɨ��</a></li>
                    </ul>
                </li>


            </ul>

            <button class="signin">
                <a href="backstage.html">�^�쭺��</a>
            </button>

        </nav>

    </div>

<table>
	
			<c:forEach var="itemVO"  items="${list}" >
				
					
					       
					<div id="cover" class="coverflow">
        
					        <a href='#'><img class="img"  src="/MovieOn/ItemPic1?itemId=${itemVO.itemId}"></a>
					        <a href='#'><img class="img"  src="/MovieOn/ItemPic2?itemId=${itemVO.itemId}"></a>
					        <a href='#'><img class="img"  src="/MovieOn/ItemPic3?itemId=${itemVO.itemId}"></a>
					        <a href='#'><img class="img"  src="/MovieOn/ItemPic?itemId=${itemVO.itemId}" ></a>
					       
					        <div class="panel">�ӫ~�s���G${itemVO.itemId }<br>
					        								${itemVO.itemName }<br>
					        								<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/item.do">
																 
																<input type="hidden" name="itemId" value="${itemVO.itemId }">
																<input type="hidden" name="action" value="getOne_For_Display">
																<button class="send" type="submit">�d�ݸԲӸ��</button>
															</FORM>
					        </div>
				        
			   		 </div>
		   		 
	  		 </c:forEach>
	  		 <button class="back" onclick="window.location.href='itemSearch.jsp'">�^��W�@��</button>
			<div><br><br><hr type="hidden"></div>
	
</table>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script src="./js/index.js"></script>


</body>
</html>