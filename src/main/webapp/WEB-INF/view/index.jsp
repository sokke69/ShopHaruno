<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SHOP HARUNO</title>

<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kiwi+Maru:wght@300&family=Kaisei+Opti&family=Klee+One&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="./css/index_style.css">
<link rel="stylesheet" href="./css/hf_style.css">

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="./js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#photo-mini-sample1 img').click(function() {
			let src = $(this).attr('src');
			console.log(src);
			$('#photo-large-sample1 img').attr('src', src);
		})
		$('#photo-mini-sample2 img').click(function() {
			let src = $(this).attr('src');
			console.log(src);
			$('#photo-large-sample2 img').attr('src', src);
		})
		$('#photo-mini-sample3 img').click(function() {
			let src = $(this).attr('src');
			console.log(src);
			$('#photo-large-sample3 img').attr('src', src);
		})
		<c:forEach items="${productList}" var="productList" varStatus="vs">
		$('#photo-mini-${productList.id} img').click(function() {
			let src = $(this).attr('src');
			console.log(src);
			$('#photo-large-${productList.id} img').attr('src', src);
		})
		</c:forEach>
	});
</script>


</head>

<body>

<c:import url="parts/header_shop.jsp" />
	

	<div class="title">

		<div class="row">
			<div class="logo_back">
				<table height="400" class="logo">
					<tr>
						<td align="center" valign="middle">*ショップ ハルノ*</td>
					</tr>
				</table>
			</div>
		</div>
		<!--/.row-->

	</div>
	<!--/.title-->

	<div class="category-a">
		<div class="container">
			<div class="row">
				<div class="col-2"></div>
				<div class="col">
					<table class="category-table" align="center">

						<tr>
							<td><a href="index">全カテゴリ</a><c:forEach items="${aCategoryList}" var="aCategoryList" varStatus="vs">
                <a href="indexByAId?aId=${aCategoryList.id}"><c:out value="${aCategoryList.id}.${aCategoryList.aCategoryName}" /></a>
                </c:forEach></td>
						</tr>

					</table>
				</div>
				<div class="col-2"></div>
			</div>
		</div>
		<!--/.container-->
	</div>
	<!--/.category-->
	
	<div class="products">
		<div class="container">
			<div class="row">
				<div align="center">
					<div class="row">

						<div class="col">
							<table width="560px" height="260px">
								<tr>
									<th height="240px" class="large">
										<div id="photo-large-sample1" class="photo-large">
											<img src="./imgs/sample1main.jpg" alt="" width="320px"
												height="240px">
										</div> <!--/.photo-large-->

									</th>
									<td height="240px" width="240px" class="mini">
										<div id="photo-mini-sample1" class="img-table">
											<ul>
												<li><img src="./imgs/sample1main.jpg" alt=""></li>
												<li><img src="./imgs/sample1sub01.jpg" alt=""></li>
												<li><img src="./imgs/sample1sub02.jpg" alt=""></li>
												<li><img src="./imgs/sample1sub03.jpg" alt=""></li>
												<li><img src="./imgs/sample1sub04.jpg" alt=""></li>
												<li><img src="./imgs/sample1sub05.jpg" alt=""></li>
												<li><img src="./imgs/sample1sub06.jpg" alt=""></li>
												<li><img src="./imgs/sample1sub07.jpg" alt=""></li>
												<li><img src="./imgs/sample1sub08.jpg" alt=""></li>
											</ul>
										</div>
									</td>

								</tr>

								<tr>
									<td colspan="2" id="table-products"><a href="#" target="_blank"><c:out
												value="消せないサンプル1です。消せないサンプル1です。消せないサンプル1です。消せないサンプル1です。消せないサンプル1です。消せないサンプル1です。消せないサンプル1です。" /></a></td>
								</tr>
							</table>
						</div>
						
						<div class="col">
							<table width="560px" height="260px">
								<tr>
									<th height="240px" class="large">
										<div id="photo-large-sample2" class="photo-large">
											<img src="./imgs/sample2main.jpg" alt="" width="320px"
												height="240px">
										</div> <!--/.photo-large-->

									</th>
									<td height="240px" width="240px" class="mini">
										<div id="photo-mini-sample2" class="img-table">
											<ul>
												<li><img src="./imgs/sample2main.jpg" alt=""></li>
												<li><img src="./imgs/sample2sub01.jpg" alt=""></li>
												<li><img src="./imgs/sample2sub02.jpg" alt=""></li>
												<li><img src="./imgs/sample2sub03.jpg" alt=""></li>
												<li><img src="./imgs/sample2sub04.jpg" alt=""></li>
												<li><img src="./imgs/sample2sub05.jpg" alt=""></li>
												<li><img src="./imgs/sample2sub06.jpg" alt=""></li>
												<li><img src="./imgs/sample2sub07.jpg" alt=""></li>
												<li><img src="./imgs/sample2sub08.jpg" alt=""></li>
											</ul>
										</div>
									</td>

								</tr>

								<tr>
									<td colspan="2" id="table-products"><a href="#" target="_blank"><c:out
												value="消せないサンプル2です。消せないサンプル2です。消せないサンプル2です。消せないサンプル2です。消せないサンプル2です。消せないサンプル2です。消せないサンプル2です。消せないサンプル2です。" /></a></td>
								</tr>
							</table>
						</div>
						
						<div class="col">
							<table width="560px" height="260px">
								<tr>
									<th height="240px" class="large">
										<div id="photo-large-sample3" class="photo-large">
											<img src="./imgs/sample3main.jpg" alt="" width="320px"
												height="240px">
										</div> <!--/.photo-large-->

									</th>
									<td height="240px" width="240px" class="mini">
										<div id="photo-mini-sample3" class="img-table">
											<ul>
												<li><img src="./imgs/sample3main.jpg" alt=""></li>
												<li><img src="./imgs/sample3sub01.jpg" alt=""></li>
												<li><img src="./imgs/sample3sub02.jpg" alt=""></li>
												<li><img src="./imgs/sample3sub03.jpg" alt=""></li>
												<li><img src="./imgs/sample3sub04.jpg" alt=""></li>
												<li><img src="./imgs/sample3sub05.jpg" alt=""></li>
												<li><img src="./imgs/sample3sub06.jpg" alt=""></li>
												<li><img src="./imgs/sample3sub07.jpg" alt=""></li>
												<li><img src="./imgs/sample3sub08.jpg" alt=""></li>
											</ul>
										</div>
									</td>

								</tr>

								<tr>
									<td colspan="2" id="table-products"><a href="#" target="_blank"><c:out
												value="消せないサンプル3です。消せないサンプル3です。消せないサンプル3です。消せないサンプル3です。消せないサンプル3です。消せないサンプル3です。消せないサンプル3です。消せないサンプル3です。" /></a></td>
								</tr>
							</table>
						</div>
						
						

						<c:forEach items="${productList}" var="productList" varStatus="vs">
							<div class="col">
								<table width="560px" height="260px">
									<tr>
										<th height="240px" class="large">
											<div id="photo-large-${productList.id}" class="photo-large">
												<img src="${productList.imgMain}" alt="" width="320px"
													height="240px">
											</div> <!--/.photo-large-->

										</th>
										<td height="240px" width="240px" class="mini">
											<div id="photo-mini-${productList.id}" class="img-table">
												<ul>
													<li><img src="${productList.imgMain}" alt=""></li>
													<li><img src="${productList.imgSub01}" alt=""></li>
													<li><img src="${productList.imgSub02}" alt=""></li>
													<li><img src="${productList.imgSub03}" alt=""></li>
													<li><img src="${productList.imgSub04}" alt=""></li>
													<li><img src="${productList.imgSub05}" alt=""></li>
													<li><img src="${productList.imgSub06}" alt=""></li>
													<li><img src="${productList.imgSub07}" alt=""></li>
													<li><img src="${productList.imgSub08}" alt=""></li>
												</ul>
											</div>
										</td>

									</tr>

									<tr>
										<td colspan="2" id="table-products"><a href="${productList.productUrl}" target="_blank"><c:out
													value="${productList.productName}" /></a></td>
									</tr>
								</table>
							</div>
						</c:forEach>




						<!--ここから消さない-->
						<div class="col">
							<table width="560px">
							</table>
						</div>
						<!--ここまで消さない-->

					</div>
					<!--/.row-->
				</div>
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
	</div>
	<!--/.products-->

	<div>
		<footer>
			<c:import url="parts/footer.jsp" />
		</footer>
	</div>




</body>

</html>