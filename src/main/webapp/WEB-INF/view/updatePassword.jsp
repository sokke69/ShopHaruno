<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>パスワード編集</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/list_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>
    
    
    
</head>

<body>
<c:import url="parts/header.jsp" />

    <div class="container" id="body">
        <div class="row">
            <div class="col"></div>
            <div class="col-8">
                <div id="add-update-user">
                <div class="display-6">パスワード編集</div>
                <form action="" method="post"  autocomplete="off">
                    <table id="list-table" class="table table-hover">
                        <tr>
                        <th>
                        <c:if test="${ not empty oldLoginPassSuccess}">
                            		<i class="fa-solid fa-circle-minus warning"></i>
                            </c:if>
                            <c:if test="${ not empty oldLoginPassError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             旧パスワード</th>
                        <td>
                            <c:if test="${ not empty oldLoginPassSuccess}">
                            	<div class="alert alert-warning" id="alert">
                            		<c:out value="※ ${oldLoginPassSuccess}" />
                            	</div>
                            </c:if>
                        <input type="text" name="request-old-login-pass" id="add-user-form">
                        </td>
                        </tr>
                        <tr>
                            <th id="head">
                            <c:if test="${ not empty newLoginPassSameSuccess}">
                            		<i class="fa-solid fa-circle-minus warning"></i>
                            </c:if>
                            <c:if test="${ not empty newLoginPassError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                            <c:if test="${ not empty newLoginPassSameError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             新パスワード</th>
                            <td>
                            <c:if test="${ not empty newLoginPassSameSuccess}">
                            	<div class="alert alert-warning" id="alert">
                            		<c:out value="※ ${newLoginPassSameSuccess}" />
                            	</div>
                            </c:if>
                            <c:if test="${ not empty newLoginPassSameError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${newLoginPassSameError}" />
                            	</div>
                            </c:if>
                            <c:if test="${ not empty newLoginPassError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${newLoginPassError}" />
                            	</div>
                            </c:if>
                            <input type="text" name="request-new-login-pass" id="add-user-form">
                            <div class="attention">※ ログインパスワードは6字以上20字以内で入力してください。</div>
                            <div class="attention">※ 使用できる文字は半角英数字のみです。</div></td>
                        </tr>
                        <tr>
                            <th><c:if test="${ not empty newLoginPassSameSuccess}">
                            		<i class="fa-solid fa-circle-minus warning"></i>
                            </c:if>
                            <c:if test="${ not empty newLoginPassError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                            <c:if test="${ not empty newLoginPassSameError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             新パスワード(確認)</th>
                            <td>
                            <c:if test="${ not empty newLoginPassSameSuccess}">
                            	<div class="alert alert-warning" id="alert">
                            		<c:out value="※ ${newLoginPassSameSuccess}" />
                            	</div>
                            </c:if>
                            
                            <c:if test="${ not empty newLoginPassSameError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${newLoginPassSameError}" />
                            	</div>
                            </c:if>
                            <c:if test="${ not empty newLoginPassCheckError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${newLoginPassCheckError}" />
                            	</div>
                            </c:if>
                            <input type="text" name="request-new-login-pass-check" id="add-user-form">
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="決定" class="submit">

                    <p><a href="updateMyData">戻る</a></p>
                </form>
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