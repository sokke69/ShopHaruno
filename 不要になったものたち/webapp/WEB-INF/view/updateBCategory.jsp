<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>カテゴリ【B】編集</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/list_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
</head>

<body>
<c:import url="parts/header.jsp" />

    <div class="container" id="body">
        <div class="row">
            <div class="col"></div>
            <div class="col-9">
                <div class="display-6">カテゴリ【B】編集</div>
                <form action="" method="post">
                    <table id="list-table" class="table table-hover">
                        <tr>
                            <th id="head">ID</th>
                            <td><c:out value="${bCategory.id}" /> (変更できません)</td>
                        </tr>
                        <tr>
                            <th>名前</th>
                            <td><input type="text" value="<c:out value="${bCategory.bCategoryName}" />" name="b-category-name"></td>
                        </tr>
                        <tr>
                            <th>カテゴリ【A】</th>
                            <td>
                            <select name="b-category-a-id" id="selectform">
									<option value="">--選択--</option>
									<c:forEach items="${aCategoryList}" var="aCategoryList"
										varStatus="vs">
										<option value="${aCategoryList.id}"><c:out
												value="${aCategoryList.id}.${aCategoryList.aCategoryName}" /></option>
									</c:forEach>
							</select>
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="決定" class="submit">

                    <p><a href="listBCategory">カテゴリ【B】一覧へ戻る</a></p>
                </form>
            </div>
            <div class="col"></div>
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->

    <div>
        <footer>
            <p class="copyright">Copyright &copy; 2022 SHOP HARUNO All Rights Reserved.</p>
        </footer>
    </div>

</body>

</html>