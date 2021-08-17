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
            <p>更換密碼</p>
            <div class="nav">
                <ul id="menu">
                    <li><a href="acct_info.jsp">帳號資訊</a></li>
                    <li><a>更換密碼</a></li>
                    <li><a href="profile.jsp">個人資料</a></li>
                    <li><a href="add_cc.jsp">帳戶設定</a></li>
                </ul>
            </div>
            <form action="#" method="post" id="c_password">
                <div class="ch_pwd"> 
                    <div class="box"></div>
                    <hr id="u_hr">
                    </div>
                    <div class="row">
                        <div id="question">
                            <label>舊密碼</label>
                        </div>
                        <div id="answer">
                            <input type="password" name="password" id="password" minlength="8" maxlength="16">
                        </div>
                        <div id="remind">
                            <span>*必填</span>
                        </div>
                    </div>
                    <div class="row">
                        <div id="question">
                            <label>新密碼</label>
                        </div>
                        <div id="answer">
                            <input type="password" name="password" id="new_password" minlength="8" maxlength="16">
                        </div>
                        <div id="remind">
                            <span>*長度8個字元以上不含空白</span>
                        </div>
                    </div> 
                    <div class="row">
                        <div id="question">
                            <label>確認新密碼</label>
                        </div>
                        <div id="answer">
                            <input type="password" name="password" id="c_new_password" minlength="8" maxlength="16">
                        </div>
                        <div id="remind">
                            <span>*再輸入一次新密碼</span>
                        </div>
                    </div>
                    <div>
                        <hr>  
                        <button type="submit" id="cancel">取消</button>
                        <button type="submit" id="save">儲存</button>
                    </div>  
                </div>     
            </form>
        </div>
    </div>
</body>
</html>