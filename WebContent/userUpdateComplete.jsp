<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>変更完了	</title>
</head>
<body>
<jsp:include page="include_header.jsp" />
<div id="main">
<div id="title"><p>ユーザー情報変更完了<p></div>
<div>
<h3>ユーザー情報の変更が完了しました。</h3>
<br>
<a href="<s:url action='MyPageAction'></s:url>"  class="button">マイページ</a>
</div>
</div>
<jsp:include page="include_footer.jsp"/>
</body>
</html>