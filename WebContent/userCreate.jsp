<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link href="css/craftdenki.css" rel="stylesheet">

  <title>UserCreate画面</title>
</head>

<body>
  <div id = "header">
  </div>

  <div id = "main">
    <div id = "top">
      <p>userCreate</p>
    </div>

    <div>
      <s:if test = "errorMessage ! = ' '">
        <s:property value="errorMessage" escape = "false"/>
      </s:if>

      <table>
      <s:form action = "UserCreateConfirmAction">

        <tr>
          <td>
            <label>ユーザーID:</label>
          </td>

          <td>
            <input type = "text" name = "loginUserId" value = ""/>
          </td>

        <tr>
          <td>
            <label>パスワード:</label>
          </td>

          <td>
            <input type = "text" name = "loginPassword" value = ""/>
          </td>
        </tr>

        <tr>
          <td>
            <label>お名前:</label>
          </td>

          <td>
            <input type = "text" name = "familyName" value = ""/>
            <input type = "text" name = "fiestName" value = ""/>
          </td>
        </tr>

        <tr>
          <td>
            <label>カナ:</label>
          </td>

          <td>
            <input type = "text" name = "familyNameKana" value = ""/>
            <input type = "text" name = "firstNameKana" value = ""/>
          </td>
        </tr>

        <tr>
          <td>
            <label>性別:</label>
          </td>

          <td>
            <input type = "radio" name = "sex" value = "">男
            <input type = "radio" name = "sex" value = "">女
          </td>
        </tr>

        <tr>
          <td>
            <label>メールアドレス:</label>
          </td>

          <td>
            <input type = "text" name = "mail" value = ""/>
          </td>
        </tr>

        <tr>
          <td>
            <label>〒:</label>
          </td>

          <td>
            <input type = "text" name = "yubin" value = ""/>
          </td>
        </tr>

        <tr>
          <td>
            <label>住所:</label>
          </td>

          <td>
            <input type = "text" name = "address" value = ""/>
          </td>
        </tr>

        <tr>
          <td>
            <label>電話番号:</label>
          </td>

          <td>
            <input type = "text" name = "tel" value = ""/>
          </td>
        </tr>


        <s:submit value = "登録"/>

      </s:form>
      </table>



      <div>
        <span>前画面に戻る場合は</span>
        <a href = '<s:url action="HomeAction"/> '>こちら</a>
      </div>

    </div>
  </div>

  <div id = "footer">
    <div id = "pr">
    </div>
  </div>

</body>
</html>