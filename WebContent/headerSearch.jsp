<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.product {
	float: left;
	width: 100%;

}

.product ul {
	float: right;
}

.product ul li {
	float: left;
}


.h_search {
	background: #DDDDDD;
	width: 350px;
	height: 38px;
	border-radius: 5px;
	background-color: rgba(0, 0, 0, 0.7);
	font-size:18px;
	color:white;
}

.h_search :hover{

opacity:0.8;}

/* .h_button { */
/* 	background: #FF6600; */
/* 	border: none; */
/* 	color: white; */
/* 	height: 22px; */
/* } */

.select {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	width: 120px;
	height: 42px;
	background-color: rgba(0, 0, 0, 0.7);
	border-radius: 5px;
	color:white;
	font-size:17px;
}

/* .img{width:65px; */
/* height:38px; */
/* font-size:15px; */
/* color:white; */
/* font-weight:900; */
/* background-color:#f3142c; */
/* border-radius: 8px; */
/* font-family: arial black, Helvetica, sans-serif; */

/* } */

.img:hover{
opacity:0.8;}

.img1{width:165px;
height:38px;
font-size:15px;
color:white;
font-weight:900;
background-color:#f3142c;
border-radius: 8px;
font-family: arial black, Helvetica, sans-serif;
}


.img1:hover{
opacity:0.8;}

</style>
</head>
<body>

	<div class="product">

		<ul>

			<li><s:form action="ProductSearchAction"
					id="productSearchAction">
					<select name="categoryId" class="select">
						<s:if test="categoryId != 1">
							<option value="1">全てのカテゴリ</option>
						</s:if>
						<s:if test="categoryId == 1">
							<option value="1" selected="selected">全てのカテゴリ</option>
						</s:if>
						<s:if test="categoryId != 2">
							<option value="2">Pizza</option>
						</s:if>
						<s:if test="categoryId == 2">
							<option value="2" selected="selected">Pizza</option>
						</s:if>
						<s:if test="categoryId != 3">
							<option value="3">SideMenu</option>
						</s:if>
						<s:if test="categoryId == 3">
							<option value="3" selected="selected">SideMenu</option>
						</s:if>
						<s:if test="categoryId != 4">
							<option value="4">DrinkMenu</option>
						</s:if>
						<s:if test="categoryId == 4">
							<option value="4" selected="selected">DrinkMenu</option>
						</s:if>
					</select>
					<input type=hidden name="pageNum" value="1" />
					<input type=hidden name="serachFlg" value="1" />
					<s:textfield name="searchWord" class="h_search" />
					<s:submit type="image" class="img" value="" src="./images/icon/serch.png" />
				</s:form></li>
			<li><s:form action="ProductListAction">
					<input type=hidden name="listFlg" value="1" />
					<s:submit class="img1" value="メニュー"  />
				</s:form></li>

		</ul>

	</div>


</body>
</html>
