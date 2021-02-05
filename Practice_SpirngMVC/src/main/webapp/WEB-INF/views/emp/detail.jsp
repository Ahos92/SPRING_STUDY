<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" 
	crossorigin="anonymous">

<style type="text/css">
	img{
		height: 250px;
		width: 200px;
	}
</style>

<title>상세 페이지</title>

</head>
<body>

<h1 class="text-center">상세 페이지</h1>
<div class="d-flex justify-content-center">
<div class="card" style="width: 30rem;">
  <div class="row">
    <div class="col-md-4 pe-3 pt-5">
    
    <!-- 
    	 / : http://localhost:8080/
     -->
  		<img alt="사진" src="/practice_mvc/resources/img/profile.png"/>
    </div>
  <div class="col-md-8 ps-4">
  <div class="card-body">
  <p class="card-text">
    <table class="table table-success table-striped">
  		<thead>
	    <tr>
	       <th scope="col">#</th>
	       <th scope="col">#</th>
	    </tr>
	    </thead>
	    <tbody>
	    <tr>
	      <th scope="row">ID</th>
	      <td>${emp.employee_id }</td>
	    </tr>
	     <tr>
	      <th scope="row">Name</th>
	      <td>${emp.first_name } ${emp.last_name }</td>
	    </tr>
	     <tr>
	      <th scope="row">Email</th>
	      <td>${emp.email }</td>
	    </tr>
	     <tr>
	      <th scope="row">Tel</th>
	      <td>${emp.phone_number }</td>
	    </tr>
	     <tr>
	      <th scope="row">Hire_date</th>
	      <td><fmt:formatDate value="${emp.hire_date }" pattern="yyyy-MM-dd"/></td>
	    </tr>
	     <tr>
	      <th scope="row">Job_ID</th>
	      <td>${emp.job_id }</td>
	    </tr>
	       <tr>
	      <th scope="row">Salary</th>
	      <td>${emp.salary }</td>
	    </tr>
	       <tr>
	      <th scope="row">Commission_pct</th>
	      <td>${emp.commission_pct }</td>
	    </tr>
	       <tr>
	      <th scope="row">Manager_ID</th>
	      <td>${emp.manager_id }</td>
	    </tr>
	       <tr>
	      <th scope="row">Department_ID</th>
	      <td>${emp.department_id }</td>
	    </tr>
	    </tbody>
	</table>
    </p>
  </div>
 </div>
 </div>
</div>
</div>

<div class="d-flex justify-content-center">
	<div class="">
		<form action="./updatepage" method="POST">
		<input type="hidden" name="id" value="${emp.employee_id}" />
		<input class="btn btn-primary" type="submit" value="수정">
		</form>
	</div>
	
	<%-- 내가 한 hidden으로 보내기
	<div class="ps-1 pe-5">
		<form action="./delete" method="POST">
		<input type="hidden" name="id" value="${emp.employee_id}" />
		<input class="btn btn-danger" type="submit" value="삭제">
		</form>
	</div> --%>
	
	<div class="ps-1 pe-5">
		<form action="./delete/${emp.employee_id}">
		<input class="btn btn-primary" type="submit" value="삭제">
		</form>
	</div>
	
	<div class="px-5 ps-5">
		<a class="btn btn-success" href="./index?page=1&amount=10">돌아가기</a>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" 
	crossorigin="anonymous"></script>
</body>
</html>