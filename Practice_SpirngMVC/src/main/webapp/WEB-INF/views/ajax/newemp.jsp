<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>사용자가 입력한 데이터를 바탕으로 POST 방식으로 요청 하는 xhr을 요청하고 DB에 INSERT해보기</h2>

<p>
	xhttp.setRequestHeader('content-type', 'application/json'); <br />
	xhttp.send(JSON.stringify(data)) <br />
</p>

<h5>연습 문제 : 사원이 DB에 진짜로 추가되게 만들어보기. method PUT 또는 PATCH로 xhr요청하면 회원정보 수정되게만들기</h5>
<table>
<tr>
	<th>first_name & last_name</th>
	<td><input name="first_name" /> <input name="last_name" /></td>
</tr>
<tr>
	<th>email</th>
	<td><input type="text" name="email"/></td>
</tr>
<tr>
	<th>phone_number</th>
	<td><input type="text" name="phone_number"/></td>
</tr>
<tr>
	<th>job_id</th>
	<td><input type="text" name="job_id"/></td>
</tr>
<tr>
	<th>salary</th>
	<td><input type="text" name="salary"/></td>
</tr>
<tr>
	<th>commission_pct</th>
	<td><input type="text" name="commission_pct"/></td>
</tr>
<tr>
	<th>manager_id</th>
	<td><input type="text" name="manager_id"/></td>
</tr>
<tr>
	<th>deprtement_id</th>
	<td><input type="text" name="department_id"/></td>
</tr>

</table>
<button id="send">send xhr</button>
<hr />

<h3>변경</h3>
사번 : <input type="number" min="100" max="220" value="218" name="employee_id" />
월급 + / - : <input type="text" name="increment" />
<button>send putxhr</button>

<script src="https://code.jquery.com/jquery-3.5.1.js" 
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" 
		crossorigin="anonymous"></script>
<script>
// JQuery
$("#send").click(function(){
	$.ajax({
		type: "POST",
		url: "/practice_mvc/rest/employee",	
		data: JSON.stringify({
				first_name: $('[name="first_name"]').val(),
				last_name: $('[name="last_name"]').val(),
				email: $('[name="email"]').val(),
				phone_number: $('[name="phone_number"]').val(),
				job_id: $('[name="job_id"]').val(),
				salary: $('[name="salary"]').val(),
				commission_pct: $('[name="commission_pct"]').val(),
				manager_id: $('[name="manager_id"]').val(),
				department_id: $('[name="department_id"]').val()
		}),
		contentType: 'application/json',
		success: function(){
			alert('성공');
		},
		
		error: function(){
			alert('실패')	;
		}
	});
	
	console.log(data)
});

// javascript
/* 	function ajaxPost() {
	
		var data = {
			first_name: document.querySelector('[name="first_name"]').value,
			last_name: document.querySelector('[name="last_name"]').value,
			email: document.querySelector('[name="email"]').value,
			phone_number: document.querySelector('[name="phone_number"]').value,
			job_id: document.querySelector('[name="job_id"]').value,
			salary: document.querySelector('[name="salary"]').value,
			commission_pct: document.querySelector('[name="commission_pct"]').value,
			manager_id: document.querySelector('[name="manager_id"]').value,
			department_id: document.querySelector('[name="department_id"]').value
		}
		
		var xhttp = new XMLHttpRequest();
		
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == XMLHttpRequest.DONE) {
				if (xhttp.status == 200){
					alert('insert OK');
					
				} else {
					alert('insert fail');
				}
			}
		}
		
		xhttp.open('POST', '/practice_mvc/rest/employee/create', true);
		xhttp.setRequestHeader('content-type', 'application/json');
		xhttp.send(JSON.stringify(data))
		
	}

	
	function patch() {
		var data = {
				employee_id: parseInt(document.querySelector('[name="employee_id"]').value),
				increment: parseInt(document.querySelector('[name="increment"]').value)
		}
		console.log(data)
		
		var xhttp = new XMLHttpRequest();
		
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == XMLHttpRequest.DONE) {
				if (xhttp.status == 200){
					alert('update OK');
					
				} else {
					alert('update fail');
				}
			}
		}
		
		xhttp.open('PATCH', '/practice_mvc/rest/employee/salary', true);
		xhttp.setRequestHeader('content-type', 'application/json');
		xhttp.send(JSON.stringify(data))
	}
 */	
</script>

</body>
</html>