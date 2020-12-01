<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Materialize CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<title>Registrar</title>
</head>
<body>
<!-- Materialize SCRIPT -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<nav class="light-blue darken-2">
    <div class="nav-wrapper container">
      <a href="./Admin.jsp" class="brand-logo">Agregar</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
      	<li><a href="./Registrar.jsp">Agregar</a></li>
        <li><a href="./Buscar.jsp">Buscar</a></li>
        <li><a href="./Listar.jsp">Listar</a></li>
        <li><a href="./Home.jsp">Salir</a></li>
      </ul>
    </div>
  </nav>
  
  <c:set var="p1" value="${ requestScope['usuario'] }" />
  <c:set var="p2" value="${ requestScope['idc'] }" />
  
 <div class="container">
 
 <h3>Agregar requerimientos</h3>
	

	<div class="row">
    	<form class="col s12" action="/Practica-1/AgregarNumero?ced=${p2 }" method="POST">
      		<div class="row">
        		<div class="input-field col s6">
        			<input id="produc" name="Producto" type="text" class="validate">
          			<label for="produc">Producto</label>
        		</div>
        		
      			<div class="input-field col s6">
      				<input id="categoria" type="text" name="Categoria" class="validate">
					<label for="categoria">Categoria</label>
      			</div>
		
				<div class="input-field col s6">
      				<input id="empresa" type="text" name="Empresa" class="validate">
					<label for="empresa">Empresa</label>
      			</div>
      			
        	</div>
        	
        	<button type="submit" name="agregar" value="ingresar" class="btn waves-effect waves-light blue darken-1">Agregar</button>
        	<button type="submit" name="regresar" value="regresar" class="btn waves-effect waves-light light-blue darken-4">Regresar</button>
       </form>
    </div>
</div>
  
</body>
<footer class="page-footer blue darken-4">
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