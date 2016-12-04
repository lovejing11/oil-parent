function toInformationUrl(type, url, dataType, async, operation) {
	$.ajax({
		type : type,
		url : url,
		dataType : dataType,
		async : async,
		success : function(item) {
			//chartsOperation("main","vintage",item.data.xCategories,itechartsOperation
		}
	});
}
/**
 * echarts 柱状图，折线图 图表请求路径
 * @param type
 * @param url
 * @param async
 * @param main 显示层
 * @param macarons 主题
 * @param tTitle  图表标题
 */
function toInformationComparsionEUrl(type, url, async, main, macarons,tTitle) {
	$.ajax({
		type : type,
		url : url,
		dataType : "json",
		async : async,
		success : function(item) {
			if(item.data != "0"){
				 var xname = item.data.xname;
	             var yname = item.data.yname;
				 chartsOperation(main, macarons,tTitle,item.data.xCategories,item.data.yLCategories,xname,yname);
			}else{
				nodataHighChart(main);
			}
            
		}
	});
}

/**
 * echarts 饼图 图表请求路径
 * @param type
 * @param url
 * @param async
 * @param main 显示层
 * @param macarons 主题
 * @param tTitle  图表标题
 */
function toInformationComparsionEPUrl(type, url, async, main, macarons,tTitle) {
	$.ajax({
		type : type,
		url : url,
		dataType : "json",
		async : async,
		success : function(item) {
			if(item.data != "0"){
				 var legendData = item.data.legendData;
				 var SingleData = item.data.typeProportion;
				 var amount = item.data.amount;
	             chartsOperationPie(main,macarons,tTitle,legendData,amount,SingleData);
			}else{
				nodataHighChart(main);
			}
            
		}
	});
}

function toInformationComparsionHUrl(type, url, async, main, tTitle,xTitle,yTitle) {
	$.ajax({
		type : type,
		url : url,
		dataType : "json",
		async : async,
		success : function(members) {
			//alert(JSON.stringify(members));	
			if (!$.isEmptyObject(members)) {
				var xAxis = members.data.xCategories;
				var yLAxis = members.data.yLCategories;
				OneYHighChart(main, tTitle,xTitle,xAxis,yTitle,yLAxis)
			} else {
				nodataHighChart(main);
			}
		}
	});
}