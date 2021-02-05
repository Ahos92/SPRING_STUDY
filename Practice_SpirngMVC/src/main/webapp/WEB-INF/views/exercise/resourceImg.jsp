<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이미지</title>
</head>
<body>
<h1># 웹페이지에 이미지 출력하기</h1>
<!--
    src : 이미지 경로
    alt : 이미지가 나오지 않을 때(인터넷이 느릴 때, 에러가 발생 했을 때)를 
          대비한 이미지에대한 설명

    ※ 시각장애인이나 지적장애인들을 위해 웹페이지를 읽어주는 프로그램들은
        alt속성에 정의된 텍스트를 읽도록 설계되어있다.
-->
<h3># 잘못된 경로 이미지</h3>
<img src="/practice_mvc/static/sun2.jpg" alt="선넘네 ..." title="선넘네..."
>
<h3># 원본 사이즈</h3>
<img src="/practice_mvc/static/sun.jpg" alt="선넘네 ..." title="선넘네...">
<!-- 
    width / height : 너비 / 높이 조절. 하나만 설정하면 다른하나는 자동으로 조절.
-->
<h3># 가로 300px</h3>
<img src="/practice_mvc/static/sun.jpg" alt="선넘네 ..." width="300" title="선넘네...">

<h3># 세로 300px</h3>
<img src="/practice_mvc/static/sun.jpg" alt="선넘네 ..." height="300" title="선넘네...">

<h3># 가로 300px 세로 300px</h3>
<img src="/practice_mvc/static/sun.jpg" alt="선넘네 ..." width="300" height="300" title="선넘네...">

<hr>
<h1># 다른 웹 서버에 저정된 URL 사용하기</h1>
<img src="https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/847/61639d9d380226f9a052178e86bb31d8.jpeg" 
     alt="아이X팔! 웹 주소" title="아이 X팔!">

<h3># 이미지는 자동으로 줄이 바뀌는 태그가 아니다 (글자 취급)</h3>   

<p>자동으로 <a href="./05_링크.html">줄이 바뀌지 않는 태그들은</a>  
    <img src="https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/847/61639d9d380226f9a052178e86bb31d8.jpeg" 
         alt="아이X팔! 웹 주소" width="40" title="아이 X팔!">
    문단 내부에 삽입하여 사용할 수있다. <br>
    이러한 요소들을 인라인 요소(inline element)라고 부른다. <br>
    ※ 줄이 바뀌는 요소들은 블록 요소(block element)라고 부른다.
</p>  

<img src="https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/847/61639d9d380226f9a052178e86bb31d8.jpeg" 
     alt="아이X팔! 웹 주소" width="40" title="아이 X팔!">
<!-- 이미지에 링크 주기 (누르면 이미지 원본으로 보내기)-->
<a href="https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/847/61639d9d380226f9a052178e86bb31d8.jpeg">
    <img src="https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/847/61639d9d380226f9a052178e86bb31d8.jpeg" 
         alt="아이X팔! 웹 주소" width="70" title="아이 X팔!"> </a> <br>

<img src="https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/847/61639d9d380226f9a052178e86bb31d8.jpeg" 
     alt="아이X팔! 웹 주소" width="80" title="아이 X팔!">
<!-- mouse액션 -->
<img src="https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/847/61639d9d380226f9a052178e86bb31d8.jpeg" 
     alt="아이X팔! 웹 주소" width="110" title="아이 X팔!"
     onmousedown="
        bodyStyle = document.body.style;
        bodyStyle.backgroundColor='black';
        bodyStyle.color='white';
    "
    onmouseup="
        bodyStyle = document.body.style;
        bodyStyle.backgroundColor='white';
        bodyStyle.color='black';
    ">

    <p onclick="
        bodyStyle = document.body.style;
        bodyStyle.backgroundColor='white';
        bodyStyle.color='black';">
    Light Mode
    </p>

    <p onclick="
        bodyStyle = document.body.style;
        bodyStyle.backgroundColor='black';
        bodyStyle.color='white';">
    Dark Mode
    </p>
</body>
</html>