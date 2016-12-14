<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

		<form:form method="POST" modelAttribute="nuevoProducto"
			class="form-horizontal">

			<fieldset>
				<legend>Añade nuevo producto</legend>

				<div class="form-group">

					<label class="control-label col-lg-2 col-lg-2" for="productId">
						ID del producto: </label>

					<div class="col-lg-10">
						<form:input id="productId" path="id" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn  btn-primary"
							value="Añadir" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>

</body>
</html>