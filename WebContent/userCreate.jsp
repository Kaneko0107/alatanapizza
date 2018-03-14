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

<<<<<<< HEAD

=======
    <div>
      <s:if test="#errMsgList!=''">
        <s:iterator value="errMsgList">
        <s:property/>
        </s:iterator>
      </s:if>
<s:form action="UserCreateConfirmAction">
>>>>>>> refs/remotes/origin/master
      <table>
<<<<<<< HEAD
       <s:iterator value="errMsgList">
       </s:iterator>

       <s:form action="UserCreateConfirmAction">
=======
>>>>>>> refs/remotes/origin/master


        <tr>
          <td>ユーザーID : </td>

          <td>
<<<<<<< HEAD
            <input type="text" name="loginUserId" value="" placeholder="半角英数字 8文字以下"/>
=======
            <input type="text" name="loginUserId"  placeholder="半角英数字 8文字以下"/>
>>>>>>> refs/remotes/origin/master
                <s:iterator value="errMsgListId">
                </s:iterator>
          </td>
        </tr>

        <tr>
          <td>パスワード : </td>

          <td>
<<<<<<< HEAD
            <input type="password" name="loginPassword" value="" placeholder="半角英数字 16文字以下"/>
=======
            <input type="password" name="loginPassword" placeholder="半角英数字 16文字以下"/>
>>>>>>> refs/remotes/origin/master
          </td>
        </tr>

        <tr>
          <td>姓 : </td>

          <td>
<<<<<<< HEAD
            <input type="text" name="familyName" value="" placeholder="16文字以下"/>
=======
            <input type="text" name="familyName"  placeholder="16文字以下"/>
>>>>>>> refs/remotes/origin/master
          </td>
        </tr>

        <tr>
          <td>名 : </td>

          <td>
<<<<<<< HEAD
            <input type="text" name="firstName" value=""/>
=======
            <input type="text" name="firstName" />
>>>>>>> refs/remotes/origin/master
          </td>
        </tr>

        <tr>
          <td>姓（かな） : </td>

          <td>
<<<<<<< HEAD
            <input type="text" name="familyNameKana" value="" placeholder="ひらがな 16文字以下"/>
=======
            <input type="text" name="familyNameKana"  placeholder="ひらがな 16文字以下"/>
>>>>>>> refs/remotes/origin/master
          </td>
        </tr>

        <tr>
          <td>名（かな） : </td>

          <td>
<<<<<<< HEAD
            <input type="text" name="firstNameKana" value=""/>
=======
            <input type="text" name="firstNameKana" />
>>>>>>> refs/remotes/origin/master
          </td>
        </tr>

        <tr>
          <td>性別 : </td>

          <td>
<<<<<<< HEAD
            <input type="radio" name="sex" value="">男
            <input type="radio" name="sex" value="">女
=======
           <s:radio name="sex" list="#{'0': '男性', '1': '女性'}" value="%{sex}"  />
>>>>>>> refs/remotes/origin/master
          </td>
        </tr>

        <tr>
          <td>メールアドレス : </td>

          <td>
<<<<<<< HEAD
            <input type="text" name="mail" value="" placeholder="14文字以上32文字以下"/>
=======
            <input type="text" name="mail"  placeholder="14文字以上32文字以下"/>
>>>>>>> refs/remotes/origin/master
          </td>
        </tr>

       <tr>
          <td>秘密の質問 : </td>

          <td>
            <select name="secretQuestion">
              <option value="">選択してください</option>
              <option value="1">好きな食べ物</option>
              <option value="2">嫌いな食べ物</option>
            </select>

<<<<<<< HEAD
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
=======

>>>>>>> refs/remotes/origin/master
          </td>
        </tr>

        <tr>
          <td>答え : </td>

          <td>
<<<<<<< HEAD
            <input type="text" name="secretAnswer" value=""/>
=======
            <input type="text" name="secretAnswer" />
>>>>>>> refs/remotes/origin/master
          </td>
        </tr>
<<<<<<< HEAD


       <div>
        <span>確認画面へ進む</span>
        <s:submit value="→"/>
       </div>
=======
        </table>
>>>>>>> refs/remotes/origin/master


<<<<<<< HEAD
      </s:form>
      </table>


=======
         <br>
      <div>
        <span>確認画面へ進む</span>
      <s:submit value="ff"/>
      </div>
       </s:form>








      <br>
>>>>>>> refs/remotes/origin/master
      <div>
        <span>前画面に戻る</span>
        <a href='<s:url action="HomeAction"/>'> ← </a>
      </div>

    </div>


  <div id="footer"> </div>


</body>
</html>