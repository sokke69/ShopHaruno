<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>商品追加</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/list_style.css">
<link rel="stylesheet" href="./css/hf_style.css">

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/jquery-uploadThumbs.js"></script>
<script type="text/javascript">
	const maxFiles = 8;
	$(function() {
		let $file_btn = $("#product-img-sub");

		$file_btn.on("change", function(evt) {
			let elm = $file_btn[0];
			if (maxFiles < elm.files.length) {
				alert(`サブ画像は8枚までです`);
				elm.value = null; 

				return false;
			}
		})
	});
</script>
<script>
	$(function() {
		$('form input:file').uploadThumbs({
			position : 0,
			imgbreak : true
		});
	});
</script>

</head>

<body>

	<c:import url="parts/header.jsp" />

	<div class="container" id="body">
		<div class="row">
			<div class="col"></div>
			<div class="col-9">
				<div class="display-6">商品追加</div>
				<form action="" method="post" enctype="multipart/form-data">
					<table id="list-table" class="table">
						<tr>
							<th id="head">商品名*</th>
							<td><input type="text" placeholder="商品名" name="product-name"
								id="longform"></td>
						</tr>
						<tr>
							<th>商品URL</th>
							<td><input type="text" value="https://" name="product-url"
								id="longform"></td>
						</tr>
						<tr>
							<th>カテゴリA*</th>
							<td><select name="a-category-id" id="selectform">
									<option value="">--選択--</option>
									<c:forEach items="${aCategoryList}" var="aCategoryList"
										varStatus="vs">
										<option value="${aCategoryList.id}"><c:out
												value="${aCategoryList.aCategoryName}" /></option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th>カテゴリB</th>
							<td>未実装</td>
						</tr>
						<tr>
							<th>メイン画像*</th>
							<td><label><input type="file" name="product-img-main"
								accept="image/jpg" required></label></td>
						</tr>
						<tr>
							<th>サブ画像</th>
							<td><label><input type="file" name="product-img-sub"
								id="product-img-sub" class="form-sub" accept="image/jpg"
								multiple></label></td>
						</tr>

					</table>
					<input type="submit" value="追加" class="submit">

					<p>
						<a href="listProduct">戻る</a>
					</p>
				</form>
			</div>
			<div class="col"></div>
		</div>
		<!--/.row-->
	</div>
	<!--/.container-->

	<div>
		<footer>
			<p class="copyright">Copyright &copy; 2022 SHOP HARUNO All Rights
				Reserved.</p>
		</footer>
	</div>

</body>

</html>