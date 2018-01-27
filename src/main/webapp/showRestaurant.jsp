<%@ page import="com.iesemilidarder.restaurants.web.Restaurante" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>informacion de restaurantes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<%
    Restaurante r = (Restaurante) request.getAttribute("restaurante");


%>

<div class="row">
    <div class="col-md-4">
        <img class="img-fluid" src="<%= r.getImg()%>">
    </div>
    <div class="col-md-8">
        <h2><%= r.getNombre() %></h2>
        <p> <%= r.getDirecc() %></p>
        <p> <%= r.getTipo() %></p>
        <p> <%= r.getVveb() %></p>
        <p><strong> <%= r.getMedia() %></strong></p>

        <h4>Opiniones</h4>
            <p>Comentario: <%= r.getOp().getObservacio() %></p>
            <p>Puntuacion: <%= r.getOp().getPuntuacio() %></p>
            <p>Usuario: <%= r.getOp().getUsuari() %></p>


    </div>
</div>
</body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</html>
