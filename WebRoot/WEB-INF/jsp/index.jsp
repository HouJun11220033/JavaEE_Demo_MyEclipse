<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--记得加标签！！！-->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>Welcome to Spring Web MVC project</title>
     </head>

     <body>
          <h3>Index Page ! ! !</h3>
          <form:form method="GET" action="/JavaEE_Demo/staticPage">
              <table>
                   <tr>
                        <td>
                             <input type="submit" value="Redirect Page"/><br>
                             <input type="submit" value="Get Static Page"/><br>

                        </td>
                   </tr>
                   <a href="root/helloworld?username=10&age=22">helloworld</a>
              </table>  
          </form:form>
          <form:form method="POST" action="root/helloworld">
              <input type="submit" value="Submit"/>
          </form:form>
          
     </body>
</html>
