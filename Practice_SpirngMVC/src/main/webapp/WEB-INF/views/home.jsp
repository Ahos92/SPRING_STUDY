<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8"/>
	<meta lang="ko"/>
	<title>Home</title>
</head>
<body>

<h1>Hello world!</h1>

<p>  The time on the server is ${serverTime}. </p>

<h3># 컨트롤러에서 전달받은 어트리뷰트들</h3>
<p>
	컨트롤러의 파라미터에 '자바 빈 데이터 클래스'(VO, DTO)를 통한 자동매핑을 이용하면 모델에 해당 객체를 알아서 실어준다. <br />
	<br /> 
	만약 자동으로 실어주지 않는 다른 타입들도 @ModelAttribute 어노테이션을 이용해 비교적 편리하게 실어줄 수 있다. <br />
</p>
<ul>
	<li>${user }</li>
	<li>${name }</li>
	<li>${age }</li>
	<li>${name1 }</li>
	<li>${age1 }</li>
	<li>${cats }</li>
</ul>

</body>
</html>
