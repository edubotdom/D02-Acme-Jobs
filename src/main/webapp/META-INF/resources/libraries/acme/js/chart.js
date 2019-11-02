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
            color: "rgba(0, 0, 0, 0.15)",
          },
	        ticks: {
            suggestedMin: 0,
            /*suggestedMax: 10,*/
						stepSize: 1,
	        }
        }],
        xAxes: [{
          gridLines: {
            color: "rgba(0, 0, 0, 0.15)"
          }
        }]
      },
      tooltips:{
        enabled:false
      },
			title:{
				display:true,
				text:titulo,
				fontSize: 20
			},
			elements: {
          line: {
            tension: 0 // disables bezier curves
          }
        },

			legend:{
				display:false
			},
			responsive : false
		}

	Chart.defaults.global.defaultFontColor = '#3a3737';
	Chart.defaults.global.defaultFontFamily = 'Lato';
  //Chart.defaults.global.defaultFontSize = 12;


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
				'rgba(185, 84, 106, 0.35)',
				'rgba(59, 153, 216, 0.35)',
				'rgba(255, 206, 86, 0.35)',
				'rgba(67, 228, 75, 0.35)',
				'rgba(245, 112, 183, 0.35)',
				'rgba(64, 255, 83, 0.35)',
				'rgba(176, 232, 32, 0.35)',
				'rgba(76, 107, 181, 0.35)',
				'rgba(68, 224, 122, 0.35)',
				'rgba(210, 62, 62, 0.35)',
				'rgba(222, 89, 236, 0.35)',
				'rgba(179, 23, 23, 0.35)'
				],
      hoverBackgroundColor: [
				'rgba(185, 84, 106, 0.55)',
				'rgba(59, 153, 216, 0.55)',
				'rgba(255, 206, 86, 0.55)',
				'rgba(67, 228, 75, 0.55)',
				'rgba(245, 112, 183, 0.55)',
				'rgba(64, 255, 83, 0.55)',
				'rgba(176, 232, 32, 0.55)',
				'rgba(76, 107, 181, 0.55)',
				'rgba(68, 224, 122, 0.55)',
				'rgba(210, 62, 62, 0.55)',
				'rgba(222, 89, 236, 0.55)',
				'rgba(179, 23, 23, 0.55)'
				],
			borderColor:  [
        'rgba(185, 84, 106, 0.75)',
        'rgba(59, 153, 216, 0.75)',
        'rgba(255, 206, 86, 0.75)',
        'rgba(67, 228, 75, 0.75)',
        'rgba(245, 112, 183, 0.75)',
        'rgba(64, 255, 83, 0.75)',
        'rgba(176, 232, 32, 0.75)',
        'rgba(76, 107, 181, 0.75)',
        'rgba(68, 224, 122, 0.75)',
        'rgba(210, 62, 62, 0.75)',
        'rgba(222, 89, 236, 0.75)',
        'rgba(179, 23, 23, 0.75)'
				],
			borderWidth: 1,
			hoverBorderColor: [
        'rgba(185, 84, 106, 1)',
        'rgba(59, 153, 216, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(67, 228, 75, 1)',
        'rgba(245, 112, 183, 1)',
        'rgba(64, 255, 83, 1)',
        'rgba(176, 232, 32, 1)',
        'rgba(76, 107, 181, 1)',
        'rgba(68, 224, 122, 1)',
        'rgba(210, 62, 62, 1)',
        'rgba(222, 89, 236, 1)',
        'rgba(179, 23, 23, 1)'
				]
		}]
	}
}
