<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.Compte" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/CSS/style.css">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Gestion bancaire</title>
</head>
<body>
	<div class="container-main">
		<h1> <img id="responsive-logo" alt="responsive logo" src="https://is5-ssl.mzstatic.com/image/thumb/Purple115/v4/7e/9e/a4/7e9ea4f8-0027-e467-5953-e2c2ec42daa1/source/256x256bb.jpg">Gestion bancaire</h1>
		<div class="container-secondary">
			<div class="row">
				<form id="guichet" method="post" action="CompteServlet">
					<div class="input-group">
						<label for="titulaire">Titulaire:</label>
						<input type="text" name="titulaire">
					</div>
					<div class="input-group">
						<label for="numeroCompte">Numéro:</label>
						<input type="text" name="numeroCompte" required>
					</div>
					<div class="input-group">
						<label for="montant">Solde, débit ou crédit:</label>
						<input type="text" name="montant" required>
					</div>
					<div class="input-group">
						<select name="operation" required>
							<option value="">Veuillez selectionner une operation</option>
							<option value="creer">Creer un compte</option>
							<option value="debiter">Débiter le compte</option>
							<option value="crediter">Créditer le compte</option>
						</select>
					</div>
					<div class="input-group">
						<button id="execution-button">Exécuter</button>
					</div>
				</form>
			</div>
			<div class="row" id="container-logo">
				<img id="logo-creditmut" alt="logo credit mutuel" src="https://www.moneyvox.fr/i/media/01i/001362i0aa.jpg">
			</div>
		</div>
		<div id="informations-container">
			<c:set scope="session" var="compte" value="${ nouveaucompte }" />
			<c:if test="${compte != null}">
				<div class="afficheur">
					<span class="afficheur-message">Compte créé:</span>
					<span>Titulaire: <c:out value="${compte.getTitulaire() }"/></span>
					<span>Numéro du compte: <c:out value="${compte.getNumero() }"/></span>
					<span>Solde: <c:out value="${compte.getSolde() }"/></span>
				</div>
			</c:if>
			<c:if test="${nouveausolde != null}">
				<div class="afficheur">
					<span>Nouveau solde: <c:out value="${nouveausolde}"/></span>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>