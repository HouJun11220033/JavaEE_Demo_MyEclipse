<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>Spring MVC Form Handling</title>
     </head>
     <body>
          <h1>Student Information</h1>
          <form:form method="POST" action="/JavaEE_Demo/addStudent">
              <table>
                   <tr>
                        <td><form:label path="name">Name</form:label></td>
                        <td><form:input path="name" /></td>
                   </tr>
                   <tr>
                        <td><form:label path="age">Age</form:label></td>
                        <td><form:input path="age" /></td>
                   </tr>
                   <tr>
                        <td><form:label path="id">id</form:label></td>
                        <td><form:input path="id" /></td>
                   </tr>
                   <tr>
                        <td colspan="2">
                             <input type="submit" value="Submit"/>
                        </td>
                   </tr>
              </table>  
          </form:form>
     </body>
</html>
