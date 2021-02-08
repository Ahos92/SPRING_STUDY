<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>

<ul id="content-list">
	<li id="content-list-item">비어 있음</li>
</ul>

<!-- this는 data-*에 정의 한것이 들어감(변수처럼 사용 가능) -->
<button onclick="btnAction(this);" data-btn-type="getText">getText</button>
<button onclick="btnAction(this);" data-btn-type="getHtml">getHTML</button>
<button onclick="addList(this);" >list 추가</button>
<button onclick="printXML(this);" data-btn-type="getXML">getXML</button>

<script>
	const prefix = "<%=application.getContextPath()%>/rest/";
</script>
<script src="<%=application.getContextPath()%>/resources/assets/js/list.js"></script>
</body>
</html>