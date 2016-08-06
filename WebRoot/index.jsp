<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#testJson").click(function() {
			var url = this.href;
			var args = {};
			$.post(url, args, function(data) {
				for (var i = 0; i < data.length; i++) {
					var id = data[i].id;
					var lastName = data[i].lastName;

					alert(id + ": " + lastName);
				}
			});
			return false;
		});
	})
</script>
</head>
<body>
	<h1>Hello World!</h1>

	<form action="testHttpMessageConverter" method="POST"
		enctype="multipart/form-data">
		File :<input type="file" name="file" /> Desc :<input type="text"
			name="desc" /> <input type="submit" value="Submit" />
	</form>
	<!--href 难道还不能加上“/” ???-->
	<a href="testJson" id="testJson">Test Json</a>
	<br>
	<a href="testResponseEntity">Test ResponseEntity</a>
	<br>
</body>
</html>
