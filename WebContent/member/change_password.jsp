<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="css/change_password.css" type="text/css" rel="stylesheet" >
</head>
<body>
  <div class="body">
        <div class="p">
            <p>�󴫱K�X</p>
            <div class="nav">
                <ul id="menu">
                    <li><a href="acct_info.jsp">�b����T</a></li>
                    <li><a>�󴫱K�X</a></li>
                    <li><a href="profile.jsp">�ӤH���</a></li>
                    <li><a href="add_cc.jsp">�b��]�w</a></li>
                </ul>
            </div>
            <form action="#" method="post" id="c_password">
                <div class="ch_pwd"> 
                    <div class="box"></div>
                    <hr id="u_hr">
                    </div>
                    <div class="row">
                        <div id="question">
                            <label>�±K�X</label>
                        </div>
                        <div id="answer">
                            <input type="password" name="password" id="password" minlength="8" maxlength="16">
                        </div>
                        <div id="remind">
                            <span>*����</span>
                        </div>
                    </div>
                    <div class="row">
                        <div id="question">
                            <label>�s�K�X</label>
                        </div>
                        <div id="answer">
                            <input type="password" name="password" id="new_password" minlength="8" maxlength="16">
                        </div>
                        <div id="remind">
                            <span>*����8�Ӧr���H�W���t�ť�</span>
                        </div>
                    </div> 
                    <div class="row">
                        <div id="question">
                            <label>�T�{�s�K�X</label>
                        </div>
                        <div id="answer">
                            <input type="password" name="password" id="c_new_password" minlength="8" maxlength="16">
                        </div>
                        <div id="remind">
                            <span>*�A��J�@���s�K�X</span>
                        </div>
                    </div>
                    <div>
                        <hr>  
                        <button type="submit" id="cancel">����</button>
                        <button type="submit" id="save">�x�s</button>
                    </div>  
                </div>     
            </form>
        </div>
    </div>
</body>
</html>