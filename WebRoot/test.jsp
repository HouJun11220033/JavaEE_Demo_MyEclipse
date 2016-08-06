<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Spring Web MVC project</title>
</head>

<body>
	<div>
		<form action="springmvc/testModelAttribute" method="post">
			<input type="hidden" name="id" value="1" /> Username:<input
				type="text" name="username" value="Tom" /><br>
			<!--                    Password<input type="password" name="password" value="123456"/><br>-->
			E-mail<input type="text" name="email" value="tom@atguigu.com" /><br>
			Age:<input type="text" name="age" value="12" /><br>
			<!--                                       City:<input type="text" name="address.city"/><br>
                                                            Province:<input type="text" name="address.province"/><br>-->
			<input type="submit" value="Submit" /><br>
		</form>

	</div>


	<a href="springmvc/testMap">Test Map</a>
	<br>
	<a href="springmvc/testPathVariable/123">Test PathVariable</a>
	<br>
	<a href="springmvc/testAntPath/aaa/abc">Test AntPath</a>
	<br>
	<a href="springmvc/testCookieValue">Test CookieValue</a>
	<br>
	<a href="springmvc/testServletAPI">Test ServletAPI</a>
	<br>
	<a href="springmvc/testModelAndView">Test ModelAndView</a>
	<br>
	<a href="springmvc/testSessionAttribute">Test SessionAttribute</a>
	<br>
	<a href="springmvc/testModelAttribute">Test ModelAttribute</a>
	<br>
	<a href="springmvc/testViewAndViewResolver">Test
		ViewAndViewResolver</a>
	<br>
	<a href="springmvc/testView">Test View</a>
	<br>
	<a href="springmvc/testRedirect">Test Redirect</a>
	<br>
	<br>


</body>
</html>
