<%@page import="java.sql.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.prob.model.*"%>
<%@ page import="java.util.*"%>

<%
//   EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>

<%

%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Backstage/css/header.css">
    <title>�ȪA����X�CMovieOn-</title>

</head>
<body>
<style>
body{
 background-color: #262626;
 color:#FFFFFF;
 font-size: 16px;
 font-family: 'Noto Sans TC', sans-serif !important;
 font-weight: 600;

}

table, th, td {
  border:1px solid black;
}


table {
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

.td1{
  width: 70px;
  font-size: 12px;  
}

.td2{
  width: 70px;
  font-size: 12px;  
}

.td3{
  width: 70px;
  font-size: 12px;  
}

.td4{
  width: 600px; 
  font-size: 12px; 
}

.td5{
  width:200px; 
  font-size: 12px; 
}

#search{
  display:inline-block;
  font-family: 'Noto Sans TC', sans-serif !important;
  font-size: 14px;
  font-weight:bold;
  width: 80px;
  height:30px;
  border: 0;
  padding:0;
  background-color:#FFBE0B;
  border-radius: 5px;
  color: black;
  margin-bottom: 20px;
    
}



#search:active{
  left: 1.1px;
  bottom: -1.1px;
}
</style>


<div id="header">
        <a href="<%=request.getContextPath()%>/Backstage/backstage.html" class="logo">
            <img src="<%=request.getContextPath()%>/Backstage/img/logo.png" alt="">
        </a>
        <nav>

            <ul>

                <li class="dropdown">
                    <a href="">�|���޲z</a>
                    	<ul>
	                        <li><a href="<%=request.getContextPath()%>/Backstage/memberDataSearch.jsp">�|����Ƭd��</a></li>
	                        <li><a href="<%=request.getContextPath()%>/Backstage/result1.jsp">�|��QA</a></li>
	                    </ul>
                </li>

                

                <li class="dropdown">
                    <a href="">�q�v�޲z</a>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/Backstage/movieDataSearch.jsp">�w�W�[�q�v�޲z</a></li>
                        <li><a href="<%=request.getContextPath()%>/Backstage/movieDataInsert.jsp">�W�[�s�q�v</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">�ӫ~�޲z</a>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/Backstage/itemSearch.jsp">�w�W�[�ӫ~�޲z</a></li>
                        <li><a href="<%=request.getContextPath()%>/Backstage/itemInsert.jsp">�W�[�s�ӫ~</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">�q�v�ɨ��</a>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/Backstage/backstage_add_theater.jsp">�W�[�v����</a></li>
                        <li><a href="<%=request.getContextPath()%>/Backstage/backstage_add_time.jsp">�s�W�q�v�ɨ��</a></li>
                        <li><a href="<%=request.getContextPath()%>/Backstage/backstage_showing_select.jsp">�w�W�[�޲z</a></li>
                    </ul>
                </li>


            </ul>

            <button class="signin">
                <a href="<%=request.getContextPath()%>/Backstage/backstage.html">�^�쭺��</a>
            </button>

        </nav>

    </div>

        <div class=search>
        <form action="<%=request.getContextPath()%>/prob/prob.do" method="post" name="result1">
            <label for="question-type">���D����</label><br>
            <select name="probtype" id="probtype" class="qa-select">
                <option value="�b��" selected="selected" >�b�����D</option>
                <option value="�q��">�q����D</option>
                <option value="�o��">�o�����D</option>
                <option value="�ӫ~">�ӫ~���D</option>
                <option value="��L">��L���D</option>
                <option value="����">����</option>
            </select><br><br>
            <input type="hidden" name="action" value="getType_For_Display">
            <input type="submit"   id="search" value="�d��">
               
        </form>
    </div>
    
    
<% if(request.getAttribute("list")!=null){ %>
<jsp:include page="/Backstage/result2.jsp"/>
<%} %>

    
</body>
</html>