<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String userId = (String)session.getAttribute("userId");
%>
<style>
header {
	width:100%;
	height:80px;
	color: white;
	font-size: 15px;
}

.logo {
	float: left;
	margin: 20px;
}

ul {
	float: right;
	margin: 10px;
	list-style-type: none;
}

li {
	float: left;
	color: #FFD700;
	font-weight: bolder;
	margin: 20px;
	list-style-type: none;
}

.down {
	width: 100%;
	height: 40px;
	float: right;
	margin: 20px;
	line-height: 40px;
}

a {
	color: #FFD700;
	text-decoration: none;
}

</style>

<header>

<div class="up">


<div class="logo"><a href='<s:url action="HomeAction"/>'>ロゴ(ホームにいく)</a></div>



	<ul><% if( userId == null){ %>
		<li><a href='<s:url action="LoginAction"/>'>ログイン</a></li>
<% }else{ %>
<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
		<li><s:form action="MyPageAction">

				<s:submit value="マイページ" class="submit" />
				<br>
			</s:form></li><% } %>
		<li><s:form action="CartProductAction">
				<s:submit value="カート" class="submit" />
			</s:form></li>


	</ul>

	</div>
<!-- 検索ボックスをインクルード -->
	<br>
	<jsp:include page="headerSearch.jsp" />

	<div class="down">

	</div>
</header>