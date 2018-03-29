<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String userId = (String)session.getAttribute("userId");
%>
<!-- ファビコン設定 -->
<script>
window.onload = function() {
	var link = document.createElement("link");
	link.setAttribute("rel", "icon");
	link.setAttribute("href", './images/icon/favicon.ico');
	document.head.appendChild(link);
}
</script>

<style>
header {
	width:100%;
	height:200px;
	color: white;
	font-size: 15px;
font-family: arial black, Helvetica, sans-serif;
	background:linear-gradient(to bottom,black,rgba(0,0,0,0.1));

}


.logo {
	float: left;
	margin:30px;
	width:45px;
	height:45px;


}

.ul {
	float: right;
	margin:5px;
	list-style-type: none;
}

ul li {
	float: left;
	color: #FFD700;
	font-weight: bolder;
	margin-left:15px;
	list-style-type: none;
	margin-right:25px;
}

a {
	color: #FFD700;
	text-decoration: none;
	font-size:15px;
}


a:hover{
    color: #ff9900;
}

.gest{
	font-weight: bold;
	}


</style>

<header>

<div class="logo"><a href='<s:url action="TopAction"/>'><img src="./images/icon/logo.png"/></a></div>

	<span class="gest">
	<br>
	<s:if test="#session.masterFlg">
		<span style="color: red;"><a href='<s:url action="MasterProductChangeAction" />'>管理者ページ</a></span>
	</s:if><s:elseif test="#session.loginFlg">
		ようこそ! <s:property value="#session.loginFirstName"/>さん
	</s:elseif><s:else>
		ようこそ! ゲストさん
	</s:else></span>

	<ul class="ul"><s:if test="#session.loginFlg">
		<li class="li"><a href='<s:url action="LogoutAction"/>'>ログアウト　<img src="./images/icon/kagi2.png" width="15" height="20"></a></li><li>|</li>
		<li class="li"><a href='<s:url action="MyPageAction"/>'>マイページ　<img src="./images/icon/mypage.png" width="15" height="20"></a></li>
	</s:if><s:else>
		<li class="li"><a href='<s:url action="LoginAction"/>'>ログイン　<img src="./images/icon/kagi1.png" width="15" height="20"></a></li>
	</s:else>
	<li>|</li>

		<li>
			<a href='<s:url action="CartProductAction"/>'>カート　<img src="./images/icon/cart.png" width="20" height="20"></a></li>
	</ul>
<!-- 検索ボックスをインクルード -->
	<jsp:include page="headerSearch.jsp" />

</header>