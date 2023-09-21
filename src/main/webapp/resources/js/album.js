// 각 버튼의 대한 화면 나타나게 하는 기능
function showSong() {
    // 곡 버튼 클릭 시
    $(".song_tb").show();
    $(".album_detail_body").hide();
    $(".comment_box").hide();
}

function showDetailAlbum() {
    // 앨범 버튼 클릭 시
    $(".song_tb").hide();
    $(".album_detail_body").show();
    $(".comment_box").hide();
}

function showComment() {
    // 상세정보 버튼 클릭 시
    $(".song_tb").hide();
    $(".album_detail_body").hide();
    $(".comment_box").show();
}


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

// 수록곡, 앨범상세, 댓글중 하나 누르면 색깔바뀌는 기능
$(document).ready(function() {
    $(".show_songs, .show_detail_albums, .show_comments").click(function() {
        $(".show_songs, .show_detail_albums, .show_comments").removeClass("active");
        $(this).addClass("active");
    });
});

// 앨범상세, 댓글을 누르면 전체선택, 전체재생버튼이 사라지게하는 기능
$(document).ready(function(){
    $(".show_detail_albums, .show_comments").click(function() {
        $(".album_menu_right").hide();
    })
})

// 수록곡을 누르면 전체선택, 전체재생버튼이 나타나게하는 기능
$(document).ready(function() {
    $(".show_songs").click(function() {
        $(".album_menu_right").show();
    })
})

$(document).ready(function () {
    $(".comment").click(function () {
        showComment();
        $(".album_menu_right").hide();
        $(".show_comments").addClass("active");
        $(".show_songs").removeClass("active");
    });
})

$(document).ready(function () {
    $(".comment_count").click(function () {
        showComment();
        $(".album_menu_right").hide();
        $(".show_comments").addClass("active");
        $(".show_songs").removeClass("active");
    });
})

function showDeleteSuccessAlert() {
    if (confirm('정말로 삭제하시겠습니까?')) {
        alert('삭제 성공');
        return true;
    } else {
        return false;
    }
}

function validateComment() {
    // 댓글 입력값 가져오기
    let commentInput = document.querySelector(".comment").value.trim();

    // 입력값이 공백인 경우 알림창 표시 후 제출 방지
    if (commentInput === "") {
        alert("댓글은 공백일 수 없습니다.");
        return false; // 제출 방지
    }

    // 모든 유효성 검사를 통과한 경우
    return true;
}

function writeSuccess() {
    alert("댓글 작성 성공");
    return true; // 폼 제출 허용
}

function formatNumberWithCommas(number) {
    return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

$(document).ready(function() {
    let isLiked = localStorage.getItem('isLiked') === 'true';
    let likeCount = parseInt(localStorage.getItem('likeCount')) || 0;

    setButtonContent(isLiked);
    updateLikeCount(likeCount);

    $('.hart').click(function() {
        let albumId = $('#albumLikeAlbumId').val();
        let button = $(this);

        if (!isLiked) {
            $.ajax({
                type: 'POST',
                url: `/album/${albumId}/like/update`,
                success: function(data) {
                    updateLikeCount(data);
                    button.html('<strong>♥ &nbsp;</strong>');
                    isLiked = true;
                    localStorage.setItem('isLiked', 'true');
                },
                error: function() {
                    console.error('에러');
                }
            });
        } else {
            $.ajax({
                type: 'POST',
                url: `/album/${albumId}/like/delete`,
                success: function(data) {
                    updateLikeCount(data);
                    button.html('<strong>♡ &nbsp;</strong>');
                    isLiked = false;
                    localStorage.setItem('isLiked', 'false');
                },
                error: function() {
                    console.error('에러');
                }
            });
        }
    });

    function updateLikeCount(likeCount) {
        let formattedLikeCount = formatNumberWithCommas(likeCount);
        $('.hart_count').text(formattedLikeCount);
        // 로컬 스토리지에 좋아요 수 저장
        localStorage.setItem('likeCount', likeCount);
    }

    function setButtonContent(isLiked) {
        let button = $('.hart');
        if (isLiked) {
            button.html('<strong>♥ &nbsp;</strong>');
        } else {
            button.html('<strong>♡ &nbsp;</strong>');
        }
    }
});





