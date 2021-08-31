<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>    
    
<%
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/acct_info.css" type="text/css" rel="stylesheet" >
</head>
<body>
<div class="header"><jsp:include page="index.jsp" /></div>
    <div class="body">
        <div class="p">
            <p>�b���T</p>
            <div class="nav">
                <ul id="menu">
                    <li><a>�b����T</a></li>
                    <li><a href="${pageContext.request.contextPath}/member/change_password.jsp">�󴫱K�X</a></li>
                    <li><a href="${pageContext.request.contextPath}/member/profile.jsp">�ӤH���</a></li>
                    <li><a href="${pageContext.request.contextPath}/member/add_cc.jsp">�b��]�w</a></li>
                </ul>
            </div>
        </div>    
        <form action="#" method="post" id="acct_info">
            <div class="acct_div"> 
                <div class="box"></div>
                <hr id="u_hr">
            </div> 
            <div class="info">
                <div id="row">
                    <div class="left">
                        <a>�|��ID</a>
                    </div>
                    <div class="right">
                        <a>${memberVO.userid}</a>
                    </div>
                </div>
                <div id="row">
                    <div class="left">
                        <a>�|���W��</a>
                    </div>
                    <div class="right">
                        <a>${memberVO.username}</a>
                    </div>
                </div>
                <div id="row">
                    <div class="left">
                        <a>�q�l�l��</a>
                    </div>
                    <div class="right">
                        <a>${memberVO.email}</a>
                    </div>
                </div>
                <div id="row">
                    <div class="left">
                        <a>���U���</a>
                    </div>
                    <div class="right">
                        <a>${memberVO.joindate}</a>
                    </div>
                </div>
                <div id="row">
                    <hr id="u_hr">
                </div>

            </div>   
        </form>
    </div>
</body>
</html>