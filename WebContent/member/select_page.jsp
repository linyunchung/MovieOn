<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h3>��Ƭd��:</h3>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
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
        <b>��J�|��ID(�p3):</b>
        <input type="text" name="userid">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="memberSvc" scope="page" class="com.member.model.MemberService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" >
       <b>��ܷ|��ID:</b>
       <select size="1" name="userid">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.userid}">${memberVO.userid}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" >
       <b>��ܷ|���m�W:</b>
       <select size="1" name="userid">
         <c:forEach var="memberVO" items="${memberSvc.all}" > 
          <option value="${memberVO.userid}">${memberVO.name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>

<h3>�|���޲z</h3>

<ul>
	<li><a href='<%=request.getContextPath()%>/member/addMember.jsp'>add</a> a new Member.</li>
</ul>

</body>
</html>