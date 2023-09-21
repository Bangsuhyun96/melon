// 곡 버튼 클릭 시 곡만 나오게 하는 기능
function showTable() {
    $(".artist_album").hide();
    $(".artist_info_body").hide();
    $(".song_tb").show();
    $(".artist_sort_and_play").show();
}

// 앨범 버튼 클릭 시 앨범만 나오게 하는 기능
function showAlbum() {
    $(".song_tb").hide();
    $(".artist_info_body").hide();
    $(".artist_album").show();
    $(".artist_sort_and_play").hide();
}

// 상세정보 버튼 클릭 시 상제정보만 나오게 하는 기능
function showInfo() {
    $(".song_tb").hide();
    $(".artist_album").hide();
    $(".artist_sort_and_play").hide();
    $(".artist_info_body").show();
}

// 곡 버튼 클릭 시
$(".show_table").click(function() {
    $(".show_table").addClass("active");
    $(".show_album, .show_info").removeClass("active");
    showTable();
});

// 앨범 버튼 클릭 시
$(".show_album").click(function() {
    $(".show_album").addClass("active");
    $(".show_table, .show_info").removeClass("active");
    showAlbum();
});

// 상세정보 버튼 클릭 시
$(".show_info").click(function() {
    $(".show_info").addClass("active");
    $(".show_table, .show_album").removeClass("active");
    showInfo();
});


//체크박스 전체선택버튼
function selectAll() {
    let checkboxes = document.querySelectorAll(".check_tb");
    let allChecked = true;

    for (let i = 0; i < checkboxes.length; i++) {
        if (!checkboxes[i].checked) {
            allChecked = false;
            break;
        }
    }
    // 만약 모든 체크박스가 선택된 경우에 전체 해제
    if (allChecked) {
        for (let i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = false;
        }
    } else {
        // 그렇지 않은 경우에는 전체 선택
        for (let i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = true;
        }
    }
}

// 인기순, 최신순, 가나다순 정렬
$(document).ready(function() {
    // 정렬 버튼 클릭 시 이벤트 핸들러
    $(".artist_song_latest_text, .artist_song_popularity_text, .artist_song_alphabetically_text").click(function () {
        const likeButtons = document.querySelectorAll('.song_hart');
        console.log(likeButtons.length);
        let artistId = $("#artistId").val();
        let sortType = $(this).text().trim(); // 클릭한 버튼의 텍스트를 정렬 기준으로 사용
        sendAjaxRequest(artistId, sortType);

        // 클릭한 버튼에만 색깔 변경
        $(this).addClass("sort");
        $(".artist_song_latest_text, .artist_song_popularity_text, .artist_song_alphabetically_text").not(this).removeClass("sort");
    });

    function sendAjaxRequest(artistId, sortType) {
        $.ajax({
            method: 'GET',
            url: `/artist/detail/song/${artistId}?sortType=${sortType}`,
            success: function (data) {
                populateTable(data);
                console.log('성공');
            },
            error: function (error) {
                console.error('Ajax 요청 실패:', error);
            }
        });
    }

    function populateTable(data) {
        // artistSongsTable 테이블 내용을 초기화
        $("#artistSongsTable").empty();

        // 데이터를 반복하여 테이블에 추가
        for (let i = 0; i < data.length; i++) {
            let song = data[i];
            let row = $("<tr>");

            // 체크박스 컬럼
            let checkboxCell = $("<td>").html('<input type="checkbox" class="check_tb">');
            row.append(checkboxCell);

            // 곡명 컬럼
            let songNameCell = $("<td>").html('<div class="artist_song_name_box_tb"><div class="artist_album_pic"><img src="/resources/Img/song/' + song.songName + '.jpg" alt="노래 이미지"></div><div class="artist_song_name_tb"><p>' + song.songName + '</p></div></div>');
            row.append(songNameCell);

            // 아티스트명 컬럼
            let artistNameCell = $("<td>").html('<div class="artist_name_tb">' + song.artistName + '</div><input type="hidden" name="artistId" value="' + song.artistId + '" id="artistId"/>');
            row.append(artistNameCell);

            // 앨범명 컬럼
            let albumNameCell = $("<td>").html('<a href="/album/' + song.albumId + '" class="artist_album_name_tb"><p>' + song.songName + '</p></a>');
            row.append(albumNameCell);

            // 발매일 컬럼
            let releaseDateCell = $("<td>").html('<p>' + song.releaseDate + '</p>');
            row.append(releaseDateCell);

            // 좋아요 컬럼
            let albumLikeCell = $("<td>").html('<p class="song_hart"><strong>♡ &nbsp;</strong></p><p class="song_hart_count">' + song.songLike + '</p><input type="hidden" name="songId" class="songId" value="' + song.songId + '"/>');
            row.append(albumLikeCell);

            // 재생 컬럼
            let playCell = $("<td>").html('<p><i class="fa-solid fa-play"></i></p>');
            row.append(playCell);

            // 행을 테이블에 추가
            $("#artistSongsTable").append(row);
        }
    }
});



$(document).ready(function() {
    // 로컬 스토리지에서 클릭 상태를 가져옴
    let isLiked = localStorage.getItem('isLiked') === 'true';
    let isArtistEmpty = $('#hartCntAdd').data('isArtistEmpty');

    // 초기 상태 설정
    setButtonState(isLiked);

    if (isArtistEmpty === 'true') {
        $('#hartCntAdd').click(function() {
            let artistId = $('#artistInfoArtistId').val();
            let button = $(this);

            if (!isLiked) {
                $.ajax({
                    type: 'POST',
                    url: `/artist/${artistId}/like/update`,
                    success: function(data) {
                        // 성공한 경우 좋아요 수를 업데이트하고 포맷
                        updateLikeCount(data);
                        setButtonState(true); // 클릭 상태 업데이트
                    },
                    error: function() {
                        console.error('에러');
                    }
                });
            } else {
                $.ajax({
                    type: 'POST',
                    url: `/artist/${artistId}/like/delete`,
                    success: function(data) {
                        // 성공한 경우 좋아요 수를 업데이트하고 포맷
                        updateLikeCount(data);
                        setButtonState(false); // 클릭 상태 업데이트
                    },
                    error: function() {
                        console.error('에러');
                    }
                });
            }
        });
    } else {
        $('#hartCntDel').click(function() {
            let artistId = $('#artistInfoArtistId').val();
            let button = $(this);

            if (!isLiked) {
                $.ajax({
                    type: 'POST',
                    url: `/artist/${artistId}/like/update`,
                    success: function(data) {
                        // 성공한 경우 좋아요 수를 업데이트하고 포맷
                        updateLikeCount(data);
                        setButtonState(true); // 클릭 상태 업데이트
                    },
                    error: function() {
                        console.error('에러');
                    }
                });
            } else {
                $.ajax({
                    type: 'POST',
                    url: `/artist/${artistId}/like/delete`,
                    success: function(data) {
                        // 성공한 경우 좋아요 수를 업데이트하고 포맷
                        updateLikeCount(data);
                        setButtonState(false); // 클릭 상태 업데이트
                    },
                    error: function() {
                        console.error('에러');
                    }
                });
            }
        });
    }

    function updateLikeCount(data) {
        // 좋아요 수를 포맷하여 업데이트
        let formattedCount = formatNumberWithCommas(data);
        $('.hart_count').text(formattedCount);
    }

    // 클릭 상태를 로컬 스토리지에 저장하고 하트 색상을 업데이트하는 함수
    function setButtonState(state) {
        isLiked = state;
        localStorage.setItem('isLiked', state.toString());
        // 버튼 상태 업데이트
        if (state) {
            $('#hartCntAdd').html('<strong style="color: #04E632;">♥ &nbsp;</strong>');
            $('#hartCntDel').html('<strong style="color: #04E632;">♥ &nbsp;</strong>');
        } else {
            $('#hartCntAdd').html('<strong style="color: #04E632;">♡ &nbsp;</strong>');
            $('#hartCntDel').html('<strong style="color: #04E632;">♡ &nbsp;</strong>');
        }
    }

    // 숫자 포맷 함수 정의
    function formatNumberWithCommas(number) {
        return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
});
