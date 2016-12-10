<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
		<h1>${producto.nombre}</h1>
	</div>

	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			
				<div class="thumbnail">
				<img src="<spring:url value="/img/${producto.id}.png"/>" width="100%"/>
					<div class="caption">
					
						<h3>${producto.nombre}</h3>
						<p>${producto.descripcion}</p>
						<p>${producto.precio}EUR</p>
						<p><a href="<spring:url value="/productos" />" 
							class="btn btn-default"> 
         					<span class="glyphicon-hand-left glyphicon"></span> back 
      						</a> </p>
					</div>
				</div>
			</div>

		</div>
	</section>
</body>
</html>
