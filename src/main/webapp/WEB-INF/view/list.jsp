<%-- <%@ page import= "java.io.FileInputStream "%> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- tomcat 9.0는 쓰면 안됨 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<section id="">
		<a href="list2">list2</a><!-- Context 경로 -->
		<a href="detail">상세</a>
		<form action="list" method="GET"><!--  Controller에게 보냄 -->
			<fieldset>
			<h1>성적출력EL(4대 저장소에서 값을 꺼냄 지역변수x)</h1>
				<table>
					<thead>
						<tr>
							<th>이름</th>
							<th>국어</th>
							<th>영어</th>
							<th>수학</th>
							<th>총점</th>
							<th>평균</th>
							<th>성적</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="exam" items="${list}"><!-- EL이 이 페이지에 저장하고 꺼낼 수 있게 exam 키값을 넣음-->
							<tr>
								<td>${exam.name}</td>
								<td>${exam.getKor()}</td>
								<td>${exam.eng}</td>
								<td>${exam.math}</td>
								<td>${exam.total}</td>
								<td><fmt:formatNumber value="${exam.avg}" pattern="#.00" />
								</td>
								<td>${exam.grade}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</form>
	</section>

	<nav id="pager">
		<ul>
			<li><a href="?p=1&c=color&c=color2&c=응 ㅇ">1 페이지로 가기 ${page}</a></li>
			<li><a href="?p=2">2 페이지로 가기 ${page}</a></li>
		</ul>
	</nav>

	<section id="">
		<form action="list" method="POST">
			<fieldset>
				<label></label><input name="p">
			</fieldset>
			<fieldset>
				<label>빨강<input type="checkbox" name="c" value="red"></label>
				<label>파랑<input type="checkbox" name="c" value="blue"></label>
				<label>초록<input type="checkbox" name="c" value="green"></label>
			</fieldset>
			<div id="">
				<button>전송</button><!-- <input type="submit" value="전송"> -->
			</div>
		</form>
	</section>

	<section>
		<form method="POST" enctype="multipart/form-data"><!-- js사용시 인코딩 -->
			<label>파일 선택<input style="display: none;" multiple="multiple"  type="file" name="img"></label>
			<button>업로드</button>
		</form>
	</section>
	
	<section><!-- 서버 경로 -->
		<div>
			<img src="/javaprj/notice/upload/supreme-green-solid-color-desktop-wallpaper.png" width="480" height="480">
		</div>
		<div>
			<video width="480" height="480"  muted controls autoplay loop><!-- 구글 브라우저는 음소거된 영상만 자동재생 가능함 -->
				<source src="/javaprj/notice/upload/2024-07-23 11-45-39.mp4"  type="video/mp4">
			</video>
		</div>
		<div>
		<a download href="/javaprj/notice/upload/supreme-green-solid-color-desktop-wallpaper.png">이미지 다운로드</a>
		<a download href="/javaprj/notice/upload/2024-07-23 11-45-39.mp4">영상 다운로드</a>
		</div>
	</section>
	
	
	
</body>
</html>