<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザー追加</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/list_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>
    <script>
    $(function(){
    	
    	for(let i = 1; i <= ${countTypeId}; i++){
    		if( ${inputedTypeId} == i ){
    			$(".select-type").val(i);
    		}
    	}
    });
    </script>
    
</head>
<body>
<c:import url="parts/header.jsp" />

    <div class="container" id="body">
        <div class="row">
            <div class="col"></div>
            <div class="col-8">
                        <div id="add-update-user">
                        <div class="display-6">ユーザー追加</div>
                        <form action="" method="post"  autocomplete="off">
                        <table id="list-table" class="table table-hover">
                            <tr><th id="head">
                            <c:if test="${ not empty nameSuccess}">
                            		<i class="fa-solid fa-circle-check success"></i>
                            </c:if>
                            <c:if test="${ not empty nameError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             ユーザー名</th>
                            <td>
                            <c:if test="${ not empty nameError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${nameError}" />
                            	</div>
                            </c:if>
                            <input type="text" name="request-user-name" value="${inputedUserName}" id="add-user-form">
                            <div class="attention">※ ユーザー名は12文字以内で入力してください。</div>
                            </td></tr>
                            <tr><th>
                            <c:if test="${ not empty loginIdSuccess}">
                            		<i class="fa-solid fa-circle-check success"></i>
                            </c:if>
                            <c:if test="${ not empty loginIdError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             ログインID</th>
                            <td>
                            <c:if test="${ not empty loginIdError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${loginIdError}" />
                            	</div>
                            </c:if>
                            <input type="text" name="request-login-id" value="${inputedLoginId}" id="add-user-form">
                            <div class="attention">※ ログインIDは4文字以上12文字以内で入力してください。</div>
                            <div class="attention">※ 使用できる文字は半角英数字と「-」「_」のみです。</div>
                            </td></tr>
                            <tr><th>
                            <c:if test="${ not empty loginPassSameSuccess}">
                            		<i class="fa-solid fa-circle-minus warning"></i>
                            </c:if>
                            <c:if test="${ not empty loginPassError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                            <c:if test="${ not empty loginPassSameError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             ログインパスワード</th>
                            <td>
                            <c:if test="${ not empty loginPassSameSuccess}">
                            	<div class="alert alert-warning" id="alert">
                            		<c:out value="※ ${loginPassSameSuccess}" />
                            	</div>
                            </c:if>
                            <c:if test="${ not empty loginPassSameError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${loginPassSameError}" />
                            	</div>
                            </c:if>
                            <c:if test="${ not empty loginPassError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${loginPassError}" />
                            	</div>
                            </c:if>
                            <input type="text" name="request-login-pass" id="add-user-form">
                            <div class="attention">※ ログインパスワードは6字以上20字以内で入力してください。</div>
                            <div class="attention">※ 使用できる文字は半角英数字のみです。</div>
                            </td></tr>
                            <tr><th>
                            <c:if test="${ not empty loginPassSameSuccess}">
                            		<i class="fa-solid fa-circle-minus warning"></i>
                            </c:if>
                            <c:if test="${ not empty loginPassError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                            <c:if test="${ not empty loginPassSameError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             ログインパスワード(確認)
                            </th>
                            <td>
                            <c:if test="${ not empty loginPassSameSuccess}">
                            	<div class="alert alert-warning" id="alert">
                            		<c:out value="※ ${loginPassSameSuccess}" />
                            	</div>
                            </c:if>
                            
                            <c:if test="${ not empty loginPassSameError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${loginPassSameError}" />
                            	</div>
                            </c:if>
                            <c:if test="${ not empty loginPassCheckError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${loginPassCheckError}" />
                            	</div>
                            </c:if>
                            <input type="text" name="request-login-pass-check" id="add-user-form"></td></tr>
                        </table>
                        <input type="submit" value="登録" class="submit">
                        </form>
                        <p><a href="listUser">戻る</a></p>

                            </div>
                        </div>
            <div class="col"></div>
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->


    <div>
        <footer>
            <c:import url="parts/footer.jsp" />
        </footer>
    </div>
    

</body>
</html>