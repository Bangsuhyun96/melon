<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside class="nav">
    <img src="<%=request.getContextPath()%>/resources/Img/melon_icon.png">
    <ul>
        <li><a href="/">멜론홈</a></li>
        <li><a href="/song/popular">인기차트</a></li>
        <li>
            <a href="/song/recente">최신음악</a>
            <ul>
                <li><a href="/song/recente">최신곡</a></li>
                <li><a href="/album/recente">최신앨범</a></li>
            </ul>
        </li>
        <li><a href="/genre/home">장르음악</a></li>
        <li><a href="/ticket">이용권 구매</a></li>
        <c:if test="${!empty user}">
            <c:if test="${user.role == 1}">
                <li><a href="/admin">관리자 페이지</a></li>
            </c:if>
        </c:if>
    </ul>
</aside>
<script>
    const moveLinks = ["music", "recente", "artist", "buy"];
    moveLinks.forEach(function(moveLink) {
        const linkElement = document.getElementById(moveLink);
        if (linkElement) {
            linkElement.addEventListener("click", function(event) {
                event.preventDefault();
                alert("로그인 후 이용 가능합니다.");
            });
        }
    });
</script>
