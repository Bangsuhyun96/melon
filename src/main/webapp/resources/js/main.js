$(document).ready(function() {
	/*추가할 노래 가져오기*/
	const add_songs = document.querySelectorAll('.play_song');
	/*셔플*/
	const shuffle = document.querySelector('.shuffle');
	/*재생목록 추가*/
	/*add_songs.forEach((add_song, index) => {
		add_song.addEventListener('click', () => {
			const songName = document.querySelectorAll('.play_song')[index].textContent;
			$.ajax({
				url: "/playlist/add", // 국내 데이터를 불러올 서버 엔드포인트 지정
				method: "POST", // HTTP 메서드 (GET, POST 등)
				data: { add_song: songName },
				dataType: "json",
				success: function(data) {
					// Ajax 호출 성공 시 실행할 코드
					showPlayLists(data);
					// 여기에서 데이터를 화면에 표시하거나 다른 작업을 수행할 수 있습니다.
				},
				error: function(error) {
					// Ajax 호출 실패 시 실행할 코드
					console.error("Ajax 호출 실패:", error);
				}
			});
		});
	});*/
	/*ajax 이후 온클릭*/
	$(document).on('click', '.play_song', function() {
		const songName = $(this).text();
		console.log(songName);
		$.ajax({
			url: "/playlist/add", // 국내 데이터를 불러올 서버 엔드포인트 지정
			method: "POST", // HTTP 메서드 (GET, POST 등)
			data: { add_song: songName },
			dataType: "json",
			success: function(data) {
				// Ajax 호출 성공 시 실행할 코드
				showPlayLists(data);
				// 여기에서 데이터를 화면에 표시하거나 다른 작업을 수행할 수 있습니다.
			},
			error: function(error) {
				// Ajax 호출 실패 시 실행할 코드
				console.error("Ajax 호출 실패:", error);
			}
		});
		// 나머지 Ajax 요청 및 처리 로직은 동일합니다.
	});
	/*셔플된 재생목록 출력*/
	shuffle.addEventListener('click', () => {
		$.ajax({
			url: "/playlist/shuffle", // 국내 데이터를 불러올 서버 엔드포인트 지정
			method: "GET", // HTTP 메서드 (GET, POST 등)
			dataType: "json",
			success: function(data) {
				// Ajax 호출 성공 시 실행할 코드
				showPlayLists(data);
				// 여기에서 데이터를 화면에 표시하거나 다른 작업을 수행할 수 있습니다.
			},
			error: function(error) {
				// Ajax 호출 실패 시 실행할 코드
				console.error("Ajax 호출 실패:", error);
			}
		});
	});
});
document.addEventListener("DOMContentLoaded", function() {
	// thead에 있는 체크박스 요소를 가져옵니다.
	var theadCheckbox = document.querySelector("thead input[type='checkbox']");
	var playlistCheckbox = document.querySelector(".playsong_info_ck input[type='checkbox']")
	/*재생목록 삭제*/
	const playlist_delete = document.querySelector('.playlist_delete');
	// thead 체크박스의 상태가 변경될 때의 이벤트 리스너를 추가합니다.
	theadCheckbox.addEventListener("change", function() {
		// tbody에 있는 모든 체크박스 요소를 가져옵니다.
		var tbodyCheckboxes = document.querySelectorAll("tbody input[type='checkbox']");

		// thead 체크박스의 상태에 따라 tbody 체크박스의 상태를 변경합니다.
		for (var i = 0; i < tbodyCheckboxes.length; i++) {
			tbodyCheckboxes[i].checked = theadCheckbox.checked;
		}
	});
	playlistCheckbox.addEventListener("change", function() {
		// tbody에 있는 모든 체크박스 요소를 가져옵니다.
		var liCheckboxes = document.querySelectorAll("li input[type='checkbox']");

		// thead 체크박스의 상태에 따라 tbody 체크박스의 상태를 변경합니다.
		for (var i = 0; i < liCheckboxes.length; i++) {
			liCheckboxes[i].checked = playlistCheckbox.checked;
		}
	});

	/*체크박스가 선택된 노래 재생목록에 추가*/
	var getSelectedDataBtn = document.getElementById("allplay");

	// 버튼 클릭 이벤트에 대한 리스너를 추가합니다.
	getSelectedDataBtn.addEventListener("click", function() {
		// tbody에 있는 모든 체크박스 요소를 선택합니다.
		var tbodyCheckboxes = document.querySelectorAll("tbody input[type='checkbox']");

		// 선택된 체크박스의 정보를 저장할 배열을 만듭니다.
		var selectedData = [];

		// 체크박스를 순회하면서 선택된 체크박스의 정보를 가져옵니다.
		tbodyCheckboxes.forEach(function(checkbox) {
			if (checkbox.checked) {
				var row = checkbox.closest("tr"); // 체크박스가 속한 행(tr)을 가져옵니다.
				var rowData = row.querySelector(".play_song").textContent;

				selectedData.push(rowData);
			}
		});
		if (selectedData.length == 1) {
			$.ajax({
				url: "/playlist/add/", // 국내 데이터를 불러올 서버 엔드포인트 지정
				method: "POST", // HTTP 메서드 (GET, POST 등)
				data: { add_song: selectedData[0] },
				dataType: "json",
				success: function(data) {
					// Ajax 호출 성공 시 실행할 코드
					showPlayLists(data);
					// 여기에서 데이터를 화면에 표시하거나 다른 작업을 수행할 수 있습니다.
				},
				error: function(error) {
					// Ajax 호출 실패 시 실행할 코드
					console.error("Ajax 호출 실패:", error);
				}
			});
		} else if (selectedData.length > 1) {
			// 선택된 체크박스의 정보를 출력하거나 원하는 작업을 수행합니다.
			console.log(selectedData);
			$.ajax({
				url: "/playlist/add/list", // 국내 데이터를 불러올 서버 엔드포인트 지정
				method: "POST", // HTTP 메서드 (GET, POST 등)
				data: { add_songs: selectedData },
				dataType: "json",
				success: function(data) {
					// Ajax 호출 성공 시 실행할 코드
					showPlayLists(data);
					// 여기에서 데이터를 화면에 표시하거나 다른 작업을 수행할 수 있습니다.
				},
				error: function(error) {
					// Ajax 호출 실패 시 실행할 코드
					console.error("Ajax 호출 실패:", error);
				}
			});
		}
	});

	playlist_delete.addEventListener('click', () => {
		// tbody에 있는 모든 체크박스 요소를 선택합니다.
		var playlistCheckboxes = document.querySelectorAll(".playsong_list input[type='checkbox']");

		// 선택된 체크박스의 정보를 저장할 배열을 만듭니다.
		var selectedData = [];

		// 체크박스를 순회하면서 선택된 체크박스의 정보를 가져옵니다.
		playlistCheckboxes.forEach(function(checkbox) {
			if (checkbox.checked) {
				var row = checkbox.closest("li"); // 체크박스가 속한 행(tr)을 가져옵니다.
				var rowData = row.querySelector(".play_song").textContent;

				selectedData.push(rowData);
			}
		});
		console.log(selectedData);
		$.ajax({
			url: "/playlist/delete", // 국내 데이터를 불러올 서버 엔드포인트 지정
			method: "POST", // HTTP 메서드 (GET, POST 등)
			data: { delete_song: selectedData },
			dataType: "json",
			success: function(data) {
				// Ajax 호출 성공 시 실행할 코드
				showPlayLists(data);
				// 여기에서 데이터를 화면에 표시하거나 다른 작업을 수행할 수 있습니다.
			},
			error: function(error) {
				// Ajax 호출 실패 시 실행할 코드
				console.error("Ajax 호출 실패:", error);
			}
		});
	});
});
/*재생목록 출력*/
function showPlayLists(data) {
	// 데이터를 받아와서 화면에 동적으로 업데이트
	$(".playsong_list").empty();
	const ul = $("<ul></ul>");
	const play_now_song_name = document.querySelector('.play_now_song_name');
	const play_now_artist_name = document.querySelector('.play_now_artist_name');
	const play_now_song_time = document.querySelector('.play_now_song_time');
	const playlist_main_img = document.querySelector('.playlist_main_img');
	const playlist_size = document.querySelector('.playlist_size');
	$.each(data, function(index, ad) {
		const li = $("<li class='playsong_list_wrap'></li>");
		const input_box = $("<input type='checkbox'>");
		const img = $("<img src='/resources/Img/song/"+ad.songName+".jpg'>");
		const div = $("<div class='playsong_list_wrap_div'></div>");

		const p1 = $("<p class='album'></p>").text(ad.songName);
		const p2 = $("<p class='artist'></p>").text(ad.artistName);

		div.append(p1, p2);
		li.append(input_box, img, div);
		ul.append(li);
		play_now_song_name.textContent = ad.songName;
		play_now_artist_name.textContent = ad.artistName;
		play_now_song_time.textContent = "00:00 | " + ad.playTime;
		playlist_main_img.src='/resources/Img/song/'+ad.songName+'.jpg';
		playlist_size.textContent = ad.dataCount+"곡";
	});
	$(".playsong_list").append(ul);
	// 기존의 ul 엘리먼트를 대체
}
/* 가수 - 곡 최신순, 인기순, 가나다순 좋아요*/
// 쿠키 저장
function setCookie(name, value, days) {
	const date = new Date();
	date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
	const expires = "expires=" + date.toUTCString();
	document.cookie = name + "=" + value + ";" + expires + ";path=/";
}

// 쿠키 가져오기 함수
function getCookie(name) {
	const cookieName = name + "=";
	const cookieArray = document.cookie.split(';');
	for (let i = 0; i < cookieArray.length; i++) {
		let cookie = cookieArray[i].trim();
		if (cookie.indexOf(cookieName) === 0) {
			return cookie.substring(cookieName.length, cookie.length);
		}
	}
	return "";
}

$(document).on('click', '.song_hart', function() {
	const clickedHart = $(this); // 클릭된 .song_hart 엘리먼트를 변수에 저장
	const songIdInput = clickedHart.siblings('.songId');
	const songId = songIdInput.val();
	console.log(songId);
	const isLiked = getCookie(`song_${songId}_liked`) === 'true';
	const url = isLiked ? `/song/${songId}/like/delete` : `/song/${songId}/like/update`;
	const method = 'POST';

	$.ajax({
		url: url,
		method: method,
		dataType: 'json',
		success: function(data) {
			// Ajax 요청 성공 시 수행할 작업
			const song_hart_counts = $('.song_hart_count');
			const song_hart_count = song_hart_counts.eq(songIdInput.index('.songId'));
			song_hart_count.text(data);

			// 아이콘 토글
			const likeIcon = clickedHart.find('strong'); // 클릭된 엘리먼트에서 아이콘을 찾습니다.
			if (isLiked) {
				likeIcon.html('♡ &nbsp;');
				setCookie(`song_${songId}_liked`, 'false', 30); // 30일 동안 유지
			} else {
				likeIcon.html('♥ &nbsp;');
				setCookie(`song_${songId}_liked`, 'true', 30); // 30일 동안 유지
			}
		},
		error: function(error) {
			console.error('Ajax 호출 실패: ', error);
		}
	});
});
