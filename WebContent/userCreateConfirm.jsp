<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>

	<link rel="stylesheet" href="./css/alatanapizza.css">

	<title>ユーザー登録 確認</title>

	<style>


#main {
		width:70%;
		background:rgba(0, 0, 0, 0.5);
		margin:0 auto;
		margin-top:80px;
		margin-bottom:100px;
		}

table {
		width:70%;
		margin:0 auto;
		text-align:left;
		}

h3 {
		border-left:10px solid red;
		}

.title {
		font-size:20px;
		}

tr td {
		padding-right:60px;
		padding-left:20px;
		padding-top:5px;
		}

hr {
		text-align:left;
		border:none;
		border-top:dashed 1px #ccc;
		height:1px;
		color:#ffffff;
		margin:0 8 0 8;
		}

.icon {
		text-align:center;
		display:flex;
		flex-direction:row-reverse;
		}

.moji {
		text-align: center;
		font-size: 12px;
		color: #FFCC33;
		}

.moji2{
		font-size: 12px;
		color: #FFCC33;
		}

	</style>
</head>


<body>

	<jsp:include page="include_header.jsp" />

	<div id="main">

	<table>

	<tr><td colspan="2"><h3>ユーザー登録 確認</h3></td></tr>
    <tr><td colspan="2"><div class=moji2>登録する内容は以下でよろしいですか？</div></td></tr>
    <tr><td colspan="2"><hr></td></tr>


	<tr id="box">
		<td>ユーザーＩＤ</td>
		<td> <s:property value="loginUserId"/> </td>
	</tr>

	<tr id="box">
		<td>パスワード</td>
		<td> <s:property value="loginPassword" /> </td>
	</tr>

	<tr id="box">
		<td>お名前（姓）</td>
		<td> <s:property value="familyName" /> </td>
	</tr>

	<tr id="box">
		<td>お名前（名）</td>
		<td> <s:property value="firstName" /> </td>
	</tr>

	<tr id="box">
		<td>ふりがな（姓）</td>
		<td> <s:property value="familyNameKana"/> </td>
	</tr>

	<tr id="box">
		<td>ふりがな（名）</td>
		<td> <s:property value="firstNameKana"/> </td>
	</tr>

	<tr id="box">
		<td>性別</td>
		<td><s:if test="sex==0">男</s:if>
			<s:if test="sex==1">女</s:if>
		</td>
	</tr>

	<tr id="box">
		<td>メールアドレス</td>
		<td> <s:property value="mail"/> </td>
	</tr>

	<tr id="box">
		<td>秘密の質問</td>
		<td> <s:if test="secretQuestion==1">好きな食べ物</s:if>
		<s:if test="secretQuestion==2">嫌いな食べ物</s:if>
		</td>
	</tr>

	<tr id="box">
		<td>答え</td>
		<td> <s:property value="secretAnswer"/> </td>
	</tr>

	<tr><td colspan="2"><hr></td></tr>

	<s:form action="UserCreateAction">

	<tr>
		<td>
		<br><div class="icon">
			<input type="image" src="./images/icon/modoru2.png">
		</div>
		</td>

		<td>
		<br><div class="icon">
			<a href='<s:url action="UserCreateCompleteAction"/>'><img src="./images/icon/登録する .png"></a>
		</div>
		</td>
	</tr>

	<input type="hidden" name="loginUserId" value="<s:property value="loginUserId"/>"/>
	<input type="hidden" name="loginPassword" value="<s:property value="loginPassword"/>">
	<input type="hidden" name="familyName" value="<s:property value="familyName"/>">
	<input type="hidden" name="firstName" value="<s:property value="firstName"/>">
	<input type="hidden" name="familyNameKana" value="<s:property value="familyNameKana"/>">
	<input type="hidden" name="firstNameKana" value="<s:property value="firstNameKana"/>">
	<input type="hidden" name="sex" value="<s:property value="sex"/>">
	<input type="hidden" name="mail" value="<s:property value="mail"/>">
	<input type="hidden" name="secretQuestion" value="<s:property value="secretQuestion"/>">
	<input type="hidden" name="secretAnswer" value="<s:property value="secretAnswer"/>">

	</s:form>

	</table>

	</div>

	<jsp:include page="include_footer.jsp" />

</body>
</html>