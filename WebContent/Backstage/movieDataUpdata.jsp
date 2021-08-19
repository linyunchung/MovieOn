<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="com.MovieTag.model.*"%>

<%
	MovieVO movieVO = (MovieVO) request.getAttribute("movieVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>
<%
	MovieTagVO movieTagVO = (MovieTagVO) request.getAttribute("movieTagVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>��x�޲z��</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/movieDataUpdata.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400&display=swap" rel="stylesheet">

</head>

<body>
    <div id="header">
        <a href="" class="logo">
            <img src="img/logo.png" alt="">
        </a>
        <nav>

            <ul>

                <li class="dropdown">
                    <a href="">�|����ƺ޲z</a>
                </li>

                <li class="dropdown">
                    <a href="">�ӫ�����</a>
                </li>

                <li class="dropdown">
                    <a href="">�q�v�޲z</a>
                    <ul>
                        <li><a href="#">�w�W�[�q�v�޲z</a></li>
                        <li><a href="#">�W�[�s�q�v</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">�ӫ~�޲z</a>
                    <ul>
                        <li><a href="#">�w�W�[�ӫ~�޲z</a></li>
                        <li><a href="#">�W�[�s�ӫ~</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">�q�v�ɨ��</a>
                    <ul>
                        <li><a href="#">�w�W�[�q�v�ɨ��޲z</a></li>
                        <li><a href="#">�W�[�s�q�v�ɨ��</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">�ȪA�^��</a>
                </li>

                <li class="dropdown">
                    <a href="">�q��޲z</a>
                </li>

            </ul>

            <button class="signin">
                <a href="">�^�쭺��</a>
            </button>

        </nav>

    </div>

    <div class="main">
        <h1 class="title">�q�v��ƺ޲z</h1>
        <h2 class="title2">�q�v��ƭק�</h2>

<li class="li1">
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do">
        <table class="table">
            <tr>
                <th>�q�v�s���G<%=movieVO.getMovieId()%></th>
                
            </tr>
            <tr>
                <th>�q�v�W�١G<input class="text" type="TEXT" name="movieName" size="45" value="<%=movieVO.getMovieName()%>" /></th>  
            </tr>
            <tr>
                <th>�^��W�١G<input class="text" type="TEXT" name="movieEName" size="45" value="<%=movieVO.getMovieEName()%>"  /></th>
            </tr>
            <tr>
                <th>�W�M����G<input class="text" type="TEXT" name="releaseDate" size="45" value="<%=movieVO.getReleaseDate()%>"  /></th>
            </tr>
            <tr>
                <th>�����G<input class="text" type="TEXT" name="mins" size="45" style="left: 31px;"value="<%=movieVO.getMins()%>"  /></th>
            </tr>
            <tr>
                <th>�o�椽�q�G<input class="text" type="TEXT" name="studio" size="45" value="<%=movieVO.getStudio()%>"  /></th>
            </tr>
            <tr>
                <th>�ɺt�G</th><br>
                
            </tr>
            <tr>
                <td><textarea name="plot" class="director_text" cols="30" rows="10"><%=movieVO.getDirector()%> </textarea></td>
            </tr>
            <tr>
                <th>�D�t�G</th><br>
                
            </tr>
            <tr>
                <td><textarea name="plot" class="actor_text" cols="30" rows="10"><%=movieVO.getActor()%></textarea> </td>
            </tr>
            <tr>
                <th>�q�v���СG</th><br>
            </tr>
            <tr>
                <td><textarea name="plot" class="plot_text" cols="30" rows="10"><%=movieVO.getPlot()%> </textarea>
                </td>
            </tr>
            <tr>
                <th>�������O�G<br>
                    <input type="checkbox" id="tag1" name="tag1" class="tag" value="�ʧ@��"><label for="tag1">�ʧ@��</label>
                    <input type="checkbox" id="tag2" name="tag2" class="tag" value="�߼@��"><label for="tag1">�߼@��</label>
                    <input type="checkbox" id="tag3" name="tag3" class="tag" value="�R����"><label for="tag1">�R����</label><br>
                    <input type="checkbox" id="tag4" name="tag4" class="tag" value="��ۤ�"><label for="tag1">��ۤ�</label>
                    <input type="checkbox" id="tag5" name="tag5" class="tag" value="���Ƥ�"><label for="tag1">���Ƥ�</label>
                    <input type="checkbox" id="tag6" name="tag7" class="tag" value="�@����"><label for="tag1">�@����</label><br>
                    <input type="checkbox" id="tag7" name="tag7" class="tag" value="�Ԫ���"><label for="tag1">�Ԫ���</label>
                    <input type="checkbox" id="tag8" name="tag8" class="tag" value="�ʵe��"><label for="tag1">�ʵe��</label>
                    <input type="checkbox" id="tag9" name="tag9" class="tag" value="���v��"><label for="tag1">���v��</label>
                </th>
                
            </tr>
            
            
        </table>

        <div class="pic">
            <img src="/MovieOn/DBGifReaderMovie?movieId= ${movieVO.movieId }"">
        </div>
        
        <input type="hidden" name="action" value="update">
		<input type="hidden" name="movieId" value="<%=movieVO.getMovieId()%>">
        <button class="confirm"  type="submit">�ק粒��</button>
        </FORM>
        
        </li>

    </div>








    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../js/nav.js"></script>
</body>

</html>