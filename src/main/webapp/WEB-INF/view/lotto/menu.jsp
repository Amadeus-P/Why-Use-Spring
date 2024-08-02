<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><!-- body는 section, section은 분명한 하나의 컨텐츠 -->
	<form action="" method="GET">
	<!-- 콘솔/윈도우 프로그램과 웹(hypertext)의 차이 이해  -->
<!-- 		<h1>[로또 복권 프로그램]</h1>
		<input type="submit" name="genManual" value="1. 수동 발권">
		<input type="submit" name="genAuto" value="2. 자동 발권">
		<input type="submit" name="print" value="3. 발권 번호 조회">
		<input type="submit" name="exit" value="4. 종료"> -->
		
		<nav>
			<h1>[로또 복권 프로그램]</h1>
			<ul>
				<li><a href="gen-manual">수동 발권</a>
				<li><a href="gen-auto">자동 발권</a>
				<li><a href="print">발권 번호 조회</a>
			</ul>		
		</nav>
		
	</form>
</body>
</html>