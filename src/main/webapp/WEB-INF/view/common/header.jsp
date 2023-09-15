<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="header">
    <div class="header_left">
        <a href="/">Melon</a>
        <form action="/search" method="get">
            <div class="header_left_read"><i class="fa-solid fa-magnifying-glass"></i></div>
            <input type="text" name="songName">
        </form>
    </div>
    <c:if test="${empty user}">
	    <div class="header_right">
	        <form action="/login" method="GET"><button>로그인</button></form>
	        <form action="/join" method="GET"><button>회원가입</button></form>
	    </div>
    </c:if>
    <c:if test="${!empty user}">
	    <div class="header_right">
            <c:if test="${user.role == 0}">
                <form action="/ticket" method="GET"><button>이용권 구매</button></form>
                <form action="/login/logout" method="GET"><button>로그아웃</button></form>
            </c:if>
            <c:if test="${user.role == 1}">
                <form action="/admin" method="GET"><button>관리자 페이지</button></form>
                <form action="/login/logout" method="GET"><button>로그아웃</button></form>
            </c:if>
	    </div>    	
    </c:if>
    <aside class="aside">
        <div class="playsong_info">
            <c:if test="${empty user}">
                <img src="<%=request.getContextPath()%>/resources/Img/default.png">
                <p>&nbsp;</p>
                <p><span>&nbsp;</span></p>
                <p class="noneuser"><a href="" class="white" id="noneuser"><strong>♥</strong></a></p>
                <p>&nbsp;</p>
                <div class="playsong_oper">
                    <div class="playsong_oper_wrap">
                        <a id="play" href=""><i class="fa-solid fa-play"></i></a>
                        <a id="pause" href=""><i class="fa-solid fa-pause"></i></a>
                        <a id="shuffle" href="" class="shuffle"><i class="fa-solid fa-shuffle"></i></a>
                        <a id="volume" href=""><i class="fa-solid fa-volume-off"></i></a>
                    </div>
                </div>
                <div class="playsong_info_ck">
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                </div>
            </c:if>
            <c:if test="${!empty user}"> <!-- 회원 재생 목록 구현-->
                <img src="<%=request.getContextPath()%>/resources/Img/.png">
                <p>Next Level</p>
                <p><span>aespa</span></p>
                <p id="like_btn"><a href="#" class="white"><strong>♥</strong></a></p>
                <p>00:00 | 04:15</p>
                <div class="playsong_oper">
                    <div class="playsong_oper_wrap">
                        <a href=""><i class="fa-solid fa-play"></i></a>
                        <a href=""><i class="fa-solid fa-pause"></i></a>
                        <a href="" class="shuffle"><i class="fa-solid fa-shuffle"></i></a>
                        <a href=""><i class="fa-solid fa-volume-off"></i></a>
                    </div>
                </div>
            </c:if>
        </div>
        <c:if test="${empty user}">
            <div class="playsong_info_ck">
                <p>&nbsp;</p>
                <p>&nbsp;</p>
            </div>
            <div class="playsong_list"> <!-- 비회원-->
                <ul>
                    <li class="playsong_list_wrap">
                        <div class="noneuser_chart">
                            <p>곡 목록이 없어요</p>
                            <p>멜론의 인기곡으로 재생을 시작해 보세요.</p>
                        </div>
                    </li>
                </ul>
            </div>
        </c:if>
        <c:if test="${!empty user}">
            <div class="playsong_info_ck">
                <input type="checkbox">
                <p>3곡</p>
                <p>삭제</p>
            </div>
            <div class="playsong_list"> <!-- 동적으로 생성-->
                <ul>
                    <li class="playsong_list_wrap">
                        <input type="checkbox">
                        <img src="<%=request.getContextPath()%>/resources/Img/next_level_img.png">
                        <div class="playsong_list_wrap_div">
                            <p>Next Level</p>
                            <p>aespa</p>
                        </div>
                    </li>
                    <li class="playsong_list_wrap">
                        <input type="checkbox">
                        <img src="<%=request.getContextPath()%>/resources/Img/album.png">
                        <div class="playsong_list_wrap_div">
                            <p>Hype boy</p>
                            <p>NewJeans</p>
                        </div>
                    </li>
                </ul>
            </div>
        </c:if>
    </aside>
</header>
<script>
    $(document).ready(function (){
        $('#like_btn').on('click', function (e){
            $('.white').toggleClass('green');
        });
    })

    const moveLinks = ["noneuser", "play", "pause", "shuffle", "volume"];
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
