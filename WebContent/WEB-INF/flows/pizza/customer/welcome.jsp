<html xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns:form="http://www.springframework.org/tags/form">
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<head><title>Spizza</title></head>
<body>
<h2>Welcome to Spizza!!!</h2>
<form action="${flowExecutionUrl}&_eventId=phoneEntered">
<input type="hidden" name="_flowExecutionKey"
value="${flowExecutionKey}"/>
<input type="text" name="phoneNumber"/><br/>
<input type="submit" name="_eventId_phoneEntered"
value="Lookup Customer" />
</form>
<a href="${flowExecutionUrl}&_eventId=phoneEntered&phoneNumber=13249554671">url</a>
</body>
</html>