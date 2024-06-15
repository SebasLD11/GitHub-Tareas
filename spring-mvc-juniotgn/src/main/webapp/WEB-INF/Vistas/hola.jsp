<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola</title>
</head>
<body>
<!-- nombre es el valor del atributo name para el campo de texto del formulario
anterior -->
<p style="color:#ff0000;">(WEB -HOLA.JSP)Hola ${mensaje}, bienvenido a tu primer formulario</p>
<p style="color:#ff0000;">(WEB -HOLA.JSP)Tu correo es: ${param.correo}</p>
<a href="http://localhost:8080/spring-mvc-3/">Pagina Principal</a>
</body>
</html>
