<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<header>



<s:form action="ProductSearchAction" id="productSearchAction">
		<select name="categoryId"  onclick="goProductSearchAction();">
			<option value="1">全てのカテゴリ</option>
			<option value="2">ピザ</option>
			<option value="3">サイドメニュー</option>
			<option value="4">ドリンク</option>
	    </select>
        <s:textfield name="searchWord" class="h_search" />
		<s:submit value="検索" />
</s:form>
<s:form action="MyPageAction">
<s:submit value="マイページ"   class="submit"/><br>
</s:form>

</header>