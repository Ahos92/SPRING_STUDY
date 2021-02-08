<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX/EMP</title>
</head>
<body>

<button onclick="req();">getXML</button>
<button onclick="reqJson();">getJson</button>

<table id="emp"></table>


<script type="text/javascript">
	function req() { 
		const xhttp = new XMLHttpRequest();
		
		xhttp.onreadystatechange = function() {
			if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
				makeTable(this.responseXML);
			}
		};
		
		xhttp.open('GET', '/practice_mvc/rest/getXML', true);
		xhttp.send();
	}
	
	function makeTable(xml) {
		console.log(xml.getElementsByTagName("employee_id")[0].childNodes[0].nodeValue);
		console.log(xml.getElementsByTagName("first_name")[0].childNodes[0].nodeValue);
		console.log(xml.getElementsByTagName("last_name")[0].childNodes[0].nodeValue);
		console.log(xml.getElementsByTagName("salary")[0].childNodes[0].nodeValue);
		console.log(xml.getElementsByTagName("job_id")[0].childNodes[0].nodeValue);
		
		
	}
	

</script>
</body>
</html>