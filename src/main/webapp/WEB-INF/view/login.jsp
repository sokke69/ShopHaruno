<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理ページ ログイン</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/loginout_style.css">
<link rel="stylesheet" href="./css/hf_style.css">

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="./js/jquery-3.6.0.min.js"></script>
</head>
<body>

<c:import url="parts/header.jsp" />

	<header></header>

	<div class="login" id="body">
		<form action="" method="post" class="login">
			<div class="display-6">
				<div class="title">管理ページ ログイン</div>
			</div>
			<c:if test="※ ${not empty Error}">
				<div class="alert alert-danger" id="alert">
				<table>
				<tr><td><c:out value="${allError}" /></td></tr>
				<tr><td><c:out value="${nameError}" /></td></tr>
				<tr><td><c:out value="${passError}" /></td></tr>
				</table>

				</div>
			</c:if>

			ログインID <input type="text" name="loginId" class="login">


			パスワード <input type="text" name="loginPass" class="login">

			<p class="login-submit">
				<input type="submit" value="ログイン" id="submitButton">
			</p>
		</form>

	</div>


	<div>
		<footer>
			<c:import url="parts/footer.jsp" />
		</footer>
	</div>

</body>
</html>