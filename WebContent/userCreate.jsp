<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="Content-Style-Type" content="text/css"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>

  <link rel="stylesheet" href="./css/alatanapizza.css">

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

    <div>
      <s:iterator value="errMsgList">
          <s:property/>
      </s:iterator>


      <s:form action="UserCreateConfirmAction">
      <table>


        <tr>
          <td>ユーザーID : </td>

          <td>
            <input type="text" name="loginUserId" value='<s:property value="loginUserId"/>' placeholder="半角英数字 8文字以下"/>
                <s:iterator value="errMsgListId">
                  <s:property/>
                </s:iterator>
          </td>
        </tr>

        <tr>
          <td>パスワード : </td>

          <td>
            <input type="password" name="loginPassword" placeholder="半角英数字 16文字以下"/>
               <s:iterator value="errMsgListPass">
                  <s:property/>
               </s:iterator>
          </td>
        </tr>

        <tr>
          <td>姓 : </td>

          <td>
            <input type="text" name="familyName" value='<s:property value="familyName"/>' placeholder="16文字以下"/>
              <s:iterator value="errMsgListName">
                  <s:property/>
               </s:iterator>

          </td>
        </tr>

        <tr>
          <td>名 : </td>

          <td>
            <input type="text" name="firstName" value='<s:property value="firstName"/>'/>
              <s:iterator value="errMsgListName">
                  <s:property/>
               </s:iterator>
          </td>
        </tr>

        <tr>
          <td>姓（かな） : </td>

          <td>
            <input type="text" name="familyNameKana" value='<s:property value="familyNameKana"/>' placeholder="ひらがな 16文字以下"/>
              <s:iterator value="errMsgListNameKana">
                <s:property/>
              </s:iterator>

          </td>
        </tr>

        <tr>
          <td>名（かな） : </td>

          <td>
            <input type="text" name="firstNameKana" value='<s:property value="firstNameKana"/>'/>
              <s:iterator value="errMsgListNameKana">
                <s:property/>
              </s:iterator>
          </td>
        </tr>

        <tr>
          <td>性別 : </td>

          <td>
          <s:if test="sex=男">
            <input type=radio name="sex" value="男">男
            <input type=radio name="sex" value="女">女
          </s:if>

          <s:else>
          	<input type=radio name="sex" value="男">男
            <input type=radio name="sex" value="女">女
          </s:else>

              <s:iterator value="errMsgListSex">
                 <s:property/>
              </s:iterator>
          </td>
        </tr>

        <tr>
          <td>メールアドレス : </td>

          <td>
            <input type="text" name="mail" value='<s:property value="mail"/>' placeholder="14文字以上32文字以下"/>
              <s:iterator value="errMsgListMail">
                <s:property/>
              </s:iterator>
          </td>
        </tr>


     <!--       <td>
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

            <s:iterator value="errMsgListQuestion">
              <s:property/>
            </s:iterator>
          </td>
        </tr>   -->


        <tr>
          <td>秘密の質問 : </td>

          <td>
          <select name="secretQuestion">
            <option value="選択してください">選択してください</option>
            <option value="好きな食べ物">好きな食べ物</option>
            <option value="嫌いな食べ物">嫌いな食べ物</option>
          </select>
          </td>
        </tr>

        <tr>
          <td>答え : </td>

          <td>
            <input type="text" name="secretAnswer" value='<s:property value="secretAnswer"/>'/>
              <s:iterator value="errMsgListAnswer">
                <s:property/>
              </s:iterator>
          </td>
        </tr>
        </table>


         <br>
      <div>
        <span>確認画面へ進む</span>
      <s:submit value="→"/>
      </div>
       </s:form>








      <br>
      <div>
        <span>前画面に戻る</span>
        <a href='<s:url action="HomeAction"/>'> ← </a>
      </div>

    </div>
   </div>

  <div id="footer"> </div>


</body>
</html>