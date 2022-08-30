<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>カテゴリ追加</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/list_style.css">
<link rel="stylesheet" href="./css/hf_style.css">


<script src="./js/bootstrap.bundle.min.js"></script>
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="https://kit.fontawesome.com/ec1be9ca10.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<c:import url="parts/header.jsp" />

	<div class="container" id="body">
		<div class="row">
			<div class="col"></div>
			<div class="col-8">
				<div id="add-update-user">
				<div class="display-6">カテゴリ追加</div>
				<form action="" method="post">
					<table id="list-table" class="table table-hover">
						<tr>
							<th><c:if test="${ not empty aCategoryError}">
									<i class="fa-solid fa-circle-exclamation error"></i>
								</c:if> 名前</th>
							<td><c:if test="${ not empty aCategoryError}">
									<div class="alert alert-danger" id="alert">
										<c:out value="※ ${aCategoryError}" />
									</div>
								</c:if> <input type="text" value="${aCategoryName}" name="a-category-name" id="add-user-form">
								<div class="attention">※ 名前は20文字以内で入力してください。</div></td>
						</tr>
					</table>
					<input type="submit" value="登録" class="submit">

				</form>
				<p>
					<a href="listACategory">戻る</a>
				</p>
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