<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>Supermercados Albosque</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>

<body>
	<div class="jumbotron">
		<h1>${saludo}</h1>
		<p>${eslogan}</p>
	</div>
	
	<section class="container"> 
              <div class="row"> 
              <c:forEach var="producto" items="${productos}">
                 <div class="col-sm-6 col-md-3" style="padding-bottom: 15px"> 
                    <div class="thumbnail"> 
                       <div class="caption"> 
                          <h3>${producto.nombre}</h3> 
                          <p>${producto.descripcion}</p> 
           <p>${producto.precio} EUR</p> 
                       </div> 
                    </div> 
                 </div> 
                 </c:forEach>
              </div> 
           </section> 
</body>
</html>
