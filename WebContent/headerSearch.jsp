<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

.product{
  width: 100%;
}

.product ul{
  float: right;
}

.product ul li{
  float: left;
}

.h_pulldown{
    background: #DDDDDD;
}
.h_pulldown option{
    border-radius: 4px 0 0 4px;
    height: 36px;
    padding-left: 5px;
    background: #DDDDDD;
    border: none;
    box-sizing: border-box;
    border-right: 1px solid #9e9e9e;
}

.h_search{
   background: #DDDDDD;
}

.h_button{
   background: #FF6600;
   border: none;
   color: white;
   height: 22px;
}

</style>
</head>
<body>

<div class="product">

<ul>
<li><s:form action="ProductListAction">
<input type=hidden name="listFlg" value="1"/>
<s:submit value="PRODUCT LIST"/>
</s:form>
</li>
<li>
<s:form action="ProductSearchAction" id="productSearchAction">
		<select name="categoryId" class="h_pulldown">
			<option value="1">全てのカテゴリ</option>
			<option value="2">ピザ</option>
			<option value="3">サイドメニュー</option>
			<option value="4">ドリンク</option>
	    </select>
	    <input type=hidden name="pageNum" value="1"/>
	    <input type=hidden name="serachFlg" value="1"/>
        <s:textfield name="searchWord" class="h_search" />
		<s:submit value="検索" class="h_button" />
</s:form>
</li>
</ul>

</div>
<br>

</body>
</html>
