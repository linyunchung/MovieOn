<%@page import="java.sql.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.prob.model.*"%>
<%@ page import="java.util.*"%>

<%
//   EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>

<%
	Locale locale = request.getLocale();
	Calendar calendar = Calendar.getInstance(locale);
	Date dateNow = new Date(calendar.getInstance().getTimeInMillis());
%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>�p���ȪA</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<style>
body{
background-color:#262626;
color:white
}


#description{
    resize: none;
}
</style>
    <form action="<%=request.getContextPath()%>/prob/prob.do" method="post" name="form1">
        <label for="question-type">���D����</label><br>
        <select name="probtype" id="probtype" class="qa-select">
            <option value="�b��" selected="selected" >�b�����D</option>
            <option value="�q��">�q����D</option>
            <option value="�o��">�o�����D</option>
            <option value="�ӫ~">�ӫ~���D</option>
            <option value="��L">��L���D</option>
        </select><br><br>
		<input value="<%=dateNow%>" type="hidden" id="probtime" name="probtime">
        <label for="question-content">���D���e</label><br>
        <textarea required id="content" placeholder="" name="content" rows="20" cols="80" class="qa-textarea"></textarea><br>
        <label for="email">E-mail�H�c</label>
        <input required type="email" id="email" name="email"><br><br>
        <input type="submit" value="�e�X���D">
        <input type="hidden" name="action" value="insert">
        </form>















</body>
</html>