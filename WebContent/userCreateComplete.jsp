<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="Content-Style-Type" content="text/css"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>

<link rel="stylesheet" href="./css/alatanapizza.css">

  <title>登録完了画面</title>
</head>

<body>
  <jsp:include page="include_header.jsp" />

  <div id="main">
      <p>UserCreateComplete</p>
    </div>

    <div>
      <h3>登録が完了しました</h3>

      <div>
        <input type="button" onclick="location.href='<s:url action="LoginAction"/>'" value="ログインへ" >
      </div>
    </div>

   <jsp:include page="include_footer.jsp" />

</body>
</html>