<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kor">
<%@ include file="/WEB-INF/view/common/front_header.jsp" %>
<link href="<%=request.getContextPath()%>/resources/css/songAdd.css" rel="stylesheet">

<script>
    document.addEventListener("DOMContentLoaded", function() {
        var radioButtons = document.querySelectorAll('input[type="radio"]');

        radioButtons.forEach(function(radioButton) {
            radioButton.addEventListener("click", function() {
                // 클릭된 라디오 버튼의 value 값을 서버로 전송
                var selectedValue = this.value;
                document.getElementById("genreId").value = selectedValue; // Hidden input 필드에 할당
            });
        });
    });
</script>

<body>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<section class="sec1">
    <%@ include file="/WEB-INF/view/common/aside.jsp" %>
    <div class="wrap">

        <div class="song_button">
            <div class="song_add_title"><p>노래 추가</p></div>
            <a href="/admin"><button>뒤로가기</button></a>
            <form action="/song/add" method="post" class="data_form">
                <label>가수이름</label>
                <input type="text" size="30px" placeholder="가수이름" name="artistName">
                <label>앨범명</label>
                <input type="text" size="30px" placeholder="앨범명" name="albumName">
                <label>노래제목</label>
                <input type="text" size="30px" placeholder="노래제목" name="songName">
                <label>재생시간</label>
                <input type="text" size="30px" placeholder="재생시간" name="playTime">
                <label>장르</label>
                <div class="radio_button">
                    <ul>
                        <li>
                            <input type="radio" id="option0" name="genre" value="0"><br>
                            <label for="option0">발라드  </label>
                        </li>
                        <li>
                            <input type="radio" id="option1" name="genre" value="1"><br>
                            <label for="option1">댄스  </label>
                        </li>
                        <li>
                            <input type="radio" id="option2" name="genre" value="2"><br>
                            <label for="option2">국내힙합 </label>
                        </li>
                        <li>
                            <input type="radio" id="option3" name="genre" value="3"><br>
                            <label for="option3">인디 </label>
                        </li>
                        <li>
                            <input type="radio" id="option4" name="genre" value="4"><br>
                            <label for="option4">국내R&D </label>
                        </li>
                        <li>
                            <input type="radio" id="option5" name="genre" value="5"><br>
                            <label for="option5">OST </label>
                        </li>
                        <li>
                            <input type="radio" id="option6" name="genre" value="6"><br>
                            <label for="option6">해외 </label>
                        </li>
                    </ul>
                </div>
                <input type="hidden" name="genreId" id="genreId" value="">

                <div class="file_select">
                    <label for="songFile">노래 파일선택</label>
                    <div class="file_input_box">
                        <input type="file" id="songFile" class="song_file">
                    </div>
                </div>
                <div class="textarea_box">
                    <p>노래가사</p>
                    <textarea cols="50" rows="12" name="lyrics"></textarea>
                    <div>
                        <input type="submit" value="제출">
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>