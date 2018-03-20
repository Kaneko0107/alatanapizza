<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:form action="ProductSearchAction" id="productSearchAction">
		<select name="categoryId">
			<option value="1">全てのカテゴリ</option>
			<option value="2">ピザ</option>
			<option value="3">サイドメニュー</option>
			<option value="4">ドリンク</option>
	    </select>
        <s:textfield name="searchWord" class="h_search" />
		<s:submit value="検索" />
</s:form>

</body>
</html>