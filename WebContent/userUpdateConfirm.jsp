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
}
.moji{
text-align:center;
	    font-size: 20px;
	    color: #FFCC33;
}
.moji2{
text-align:right;
	    font-size: 20px;
	    color: #FFCC33;
}
.image2 {

	    text-align:right;
	    margin-top: 5px;
	    }
</style>
</head>
<body>
<jsp:include page="include_header.jsp" />

<table>
<s:form action="UserUpdateCompleteAction">
  <tr>
   <td><div class="moji">ユーザーID</div></td>
   <td><s:property value="%{user_id}"/>
   <s:hidden name="user_id" value="%{user_id}" /></td>
   </tr>
   <tr>
   <s:if test='newPassword !=""'>
   <td>
   <div class="moji">新規パスワード</div></td>
   <td>
   <s:property value="hideNewPassword"/>
   </td>
   </s:if>
   </tr>
   <s:hidden name="newPassword" value="%{newPassword}" />
   <tr>
   <td><div class="moji">メールアドレス</div></td>
   <td><s:property value="newEmail"/>
   <s:hidden name="newEmail" value="%{newEmail}" /></td>
   </tr>
   <tr>
   <td><div class="moji">姓</div></td>
   <td><s:property value="familyName"/>
   <s:hidden name="familyName" value="%{familyName}" /></td>
   </tr>
   <tr>
   <td><div class="moji">名</div></td>
   <td><s:property value="firstName"/>
   <s:hidden name="firstName" value="%{firstName}" /></td>
   </tr>
   <tr>
   <td><div class="moji">せい</div></td>
   <td><s:property value="familyNameKana"/>
   <s:hidden name="familyNameKana" value="%{familyNameKana}" /></td>
   </tr>
   <tr>
   <td><div class="moji">めい</div></td>
   <td><s:property value="firstNameKana"/>
   <s:hidden name="firstNameKana" value="%{firstNameKana}" /></td>
   </tr>


   <tr>
   <td><div class="moji2">変更内容が正しければ右のボタンで変更を完了してください。</div></td>
   </tr>
   <tr>
   <td><a href='<s:url action="UserUpdateAction"/>'><img class="icon" src="./images/icon/modoru2.png"></a></td>
   <td><div class="image2"><s:a href="javascrrpt:void(0)"
	onclick="document.UserUpdateCompleteAction.submit();return false;"
	 class="button"><input type="image" class="icon" src="./images/icon/登録する .png" alt="touroku"></s:a></div>
	 </td>
	 </tr>
	 </s:form>
  </table>



<jsp:include page="include_footer.jsp"/>
</body>
</html>