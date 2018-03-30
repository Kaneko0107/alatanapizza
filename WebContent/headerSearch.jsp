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
	display: block;

}

.product ul {
	float: right;
	width: 80%;

}

.product ul li {
	float: left;
}


.h_search {
	background: #DDDDDD;
	width: 60%;
	height: 38px;
	border-radius: 5px;
	background-color: rgba(0, 0, 0, 0.7);
	font-size:18px;
	color:white;
	position:relative;
bottom:7px;
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
	font-size:15px;
	position:relative;
bottom:6px;
}

.img:hover{
opacity:0.8;}

.img1{
position:relative;
top:5px;
}

.img{
position:relative;
top:5px;

}
ul{
margin-right:5px;
}


.img1:hover{
opacity:0.8;}



.img1:hover{
    color:white;
}

#productSearchAction{
width: 50%;
}



</style>
</head>
<body>

	<div class="product">

	<ul>
	<li><s:if test="#session.masterFlg"><div class="img1">
		<a href='<s:url action="MasterAddAction"/>'class="icon"><img src="./images/icon/商品追加.png"></a></div>
	</s:if>
	</li>


		    <li><s:form action="ProductListAction">
					<input type=hidden name="listFlg" value="1" /><div class="img1">
					<s:submit class="icon" type="image" value="" src="./images/icon/MENU.png" /></div>
				</s:form></li>



			<li id="productSearchAction"><s:form action="ProductSearchAction">
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
					<input type=hidden name="searchFlg" value="1" />
					<s:textfield name="searchWord" class="h_search" />
					<s:submit type="image" class="img" value="" src="./images/icon/serch.png" />
				</s:form>
			</li>


		</ul>

	</div>


</body>
</html>
