<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" 
	crossorigin="anonymous">
<title>상세 페이지</title>
</head>
<body>

<h1>상세 페이지</h1>

<div class="card" style="width: 30rem;">
  <img src="/some/둘리웃음.png" class="card-img-top" alt="사진">
  <div class="card-body">
    <p class="card-text">
    <ul>
    	<li>ID : ${emp.employee_id }</li>
    	<li>Name : ${emp.first_name }'s ${emp.last_name }</li>
    	<li>Email : ${emp.email }</li>
    	<li>Tel : ${emp.phone_number }</li>
    	<li>Hire_date : ${emp.hire_date }</li>
    	<li>Job_ID : ${emp.job_id }</li>
    	<li>Salary : ${emp.salary }</li>
    	<li>Commission_pct : ${emp.commission_pct }</li>
    	<li>Manager_ID : ${emp.manager_id }</li>
    	<li>Department_ID : ${emp.department_id }</li>
    </ul>
    </p>
  </div>
</div>


<form action="./updatepage" method="POST">
<input type="hidden" name="id" value="${emp.employee_id}" />
<input class="btn btn-primary" type="submit" value="수정">
</form>

<form action="./delete" method="POST">
<input type="hidden" name="id" value="${emp.employee_id}" />
<input class="btn btn-danger" type="submit" value="삭제">
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" 
	crossorigin="anonymous"></script>
</body>
</html>