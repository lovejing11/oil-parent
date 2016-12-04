/**
 *创建图表
 */
/***无数据highchart***/
function nodataHighChart(containerId) {
	var chart = new Highcharts.Chart({
		chart : {
			renderTo : containerId,
			//backgroundColor : '#FBFBFB'
		},

		title : {
			text : '没有相关数据显示'
		},
		exporting : {
			enabled : false
		},
		credits : {
			enabled : false
		},
		xAxis : {
			categories : []
		},
		yAxis : {
			min : 0,
			lineWidth : 1.0,
			lineColor : '#CCD4D4',
			gridLineColor : '#CCD4D4',
			gridLineDashStyle : 'dash',
			title : {
				text : '无数据'
			},
			labels : {
				formatter : function() {
					return this.value;
				}
			},
			plotLines : [ {
				value : 0,
				width : 1,
				color : '#808080'
			} ]
		},
		series : [ {
			name : '无显示数据',
			data : []
		} ]
	}

	);
}


/**
 * 单Y轴坐标显示
 * @param containerId    显示位置ID
 * @param tTitle       统计图标题
 * @param xTitle       X轴坐标标题
 * @param xCategories    X轴坐标数据
 * @param yTitle     Y轴坐标标题
 * @param yCategories    Y轴坐标显示数据
 */
function OneYHighChart(containerId,tTitle,xTitle,xCategories,yTitle,yCategories) {
	var chart = new Highcharts.Chart({
		chart : {
			renderTo : containerId,
			zoomType : 'xy',
			backgroundColor : '#FFFFFF',
		},
		title : {
			text : tTitle,
			x: 0,
			style:{
				fontSize: '18px',
				fontWeight: 'bold'
			}
		},
		lang:{
			printChart: '导出',
			downloadJPEG: '导出JPEG图片',
			downloadPDF: '导出DF文档',
			downloadPNG: '导出PNG图片',
			downloadSVG: '导出SVG矢量图',
		},
		
		exporting : {
			enabled : false
		},
		credits : {
			enabled : false
		},
		xAxis : {
			enabled: true,
			categories : xCategories,
			title:{
				text:xTitle,
				align: "high"
			}
		},
		yAxis : {
			min : 0,
			lineWidth : 1.0,
			lineColor : '#CCD4D4',
			gridLineColor : '#CCD4D4',
			gridLineDashStyle : 'dash',
			title : {
				text : yTitle
			},
			labels : {
				formatter : function() {
					return this.value;
				}
			},
			plotLines : [ {
				value : 0,
				width : 1,
				color : '#808080'
			} ]
		},
		tooltip:{
			//pointFormat: '<span style="color:{series.color}">{series.name}</span>:{point.y:,.2f} <b>万kW·h</b><br/>',
            shared: true,
            crosshairs: true,//标线
		},
		series : [],
	}

	);
	var len=yCategories.length;
	for(var i=0;i<len;i++){
		chart.addSeries({
			name:yCategories[i].name,
			type:yCategories[i].type,
			data:yCategories[i].data,
			color:yCategories[i].color,
			tooltip : {
				valueSuffix : yCategories[i].unit,
			},
		});
		
	}
}

/**
 * 三Y轴坐标显示
 * @param containerId   显示ID位置
 * @param tTitle   统计图标题
 * @param xTitle   X轴标题
 * @param xCategories   X轴坐标数据
 * @param yTitle1   1Y轴标题
 * @param yTitle2   2Y轴标题
 * @param yTitle3   3Y轴标题
 * @param yLCategories   1Y轴坐标数据
 * @param yRCategories   2Y轴坐标数据  
 * @param yMCategories   3Y轴坐标数据
 */
function ThreeYHighChart(containerId,tTitle,xTitle,xCategories,yTitle1,yTitle2,yTitle3,yLCategories,yRCategories,yMCategories) {
	var chart = new Highcharts.Chart({
		chart : {
			renderTo : containerId,
			//zoomType : 'xy',
			ignoreHiddenSeries: false,
			backgroundColor : '#FBFBFB',
		},
		lang:{
			printChart: '导出',
			downloadJPEG: '导出JPEG图片',
			downloadPDF: '导出DF文档',
			downloadPNG: '导出PNG图片',
			downloadSVG: '导出SVG矢量图',
		},
		title : {
			text : tTitle,
			x: 0,
			style:{
				fontSize: '18px',
				fontWeight: 'bold'
			}
		},
		exporting : {
			//enabled : false
		},
		credits : {
			enabled : false
		},
		xAxis : {
			categories : xCategories,
			labels: {
	               rotation: -45,
	               align: 'right',
	               style: {
	                   fontSize: '12px',
	                   fontFamily: 'Verdana, sans-serif'
	               }
	           },
			tickInterval:12,
			style:{
				text:xTitle
			}
		},
		//显示线
        tooltip: {			
            shared: true,
            crosshairs: true,
			marker: {
                enabled: false
           }
        },plotOptions: {
        	line: {
                fillOpacity: 0.5,
				//去数据点
			marker: {
                enabled: false
           }  }  },
		 yAxis: [{ // Primary yAxis
        	    min: 0,
				lineWidth: 1.0,
				lineColor: '#CCD4D4',
				gridLineColor: '#CCD4D4',
				gridLineDashStyle: 'dash',
             labels: {
                 formatter: function() {
                     return this.value +''
                 },
                 style: {
                     color: '#89A54E'
                 }
             },
             title: {
                 text: yTitle1,
                 style: {
                     color: '#89A54E'
                 },
             },
         }, { // Secondary yAxis
        	 min: 0,
				lineWidth: 1.0,
				lineColor: '#CCD4D4',
				gridLineColor: '#CCD4D4',
				gridLineDashStyle: 'dash',
             title: {
                 text: yTitle2,
                 style: {
                     color: '#4572A7'
                 },
             },
             labels: {
                 formatter: function() {
                     return this.value;//+"";
                 },
                 style: {
                     color: '#4572A7'
                 }
             },
             opposite: true
         },{ // THIRD yAxis
        	 min: 0,
				lineWidth: 1.0,
				lineColor: '#CCD4D4',
				gridLineColor: '#CCD4D4',
				gridLineDashStyle: 'dash',
          title: {
              text: yTitle3,
              style: {
                  color: '#4572A7'
              },
          },
          labels: {
              formatter: function() {
                  return this.value+"";
              },
              style: {
                  color: '#4572A7'
              }
          },
          opposite: true
      }
         
         
         ],
		colors: [
            '#AA60BA', 
            '#019DCD',
			'#DE7A2A',
			'#1287C6',
			'#83AD2D',
			'#2CA562'
			
			
		],
		series : []
	});
	var len=yLCategories.length;
	for(var i=0;i<len;i++){
		chart.addSeries({
			name:yLCategories[i].name,
			type:yLCategories[i].type,
			data:yLCategories[i].data,
			//valueSuffix:'%'
			tooltip : {
				valueSuffix : yLCategories[i].unit,
			}
		});
	}
	var len=yRCategories.length;
	for(var i=0;i<len;i++){
		chart.addSeries({
			name:yRCategories[i].name,
			type:yRCategories[i].type,
			data:yRCategories[i].data,
			color:yRCategories[i].color,
			tooltip : {
				valueSuffix : yRCategories[i].unit,
			},
			yAxis:1,
			
		});
	}
	
	var len1=yMCategories.length;
	for(var i=0;i<len1;i++){
		chart.addSeries({
			name:yMCategories[i].name,
			type:yMCategories[i].type,
			data:yMCategories[i].data,
			color:yMCategories[i].color,
			tooltip : {
				valueSuffix : yMCategories[i].unit,
			},
			yAxis:2,
			
		});
	}
}