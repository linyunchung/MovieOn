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
            <p>帳戶資訊</p>
            <div class="nav">
                <ul id="menu">
                    <li><a>帳號資訊</a></li>
                    <li><a href="${pageContext.request.contextPath}/member/change_password.jsp">更換密碼</a></li>
                    <li><a href="${pageContext.request.contextPath}/member/profile.jsp">個人資料</a></li>
                    <li><a href="${pageContext.request.contextPath}/member/add_cc.jsp">帳戶設定</a></li>
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
                        <a>會員ID</a>
                    </div>
                    <div class="right">
                        <a>${memberVO.userid}</a>
                    </div>
                </div>
                <div id="row">
                    <div class="left">
                        <a>會員名稱</a>
                    </div>
                    <div class="right">
                        <a>${memberVO.username}</a>
                    </div>
                </div>
                <div id="row">
                    <div class="left">
                        <a>電子郵件</a>
                    </div>
                    <div class="right">
                        <a>${memberVO.email}</a>
                    </div>
                </div>
                <div id="row">
                    <div class="left">
                        <a>註冊日期</a>
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