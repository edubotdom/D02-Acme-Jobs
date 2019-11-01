function construyeGrafica(chart, width, height, tipo, datos, etiquetas, label){
  chart.height = height;  chart.width = width;

  return grafica(chart, tipo, datos, etiquetas, label);
}

function grafica(ctx, tipo, datos, etiquetas ,titulo){
	var data = datosGrafica(datos, etiquetas);
	var options = {
			scales: {
        yAxes: [{
          gridLines: {
            color: "rgba(255, 255, 255, 0.2)"
          },
	        ticks: {
            suggestedMin: 0,//este es importante
            /*suggestedMax: 10,
						stepSize: 50,*/
	        }
        }],
        xAxes: [{
          gridLines: {
            color: "rgba(0, 2, 2, 0.2)"
          }
        }]
      },
			title:{
				display:true,
				text:titulo,
				fontSize: 18
			},
			elements: {
          line: {
            tension: 0.3 // disables bezier curves
          }
        },
			tooltips:{
				display:false
			},
			legend:{
				display:false
			},
			responsive : false
		}

	Chart.defaults.global.defaultFontColor = '#3a3737';
	Chart.defaults.global.defaultFontFamily = 'Lato';

	var c = new Chart(ctx, {
		type: tipo,
		data: data,
		options: options
		});
	return c
}


function datosGrafica(datos, etiquetas){
	return {
		labels: etiquetas,
		datasets: [{
			data: datos,
			backgroundColor: [
				'rgba(255, 99, 132, 0.45)',
				'rgba(54, 162, 235, 0.45)',
				'rgba(255, 206, 86, 0.45)',
				'rgba(75, 192, 192, 0.45)',
				'rgba(153, 102, 255, 0.45)',
				'rgba(255, 159, 64, 0.45)',
				'rgba(255, 99, 132, 0.45)',
				'rgba(54, 162, 235, 0.45)',
				'rgba(255, 206, 86, 0.45)',
				'rgba(75, 192, 192, 0.45)',
				'rgba(153, 102, 255, 0.45)',
				'rgba(255, 159, 64, 0.45)'
				],
			borderColor: "#827d7d",
			borderWidth: 1,
			hoverBorderColor:"#383737"
		}]
	}
}
