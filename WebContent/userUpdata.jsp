<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<link rel="stylesheet" href="./css/userAdd.css">
<title>ユーザー情報変更画面</title>

</head>
<body>
<jsp:include page="include_header.jsp" />
<div id="main">
<table>
<tr><td colspan="2"><h3>ユーザー情報変更画面</h3></td></tr>
<tr><td colspan="2"><hr></td></tr>
<tr><td colspan="2"><div class="moji">お客様の登録されているパスワードから以下の項目を変更できます。</div></td></tr>
<tr><td colspan="2"><div class="moji">指定に従って以下の項目を入力し、下記の確認ボタンを押してください</div></td></tr>
<tr><td colspan="2"><div class="moji">変更したくない項目は、空欄または初期状態のまま処理を進めてください。</div></td></tr>

<s:if test="errorMessage!=''">
   <tr><td colspan="2"><s:iterator value="errMsgList">

<div class="moji1">
			<s:property />
</div>

		</s:iterator></td></tr>
		</s:if>
<s:form action="UserUpdateConfirmAction">


   <tr>
   <th>ユーザーID</th>
   <td><s:property value="%{session.userId}" />
   <s:hidden name="user_id" value="%{session.userId}"/>
   </td>
   </tr>
   <tr>
   <th>現在のパスワード</th>
   <td><s:password name="password" placeholder="1～16文字の半角英数字" class="form"/></td>
   </tr>
   <tr>
   <th>新規パスワード</th>
   <td><s:password name="newPassword" placeholder="1～16文字の半角英数字" class="form"/></td>
   </tr>
   <tr>
   <th>確認用パスワード</th>
   <td><s:password name="conPassword" placeholder="確認のため再入力" class="form"/></td>
   </tr>
   <tr>
   <th>メールアドレス</th>
   <s:if test="newEmail != null">
   <td><s:textfield name="newEmail" placeholder="14文字以上32文字以下" value="%{newEmail}" class="form"/></td>
   </s:if>
   <s:else>
    <td><s:textfield name="newEmail" placeholder="14文字以上32文字以下"  value="%{dto.email}" class="form"/></td>
   </s:else>
   </tr>
   <tr>
  <th>お名前</th>
   </tr>
   <tr>
   <th>姓</th>
    <s:if test="familyName != null">
   <td><s:textfield name="familyName" value="%{familyName}" placeholder="1文字以上16文字以下" class="form"/></td>
   </s:if>
   <s:else>
    <td><s:textfield name="familyName" placeholder="1文字以上16文字以下" value="%{dto.familyName}" class="form"/></td>
   </s:else>
   </tr>
   <tr>
   <th>名</th>
    <s:if test="firstName != null">
   <td><s:textfield name="firstName" value="%{firstName}" placeholder="1文字以上16文字以下" class="form"/></td>
   </s:if>
   <s:else>
    <td><s:textfield name="firstName" placeholder="1文字以上16文字以下" value="%{dto.firstName}" class="form"/></td>
   </s:else>
   </tr>
   <tr>
   <th>ふりがな</th>
   </tr>
   <tr>
    <th>せい</th>
   <s:if test="familyNameKana != null">
   <td><s:textfield name="familyNameKana" value="%{familyNameKana}" placeholder="1文字以上16文字以下" class="form"/></td>
   </s:if>
   <s:else>
    <td><s:textfield name="familyNameKana" placeholder="1文字以上16文字以下" value="%{dto.familyNameKana}" class="form"/></td>
   </s:else>
   </tr>
   <tr>
   <th>めい</th>
     <s:if test="firstNameKana != null">
   <td><s:textfield name="firstNameKana" value="%{firstNameKana}" placeholder="1文字以上16文字以下" class="form"/></td>
   </s:if>
   <s:else>
    <td><s:textfield name="firstNameKana" placeholder="1文字以上16文字以下" value="%{dto.firstNameKana}" class="form"/></td>
   </s:else>
   </tr>
<tr><td colspan="2"><hr></td></tr>
   <tr><td><a href='<s:url action="MyPageAction"/>'><img class="icon" src="./images/icon/modoru2.png"></a></td>
   <td><div class="image2">
   <s:a href="javascrrpt:void(0)"
	onclick="document.UserUpdateConfirmAction.submit();return false;"
	 class="button"><input class="image2" type="image" src="./images/icon/kakuninn.png" alt="touroku"></s:a>
   </div></td></tr>
   <br>
   </s:form>
   </table>
   </div>


   <jsp:include page="include_footer.jsp"/>

</body>
</html>