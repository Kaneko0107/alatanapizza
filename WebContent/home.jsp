<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
<!-- <link rel="stylesheet" href="./css/alatanapizza.css"> -->
<link rel="stylesheet" href="./css/home.css">

<title>alatanapizza HOME画面</title>
<style type="text/css">
/* body {
	font-family: arial black, Helvetica, sans-serif;
	font-size: 15px;
	color: white;
	text-align: center;
	background-color: black;
	background-image:url("./images/icon/HomeBackground.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
/* 	background-size: cover; */
} */


body{
background-image:url("./images/icon/HomeBackground.jpg");
}
.slide-wrapper {
width:70%;
height:auto;
margin:0 auto;

}


.slide{
width:80%;
height:auto;
}

</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

  <script>
    $(document).ready(function(){
        $('.slide').bxSlider({
            auto:true,
            speed:1000,
            slidewidth:300
        });
    });
  </script>
</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />

<br>
	<div class="slide-wrapper">
		<div class="slide">
			<div>
				<a href='<s:url action="ProductListAction?listFlg=1"/>'><img src="./images/slide/slide1.jpg"></a>
			</div>
			<div>
				<a href='<s:url action="ProductListAction?listFlg=1"/>'><img src="./images/slide/slide2.jpg"></a>
			</div>
			<div>
				<a href='<s:url action="ProductListAction?listFlg=1"/>'><img src="./images/slide/slide4.jpg"></a>
			</div>
		</div>
	</div>

<br><br><br>


	<!-- フッター -->
<jsp:include page="include_footer.jsp" />
</body>
<!-- <footer> -->

<!-- 	A L A T A N A P I Z Z A -->


<!-- 	</footer> -->
</html>