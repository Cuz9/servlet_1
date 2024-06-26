<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style type="text/css">
	#update {
		width: 500px;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
</style>
</head>
<body>
<div id="update">
<h2>Update form</h2>
<form action="/demo_tom9/categories?action=updatePost" method="post">
<div class="mb-3" hidden>
  <label for="id" class="form-label">Id</label>
  <input type="text" class="form-control" id="id" name="id" value="${category.id }" >
</div>
<div class="mb-3">
  <label for="name" class="form-label">Name</label>
  <input type="text" class="form-control" id="name" name="name" value="${category.name }">
</div>
	<button class="btn btn-primary" type="submit">Update</button>
	<a class="btn btn-secondary" href="/demo_tom9/categories">Back</a>
</form>
</div>
</body>
</html>