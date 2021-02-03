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

<title>사원 조회 페이지</title>
</head>
<body>

<h1 class="text-center">사원 조회 페이지</h1>

<table class="table container-xxl">
  <thead>
    <tr>
      <th scope="col">Employee_id</th>
      <th scope="col">First_name</th>
      <th scope="col">Last_name</th>
      <th scope="col">phone_number</th>
      <th scope="col">job_id</th>
      <th scope="col">salary</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${list }" var="emp" varStatus="status"> 	
	  	<tr>
	      <td><a href="./detail?id=${emp.employee_id }">${emp.employee_id }</a></td>
	      <td>${emp.first_name }</td>
	      <td>${emp.last_name }</td>
	      <td>${emp.phone_number }</td>
	      <td>${emp.job_id }</td>
	      <td>${emp.salary }</td>
	    </tr>
  	</c:forEach>
  </tbody>
</table>

<form action="./addpage" method="POST">
	<button type="submit" class="btn btn-primary">신입사원 추가</button>
</form>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item">
      <a class="page-link" href="./index?page=${page - 1 }" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
   	<c:forEach var="page" begin="1" end="${all.size() / 10 + 1}" varStatus="status">
   		<li class="page-item">
   			<a class="page-link" href="./index?page=${status.count }">${status.count }</a>
   		</li>
   	</c:forEach>
      		   	
    <li class="page-item">
      <a class="page-link" href="./index?page=${page + 1 }" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        </a>
    </li>
  </ul>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" 
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" 
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" 
	crossorigin="anonymous"></script>
</body>
</html>