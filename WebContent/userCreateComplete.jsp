<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="Content-Style-Type" content="text/css"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>

  <link rel="stylesheet" href="./css/alatanapizza.css">

  <title>登録完了</title>

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

tr td {
	    padding-right:60px;
	    padding-left:20px;
	    padding-top:5px;
	    }

.moji {
	    text-align: center;
	    font-size: 20px;
	    color: #FFCC33;
	    }

hr {
	    text-align:left;
	    border: none;
	    border-top: dashed 1px #ccc;
	    height: 1px;
	    color: #ffffff;
	    margin: 0 8 0 8;
	    }

h3 {
	    border-left:10px solid red;
	    }

.title {
	    text-align: center;
	    font-size: 20px;
	    }

</head>

  </style>


<body>

  <jsp:include page="include_header.jsp" />

  <div id="main">
      <h3>登録完了</h3>


  <table>

    <tr>
      <td>
      <h1 class="moji">ありがとうございます</h1>
      </td>
    </tr>

    <tr>
      <td>
        <a href='<s:url action="LoginAction"/>'><img src="./images/icon/ログイン.png"></a>
      </td>
    </tr>

  </table>
</div>

   <jsp:include page="include_footer.jsp" />

</body>
</html>