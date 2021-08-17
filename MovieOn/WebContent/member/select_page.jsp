<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h3>資料查詢:</h3>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='<%=request.getContextPath()%>/member/listAllMember.jsp'>List</a> all Members.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" >
        <b>輸入會員ID(如3):</b>
        <input type="text" name="userid">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="memberSvc" scope="page" class="com.member.model.MemberService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" >
       <b>選擇會員ID:</b>
       <select size="1" name="userid">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.userid}">${memberVO.userid}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" >
       <b>選擇會員姓名:</b>
       <select size="1" name="userid">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.userid}">${memberVO.name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>

<h3>會員管理</h3>

<ul>
	<li><a href='<%=request.getContextPath()%>/member/addMember.jsp'>add</a> a new Member.</li>
</ul>

</body>
</html>