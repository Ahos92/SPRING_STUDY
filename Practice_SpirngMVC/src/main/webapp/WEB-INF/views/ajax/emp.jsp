<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX/EMP</title>
</head>
<body>

<input id="eid" type="number" value="100" min="100" max="208" />

<button onclick="req();">getXML</button>
<button onclick="reqJson();">getJson</button>

<table id="emp" border="1"></table>


<script type="text/javascript">

	/* XML */
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
	
	
	/* JSON */
	function reqJson(){
		const xhttp = new XMLHttpRequest();
		
		xhttp.onreadystatechange = function() {
			// ★ readyState 0~4
			// 서버에서 보내주는 status값 - 원하는 타이밍에 원하는값을 보내줌
			if (this.readyState == XMLHttpRequest.DONE) {

				if (this.status == 200) {
					makeTable(JSON.parse(this.responseText));
					
				} else if (this.status == 400) {
					// 통신완료 되었지만 잘못된 상태
					alert(document.getElementById("eid").value + '번 사원은 없습니다!');
				}
			}
			
		};
		var employee_id = parseInt(document.getElementById("eid").value);
		// 정보 생성 (요청 방식, 주소, 비동기여부)
		xhttp.open('GET', '/practice_mvc/rest/getJson/' + employee_id, true);
		xhttp.send();
		
		
	/* 	// Javascript Object -> JSON
		var data = {
				employee_id: parseInt(document.getElementById("eid").value)
		};
		
		// 타입설정 controller에 consumes에 알려줌
		xhttp.setRequestHeader('content-type', 'application/json');
	
		// 요청보내기 (파라미터를 실어 보낼 수 있음)
		xhttp.send(JSON.stringify(data)); */
	}
	
	
	
	/* 화면 출력 함수 */
	function makeTable(js_obj) {
		/* console.log(js_obj); */
		
		var table_content = "";
		
		for (key in js_obj) {
			// console.log(key + " : " + js_obj[key]);
			
			table_content += "<tr><th>" + key + "</th><td>" + js_obj[key] + "</td></tr>";
		}
		
		document.getElementById("emp").innerHTML = table_content;
		
		/* console.log(xml.getElementsByTagName("employee_id")[0].childNodes[0].nodeValue);
		console.log(xml.getElementsByTagName("first_name")[0].childNodes[0].nodeValue);
		console.log(xml.getElementsByTagName("last_name")[0].childNodes[0].nodeValue);
		console.log(xml.getElementsByTagName("salary")[0].childNodes[0].nodeValue);
		console.log(xml.getElementsByTagName("job_id")[0].childNodes[0].nodeValue);
		 */
		
	}
	

</script>
</body>
</html>