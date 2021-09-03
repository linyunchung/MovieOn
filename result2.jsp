<%@page import="java.sql.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.prob.model.*"%>
<%@ page import="java.util.*"%>

<%
List<ProbVO> list = (List<ProbVO>)request.getAttribute("list");
pageContext.setAttribute("list",list);
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
  
  .td1{
  width: 70px;
  
  }
</style>
<table>
            <tr>
                <th>問題編號</th>
                <th>問題時間</th>
                <th>問題類型</th>
                <th>問題內容</th>
                <th>聯絡信箱</th>
            </tr>
<c:forEach var="probVO" items="${list}">            
            <tr>
                <td class="td1">${probVO.probno}</td>
                <td cl>${probVO.probtime}</td>
                <td>${probVO.probtype}</td>
                <td>${probVO.content}</td>
                <td>${probVO.email}</td>
            </tr>
</c:forEach>            
        </table>
        
    </div>
</body>
</html>