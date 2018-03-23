<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<title>あて先情報選択画面</title>
<style type="text/css">
/*========TAG LAYOUT========*/
h2{
margin-top:70px;
}
/*========ID LAYOUT========*/
.main{
clear:both;
text-align
margin: 0 auto;
margin-top:90px;
}
</style>
</head>
<body>
<h2>お届け先の選択</h2><br>
<s:form action="">
<div class="main">

<s:iterator value="destinationInfoListDTO">
<table>
<tr>
<td>ふりがな:</td>
<td><s:property value="familyNameKana"/><s:property value="firstNameKana"/></td>
<tr>
<td>氏名:</td>
<td><s:property value="familyName"/><s:property value="firstName"/></td>
<tr>
<tr>
<td>郵便番号:</td>
<td><s:property value="zip11"/><s:property value="zip11"/></td>
<tr>
<td>住所:</td>
<td><s:property value="addr11"/></td>
<td><input type=radio name="destination" value="<s:property value='destinationInfoListDTO'/>" checked="checked"/></td>
</tr>
<tr>
<td>電話番号:</td>
<td><s:property value="telNumber"/></td>
</tr>
<tr>
<td>メールアドレス:</td>
<td><s:property value="email"/></td>
</tr>
</table>
</s:iterator>
<s:a href="javascrrpt:void(0)"
onclick="document.SettlementCompleteAction.submit();return false;" class="button">購入</s:a>

</div>
</s:form>



</body>
</html>