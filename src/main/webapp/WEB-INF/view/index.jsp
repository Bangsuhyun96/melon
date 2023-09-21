<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kor">
<%@ include file="/WEB-INF/view/common/front_header.jsp" %>
<link href="<%=request.getContextPath()%>/resources/css/index.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<section class="sec1">
    <%@ include file="/WEB-INF/view/common/aside.jsp" %>
    <div class="wrap">
        <div class="with_playlist">
        <c:if test="${empty user}">
        	<h3>함께 들어요 → </h3>
        </c:if>
        <c:if test="${!empty user}">
        	<c:if test="${!empty user.nick }">
        		<h3>${user.nick}님 함께 들어요 → </h3>
        	</c:if>
        	<c:if test="${empty user.nick }">
        		<h3>${user.name}님 함께 들어요 → </h3>
        	</c:if>
        </c:if>
            <table>
                <tbody>
                    <c:forEach var="item" items="${fourAlbum}">
                        <tr>
                            <td><a href="/album/${item.albumId}"><img src="<%=request.getContextPath()%>/resources/Img/song/${item.songName}.jpg" alt="앨범 이미지"></a></td>
                            <td><a href="/album/${item.albumId}"><p>${item.albumName}</p></a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="main_topsong">
            <h3>TOP100 →</h3>
            <div class="main_topsong_wrap">
                <table id="top_chart1">
                    <tbody style="position: relative; display: flex; justify-content: space-between; flex-wrap: wrap;">
                    <c:forEach var="item" items="${topMusic}" varStatus="loop">
                        <tr style="margin: 10px">
                            <td class="topsong_fst">
                                <a href="/album/${item.albumId}"><img src="<%=request.getContextPath()%>/resources/Img/song/${item.songName}.jpg"></a>
                            </td>
                            <td class="topsong_sec">
                                <p>${loop.index+i+1}</p>
                                <p>-</p>
                            </td>
                            <td class="topsong_thd">
                                <div>
                                    <a class="play_song"><p>${item.songName}</p></a>
                                    <a href="/artist/${item.artistId}"><p>${item.artistName}</p></a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
        <div class="sug_newsong">
            <h3>추천 음악 →</h3>
            <table>
                <tbody>
                    <tr>
                        <c:forEach var="item" items="${recommendSong}">
                            <td>
                                <a href="/album/${item.albumId}"><img src="<%=request.getContextPath()%>/resources/Img/song/${item.songName}.jpg"></a>
                                <div>
                                    <p class="play_song">${item.songName}</p>
                                    <a href="/artist/${item.artistId}"><p>${item.artistName}</p></a>
                                </div>
                            </td>
                        </c:forEach>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="my_music">
<%--            <h3>마이 뮤직 →</h3>--%>
            <table>
                <tbody>
                <c:if test="${not empty myMusic}">
                    <c:forEach var="item" items="${myMusic}">
                        <tr>
                            <td><img src="<%=request.getContextPath()%>/resources/Img/song/${item.songName}"></td>
                            <td><p class="play_song">${item.songName}</p></td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>
