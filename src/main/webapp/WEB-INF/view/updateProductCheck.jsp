<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <script type="text/javascript">

    </script>

</head>

<body>

    <header></header>

    <div class="container">
        <div class="row">
            <div class="col"></div>
            <div class="col-9">
                <div class="display-6">商品編集 確認</div>
                <form action="" method="post">
                    <table border="1" id="list-table">
                        <tr>
                            <th id="head">商品名</th>
                            <td><c:out value="${product.productName}" />
                            <input type="hidden" name="product-name" value="${product.productName}"></td>
                        </tr>
                        <tr>
                            <th>商品URL</th>
                            <td><c:out value="${product.productUrl}" />
                            <input type="hidden" name="product-url" value="${product.productUrl}">
                            </td>
                        </tr>
                        <tr>
                            <th>カテゴリA</th>
                            <td><c:out value="${product.categoryA}" />
                            <input type="hidden" name="a-category-id" value="${product.categoryA}">
                            </td>
                        </tr>
                        <tr>
                            <th>カテゴリB</th>
                            <td>未実装</td>
                        </tr>
                        <tr>
                            <th>メイン画像</th>
                            <td><c:out value="${product.imgMain}" />
                            <input type="hidden" name="product-img-main" value="${product.imgMain}">
                            </td>
                        </tr>
                        <tr>
                            <th>サブ画像01</th>
                            <td><c:out value="${product.imgSub01}" />
                            <input type="hidden" name="product-img-sub-01" value="${product.imgSub01}"></td>
                        </tr>
                        <tr>
                            <th>サブ画像02</th>
                            <td><c:out value="${product.imgSub02}" />
                            <input type="hidden" name="product-img-sub-02" value="${product.imgSub02}">
                            </td>
                        </tr>
                        <tr>
                            <th>サブ画像03</th>
                            <td><c:out value="${product.imgSub03}" />
                            <input type="hidden" name="product-img-sub-03" value="${product.imgSub03}">
                            </td>
                        </tr>
                        <tr>
                            <th>サブ画像04</th>
                            <td><c:out value="${product.imgSub04}" />
                            <input type="hidden" name="product-img-sub-04" value="${product.imgSub04}">
                            </td>
                        </tr>
                        <tr>
                            <th>サブ画像05</th>
                            <td><c:out value="${product.imgSub05}" />
                            <input type="hidden" name="product-img-sub-05" value="${product.imgSub05}">
                            </td>
                        </tr>
                        <tr>
                            <th>サブ画像06</th>
                            <td><c:out value="${product.imgSub06}" />
                            <input type="hidden" name="product-img-sub-06" value="${product.imgSub06}">
                            </td>
                        </tr>
                        <tr>
                            <th>サブ画像07</th>
                            <td><c:out value="${product.imgSub07}" />
                            <input type="hidden" name="product-img-sub-07" value="${product.imgSub07}">
                            </td>
                        </tr>
                        <tr>
                            <th>サブ画像08</th>
                            <td><c:out value="${product.imgSub08}" />
                            <input type="hidden" name="product-img-sub-08" value="${product.imgSub08}">
                            </td>
                        </tr>
                        <tr>
                            <th>登録日</th>
                            <td><c:out value="${product.registDate}" />
                            </td>
                        </tr>
                        <tr>
                            <th>登録者</th>
                            <td><c:out value="${product.registBy}" />
                            </td>
                        </tr>
                        <tr>
                            <th>最終編集日</th>
                            <td><c:out value="${product.updateDate}" />
                            </td>
                        </tr>
                        <tr>
                            <th>最終編集者</th>
                            <td><c:out value="${product.updateBy}" />
                            <input type="hidden" name="update-by" value="${product.updateBy}">
                            </td>
                        </tr>
                        
                    </table>
                    <input type="hidden" name="product-id" value="${product.id}">
                    <input type="submit" value="編集" class="submit"> <input type="submit" value="追加" class="submit">

                    <p><a href="listProduct">商品一覧へ戻る</a></p>
                    <p><a href="listDb">データベース一覧へ戻る</a></p>
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