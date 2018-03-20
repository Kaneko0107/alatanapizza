<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="Content-Style-Type" content="text/css"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>

  <link rel="stylesheet" href="./css/alatanapizza.css">

  <title>お客様情報の登録</title>

  <style>

#main {
	    width: 70%;
	    background: rgba(0, 0, 0, 0.5);
	    margin:0 auto;
	    margin-top:80px;
	    margin-bottom:100px;
	    }

table {
		width:70%;
		margin:0 auto;
	    text-align: left;
	    }

h3{
	    border-left:10px solid red;
	    }

.form {
	    background-color: rgba(200, 200, 200, 0.5);
	    width: 200px;
	    height: 30px;
	    border-radius: 5px;
	    }

.title {
	    font-size: 20px;
	    }

tr td {
	    padding-right:60px;
	    padding-left:20px;
	    padding-top:5px;
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
	    text-align:left;
	    border: none;
	    border-top: dashed 1px #ccc;
	    height: 1px;
	    color: #ffffff;
	    margin: 0 8 0 8;
	    }

.icon {
		text-align:center;
		display:flex;
		flex-direction:row-reverse;
		}

.moji {
	    text-align: center;
	    font-size: 12px;
	    color: #FFCC33;
	    }

.moji2{
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

.image2 {
	    text-align:right;
	    margin-top: 5px;
	    }

</style>
</head>

<body>

  <jsp:include page="include_header.jsp" />


  <div id="main">
   <table>
    <tr><td colspan="2">
      <h3>お客様情報の登録</h3></td></tr>
      <tr><td colspan="2">
      <div class="moji2">下記の情報を入力してください。</div></td></tr>
<tr><td colspan="2"><hr></td></tr>
   <tr>

    <!-- エラーメッセージ-->

      <s:if test="errMsgList !=null && !(errMsgList.isEmpty())">
        <td><s:iterator value="errMsgList"><s:property /></s:iterator><br></td>
      </s:if>
      <s:if test="errMsgListId != null && !(errMsgListId.isEmpty())">
	    <td><s:iterator value="errMsgListId"><s:property /></s:iterator></td>
      </s:if>
      <s:if test="errMsgListPass != null && !(errMsgListPass.isEmpty())">
        <td><s:iterator value="errMsgListPass"><br><s:property /></s:iterator></td>
      </s:if>
      <s:if test="errMsgListFamilyName !=null && !(errMsgListFamilyName.isEmpty())">
        <td><s:iterator value="errMsgListFamilyName"><br><s:property /></s:iterator></td>
      </s:if>
      <s:if test="errMsgListFirstName != null && !(errMsgListFirstName.isEmpty())">
        <td><s:iterator value="errMsgListFirstName"><br><s:property /></s:iterator></td>
      </s:if>
      <s:if test="errMsgListFamilyNameKana != null && !(errMsgListFamilyNameKana.isEmpty())">
        <td><s:iterator value="errMsgListFamilyNameKana"><br><s:property /></s:iterator></td>
      </s:if>
      <s:if test="errMsgListFirstNameKana != null && !(errMsgListFirstNameKana.isEmpty())">
        <td><s:iterator value="errMsgListFirstNameKana"><br><s:property /></s:iterator></td>
      </s:if>
      <s:if test="errMsgListSex != null && !(errMsgListSex.isEmpty())">
        <td><s:iterator value="errMsgListSex"><s:property /></s:iterator></td>
      </s:if>
      <s:if test="errMsgListMail != null && !(errMsgListMail.isEmpty())">
        <td><s:iterator value="errMsgListMail"><br><s:property /></s:iterator></td><br>
      </s:if>
      <s:if test="errMsgListQuestion != null && !(errMsgListQuestion.isEmpty())">
        <td><s:iterator value="errMsgListQuestion"><s:property /></s:iterator></td><br>
      </s:if>
      <s:if test="errMsgListAnswer != null && !(errMsgListAnswer.isEmpty())">
        <td><s:iterator value="errMsgListAnswer"><s:property /></s:iterator></td>
      </s:if>


    </tr>


	  <s:form action="UserCreateConfirmAction">

        <tr>
          <td>ユーザーＩＤ</td>

          <td>
            <input type="text" name="loginUserId" value='<s:property value="loginUserId"/>' class="form"/>
          </td>
        </tr>

        <tr>
          <td>パスワード</td>

          <td>
            <input type="password" name="loginPassword" class="form"/>
          </td>
        </tr>

        <tr>
          <td>お名前（姓）</td>

          <td>
            <input type="text" name="familyName" value='<s:property value="familyName"/>' class="form"/>
          </td>
        </tr>

        <tr>
          <td>お名前（名）</td>

          <td>
            <input type="text" name="firstName" value='<s:property value="firstName"/>' class="form"/>
          </td>
        </tr>

        <tr>
          <td>ふりがな（姓）</td>

          <td>
            <input type="text" name="familyNameKana" value='<s:property value="familyNameKana"/>'  class="form"/>
          </td>
        </tr>

        <tr>
          <td>ふりがな（名）</td>

          <td>
            <input type="text" name="firstNameKana" value='<s:property value="firstNameKana"/>' class="form"/>
          </td>
        </tr>

        <tr>
          <td>性別</td>

          <td>
          <s:if test="sex==0">
            <s:radio name="sex" list="#{'0':'男性','1':'女性'}" value="0" class="seibetu"/>
          </s:if>

          <s:elseif test="sex==1">
            <s:radio name="sex" list="#{'0':'男性','1':'女性'}" value="1" class="seibetu"/>
          </s:elseif>

          <s:else>
            <s:radio name="sex" list="#{'0':'男性','1':'女性'}" value="0" class="seibetu"/>
          </s:else>
          </td>
        </tr>

        <tr>
          <td>メールアドレス</td>

          <td>
            <input type="text" name="mail" value='<s:property value="mail"/>'  class="form"/>
          </td>
        </tr>

        <tr>
         <td>秘密の質問</td>

         <td>
          <s:if test="secretQuestion==1">
            <select name="secretQuestion" class="form">
              <option value="">選択してください</option>
              <option value="1" selected>好きな食べ物</option>
              <option value="2">嫌いな食べ物</option>
            </select>
          </s:if>

          <s:elseif test="secretQuestion==2">
            <select name="secretQuestion" class="form">
              <option value="">選択してください</option>
              <option value="1">好きな食べ物</option>
              <option value="2" selected>嫌いな食べ物</option>
            </select>
          </s:elseif>

          <s:else>
            <select name="secretQuestion" class="form">
              <option value="">選択してください</option>
              <option value="1">好きな食べ物</option>
              <option value="2">嫌いな食べ物</option>
            </select>
          </s:else>
          </td>
        </tr>

        <tr>
          <td>答え</td>

          <td>
            <input type="text" name="secretAnswer" value='<s:property value="secretAnswer"/>' class="form"/>
          </td>
        </tr>
<tr><td colspan="2"><hr></td></tr>

		<tr>
		  <td>
		  <br>
            <div class="icon">
            <a href='<s:url action="HomeAction"/>'><img src="./images/icon/modoru2.png"></a>
            </div>
          </td>

		  <td>
		  <br>
		    <div class="icon">
            <input type="image" src="./images/icon/kakuninn.png">
            </div>
          </td>
        <tr>

       </s:form>
       </table>

    </div>


    <jsp:include page="include_footer.jsp" />

</body>
</html>