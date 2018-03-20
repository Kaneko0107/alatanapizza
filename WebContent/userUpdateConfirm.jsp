<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>ユーザー情報変更確認画面</title>
<script type="text/javascript">
window.onunload=function(){};
history.forward();
</script>
<style>
table {
	width: 80%;
	margin: 0 auto;
	text-align: left;
}
tr td {
	padding-right: 30px;
	padding-left: 20px;
	padding-top: 5px;
}
table {
	width: 80%;
	margin: 0 auto;
	text-align: left;
	padding-left:20px;
}.moji{
text-align:center;
	    font-size: 20px;
	    color: #FFCC33;
}
</style>
</head>
<body>
<jsp:include page="include_header.jsp" />

<table>
<s:form action="UserUpdateCompleteAction">
  <tr>
   <td><div class="moji">ユーザーID</div></td>
   <td><s:property value="%{session.userId}"/>
   <s:hidden name="user_id" value="%{session.userId}" /></td>
   </tr>
   <s:if test="newPassword != ''" >
   <tr>
   <td><div class="moji">新規パスワード</div></td>
   <td><s:property value="newPassword"/>
   <s:hidden name="newPassword" value="%{newPassword}" /></td>
   </tr>
   </s:if>
   <s:if test="newEmail != ''" >
   <tr>
   <td><div class="moji">メールアドレス</div></td>
   <td><s:property value="newEmail"/>
   <s:hidden name="newEmail" value="%{newEmail}" /></td>
   </tr>
   </s:if>
   <tr>
   <td>変更内容が正しければ右のボタンで変更を完了してください。</td>
   <td><s:a href="javascrrpt:void(0)"
	onclick="document.UserUpdateCompleteAction.submit();return false;"
	 class="button"><input type="image" src="./images/icon/登録する .png" alt="touroku"></s:a>
	 </s:form>
  </table>



<jsp:include page="include_footer.jsp"/>
</body>
</html>