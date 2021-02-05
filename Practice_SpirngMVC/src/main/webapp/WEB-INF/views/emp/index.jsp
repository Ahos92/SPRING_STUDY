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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" 
	crossorigin="anonymous"></script>
<title>사원 조회 페이지</title>
</head>
<body>

<div class="container" style="max-width: 900px;">
<h1 class="text-center">사원 조회 페이지</h1>
<div class="d-flex d-flex justify-content-end">
	<div class="px-1">
		<a class="btn btn-primary btn-sm" href="./index?page=1&amount=5">5개씩 보기</a>
	</div>
	<div class="px-1">
		<a class="btn btn-primary btn-sm" href="./index?page=1&amount=10">10개씩 보기</a>
	</div>
	<div class="px-1">
		<a class="btn btn-primary btn-sm" href="./index?page=1&amount=15">15개씩 보기</a>
	</div>
	<div class="px-1">
		<a class="btn btn-primary btn-sm" href="./index?page=1&amount=20">20개씩 보기</a>
	</div>
</div>

<div class="d-flex d-flex justify-content-start">
	<form action="./addpage" method="POST">
		<button type="submit" class="btn btn-success btn-sm">신입사원 추가</button>
	</form>
</div>
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
  <!-- 모든 정보가 아닌 보여줄 정보만 EmpMainListVO라는 VO로 가져오는게 더 좋음 -->
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

<c:url var="nextHref" value="./index?page=${page.startPage - page.size}&amount=${page.amount}" />
<c:url var="preHref" value="./index?page=${page.startPage + page.size}&amount=${page.amount}" />

<nav aria-label="...">
  <ul class="pagination justify-content-center">                
          <li class="page-item<c:if test="${not page.prev }"> disabled</c:if>">
             <a class="page-link" href="${nextHref}" tabindex="-1" aria-disabled="true">&laquo;</a>
          </li>
          <c:forEach var="i" begin="${page.startPage }" end="${page.endPage }">                                
                  <li class="page-item<c:if test="${page.currPage eq i }"> active</c:if>" aria-current="page">
                        <a class="page-link" href="./index?page=${i }&amount=${page.amount}">${i }</a>
              </li>                                
          </c:forEach>
          <li class="page-item<c:if test="${not page.next || page.endPage eq page.lastPage}"> disabled</c:if>">
              <a class="page-link" href="${preHref}" tabindex="-1" aria-disabled="true">&raquo;</a>
          </li>    
    </ul>
</nav>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.js" 
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" 
	crossorigin="anonymous"></script>
</body>
</html>