<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<header>



<!-- 検索ボックスをインクルード -->
<jsp:include page="headerSearch.jsp" />

<s:form action="MyPageAction">
<s:submit value="マイページ"   class="submit"/><br>
</s:form>

</header>