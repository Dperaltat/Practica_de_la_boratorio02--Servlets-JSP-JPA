<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<title>Home Usuario</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

  <nav class="cyan darken-2">
    <div class="nav-wrapper container">
      <a href="./Usuario.jsp" class="brand-logo">Usuario</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
      	<li><a href="JSPs/Agregar.jsp">Agregar</a></li>
        <li><a href="JSPs/Buscar.jsp">Buscar</a></li>
        <li><a href="JSPs/Listar.jsp">Listar</a></li>
        <li><a href="JSPs/InicioSesion.jsp">Salir</a></li>
      </ul>
    </div>
  </nav>
  
<div class="container">
	<h3>Bienvenido</h3>
	
	<table class="highlight centered">
	  <thead>
		<tr>
			<th>ID Requerimiento</th>
			<th>Producto</th>
			<th>Empresa</th>
			<th>Estado</th>
		</tr>
	</thead>
	<tbody>
		
		<c:forEach var="re" items="${requerimientos}" varStatus="loop">
		<tr>
			<td>${re.idRequerimientos}</td>
            <td>${productos[loop.index].nombre}</td>
            <td>${empresas[loop.index].nombre}</td>
            <td>${re.estado}</td>
         </tr>
		</c:forEach>
		
				<form action="UsuarioControlador" method="POST">
					<button class="btn waves-effect waves-light green" type="submit" name="mostrarPrincipalU" value="mostrar">Mostar info</button>
				</form>
	</tbody>
	</table>
	
</div>  
  	

</body>
<footer class="page-footer cyan darken-4">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h4 class="white-text">Universidad Politécnica Salesiana</h4>
                <h5 class="white-text">Práctica de laboratorio 01: Servlets, JSP y JDBC</h5>
                <p class="grey-text text-lighten-4">Integrantes:</p>
                <p class="grey-text text-lighten-4">David Cornejo</p>
                <p class="grey-text text-lighten-4">Pedro Orellana</p>
                <p class="grey-text text-lighten-4">Daniel Peralta</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <!--<h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                </ul>-->
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2020 Copyright Text
            </div>
          </div>
</footer>
</html>