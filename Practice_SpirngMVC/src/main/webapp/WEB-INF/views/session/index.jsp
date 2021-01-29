<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="./success?session1=aa&session2=bb&">Success</a><br />

<c:if test="${not empty session1 and not empty session2 }">
	<a href="./check">Check Session Values</a><br />
	<a href="./check2">Check Session Values 2</a><br />
	<a href="./remove">Remove Session</a><br />
	<a href="<%=request.getContextPath() %>/exercise/session">Other Controllers</a>
</c:if>

<hr />

<ul>
	<li>session1 : ${session1 }</li>
	<li>session2 : ${session2 }</li>
</ul>

<script>
window.onload = function(){
	<c:if test="${not empty msg}">
		setTimeout(() => { alert("${msg}"); }, 1000);
	</c:if>	
};

</script>

</body>
</html>