<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="5;URL='TopAction'"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<link rel="stylesheet" href="./css/clear.css">
<title>退会完了</title>

</head>
<body>
<jsp:include page="include_header.jsp" />
<div class="main">
<span class="moji">退会処理が完了いたしました。</span>
<div class="moji">またのご利用をお待ちしております。</div>
<div class="moji">このページは5秒後に自動的にホーム画面に移動します。</div>
<div class="moji2"><a href='<s:url action="HomeAction"/>'>ホームへ</a></div>
</div>



<jsp:include page="include_footer.jsp" />

</body>
</html>