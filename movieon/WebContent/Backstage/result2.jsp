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
body{
 background-color: #262626;
 color:#FFFFFF;
 font-size: 16px;
 font-family: 'Noto Sans TC', sans-serif !important;
 font-weight: 600;
 text-transform: none;

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
  width: 60px;
  height:30px;
  border: 1px solid#FFBE0B;
  background-color:#FFBE0B;
  border-radius: 5px;
  color: black;
  position: relative;
}



#search:active{
  left: 1.1px;
  bottom: -1.1px;
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
                <td class="td2">${probVO.probtime}</td>
                <td class="td3">${probVO.probtype}</td>
                <td class="td4">${probVO.content}</td>
                <td class="td5">${probVO.email}</td>
            </tr>
</c:forEach>            
        </table>
        
    </div>
</body>
</html>