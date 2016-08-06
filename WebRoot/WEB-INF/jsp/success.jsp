<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>JSP Page</title>
     </head>
     <body>
          <h1>Hello World!</h1>
          Time: ${requestScope.time}
          <br>
          Names:${requestScope.names}
          <br>
          requestScope ${requestScope.user}
          <br>
          sessionScope ${sessionScope.user}
          <br>
          requestScope ${requestScope.school}
          <br>
          sessionScope ${sessionScope.school}
          <br>
          <fmt:message key="i18n.username"></fmt:message>
          <br>
          <fmt:message key="i18n.password"></fmt:message>


     </body>
</html>
