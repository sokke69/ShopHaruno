<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お問い合わせ</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/loginout_style.css">
<link rel="stylesheet" href="./css/hf_style.css">

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="./js/jquery-3.6.0.min.js"></script>
</head>
<body>
<body>

<c:import url="parts/header_shop.jsp" />

	<div class="container" id="body">
		<div class="row">
			<div class="col"></div>
			<div class="col-5">
				<div class="title">
					<div class="h3">
						<div class="logout-center">送信しました。</div>
					</div>
					<div class="h3">
						<div class="logout-center">お問い合わせありがとうございました。</div>
					</div>
				</div>
				<p class="logout-center">
					<a href="index">トップへ戻る</a>
				</p>
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

</body>
</html>
