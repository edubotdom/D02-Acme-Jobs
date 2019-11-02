<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>
<%@page import="java.util.List"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<link rel="stylesheet" href="libraries/acme/css/chart.css"/>

<script type="text/javascript" src="libraries/chart.js/2.7.2/js/chart.min.js"></script>

<acme:form readonly="true">
	<div class="graficas">
	   <div>
	     <div class="chart">
	       <canvas id="chart1" width="400" height="400"></canvas>
	     </div>
	     <div class="chart">
	       <canvas id="chart2" width="400" height="400"></canvas>
	     </div>
	   </div>
	</div>

  	<acme:form-return code="administrator.charts.form.button.return"/>
</acme:form>

	<script src="libraries/acme/js/chart.js" charset="utf-8"></script>
	<script type="text/javascript">
	
		var companyEtiquetes = new Array();
		<jstl:forEach items="${sectorComp}" var="item">
			companyEtiquetes.push("${item}");
		</jstl:forEach>
	
		var companyData = new Array();	
		<jstl:forEach items="${numComp}" var="item">
			companyData.push(${item});
		</jstl:forEach>
	
		var inversorEtiquetes = new Array();
		<jstl:forEach items="${sectorInv}" var="item">
			inversorEtiquetes.push("${item}");
		</jstl:forEach>
	
		var inversorData = new Array();	
		<jstl:forEach items="${numInv}" var="item">
			inversorData.push(${item});
		</jstl:forEach>
		
		
		var ctCompany = document.getElementById('chart1');		
		var ctInversor = document.getElementById('chart2');

		
		var chartComp = construyeGrafica(ctCompany, 300, 300, "bar", companyData, companyEtiquetes, "Nº empresas por sector");
		var chartInv = construyeGrafica(ctInversor, 300, 300, "bar", inversorData, inversorEtiquetes, "Nº inversores por sector");
	</script>

