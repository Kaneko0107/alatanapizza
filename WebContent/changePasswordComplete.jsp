<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>パスワード変更完了</title>
<style>
.main{
width:50%;
margin-top:70px;
margin-left:25%;
margin-bottom:30px;
}
.moji {
	    text-align: center;
	    font-size: 20px;
	    color: #FFCC33;
	    margin-bottom:30px;
	    }
</style>
</head>
<body>
<jsp:include page="include_header.jsp" />
<div class="main">
<s:if test="#session.newpass == null">
<span id="error">パスワードの変更に失敗しました。<br>
お手数ですが最初からやり直してください。
</span>
<a href='<s:url action="ChangePasswordAction"/>'>再設定画面へ</a>
</s:if>
<s:else>
<div class="moji">再設定が完了しました。</div>
 <div>
       <a href="<s:url action='LoginAction'/>">ログイン画面へ</a>
      </div>


</s:else>
</div>
<jsp:include page="include_footer.jsp"/>


</body>
</html>