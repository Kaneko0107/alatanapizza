<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<link rel="stylesheet" href="./css/alatanapizza.css">

	<title>追加商品確認</title>
</head>
<style type="text/css">
table{
	width:30%;
	margin:0 auto;
	text-align: left;
}
fieldset{
	width: 50%;
	background: rgba(0, 0, 0, 0.5);
	margin:0 auto;
	margin-top:80px;
	margin-bottom:100px;
}
legend{
	color:white;
	font-size:20px;
	font-weight: bold;
}
</style>
	<body>

	<jsp:include page="include_header.jsp" />

<fieldset>
	<legend>
		新商品追加確認画
	</legend>

		<div class="confirm">
			<h3>以下の商品を新しく追加します。よろしいですか？</h3>
		</div>

		<div class="main">
			<table>

					<tr>
						<td>
							<label>商品名:</label>
						</td>
						<td>
							<s:property value="itemName" />
						</td>
					</tr>
					<tr>
						<td>
							<label>商品名(ひらがな):</label>
						</td>
						<td>
							<s:property value="itemKanaName"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>価格:</label>
						</td>
						<td>
							<s:property value="itemPrice"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>個数:</label>
						</td>
						<td>
							<s:property value="itemStock"/>
						</td>
					</tr>

			</table>
		</div>
</fieldset>

								<s:form action="MasterAddCompleteAction">
								<s:submit value="登録する"/>
								<input type="hidden" name="itemName" value="<s:property value="itemName"/>"/>
								<input type="hidden" name="itemKanaName" value="<s:property value="itemKanaName"/>">
								<input type="hidden" name="itemStock" value="<s:property value="itemStock"/>">
								<input type="hidden" name="itemPrice" value="<s:property value="itemPrice"/>">
								<input type="hidden" name="imageName" value="<s:property value="imageName"/>">
							</s:form>

							<div class="back">
								<a href="MasterAddAction.action">戻 る</a>
							</div>



	<jsp:include page="include_footer.jsp" />

	</body>
</html>