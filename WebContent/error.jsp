<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>エラーページ</title>
<style>
.main{
width:70%;
height:80%
background:rgba(0,0,0,0.5);
margin-top:70px;
margin-left:15%;
margin-bottom:30px;
}
.moji {
	    text-align: center;
	    font-size: 15px;
	    color: #FFCC33;
	    }

</style>
</head>
<body>
<jsp:include page="include_header.jsp" />
<div class="main">
<div class="moji">エラーが発生しました。</div>
<div class="moji">お手数ですが最初からやり直してください。</div>
</div>

<jsp:include page="include_footer.jsp"/>

</body>
</html>