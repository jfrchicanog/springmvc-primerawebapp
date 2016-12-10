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
	<section>
		<div class="pull-right" style="padding-right: 50px">
			<a href="?idioma=en">English</a>|
			<a href="?idioma=es">Español</a>
		</div>
	</section>

	<div class="jumbotron">
		<h1>Productos</h1>
	</div>

	<section class="container">
		<div class="row">
			<c:forEach var="producto" items="${productos}">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<img src="<spring:url value="/img/${producto.id}.png"/>"
							width="100%" />
						<div class="caption">
							<h3>${producto.nombre}</h3>
							<p>${producto.descripcion}</p>
							<p>${producto.precio}EUR</p>
							<p>
								<a href="<spring:url value="/producto?id=${producto.id}" />"
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Detalles
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="row">
		<a class="btn btn-primary" href='<spring:url value="/productos/add"/>'>Añadir producto</a>
		</div>
	</section>
</body>
</html>
