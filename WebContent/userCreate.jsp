<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="Content-Style-Type" content="text/css"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>

  <link href="css/craftdenki.css" rel="stylesheet">

  <title>ユーザー情報入力画面</title>
</head>

<body>
  <div id="header"> </div>

  <div id="main">
    <div id="top">
      <h3>ユーザー情報入力画面</h3>
      <br>
      <p>下記情報を入力してください</p>
    </div>


      <table>
       <s:iterator value="errMsgList">
       </s:iterator>

       <s:form action="UserCreateConfirmAction">


        <tr>
          <td>ユーザーID : </td>

          <td>
            <input type="text" name="loginUserId" value="" placeholder="半角英数字 8文字以下"/>
                <s:iterator value="errMsgListId">
                </s:iterator>
          </td>
        </tr>

        <tr>
          <td>パスワード : </td>

          <td>
            <input type="password" name="loginPassword" value="" placeholder="半角英数字 16文字以下"/>
          </td>
        </tr>

        <tr>
          <td>姓 : </td>

          <td>
            <input type="text" name="familyName" value="" placeholder="16文字以下"/>
          </td>
        </tr>

        <tr>
          <td>名 : </td>

          <td>
            <input type="text" name="firstName" value=""/>
          </td>
        </tr>

        <tr>
          <td>姓（かな） : </td>

          <td>
            <input type="text" name="familyNameKana" value="" placeholder="ひらがな 16文字以下"/>
          </td>
        </tr>

        <tr>
          <td>名（かな） : </td>

          <td>
            <input type="text" name="firstNameKana" value=""/>
          </td>
        </tr>

        <tr>
          <td>性別 : </td>

          <td>
            <input type="radio" name="sex" value="">男
            <input type="radio" name="sex" value="">女
          </td>
        </tr>

        <tr>
          <td>メールアドレス : </td>

          <td>
            <input type="text" name="mail" value="" placeholder="14文字以上32文字以下"/>
          </td>
        </tr>

       <tr>
          <td>秘密の質問 : </td>

          <td>
           <s:if test="secretQuestion==1">
            <select name="secretQuestion">
              <option value="">選択してください</option>
              <option value="1" selected>好きな食べ物</option>
              <option value="2">嫌いな食べ物</option>
            </select>
           </s:if>

           <s:elseif test="secretQuestion==2">
            <select name="secretQuestion">
              <option value="">選択してください</option>
              <option value="1">好きな食べ物</option>
              <option value="2" selected>嫌いな食べ物</option>
            </select>
           </s:elseif>

           <s:else>
           <select name="secretQuestion">
				<option value="">選択してください</option>
				<option value="1">好きな食べ物</option>
				<option value="2">嫌いな食べ物</option>
			</select>
	       </s:else>
          </td>
        </tr>

        <tr>
          <td>答え : </td>

          <td>
            <input type="text" name="secretAnswer" value=""/>
          </td>
        </tr>


       <div>
        <span>確認画面へ進む</span>
        <s:submit value="→"/>
       </div>


      </s:form>
      </table>


      <div>
        <span>前画面に戻る</span>
        <a href='<s:url action="HomeAction"/>'> ← </a>
      </div>

    </div>


  <div id="footer"> </div>


</body>
</html>