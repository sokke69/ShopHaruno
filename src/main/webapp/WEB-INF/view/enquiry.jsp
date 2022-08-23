<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>お問い合わせ</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/list_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>
    
    
    
</head>

<body>

<c:import url="parts/header_shop.jsp" />

    <div class="container" id="body">
        <div class="row">
            <div class="col"></div>
            <div class="col-8">
                <div id="add-update-user">
                <div class="display-6">お問い合わせ</div>
                <form action="" method="post"  autocomplete="off">
                    <table id="list-table" class="table table-hover">
                        <tr>
                            <th id="head">
                            <c:if test="${ not empty nameSuccess}">
                            		<i class="fa-solid fa-circle-check success"></i>
                            </c:if>
                            <c:if test="${ not empty nameError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             お名前(会社名)*</th>
                            <td>
                            <c:if test="${ not empty nameError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${nameError}" />
                            	</div>
                            </c:if>
                            <input type="text" value="<c:out value="${requestName}" />" name="request-name" id="add-user-form">
                            <div class="attention">※ お名前(会社名)は25文字以内で入力してください。</div></td>
                        </tr>
                        <tr>
                            <th><c:if test="${ not empty emailAddressSuccess}">
                            		<i class="fa-solid fa-circle-check success"></i>
                            </c:if>
                            <c:if test="${ not empty emailAddressError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             メールアドレス*</th>
                            <td>
                            <c:if test="${ not empty emailAddressError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${emailAddressError}" />
                            	</div>
                            </c:if>
                            <input type="text" value="<c:out value="${requestEmailAddress}" />" name="request-email" id="add-user-form">
                        </tr>
                        <tr>
                            <th>
                            <c:if test="${ not empty textSuccess}">
                            		<i class="fa-solid fa-circle-check success"></i>
                            </c:if>
                            <c:if test="${ not empty textddressError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             お問い合わせ内容*</th>
                            <td>
                            <c:if test="${ not empty textError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${textError}" />
                            	</div>
                            </c:if>
                            <textarea name="request-text" cols="80" rows="8"><c:out value="${requestText}" /></textarea>
                            <div class="attention">※ お問い合わせ内容は1000文字以内で入力してください。</div></td>
                        </tr>
                    </table>
                    <div class="attention">「*」は必須項目です。</div>
                    <input type="submit" value="送信する" class="submit">

                    <p><a href="viewMyData">戻る</a></p>
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