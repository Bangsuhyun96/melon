<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html lang="kor">
<%@ include file="/WEB-INF/view/common/front_header.jsp" %>
<link href="<%=request.getContextPath()%>/resources/css/artist/artist.css" rel="stylesheet">

<body>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<section class="sec1">
    <%@ include file="/WEB-INF/view/common/aside.jsp" %>
    <div class="wrap">
        <div class="container">
            <div class="artist_top">
                <div class="artist_top_img">
                    <div class="artist_img">
                        <img src="<%= request.getContextPath() %>/resources/Img/artist/${artistInfo.artistName}.jpg" alt="노래 이미지">
                    </div>
                </div>
                <div class="artist_top_text">
                    <div class="artist_top_text_box">
                        <div class="artist_top_name"><p>${artistInfo.artistName}</p></div>
                        <div class="artist_top_hart_play">
                            <div class="hart_box">
                                <c:if test="${empty artistCnt}">
                                    <div class="hart" id="hartCntAdd" data-isArtistEmpty="true"><strong>♡ &nbsp;</strong></div>
                                </c:if>
                                <c:if test="${not empty artistCnt}">
                                    <div class="hart" id="hartCntDel" data-isArtistEmpty="false"><strong>♥ &nbsp;</strong></div>
                                </c:if>
                                <div class="hart_count"><fmt:formatNumber value="${artistInfo.artistLike}" type="number" pattern="###,###"/></div>
                                <input type="hidden" id="artistInfoArtistId" name="artistInfoArtistId" value="${artistInfo.artistId}"/>
                            </div>
                            <div class="play_btn_box">
                                <div class="play_btn"><i class="fa-solid fa-play"></i></div>
                                <div class="rep_song">${artistInfo.songName}</div>
                            </div>
                        </div>
                        <div class="artist_top_agency">
                            <div class="agency"><p>소속사</p></div>
                            <c:choose>
                                <c:when test="${empty artistInfo.agency}">
                                    <div class="agency_name"><p>없음</p></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="agency_name"><p>${artistInfo.agency}</p></div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
            <div class="artist_menu">
                <div class="artist_menu_left">
                    <div class="artist_left_song">
                        <div class="artist_left_song_text">
                            <p class="show_table active" onclick="showTable()">곡</p>
                        </div>
                    </div>
                    <div class="artist_left_detail">
                        <div class="artist_left_detail_text">
                            <p class="show_album" onclick="showAlbum()">앨범</p>
                        </div>
                    </div>
                    <div class="artist_left_comment">
                        <div class="artist_left_comment_text">
                            <p class="show_info" onclick="showInfo()">상세정보</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="artist_sort_and_play">
                <div class="artist_song_sort_box">
                    <div class="artist_song_latest_box">
                        <span class="artist_song_latest_text sort">최신순</span>
                    </div>
                    <div class="artist_song_popularity_box">
                        <span class="artist_song_popularity_text">인기순</span>
                    </div>
                    <div class="artist_song_alphabetically_box">
                        <span class="artist_song_alphabetically_text">가나다순</span>
                    </div>
                </div>
                <div class="artist_select_and_play">
                    <div class="artist_menu_right">
                        <div class="artist_right_select">
                            <div class="artist_right_select_btn" onclick="selectAll()">
                                <i class="fa-solid fa-check"></i>&nbsp
                                <span class="select_btn">전체선택</span>
                            </div>
                        </div>
                        <div class="artist_right_play">
                            <div class="artist_right_select_play">
                                <i class="fa-solid fa-play"></i>&nbsp
                                <span class="play_btn">전체재생</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table class="song_tb">
                <thead class="head_th">
                <tr>
                    <th><input type="checkbox" class="check_tb"></th>
                    <th>
                        <p>앨범</p>
                        <p>곡명</p>
                    </th>
                    <th><p>아티스트명</p></th>
                    <th><p>앨범명</p></th>
                    <th><p>발매일</p></th>
                    <th><p>좋아요</p></th>
                    <th><p>재생</p></th>
                </tr>
                </thead>
                <tbody class="body_tb" id="artistSongsTable">
                <c:forEach items="${artistSongs}" var="song">
                    <tr>
                        <td><input type="checkbox" class="check_tb"></td>
                        <td>
                            <div class="artist_song_name_box_tb">
                                <div class="artist_album_pic">
                                    <img src="<%= request.getContextPath() %>/resources/Img/song/${song.songName}.jpg" alt="노래 이미지">
                                </div>
                                <div class="artist_song_name_tb"><p>${song.songName}</p></div>
                            </div>
                        </td>
                        <td>
                            <div class="artist_name_tb"><p>${song.artistName}</p></div>
                            <input type="hidden" name="artistId" value="${song.artistId}" id="artistId"/>
                        </td>
                        <td>
                            <a href="/album/${song.albumId}" class="artist_album_name_tb"><p>${song.albumName}</p></a>
                            <input type="hidden" name="albumId" value="${song.albumId}" id="albumId">
                        </td>
                        <td>
                            <p id="song_releaseDate">${song.releaseDate}</p>
                        </td>
                        <td>
                            <p class="song_hart"><strong>♡ &nbsp</strong></p>
                            <p class="song_hart_count">${song.songLike}</p>
                            <input type="hidden" name="songId" class="songId" value="${song.songId}"/>
                        </td>
                        <td>
                            <p><i class="fa-solid fa-play"></i></p>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="artist_album" style="display: none" id="artistAlbumsList">
                <div class="artist_album_list">
                    <c:forEach items="${removeDuplication}" var="albums">
                        <input type="hidden" name="albumArtistId" value="${albums.artistId}" id="albumArtistId"/>
                        <div class="artist_album_list_box">
                            <div class="artist_album_list_img">
                                <a href="/album/${albums.albumId}"><img src="<%= request.getContextPath() %>/resources/Img/song/${albums.songName}.jpg" alt="노래 이미지"></a>
                            </div>
                            <div class="artist_album_text_box">
                                <a href="/album/${albums.albumId}"><p>${albums.albumName}</p></a>
                                <p>${albums.releaseDate}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="artist_info_body" style="display: none">
                <div class="artist_info_text_box">
                    <div class="artist_info_text">
                        <div class="artist_activity_info"><p>활동정보</p></div>
                        <div class="artist_debut">
                            <p>데뷔</p>
                            <c:choose>
                                <c:when test="${empty artistActivity.debut}">
                                    <p>알 수 없음</p>
                                </c:when>
                                <c:otherwise>
                                    <p>${artistActivity.debut}</p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="artist_recent_song">
                            <div class="artist_recent_song_text">
                                <p>최근곡</p>
                            </div>
                            <div class="artist_recent_album">
                                <p><i class="fa-solid fa-play"></i></p>
                                <img src="<%= request.getContextPath() %>/resources/Img/song/${artistActivity.songName}.jpg" alt="노래 이미지">
                            </div>
                            <div class="artist_song_name">
                                <p>${artistActivity.songName}</p>
                                <p>${artistActivity.artistName}</p>
                            </div>
                        </div>
                        <div class="artist_type">
                            <p>유형</p>
                            <p>${artistActivity.activityType}</p>
                        </div>
                        <div class="artist_group">
                            <p>소속그룹</p>
                            <p>${artistActivity.artistName}</p>
                        </div>
                    </div>
                </div>
                <div class="artist_pro_box">
                    <div class="artist_pro_text_box">
                        <p>아티스트 소개</p>
                    </div>
                    <div class="artist_pro_content_box">
                        <div class="artist_pro_content">
                            <div>${artistActivity.artistPro}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<script src="<%=request.getContextPath()%>/resources/js/artist.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</html>