<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="Content-Style-Type" content="text/css"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>

  <link rel="stylesheet" href="./css/alatanapizza.css">

  <title>確認画面</title>

  <style>


header{
	    position:absolute;
	    top:0;
	    width:100%;
	    height:100px;
	    background:linear-gradient(to bottom,black,rgba(0,0,0,0.1));
	    }

.tab {
	    width: 50%;
	    background: rgba(0, 0, 0, 0.5);
	    margin:0 auto;
	    padding-top:20px;
	    margin-bottom:100px;
	    }


table {
	    text-align: left;
	    padding-top: 10%;
	    }


/* .form {
	    background-color: rgba(200, 200, 200, 0.5);
	    width: 200px;
	    height: 30px;
	    border-radius: 5px;
	    } */

.title {
	    font-size: 20px;
	    }

tr td {
	    padding:5px 5px 5px 20px;
	    }

footer {
	    width:100%;
	    height:30px;
	    position: fixed;
	    bottom: 0;
	    text-align: center;
	    margin: 0 auto;
	    }

hr {
	    border: none;
	    border-top: dashed 1px #ccc;
	    height: 1px;
	    color: #ffffff;
	    margin: 0 8 0 8;
	    }

.moji {
	    text-align: center;
	    font-size: 12px;
	    color: #FFCC33;
	    }

.gazou {
	    text-align:right;
	    margin-top: 5px;
	    }

.gazou:hover{
	    background-image:url("modoru.png")
	    }


</style>

</head>

<body>
  <jsp:include page="include_header.jsp" />

  <div id="main">
    <div id="top">
      <p>ユーザー登録</p>
    </div>


    <div class=moji>登録する内容は以下でよろしいですか？</div>

    <div class="tab">

      <table>

      <tr id="box">
        <td>ユーザーＩＤ</td>
        <td> <s:property value="loginUserId"/> </td>
      </tr>

      <tr id="box">
        <td>パスワード</td>
        <td> <s:property value="loginPassword" /> </td>
      </tr>

      <tr id="box">
        <td>お名前（姓）</td>
        <td> <s:property value="familyName" /> </td>
      </tr>

      <tr id="box">
        <td>お名前（名）</td>
        <td> <s:property value="firstName" /> </td>
      </tr>

      <tr id="box">
        <td>ふりがな（姓）</td>
        <td> <s:property value="familyNameKana"/> </td>
      </tr>

      <tr id="box">
        <td>ふりがな（名）</td>
        <td> <s:property value="firstNameKana"/> </td>
      </tr>

      <tr id="box">
        <td>性別</td>
          <td> <s:if test="sex==0">男</s:if>
	 		   <s:if test="sex==1">女</s:if>
	 	  </td>
      </tr>

      <tr id="box">
        <td>メールアドレス</td>
        <td> <s:property value="mail"/> </td>
      </tr>

      <tr id="box">
        <td>秘密の質問</td>
          <td> <s:if test="secretQuestion==1">好きな食べ物</s:if>
	 		   <s:if test="secretQuestion==2">嫌いな食べ物</s:if>
	 	  </td>
      </tr>

      <tr id="box">
        <td>答え</td>
        <td> <s:property value="secretAnswer"/> </td>
      </tr>

     </table>
     </div>
     </div>


          <s:form action="UserCreateCompleteAction">
            <s:submit value="登録する"/>
          </s:form>


      <s:form action="UserCreateAction">

      <input type="hidden" name="loginUserId" value="<s:property value="loginUserId"/>"/>
      <input type="hidden" name="loginPassword" value="<s:property value="loginPassword"/>">
      <input type="hidden" name="familyName" value="<s:property value="familyName"/>">
      <input type="hidden" name="firstName" value="<s:property value="firstName"/>">
      <input type="hidden" name="familyNameKana" value="<s:property value="familyNameKana"/>">
      <input type="hidden" name="firstNameKana" value="<s:property value="firstNameKana"/>">
      <input type="hidden" name="sex" value="<s:property value="sex"/>">
      <input type="hidden" name="mail" value="<s:property value="mail"/>">
      <input type="hidden" name="secretQuestion" value="<s:property value="secretQuestion"/>">
      <input type="hidden" name="secretAnswer" value="<s:property value="secretAnswer"/>">
      <s:submit value="戻る" class="userCreateButton"/>
    </s:form>

    </div>
<br>
<br><br>


   <jsp:include page="include_footer.jsp" />

</body>
</html>