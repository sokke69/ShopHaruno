<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>商品編集</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/list_style.css">
<link rel="stylesheet" href="./css/hf_style.css">

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/jquery-uploadThumbs.js"></script>
<script>
$(function() {
    // jQuery Upload Thumbs 
    $('form input:file').uploadThumbs();
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
			<div class="col-9">
				<div class="display-6">商品編集</div>
				<!-- <form action="" method="post" enctype="multipart/form-data"> -->
				<form action="" method="post">
					<table id="list-table" class="table table-hover">
						<tr>
							<th id="head">ID</th>
							<td><c:out value="${product.id}" /> (変更できません)</td>
						</tr>
						<tr>
							<th>商品名</th>
							<td><input type="text"
								value="<c:out value="${product.productName}" />"
								name="product-name" id="longform"></td>
						</tr>
						<tr>
							<th>商品URL</th>
							<td><input type="text"
								value="<c:out value="${product.productUrl}" />"
								name="product-url" id="longform"></td>
						</tr>
						<tr>
							<th>カテゴリ*</th>
							<td><select name="a-category-id" id="selectform" class="select-a">
									<option value="0">--選択--</option>
									<c:forEach items="${aCategoryList}" var="aCategoryList"
										varStatus="vs">
										<option value="${aCategoryList.id}"><c:out
												value="${aCategoryList.id}.${aCategoryList.aCategoryName}" /></option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th>メイン画像</th>
							<td>
								<%-- <label>
									<input type="checkbox" name="checked" value="1" checked="checked" /> <small>変更しない</small>
								</label><br />
								<label>
									<img src="${product.imgMain}" class="uploaded thumb" alt="" /><br />
									<input type="file" name="product-img-main" /><br />
									<br />
								</label>  --%>
							</td>
						</tr>
						<tr>
							<th>サブ画像01</th>
							<td>
								<%-- <label>
									<input type="checkbox" name="checked" value="1" checked="checked" /> <small>変更しない</small>
								</label><br />
								<label>
									<img src="${product.imgSub01}" class="uploaded thumb" alt="" /><br />
									<input type="file" name="product-img-sub-01" /><br />
								</label>  --%>
							</td>
						</tr>
						<tr>
							<th>サブ画像02</th>
							<td>
								<%-- <label>
									<input type="checkbox" name="checked" value="1" checked="checked" /> <small>変更しない</small>
								</label><br />
								<label>
									<img src="${product.imgSub02}" class="uploaded thumb" alt="" /><br />
									<input type="file" name="product-img-sub-02" /><br />
								</label>  --%>
							</td>
						</tr>
						<tr>
							<th>サブ画像03</th>
							<td>
								<%-- <label>
									<input type="checkbox" name="checked" value="1" checked="checked" /> <small>変更しない</small>
								</label><br />
								<label>
									<img src="${product.imgSub03}" class="uploaded thumb" alt="" /><br />
									<input type="file" name="product-img-sub-03" /><br />
								</label>  --%>
							</td>
						</tr>
						<tr>
							<th>サブ画像04</th>
							<td>
								<%-- <label>
									<input type="checkbox" name="checked" value="1" checked="checked" /> <small>変更しない</small>
								</label><br />
								<label>
									<img src="${product.imgSub04}" class="uploaded thumb" alt="" /><br />
									<input type="file" name="product-img-sub-04" /><br />
								</label>  --%>
							</td>
						</tr>
						<tr>
							<th>サブ画像05</th>
							<td>
								<%-- <label>
									<input type="checkbox" name="checked" value="1" checked="checked" /> <small>変更しない</small>
								</label><br />
								<label>
									<img src="${product.imgSub05}" class="uploaded thumb" alt="" /><br />
									<input type="file" name="product-img-sub-05" /><br />
								</label>  --%>
							</td>
						</tr>
						<tr>
							<th>サブ画像06</th>
							<td>
								<%-- <label>
									<input type="checkbox" name="checked" value="1" checked="checked" /> <small>変更しない</small>
								</label><br />
								<label>
									<img src="${product.imgSub06}" class="uploaded thumb" alt="" /><br />
									<input type="file" name="product-img-sub-06" /><br />
								</label>  --%>
							</td>
						</tr>
						<tr>
							<th>サブ画像07</th>
							<td>
								<%-- <label>
									<input type="checkbox" name="checked" value="1" checked="checked" /> <small>変更しない</small>
								</label><br />
								<label>
									<img src="${product.imgSub07}" class="uploaded thumb" alt="" /><br />
									<input type="file" name="product-img-sub-07" /><br />
								</label>  --%>
							</td>
						</tr>
						<tr>
							<th>サブ画像08</th>
							<td>
								<%-- <label>
									<input type="checkbox" name="checked" value="1" checked="checked" /> <small>変更しない</small>
								</label><br />
								<label>
									<img src="${product.imgSub08}" class="uploaded thumb" alt="" /><br />
									<input type="file" name="product-img-sub-08" /><br />
								</label>  --%>
							</td>
						</tr>
					</table>
					<input type="submit" value="決定" class="submit">

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
			<c:import url="parts/footer.jsp" />
		</footer>
	</div>

</body>

</html>