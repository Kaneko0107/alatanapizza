<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="5;URL='TopAction'" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>エラーページ</title>
<style>

/* body{ */
/* background-image:url("./images/icon/backgroundError.png"); */
/* background-repeat: no-repeat; */
/* width:100%; */
/* height:100%; */


/* } */

/* .main{ */
/* width:70%; */
/* height:80%; */
/* margin-top:70px; */
/* margin-left:15%; */
/* margin-bottom:30px; */
/* } */
/* .moji { */
/* 	    text-align: center; */
/* 	    font-size: 15px; */
/* 	    color: #FFCC33; */
/* 	    } */

/* footer{ */
/* font-family: arial black, Helvetica, sans-serif; */
/* 	font-size: 15px; */
/* 	color: white; */
/* 	text-align: center; */
/* 	width:100%; */
/* 	position:fixed; */
/* 	bottom:0; */
/* } */

</style>
</head>
<body>
<jsp:include page="include_header.jsp" />

<!-- <div class="background"> -->



<div class="main">
<div class="moji">エラーが発生しました。</div>
<div class="moji">お手数ですが最初からやり直してください。</div>
<div class="moji">このページは5秒後に自動的にホーム画面へ移動します。</div>
</div>
<!-- </div> -->



</body>
<!-- <footer> -->
<!-- A L A T A N A P I Z Z A -->
<!-- </footer> -->
</html>