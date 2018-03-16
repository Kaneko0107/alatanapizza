<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>Complete</title>
</head>
<body>
<jsp:include page="include_header.jsp" />
<s:if test="#session.newpass == null">
<span id="error">パスワードの変更に失敗しました。<br>
お手数ですが最初からやり直してください。
</span>
<a href='<s:url action="ChangePasswordAction"/>'>再設定画面へ</a>
</s:if>
<s:else>
<div>再設定が完了しました。</div>
 <div>
        <input type="button" onclick="location.href='<s:url action="HomeAction"/>'" value="ログインへ" >
      </div>


</s:else>
<jsp:include page="include_footer.jsp"/>


</body>
</html>