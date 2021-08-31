<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>��x�޲z��</title>
  <link rel="stylesheet" href="css/header.css">
  <link rel="stylesheet" href="css/memberDataSearch.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap" rel="stylesheet">
</head>


<body>
 <div id="header">
        <a href="backstage.html" class="logo">
            <img src="img/logo.png" alt="">
        </a>
        <nav>

            <ul>

                <li class="dropdown">
                    <a href="">�|���޲z</a>
                    	<ul>
	                        <li><a href="#">�|����Ƭd��</a></li>
	                    </ul>
                </li>

                

                <li class="dropdown">
                    <a href="">�q�v�޲z</a>
                    <ul>
                        <li><a href="movieDataSearch.jsp">�w�W�[�q�v�޲z</a></li>
                        <li><a href="movieDataInsert.jsp">�W�[�s�q�v</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">�ӫ~�޲z</a>
                    <ul>
                        <li><a href="itemSearch.jsp">�w�W�[�ӫ~�޲z</a></li>
                        <li><a href="itemInsert.jsp">�W�[�s�ӫ~</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">�q�v�ɨ��</a>
                    <ul>
                        <li><a href="#">�W�[�s�q�v�ɨ��</a></li>
                    </ul>
                </li>


            </ul>

            <button class="signin">
                <a href="backstage.html">�^�쭺��</a>
            </button>

        </nav>

    </div>

  <div class="main">
    <h1 class="title">�|����ƺ޲z</h1>

    <li class="li1">
      <FORM METHOD="post" ACTION="emp.do" >
        <input id="idSearch" class="input" autofocus placeholder='�|���s���j�M' type='text' name="memberId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <button class="send1" type="submit">�e�X</button>
      </FORM>

      


    </li>

    <!-- <input id="idSearch" class="input" autofocus placeholder='�|���s���j�M' type='text' name="memberId">
    <button class="send1" type="submit">�e�X</button>
    <input id="tagSearch" class="input" autofocus placeholder='�ߦn���O�j�M' type='text'>
    <button class="send2">�e�X</button> -->

    

  </div>








  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="../js/nav.js"></script>
</body>
</html>