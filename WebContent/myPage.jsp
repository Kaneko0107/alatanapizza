<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
<title>マイページ画面</title>
<style type="text/css">

</style>

</head>
<body>

<jsp:include page="include_header.jsp" />




	<div class="header"></div>



	<div class="main">

		<div class="Registration">

			<div class="sectionInner">

				<div class="sectionHeader">
					<h3>会員登録情報</h3>
					<!-- sectionHeader -->
				</div>

				<div class="contBody">
					<table>
						<tbody>
							<s:iterator value="myPageList">
								<tr>
									<th>氏名</th>
									<td>
										<p>
				<!-- s:propertyを用いてMyPageActionのmyPageListから情報を参照 -->
											<s:property value="familyName" />
											<s:property value="firstName" />
										<p>
									</td>
								</tr>

								<tr>
									<th>ふりがな</th>
									<td><p>
											<s:property value="familyNameKana" />
											<s:property value="firstNameKana" />
										<p></td>
								</tr>

								<tr>
									<th>性別</th>
									<td><p>
				<!-- DBにTinyInt型でデータが入っており、getBooleanで値を取得-->
											<s:if test="sex==0">男性</s:if>
											<s:else>女性</s:else>
										<p></td>
								</tr>

								<tr>
									<th>メールアドレス</th>
									<td><s:property value="email" /></td>
								</tr>

								<tr>
									<th>alatanapizza ID</th>
									<td><p>
											<s:property value="userId" />
										</p></td>
								</tr>

								<tr>
									<th>パスワード</th>
									<td><p>
											<s:property value="password" />
										</p></td>
			<!-- パスワード変更画面へ遷移 -->
									<td class="change"><a href="ChangePasswordAction"
										class="btn">変更</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>





			<!-- 購入履歴ページに遷移 -->
					<div class="buttonBox">
						<div class="btnn">
							<a href="PurchaseHistoryAction" class="button">購入履歴へ</a>
						</div>
					</div>
				</div>

			<!-- お気に入りページに遷移 -->
					<div class="buttonBox2">
						<div class="btnn2">
							<a href='<s:url action="FavoriteAction"/>'>お気に入り一覧へ</a>
						</div>
					</div>

			<!-- ユーザー情報変更ページに遷移 -->
					<div class="buttonBox3">
						<div class="btnn3">
							<a href='<s:url action="UserUpdateAction"/>'>ユーザー情報を変更する</a>
						</div>
					</div>

			<!-- ホームに遷移 -->
					<div class="buttonBox4">
						<div class="btnn4">
							<a href='<s:url action="HomeAction"/>'>ホームへ</a>
						</div>
					</div>



			</div>
		</div>
	</div>

<jsp:include page="include_footer.jsp" />

</body>
</html>