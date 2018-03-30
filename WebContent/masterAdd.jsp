<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link rel="stylesheet" href="./css/alatanapizza.css">

<title>新商品追加</title>

<style type="text/css">
table {
	width: 60%;
	margin: 0 auto;
	text-align: left;
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

.submit {
	text-align: right;
}

div.image {
	text-align: center;
}

.image {
	margin-top: 10%;
}

.message {
	margin-top: 0;
}
</style>

</head>
<body>

	<jsp:include page="include_header.jsp" />

	<fieldset>
		<legend>
			<img class="image" src="./images/icon/SIDE2.png" alt="icon">

		</legend>
		<h3 class="message">メニュー追加画面</h3>

		<div class="instruction">
			<p>追加したい商品情報を入力してください。</p>
		</div>

		<tr>
			<s:iterator value="errorMessageList">
				<td><span style="color: red"><s:property /><br></span></td>
			</s:iterator>
		</tr>
		<div class="main">
			<table>
				<s:form action="MasterAddConfirmAction" method="post"
					enctype="multipart/form-data">
					<tr>
						<td><label>商品名:</label></td>
						<td><input type="text" name="itemName" value=""
							placeholder="20文字以下で入力" /></td>
					</tr>

					<tr>
						<td><label>商品名(ひらがな):</label></td>
						<td><input type="text" name="itemKanaName" value=""
							placeholder="30文字以下で入力" /></td>
					</tr>

					<tr>
						<td><label>価格(上限1万円):</label></td>
						<td><input type="text" name="itemPrice" value=""
							placeholder="上限1万円 半角数字" /></td>
					</tr>
					<tr>
						<td><label>個数:</label></td>
						<td><select name="itemStock">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>

						</select></td>
					</tr>

					<!-- 商品画像 -->
					<tr>
						<td>画像:</td>
						<td><s:select name="imageName" id="image_bname"
								list="imageFileNames" /></td>
					</tr>

					<!-- 登録ボタン -->
					<tr>
						<td colspan="2">
							<div class="image">
								<s:a href="javascrrpt:void(0)"
									onclick="document.MasterAddConfirmAction.submit();return false;"
									class="button">
									<input type="image" class="icon" src="./images/icon/登録する .png"
										alt="touroku">
								</s:a>
							</div>
						</td>

					</tr>

				</s:form>
			</table>

			<!-- 戻るボタン -->
			<a href='<s:url action="MasterProductChangeAction?listFlg=1"/>'>◀
				管理者画面に戻る</a>
		</div>
	</fieldset>

	<jsp:include page="include_footer.jsp" />
</body>
</html>