///*******************************************************************************
// * by songchunlong@aikxian.com datatable封装，鼠标浮动；选中
// */
//$(document).ready(function() {
//    
//	$('table.table.datatable:not(.hasInit)').each(function() {
//		var tl=$(this).children("th").length-1;
//		$(this).addClass("hasInit");
//		if ($(this).hasClass("multi")) {
//			$(this).DataTable({
//				columnDefs : [ {
//					orderable : false,
//					targets : [0,tl]
//				} ,{
//					className : 'select-checkbox',
//					targets : 0
//				}],
//				"order": [[ 1, "desc" ]]/*,
//				select : {
//					style : 'multi'
//				}*/
//			});
//		} else if ($(this).hasClass("single")) {
//			$(this).DataTable({
//				columnDefs : [ {
//					orderable : false,
//					targets : [0,tl]
//				} ,{
//					className : 'select-checkbox',
//					targets : 0
//				} ],
//				"order": [[ 1, "desc" ]]
//				/*,
//				select : {
//					style : 'os'
//				}*/
//			});
//		} else {
//			$(this).DataTable({
//				/*select : false,*/
//			});
//		}
//	});
//
//});

$(document).ready(function() {
		$(".queryForm").submit(function() {
			if($.dataTable){
				$.dataTable.fnDraw();
			}
			return false;
		});
		$(".queryForm .formRest").click(function(){
			$(".queryForm").resetForm();
			$.resetSelect2();
			return false;
		});
		$(".queryForm .formRestsubmit").click(function(){
			$(".queryForm").resetForm();
			$(".queryForm").submit();
			$.resetSelect2();
			return false;
		});
		$(".queryForm .formSubmit").click(function() {
			$(".queryForm").submit();
		});
		
		$.refresh=($.refresh?true:false)
		
		$('table.table.datatable input.checkall').on('ifChecked', function(event){ 
			//ifCreated 事件应该在插件初始化之前绑定 
		  $('table.table.datatable tbody :checkbox').iCheck('check');
		});
		$('table.table.datatable input.checkall').on('ifUnchecked', function(event){ 
			//ifCreated 事件应该在插件初始化之前绑定 
			$('table.table.datatable tbody :checkbox').iCheck('uncheck');
		});
		
	});