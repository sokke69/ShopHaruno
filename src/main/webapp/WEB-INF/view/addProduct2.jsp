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
<script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>
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

<script>
$(function(){
	
	for(let i = 1; i <= ${countAId}; i++){
		if( ${aId} == i ){
			$(".select-a").val(i);
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
					<div class="display-6">商品追加</div>
					<form action="" method="post" enctype="multipart/form-data">
						<table id="list-table" class="table table-hover">
							<tr>
								<th id="head"><c:if test="${ not empty nameSuccess}">
										<i class="fa-solid fa-circle-check success"></i>
									</c:if> <c:if test="${ not empty nameError}">
										<i class="fa-solid fa-circle-exclamation error"></i>
									</c:if>
									 商品名*</th>
								<td><c:if test="${ not empty nameError}">
										<div class="alert alert-danger" id="alert">
											<c:out value="※ ${nameError}" />
										</div>
									</c:if> <input type="text" value="${productName}" placeholder="商品名"
									name="product-name" id="add-user-form">
									<div class="attention">※ 商品名は255文字以内で入力してください。</div></td>
							</tr>
							<tr>
								<th><c:if test="${ not empty urlSuccess}">
										<i class="fa-solid fa-circle-check success"></i>
									</c:if> <c:if test="${ not empty urlError}">
										<i class="fa-solid fa-circle-exclamation error"></i>
									</c:if> 商品URL*</th>
								<td><c:if test="${ not empty urlError}">
										<div class="alert alert-danger" id="alert">
											<c:out value="※ ${urlError}" />
										</div>
									</c:if> <input type="text" value="${productUrl}" name="product-url"
									id="add-user-form"></td>
							</tr>
							<tr>
								<th><c:if test="${ not empty aCategorySuccess}">
										<i class="fa-solid fa-circle-check success"></i>
									</c:if> <c:if test="${ not empty aCategoryError}">
										<i class="fa-solid fa-circle-exclamation error"></i>
									</c:if> カテゴリA*</th>
								<td><c:if test="${ not empty aCategoryError}">
										<div class="alert alert-danger" id="alert">
											<c:out value="※ ${aCategoryError}" />
										</div>
									</c:if> <select name="a-category-id" id="selectform" class="select-a">
										<option value="0">--選択--</option>
										<c:forEach items="${aCategoryList}" var="aCategoryList"
											varStatus="vs">
											<option value="${aCategoryList.id}"><c:out
													value="${aCategoryList.id}.${aCategoryList.aCategoryName}" /></option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<th>メイン画像*</th>
								<td><label><input type="file"
										name="product-img-main" accept="image/jpg" required></label>
									<div class="attention">※ 形式はjpgのみです。</div></td>
							</tr>
							<tr>
								<th>サブ画像</th>
								<td><label><input type="file"
										name="product-img-sub" id="product-img-sub" class="form-sub"
										accept="image/jpg" multiple></label>
									<div class="attention">※ 形式はjpgのみです。</div></td>
							</tr>

						</table>
						<div class="attention">「*」は必須項目です。</div>
						<input type="submit" value="追加" class="submit">

						<p>
							<a href="listProduct">戻る</a>
						</p>
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