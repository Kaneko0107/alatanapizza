<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<link rel="stylesheet" href="./css/alatanapizza.css">

<title>新商品追加</title>

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

</head>
<body>

<jsp:include page="include_header.jsp" />

<fieldset>
	<legend>
		サイドメニュー追加画面
	</legend>

	<div class="instruction">
		<h3>追加したい商品情報を入力してください。</h3>
	</div>

	<ul>
	<s:iterator value="errorMessageList">
		<li><span style="color:red"><s:property/></span></li>
	</s:iterator>
	</ul>
	<div class="main">
			<table>
				<s:form action="MasterAddConfirmAction"  method="post" enctype="multipart/form-data">
					<tr>
						<td>
							<label>商品名:</label>
						</td>
						<td>
							<input type="text" name="itemName" value=""  placeholder="20文字以下で入力"/>
						</td>
					</tr>

					<tr>
						<td>
							<label>商品名(ひらがな):</label>
						</td>
						<td>
							<input type="text" name="itemKanaName" value="" placeholder="30文字以下で入力"/>
						</td>
					</tr>

					<tr>
						<td>
							<label>価格:</label>
						</td>
						<td>
							<input type="text" name="itemPrice" value="" placeholder="上限10,000円 半角数字"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>個数:</label>
						</td>
						<td>
							<select name="itemStock">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>

							</select>
						</td>
					</tr>

					<!-- 商品画像 -->
					<tr>
						<td>画像</td>
						<td><s:select name="imageName" id="image_bname" list="imageFileNames"/></td>
					</tr>

					<!-- 登録ボタン -->
					<tr>
						<td><s:submit value="登録"/></td>
					</tr>

				</s:form>
					<!-- 戻るボタン -->
					<tr>
						<td><a href='<s:url action="MasterProductChangeAction?listFlg=1"/>'>管理者画面に戻る</a></td>
					</tr>
			</table>
		</div>
	</fieldset>

<jsp:include page="include_footer.jsp" />
</body>
</html>