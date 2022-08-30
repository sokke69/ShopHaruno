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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kaisei+Decol:wght@700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="./css/default.css">
<link rel="stylesheet" href="./css/list.css">
<link rel="stylesheet" href="./css/hf_style.css">

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/jquery-uploadThumbs.js"></script>
<script type="text/javascript">
	const maxFiles = 9;
	$(function() {
		let $file_btn = $("#product-img");

		$file_btn.on("change", function(evt) {
			let elm = $file_btn[0];
			if (maxFiles < elm.files.length) {
				alert(`画像は9枚までです`);
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

<%-- ナビ・ロゴ ここから --%>
<c:import url="parts/header_setting.jsp" />
<c:import url="parts/logo_setting.jsp" />
<%-- ここまで --%>

<%-- テーブルサンプル ここから --%>

<table class="basic">
	<tr>
		<td class="basic-top"></td>
	</tr>
	<tr>
		<td class="basic-middle">
			<form action="" method="post" enctype="multipart/form-data">
				<%-- テーブル中身 ここから --%>
				<table class="table-list">
					<tr>
						<th class="subject">ユーザー追加</th>
					</tr>
					<tr>
						<td><hr></td>
					</tr>
					<%-- ユーザー名 --%>
					<tr>
						<th><c:if test="${ not empty nameSuccess}">
								<i class="fa-solid fa-circle-check success"></i>
							</c:if> <c:if test="${ not empty nameError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> 商品名*</th>
					</tr>
					<tr>
						<td><c:if test="${ not empty nameError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${nameError}" />
								</div>
							</c:if> <input type="text" value="${productName}" placeholder="商品名"
							name="product-name" id="add-user-form">
							<div class="attention">※ 商品名は255文字以内で入力してください。</div></td>
					</tr>

					<%-- ログインID --%>
					<tr>
						<th><c:if test="${ not empty urlSuccess}">
								<i class="fa-solid fa-circle-check success"></i>
							</c:if> <c:if test="${ not empty urlError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> 商品URL*</th>
					</tr>
					<tr>
						<td><c:if test="${ not empty urlError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${urlError}" />
								</div>
							</c:if> <input type="text" value="${productUrl}" name="product-url"
							id="add-user-form"></td>
					</tr>
					<%-- ログインパスワード --%>
					<tr>
						<th><c:if test="${ not empty aCategorySuccess}">
								<i class="fa-solid fa-circle-check success"></i>
							</c:if> <c:if test="${ not empty aCategoryError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> カテゴリA*</th>
					</tr>
					<tr>
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
					<%-- ログインパスワード(確認) --%>
					<tr>
						<th>画像*</th>
					</tr>
					<tr>
						<td><label><input type="file" name="product-img"
								id="product-img" class="form-sub" accept="image/jpg"
								multiple required></label>
							<div class="attention">※ 形式はjpgのみです。</div></td>
					</tr>
					<tr>
						<td><div class="submit">
								<input type="submit" value="追加" class="btn btn-secondary">
							</div></td>
					</tr>
					<tr>
						<td><hr></td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
									<td class="bottom-link"><c:if
											test="${not empty visitedByDesign}">
											<a href="listProduct">戻る</a>
										</c:if> <c:if test="${not empty visitedBySimple}">
											<a href="listProductSimple">戻る</a>
										</c:if></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<%-- ここまで --%>
			</form>

		</td>
	</tr>
	<tr>
		<td class="basic-bottom"></td>
	</tr>
</table>

<br>
<br>
<%-- ここまで --%>

<footer>
	<c:import url="parts/footer.jsp" />
</footer>


</body>

</html>