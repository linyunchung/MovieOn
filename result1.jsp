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
    <title>Document</title>

</head>
<body>
<style>
table, th, td {
    border:1px solid black;
  }


  table {
    /* font-family: arial, sans-serif; */
    border-collapse: collapse;
    width: 100%;
  }
  
  td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
  }
</style>
        <div class=search>
        <form action="<%=request.getContextPath()%>/prob/prob.do" method="post" name="result1">
            <label for="question-type">問題類型</label><br>
            <select name="probtype" id="probtype" class="qa-select">
                <option value="帳號" selected="selected" >帳號問題</option>
                <option value="訂單">訂單問題</option>
                <option value="發票">發票問題</option>
                <option value="商品">商品問題</option>
                <option value="其他">其他問題</option>
                <option value="全部">全部</option>
            </select><br><br>
            <input type="hidden" name="action" value="getType_For_Display">
            <input type="submit" value="送出查詢">
               
        </form>
    </div>
<% if(request.getAttribute("list")!=null){ %>
<jsp:include page="/emp/result2.jsp"/>
<%} %>

    
</body>
</html>