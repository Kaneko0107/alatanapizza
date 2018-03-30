<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link rel="stylesheet" href="./css/alatanapizza.css">

<title>追加商品確認</title>
</head>
<style type="text/css">
table {
	width: 60%;
	margin: 0 auto;
	text-align: left;
}

td {
	width: 20%;
}

fieldset {
	width: 45%;
	background: rgba(0, 0, 0, 0.5);
	margin: 0 auto;
	margin-top: 80px;
	margin-bottom: 100px;
}

legend {
	color: white;
	font-size: 20px;
	font-weight: bold;
}
</style>
<body>

	<jsp:include page="include_header.jsp" />

	<fieldset>
		<legend> 追加確認画面 </legend>

		<div class="confirm">
			<h3>以下の商品を新しく追加します。よろしいですか？</h3>
		</div>

		<div class="main">
			<table>

				<tr>
					<td><label>商品名:</label></td>
					<td><s:property value="itemName" /></td>
				</tr>
				<tr>
					<td><label>商品名(ふりがな):</label></td>
					<td><s:property value="itemKanaName" /></td>
				</tr>
				<tr>
					<td><label>価格(上限1万円):</label></td>
					<td>¥ <s:property value="itemPrice" />
					</td>
				</tr>
				<tr>
					<td><label>個数:</label></td>
					<td><s:property value="itemStock" />個</td>
				</tr>
				<tr>
					<td><label>画像:</label></td>
					<td><img class="image" src="<s:property value='imagePath'/>"
						width="200" height="170"></td>
				</tr>

			</table>
		</div>


		<s:form action="MasterAddCompleteAction">
			<td>
				<div class="image">
					<s:a href="javascrrpt:void(0)"
						onclick="document.MasterAddCompleteAction.submit();return false;"
						class="button">
						<input type="image" class="icon" src="./images/icon/登録する .png"
							alt="touroku">
					</s:a>
				</div>
			</td>
			<input type="hidden" name="itemName"
				value="<s:property value="itemName"/>" />
			<input type="hidden" name="itemKanaName"
				value="<s:property value="itemKanaName"/>">
			<input type="hidden" name="itemStock"
				value="<s:property value="itemStock"/>">
			<input type="hidden" name="itemPrice"
				value="<s:property value="itemPrice"/>">
			<input type="hidden" name="imageName"
				value="<s:property value="imageName"/>">
		</s:form>

		<div class="back">
			<a href="MasterAddAction.action">戻 る</a>
		</div>
	</fieldset>


	<jsp:include page="include_footer.jsp" />

</body>
</html>