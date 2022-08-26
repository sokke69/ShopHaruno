<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<div class="container">
		<c:if test="${not empty userNickName}">
		<a class="navbar-brand" href="viewMyData"><i class="fa-solid fa-circle-user"></i>  <c:out value="${userNickName}" /> さん</a>
		</c:if>
			
			<button class="navbar-toggler" data-bs-toggle="collapse"
				data-bs-target="#menu">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="menu">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="listDb">データベース一覧</a></li>
					<li class="nav-item"><a class="nav-link" href="listACategory">カテゴリ一覧</a></li>
					<li class="nav-item"><a class="nav-link" href="listUser">ユーザー一覧</a></li>
					<li class="nav-item"><a class="nav-link" href="index">会社トップページ</a></li>
					<li class="nav-item"><a class="nav-link" href="logout">ログアウト</a></li>
					
				</ul>
			</div>
			<!--/.collapse.navbar-collapse-->
		</div>
		<!--/.container-->

	</nav>
