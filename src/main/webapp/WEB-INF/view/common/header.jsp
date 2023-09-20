<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="header">
	<div class="header_left">
		<a href="/">Melon</a>
		<form action="/search" method="get">
			<div class="header_left_read">
				<i class="fa-solid fa-magnifying-glass"></i>
			</div>
			<input type="text" name="songName">
		</form>
	</div>
	<c:if test="${empty user}">
		<div class="header_right">
			<form action="/login" method="GET">
				<button>로그인</button>
			</form>
			<form action="/join" method="GET">
				<button>회원가입</button>
			</form>
		</div>
	</c:if>
	<c:if test="${!empty user}">
		<div class="header_right">
			<c:if test="${user.role == 0}">
				<form action="/ticket" method="GET">
					<button>이용권 구매</button>
				</form>
				<form action="/login/logout" method="GET">
					<button>로그아웃</button>
				</form>
			</c:if>
			<c:if test="${user.role == 1}">
				<form action="/admin" method="GET">
					<button>관리자 페이지</button>
				</form>
				<form action="/login/logout" method="GET">
					<button>로그아웃</button>
				</form>
			</c:if>
		</div>
	</c:if>
	<aside class="aside">
		<div class="playsong_info">
			<c:if test="${empty user}">
				<img src="<%=request.getContextPath()%>/resources/Img/default.png">
				<p>&nbsp;</p>
				<p>
					<span>&nbsp;</span>
				</p>
				<p class="noneuser">
					<a href="" class="white" id="noneuser"><strong>♥</strong></a>
				</p>
				<p>&nbsp;</p>
				<div class="playsong_oper">
					<div class="playsong_oper_wrap">
						<a id="play" href=""><i class="fa-solid fa-play"></i></a> <a
							id="pause" href=""><i class="fa-solid fa-pause"></i></a> <a
							id="shuffle" href="" class="shuffle"><i
							class="fa-solid fa-shuffle"></i></a> <a id="volume" href=""><i
							class="fa-solid fa-volume-off"></i></a>
					</div>
				</div>
				<div class="playsong_info_ck">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</div>
			</c:if>
			<c:if test="${!empty user}">
				<!-- 회원 재생 목록 구현-->
				<c:set var="pd" value="${pd}"/>
				<img src="<%=request.getContextPath()%>/resources/Img/default.png" class="playlist_main_img">
				<p class="play_now_song_name"></p>
				<p class="play_now_artist_name">
					<span></span>
				</p>
				<p id="like_btn">
					<a href="#" class="white"><strong>♥</strong></a>
				</p>
				<p class="play_now_song_time">00:00 | 00:00</p>
				<div class="playsong_oper">
					<div class="playsong_oper_wrap">
						<a href=""><i class="fa-solid fa-play"></i></a> <a href=""><i
							class="fa-solid fa-pause"></i></a> <a href=""><i
							class="fa-solid fa-shuffle"></i></a> <a href=""><i
							class="fa-solid fa-volume-off"></i></a>
					</div>
				</div>
			</c:if>
		</div>
		<c:if test="${empty user}">
			<div class="playsong_info_ck">
				<p>&nbsp;</p>
				<p>&nbsp;</p>
			</div>
			<div class="playsong_list">
				<!-- 비회원-->
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
				<p class="playlist_size">${pd.size()}곡</p>
				<p>삭제</p>
			</div>
			<div class="playsong_list">
				<!-- 동적으로 생성-->
				<ul>
					<c:forEach var="pd" items="${pd}">
						<li class="playsong_list_wrap"><input type="checkbox">
							<img
							src="<%=request.getContextPath()%>/resources/Img/song/${pd.songName}.jpg">
							<div class="playsong_list_wrap_div">
								<p>${pd.songName}</p>
								<p>${pd.artistName}</p>
							</div></li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	</aside>
</header>
<script>
	$(document).ready(function() {
		$('#like_btn').on('click', function(e) {
			$('.white').toggleClass('green');
		});
	})

	const moveLinks = [ "noneuser", "play", "pause", "shuffle", "volume" ];
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