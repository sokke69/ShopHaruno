<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理ページ ログイン</title>
    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/loginout_style.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/hf_style.css">

    <script src="<%=request.getContextPath() %>/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
</head>
<body>

    <header></header>

    <div class="container">
        <div class="row">
            <div class="col"></div>
            <div class="col-5">
                <form action="" method="post" class="login">
                    <div class="display-6"><div class="title">管理ページ ログイン</div></div>

                    <c:if test="${not empty nameError}">
                        <div class="alert alert-danger" id="alert">
                            ※ <c:out value="${nameError}" />
                        </div>
                    </c:if>
                    
                        ログインID
                        <input type="text" name="userName" class="login" value="${id}">

                        <c:if test="${not empty passError}">
                        <div class="alert alert-danger" id="alert">
                            ※ <c:out value="${passError}" />
                        </div>
                    </c:if>
                        ログインパスワード
                        <input type="text" name="userPass" class="login">
                    
                    <p class="login-submit"><input type="submit" value="ログイン" id="submitButton"></p>
                </form>
            </div>
            <div class="col"></div>
        </div><!--/.row-->
    </div><!--/.container-->

    <div>
        <footer>
            <p class="copyright">Copyright &copy 2022 SHOP HARUNO All Rights Reserved.</p>
        </footer>
    </div>
    
</body>
</html>