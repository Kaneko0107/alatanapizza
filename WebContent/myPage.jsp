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
	<link rel="stylesheet" href="./css/alatanapizza.css">
<title>マイページ</title>
<style type="text/css">
#main{
width:70%;
background:rgba(0,0,0,0.5);
margin-top:60px;
margin-left:15%;
margin-bottom:30px;
}

table{
width:80%;
	margin:0 auto;
	text-align: left;

}


.id {text-align:right;
	}

hr{border: none;
	border-top: dashed 1px #ccc;
	height: f1px;
	color: #ffffff;
	margin: 0 8 0 8;}
tr td{
padding:10px;
}
h3{
border-left:10px solid red;
}

.line{
font-weight:900;
background-color: rgba(150, 150, 150, 0.5);
}


.line1{

background-color: rgba(150, 150, 150, 0.5);

}


</style>

</head>
<body>

<jsp:include page="include_header.jsp" />





	<div id="main">



			<table>

				<tr><td colspan="2">	<h3>会員登録情報</h3></td></tr>

<tr><td colspan="2"><hr></td></tr>
							<s:iterator value="myPageList">
								<tr>
									<td class="line">氏名</td>
									<td class="line1">

				<!-- s:propertyを用いてMyPageActionのmyPageListから情報を参照 -->
											<s:property value="familyName" />
											<s:property value="firstName" />

									</td>
								</tr>

								<tr>
									<td class="line">ふりがな</td>
									<td class="line1">
											<s:property value="familyNameKana" />
											<s:property value="firstNameKana" />
									</td>
								</tr>

								<tr>
									<td class="line">性別</td>
									<td class="line1">
				<!-- DBにTinyInt型でデータが入っており、getBooleanで値を取得-->
											<s:if test="sex==0">男性</s:if>
											<s:else>女性</s:else>
										</td>
								</tr>

								<tr>
									<td class="line">メールアドレス</td>
									<td class="line1"><s:property value="email" /></td>
								</tr>

								<tr>
									<td class="line">alatanapizza ID</td>
									<td class="line1">
											<s:property value="userId" />
										</td>
								</tr>

								<tr>
									<td class="line">パスワード</td>
									<td class="line1">
											<s:property value="password" />
											<a href="ChangePasswordAction"
										class="btn">変更</a>
										</td>
			<!-- パスワード変更画面へ遷移 -->

								</tr>
							</s:iterator>
<tr><td colspan="2"><hr></td></tr>
					</table>





			<!-- 購入履歴ページに遷移 -->

						<div class="btnn">
							<a href="PurchaseHistoryAction" class="button">購入履歴へ</a>
						</div>



			<!-- お気に入りページに遷移 -->

						<div class="btnn2">
							<a href='<s:url action="FavoriteAction"/>'>お気に入り一覧へ</a>
						</div>


			<!-- ユーザー情報変更ページに遷移 -->

						<div class="btnn3">
							<a href='<s:url action="UserUpdateAction"/>'>ユーザー情報を変更する</a>
						</div>
			<!-- 退会 -->
						<div class="btnn4">
							<a href='<s:url action="ClearUserAction"/>'>退会処理へ</a>
						</div>


			<!-- ホームに遷移 -->

						<div class="btnn5">
							<a href='<s:url action="HomeAction"/>'>ホームへ</a>

					</div>



			</div>


<jsp:include page="include_footer.jsp" />

</body>
</html>