<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Supermercados Albosque</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Productos</h1>
				<p>Añadir productos</p>
			</div>
		</div>
	</section>
	<section class="container">
	
		<form:form method="POST" modelAttribute="nuevoProducto" class="form-horizontal">
			
			<fieldset>
				<legend>Añade nuevo producto</legend>

				<div class="form-group">
				
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="addProduct.form.productId.label"/></label>
					
					<div class="col-lg-10">
					
						<form:input id="productId" path="id" type="text" class="form:input-large" />
						
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="nombre">Nombre</label>
					<div class="col-lg-10">
						<form:input id="nombre" type="text" path="nombre"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Descripción</label>
					<div class="col-lg-10">
						<form:textarea id="description" path="descripcion" rows="2" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="categoria">Categoría</label>
					<div class="col-lg-10">
						<form:input id="categoria" type="text" path="categoria"
							class="form:input-large" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="precio">Precio</label>
					<div class="col-lg-10">
						<form:input id="precio" type="text" path="precio"
							class="form:input-large" />
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn  btn-primary"
							value="Add" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
