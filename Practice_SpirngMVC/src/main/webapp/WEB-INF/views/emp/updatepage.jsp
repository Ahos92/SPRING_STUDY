<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" 
	crossorigin="anonymous">
<title>수정</title>
</head>
<body>

<h1>수정 페이지</h1>
<div class="container-xl w-50">

<form action="./update" method="POST">
	<div class="input-group input-group-sm mb-3">
	  <span class="input-group-text" id="inputGroup-sizing-sm">Employee_id</span>
	  <input type="text" readonly name="employee_id" value="${emp.employee_id }" class="form-control" aria-describedby="inputGroup-sizing-sm">
	</div>
	
	<div class="input-group input-group-sm mb-3">
	  <span class="input-group-text">First and last name</span>
	  <input type="text" aria-label="First name" name="first_name" value="${emp.first_name }" class="form-control">
	  <input type="text" aria-label="Last name" name="last_name" value="${emp.last_name }" class="form-control">
	</div>
	
	<div class="input-group input-group-sm mb-3">
	  <span class="input-group-text" id="inputGroup-sizing-sm">Email</span>
	  <input type="text" class="form-control" name="email" value="${emp.email }" aria-describedby="inputGroup-sizing-sm">
	</div>
	
	<div class="input-group input-group-sm mb-3">
	  <span class="input-group-text" id="inputGroup-sizing-sm">Phone_number</span>
	  <input type="text" class="form-control" name="phone_number" value="${emp.phone_number }" aria-describedby="inputGroup-sizing-sm">
	</div>

	<select class="form-select form-select-sm mb-3" name="job_id" aria-label=".form-select-sm example">
	  <option selected value="0">Job_id</option>
	  <option>AD_ASST</option>
	  <option>FI_MGR</option>
	  <option>FI_ACCOUNT</option>
	  <option>AC_MGR</option>  
	  <option>AC_ACCOUNT</option>
	  <option>SA_MAN</option>
	  <option>SA_REP</option>
	  <option>PU_MAN</option>
	  <option>PU_CLERK</option>
	  <option>ST_MAN</option>
	  <option>ST_CLERK</option>
	  <option>SH_CLERK</option>
	  <option>IT_PROG</option>
	  <option>MK_MAN</option>
	  <option>MK_REP</option>
	  <option>HR_REP</option>
	  <option>PR_REP</option>
	</select>
	
	<div class="input-group input-group-sm mb-3">
	  <span class="input-group-text" id="inputGroup-sizing-sm">Salary</span>
	  <input type="text" class="form-control" name="salary" value="${emp.salary }" aria-describedby="inputGroup-sizing-sm">
	</div>
	
	<div class="input-group input-group-sm mb-3">
	  <span class="input-group-text" id="inputGroup-sizing-sm">Commission_pct</span>
	  <input type="text" class="form-control" name="commission_pct" value="${emp.commission_pct }" aria-describedby="inputGroup-sizing-sm">
	</div>
	
	<div class="input-group input-group-sm mb-3">
	  <span class="input-group-text" id="inputGroup-sizing-sm">Manager_id</span>
	  <input type="text" class="form-control" name="manager_id" value="${emp.manager_id }" aria-describedby="inputGroup-sizing-sm">
	</div>
	
	<div class="input-group input-group-sm mb-3">
	  <span class="input-group-text" id="inputGroup-sizing-sm">Department_id</span>
	  <input type="text" class="form-control" name="department_id" value="${emp.department_id }" aria-describedby="inputGroup-sizing-sm">
	</div>
	
	<div class="pb-2">
		<input class="btn btn-primary" type="submit" value="수정" /> 
		<a class="btn btn-danger" href="./detail?id=${emp.employee_id }">취소</a>
	</div>
</form>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" 
	crossorigin="anonymous"></script>
</body>
</html>