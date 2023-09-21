<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kor">
<%@ include file="/WEB-INF/view/common/front_header.jsp" %>
<link href="<%=request.getContextPath()%>/resources/css/melon_login.css" rel="stylesheet">
<body>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<section class="sec1">
    <%@ include file="/WEB-INF/view/common/aside.jsp" %>
    <div class="wrap">
        <div class="login_wrap">
            <h2>Melon</h2>
            <c:if test="${empty user}">
				<div class="kakao_btn">
	                <form action="${c}/login" method="post">
	                    <input type="text" placeholder="아이디 입력" name="id" value="" class="id" id="id" maxlength="20">
	                    <input type="password" placeholder="비밀번호 입력" name="password" value="" class="pw" id="pw" maxlength="50">
	                    <div class="checkbox">
	                        <input type="checkbox">
	                        <p>로그인 상태 유지</p>
	                    </div>
	                    <button type="submit" id="login_btn"><p>로그인</p></button>
	                    <button formaction="/login" formmethod="get"><p>취소</p></button>
	                </form>
	            </div>
            </c:if>
        </div>
    </div>
</section>
<script>
const msg = '${msg}';
if(msg === '로그인 실패'){
	alert("아이디 또는 비밀번호를 확인해 주세요.");
}
if(msg === '중복된 아이디입니다.'){
	console.log("중복된 아이디입니다.");
}
</script>
</body>
</html>