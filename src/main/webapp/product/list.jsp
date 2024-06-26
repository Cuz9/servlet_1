<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style type="text/css">
	img {
		width: 150px;
		height: 150px;
	}
	
	h1 {
		text-align: center;
	}
	
	.btn-primary {
		margin-bottom: 20px;
	}
    .pagination {
        text-align: center;
        margin-top: 20px;
    }
    .pagination a {
        margin: 0 5px;
        text-decoration: none;
        color: #007bff;
     }
     .pagination a:hover {
            text-decoration: underline;
     }

</style>
</head>
<body>
<div class="container">
<h1>List Product</h1>
<a class="btn btn-primary" href="/demo_tom9/products?action=createGet">Create new</a>
<a class="btn btn-primary" href="/demo_tom9/categories">List category</a>
<table class="table table-striped">
	<tr>
		<th>STT</th>
		<th>Name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Image</th>
		<th>Category</th>
		<th colspan="2">Action</th>
	</tr>
	<c:forEach items="${products}" var="p" varStatus="ps">
	<tr>
		<td>${ps.count }</td>
		<td>${p.name }</td>
		<td>${p.price }</td>
		<td>${p.quantity }</td>
		<td><img src="${p.image }"/></td>
		<td><a href="/demo_tom9/products?action=findByCategory&cId=${p.category.id }">${p.category.name }</a></td>
		<td><a class="btn btn-warning" href="/demo_tom9/products?action=updateGet&id=${p.id }">Edit</a></td>
		<td><button class="btn btn-danger" onclick="deleteProduct(${p.id })">Delete</button></td>
	</tr>
	</c:forEach>
</table>
</div>
    <div class="pagination">
        <c:if test="${currentPage > 1}">
            <a href="?page=${currentPage - 1}"> < </a>
        </c:if>
        <c:forEach var="i" begin="1" end="${totalPages}">
            <a href="?page=${i}">${i}</a>
        </c:forEach>
        <c:if test="${currentPage < totalPages}">
            <a href="?page=${currentPage + 1}"> > </a>
        </c:if>
    </div>
</body>
<script>
	function deleteProduct(id) {
		if (confirm("Are you sure?")) {
			window.location.href = "http://localhost:8080/demo_tom9/products?action=deleteProduct&id=" + id
		}
	}
</script>
</html>