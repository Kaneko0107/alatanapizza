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
margin-top:600px;
margin-bottom:30px;
	    background:rgba(0, 0, 0, 0.5);
	    margin:0 auto;
	    height:70%;

position:relative;
top:200px;
}
.moji {
	    text-align: center;
	    font-size: 20px;
	    color: #FFCC33;
	    margin-bottom:30px;
	    }

table{
margin:0 auto;
padding-top:30px;

}

hr {
	    text-align:left;
	    border:none;
	    border-top:dashed 1px #ccc;
	    height:1px;
	    color:#ffffff;
	    margin:0 8 0 8;
	    }


</style>
</head>
<body>
<jsp:include page="include_header.jsp" />
<div class="main">
<s:if test="#session.newpass == null">
<div class="error">パスワードの変更に失敗しました。<br>
お手数ですが最初からやり直してください。
</div>
<a href='<s:url action="ChangePasswordAction"/>'>再設定画面へ</a>
</s:if>
<s:else>
<br>
<table>
<tr><td><div class="moji">再設定が完了しました。</div><br>

<tr>
	<td colspan="2"><hr></td></tr>
<tr>

		<td><div class="icon5"><a href='<s:url action="LoginAction"/>'><img class="icon5" src="./images/icon/ログイン.png"></a></div></td>
	</tr>

	</table>




</s:else>
</div>
<jsp:include page="include_footer.jsp"/>


</body>
</html>