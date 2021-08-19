<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="com.MovieTag.model.*"%>

<%
	MovieVO movieVO = (MovieVO) request.getAttribute("movieVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>
<%
	MovieTagVO movieTagVO = (MovieTagVO) request.getAttribute("movieTagVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>後台管理員</title>
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
                    <a href="">會員資料管理</a>
                </li>

                <li class="dropdown">
                    <a href="">商城報表</a>
                </li>

                <li class="dropdown">
                    <a href="">電影管理</a>
                    <ul>
                        <li><a href="#">已上架電影管理</a></li>
                        <li><a href="#">上架新電影</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">商品管理</a>
                    <ul>
                        <li><a href="#">已上架商品管理</a></li>
                        <li><a href="#">上架新商品</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">電影時刻表</a>
                    <ul>
                        <li><a href="#">已上架電影時刻表管理</a></li>
                        <li><a href="#">上架新電影時刻表</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="">客服回覆</a>
                </li>

                <li class="dropdown">
                    <a href="">訂單管理</a>
                </li>

            </ul>

            <button class="signin">
                <a href="">回到首頁</a>
            </button>

        </nav>

    </div>

    <div class="main">
        <h1 class="title">電影資料管理</h1>
        <h2 class="title2">電影資料修改</h2>

<li class="li1">
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Backstage/movie.do">
        <table class="table">
            <tr>
                <th>電影編號：<%=movieVO.getMovieId()%></th>
                
            </tr>
            <tr>
                <th>電影名稱：<input class="text" type="TEXT" name="movieName" size="45" value="<%=movieVO.getMovieName()%>" /></th>  
            </tr>
            <tr>
                <th>英文名稱：<input class="text" type="TEXT" name="movieEName" size="45" value="<%=movieVO.getMovieEName()%>"  /></th>
            </tr>
            <tr>
                <th>上映日期：<input class="text" type="TEXT" name="releaseDate" size="45" value="<%=movieVO.getReleaseDate()%>"  /></th>
            </tr>
            <tr>
                <th>片長：<input class="text" type="TEXT" name="mins" size="45" style="left: 31px;"value="<%=movieVO.getMins()%>"  /></th>
            </tr>
            <tr>
                <th>發行公司：<input class="text" type="TEXT" name="studio" size="45" value="<%=movieVO.getStudio()%>"  /></th>
            </tr>
            <tr>
                <th>導演：</th><br>
                
            </tr>
            <tr>
                <td><textarea name="plot" class="director_text" cols="30" rows="10"><%=movieVO.getDirector()%> </textarea></td>
            </tr>
            <tr>
                <th>主演：</th><br>
                
            </tr>
            <tr>
                <td><textarea name="plot" class="actor_text" cols="30" rows="10"><%=movieVO.getActor()%></textarea> </td>
            </tr>
            <tr>
                <th>電影介紹：</th><br>
            </tr>
            <tr>
                <td><textarea name="plot" class="plot_text" cols="30" rows="10"><%=movieVO.getPlot()%> </textarea>
                </td>
            </tr>
            <tr>
                <th>標籤類別：<br>
                    <input type="checkbox" id="tag1" name="tag1" class="tag" value="動作片"><label for="tag1">動作片</label>
                    <input type="checkbox" id="tag2" name="tag2" class="tag" value="喜劇片"><label for="tag1">喜劇片</label>
                    <input type="checkbox" id="tag3" name="tag3" class="tag" value="愛情片"><label for="tag1">愛情片</label><br>
                    <input type="checkbox" id="tag4" name="tag4" class="tag" value="科幻片"><label for="tag1">科幻片</label>
                    <input type="checkbox" id="tag5" name="tag5" class="tag" value="恐怖片"><label for="tag1">恐怖片</label>
                    <input type="checkbox" id="tag6" name="tag7" class="tag" value="劇情片"><label for="tag1">劇情片</label><br>
                    <input type="checkbox" id="tag7" name="tag7" class="tag" value="戰爭片"><label for="tag1">戰爭片</label>
                    <input type="checkbox" id="tag8" name="tag8" class="tag" value="動畫片"><label for="tag1">動畫片</label>
                    <input type="checkbox" id="tag9" name="tag9" class="tag" value="歷史片"><label for="tag1">歷史片</label>
                </th>
                
            </tr>
            
            
        </table>

        <div class="pic">
            <img src="/MovieOn/DBGifReaderMovie?movieId= ${movieVO.movieId }"">
        </div>
        
        <input type="hidden" name="action" value="update">
		<input type="hidden" name="movieId" value="<%=movieVO.getMovieId()%>">
        <button class="confirm"  type="submit">修改完成</button>
        </FORM>
        
        </li>

    </div>








    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../js/nav.js"></script>
</body>

</html>