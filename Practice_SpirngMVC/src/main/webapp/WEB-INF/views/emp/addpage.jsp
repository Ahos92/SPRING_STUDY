<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" 
	crossorigin="anonymous">
<title>신입사원 추가</title>
</head>
<body>

<h1 style="padding-top: 1.6em; text-align: center;">사원 등록 페이지</h1>
<div class="container-xl w-50 pb-5" style="max-width: 600px;">

<form action="./add" method="POST">
	<div class="input-group input-group mb-3 pt-5">
	  <span class="input-group-text">First and last name</span>
	  <input type="text" aria-label="First name" name="first_name" class="form-control" required>
	  <input type="text" aria-label="Last name" name="last_name" class="form-control" required>
	</div>
	
	<div class="input-group input-group mb-3">
	  <span class="input-group-text" id="inputGroup-sizing">Email</span>
	  <input type="text" class="form-control" name="email" aria-describedby="inputGroup-sizing" required>
	</div>
	
	<div class="input-group input-group mb-3">
	  <span class="input-group-text" id="inputGroup-sizing">Phone_number</span>
	  <input type="text" class="form-control" name="phone_number" aria-describedby="inputGroup-sizing" required>
	</div>

	<div class="input-group mb-3">
	  <label class="input-group-text" for="inputGroupSelect01">Job_id</label>
	  <select class="form-select" id="inputGroupSelect01" name="job_id">
		   <c:forEach var="i" items="${jobId }" varStatus="status">
		  	<option>${i.job_id }</option>
		  </c:forEach>
	  </select>
	</div>
	
	<div class="input-group input-group mb-3">
	  <span class="input-group-text" id="inputGroup-sizing">Salary</span>
	  <input type="text" class="form-control" name="salary" aria-describedby="inputGroup-sizing" required>
	</div>
	
	<div class="input-group input-group mb-3">
	  <span class="input-group-text" id="inputGroup-sizing">Commission_pct</span>
	  <input type="text" class="form-control" name="commission_pct" aria-describedby="inputGroup-sizing" required>
	</div>
	
	<div class="input-group mb-3">
	  <label class="input-group-text" for="inputGroupSelect01">Manager_id</label>
	  <select class="form-select" id="inputGroupSelect01" name="manager_id">
		   <c:forEach var="i" items="${manId }" varStatus="status">
		  	<option>${i.manager_id }</option>
		  </c:forEach>
	  </select>
	</div>
	
	<div class="input-group mb-3">
	  <label class="input-group-text" for="inputGroupSelect01">Department_id</label>
	  <select class="form-select" id="inputGroupSelect01" name="department_id">
		   <c:forEach var="i" items="${deptId }" varStatus="status">
		  	<option>${i.department_id }</option>
		  </c:forEach>
	  </select>
	</div>
	
	<div class="pb-2">
		<input class="btn btn-primary" type="submit" value="추가" /> 
		<a class="btn btn-danger" href="./index?page=1&amount=10">취소</a>
	</div>
</form>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" 
	crossorigin="anonymous"></script>
</body>
</html>