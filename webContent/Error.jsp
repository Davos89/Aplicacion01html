<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina de error</title>
</head>
<body>
Ha ocurrido un error en la aplicacion :<%=exception.getMessage()%><br/>
Error Interno:<%=exception.getCause().getMessage()%>
</body>
</html>