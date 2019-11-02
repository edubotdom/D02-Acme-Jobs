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

	<script src="scripts/chart.js" charset="utf-8"></script>
	<script src="scripts/init.js" charset="utf-8"></script>
	<script type="text/javascript">
		var chart1;
		var chart2;
		var ctx1 = document.getElementById('chart1');
		var ctx2 = document.getElementById('chart2');
	
		var año = 2019;
		var datos = [3,5,1,6], etiquetas = ["comida","electrodomesticos","b","c"];
	
		chart1 = construyeGrafica(ctx1, 300, 300, "bar", datos, etiquetas, "Empresas por sector");
		chart2 = construyeGrafica(ctx2, 300, 300, "line", datos, etiquetas, "Empresas por sector");
	</script>

