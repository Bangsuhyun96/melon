 <div align=left><h2>🎧Melon 스트리밍 클론 사이트🎧</h2></div>

스프링 부트 + Mybatis 멜론 사이트 클론 코딩

<div align=left><h2>프로젝트 소개</h2></div>
음악 스트리밍 사이트 Melon을 참고하여 만든 음악 스트리밍 클론 사이트 입니다.

<div align=left><h2>📚 STACKS</h2></div>

<div align=left><h3>📕 Environment</h3></div>

<div>
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
</div>

<div align=left><h3>📙 Development</h3></div>

<div>
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
  <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <img src="https://img.shields.io/badge/jsp-E6700C?style=for-the-badge&logo=jsp&logoColor=white">
  <img src="https://img.shields.io/badge/mybatis-251C1D?style=for-the-badge&logo=mybatis&logoColor=white">
</div>

<div align=left><h2>맴버 구성 및 역할 분담</h2></div>

**👺팀장 여수한** : 차트(인기, 최신, 장르별, 앨범), 재생목록 페이지

**😺팀원 방수현** : 전체적인 프론트 디자인, 로그인 페이지, 회원가입 페이지

**😺팀원 서지환** : 관리자 페이지, 고객센터 페이지, 회원 관리 페이지, 이용권 관리 페이지, 이용권 구매 기능

**😺팀원 임휘재** : 앨범 페이지, 가수 페이지, 좋아요 기능

<div align=left><h2>💻 화면 구성</h2></div>
<div align=center>
    <img width="30%" src="https://github.com/Bangsuhyun96/melon/assets/105468233/b647cfbc-ea49-4ff7-9c29-b20d3ddd991f.jpg"/>
    <img width="30%" src="https://github.com/Bangsuhyun96/melon/assets/105468233/db45d2c4-acf8-427c-b277-db70fe1f16f8.jpg"/>
    <img width="30%" src="https://github.com/Bangsuhyun96/melon/assets/105468233/a9126c37-905f-4914-b170-03b4f7c37f4e.jpg"/>
</div>
<div align=left><h2>💡 주요 기능</h2></div>

### 로그인 및 회원가입 기능

### 인기차트
- 인기차트에서 2가지 조회수를 계산해 나온 결과로 1시간마다 목록이 업데이트 된다.
- 사용자들의 이용량(재생수)에 따라 1시간마다 자동적으로 업데이트 된다.

### 최신노래
- 최신곡을 국내 또는 해외로 구분하여 볼 수 있다.

### 최신앨범
- 최신앨범을 전체, 국내, 해외를 구분하여 볼 수 있다.

### 장르음악
- 장르목록에서 플러스(➕) 버튼을 누르면 체크(✔️)표시로 변경되면서 장르 상단에 해당 장르가 추가된다.
- 장르 상단에서 해당 장르를 클릭하면 해당 장르에 대한 노래를 볼 수 있다.
- 장르는 전체, 2020년도, 2010년도, 2000년도, 1990년도, 1980년도로 구분해서 볼 수 있다.
- 장르는 최신앨범 또는 최신곡을 구분해서 볼 수 있다.


### 재생목록(단일)
- 인기차트에서 노래 제목을 클릭하면 재생목록에 저장된다.

### 재생목록(다중)
- 노래 목록에서 해당 노래를 원하는 대로 선택한 후 전체 재생 버튼을 누르면 재생목록에 저장된다.

### 재생목록 기능
- 재생목록에서 셔플버튼을 누르면 재생목록에 있는 노래들이 랜덤으로 위치가 조정된다.
- 재생목록에 있는 노래를 선택한 후 삭제버튼을 누르면 노래가 삭제된다.

### 상세조회(앨범)
- 앨범 페이지에서 앨범의 곡을 조회하는 수록곡탭, 앨범의 정보를 조회하는 앨범상세탭, 앨범에 대한 댓글을 조회, 작성, 삭제기능을 할 수 있는 댓글탭이 있다.
- 댓글을 작성하면 앨범 페이지 우측상단에 댓글의 개수를 알 수 있다.

### 상세조회(가수)
- 가수 페이지에서 해당 가수의 곡을 조회하는 곡탭, 가수의 앨범을 조회하는 앨범탭, 가수의 정보를 조회하는 상세정보탭이 있다.
- 가수의 곡탭에서 사용자가 원하는 대로 최신순, 인기순, 가나다순으로 정렬하여 볼 수 있다.

### 좋아요
- 가수 페이지에서 좌측 상단에서 가수 좋아요를 누를 수 있다.
- 가수 페이지의 곡탭에서 노래 좋아요를 누를 수 있다.
- 앨범 페이지 우측 상단에서 앨범 좋아요를 누를 수 있다.
- 가수 및 앨범 페이지에서 노래 좋아요를 누를 수 있다.

### 관리자 페이지
- 노래, 앨범, 가수의 전체 목록을 조회할 수 있다.
- 노래, 앨범, 가수를 추가하거나 삭제할 수 있다.
- 노래제목, 아티스트명으로 검색이 가능하다.
- 전체 회원목록을 볼 수 있고 회원이 이용권을 구매했는지 확인할 수 있다.

### 이용권
- 이용권 페이지에서 이용권 목록을 조회 및 구매(카카오 API)를 할 수 있다.

<div align=left><h2>프로젝트 회고</h2></div>

### 😃keep
- 서로가 모르는 부분이 있을 때 도와주어 문제를 빠르게 해결할 수 있었다.
- 소프트웨어 재사용성을 고려한 코드 작성으로 불필요한 코드를 줄일 수 있었다.

### 😥problem
- STS와 IntelliJ를 병행하여 사용했기 때문에 Git활용에 있어서 오류가 많이 발생해 PUSH, PULL하는 과정에서 더 조심스럽게 충돌을 해결할 수 있었다.

### 😎Try
- 많은 데이터를 활용해 정규화, 비정규화 성능 비교를 할 수 있도록 데이터와 데이터베이스에 대한 이해도를 높이도록 했다.

