<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Materialize CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<title>Home</title>
</head>
<body>
<!-- Materialize SCRIPT -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

  <nav class="light-blue darken-2">
    <div class="nav-wrapper container">
      <a href="./Home.jsp" class="brand-logo">Home</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="./InicioSesion.jsp">Iniciar Sesión</a></li>
        <li><a href="./RegistrarU.jsp">Registrarse</a></li>
      </ul>
    </div>
  </nav>
  
<div class="container">
<br>
	
	<div class="col s12 m7">
    <div class="card horizontal">
      <div class="card-image">
        <img src="../Imagenes/soccer-ball.png" width="40" height="140">
      </div>
      <div class="card-stacked">
        <div class="card-content">
          <h5>Nombre de la empresa</h5>
        </div>
        <div class="card-action">
          <p>Listado productos</p>
        </div>
      </div>
    </div>
  </div>
  
  <div class="col s12 m7">
    <div class="card horizontal">
      <div class="card-image">
        <img src="../Imagenes/cubes.png" width="40" height="140">
      </div>
      <div class="card-stacked">
        <div class="card-content">
          <h5>Nombre de la empresa</h5>
        </div>
        <div class="card-action">
          <p>Listado productos</p>
        </div>
      </div>
    </div>
    
  </div><div class="col s12 m7">
    <div class="card horizontal">
      <div class="card-image">
        <img src="../Imagenes/open-book.png" width="40" height="140">
      </div>
      <div class="card-stacked">
        <div class="card-content">
          <h5>Nombre de la empresa</h5>
        </div>
        <div class="card-action">
          <p>Listado productos</p>
        </div>
      </div>
    </div>
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