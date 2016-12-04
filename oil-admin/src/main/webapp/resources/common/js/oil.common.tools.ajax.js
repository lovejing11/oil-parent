/**
 * tools 的ajax加载页面的函数初始化，应对添加、编辑时加载的页面不能绑定对应的事件问题
 * 
 * @author hejunsong
 */
$(function() {
	$("form[action]:not(.hasInit)").addClass("hasInit").validate({
		submitHandler : function(form) {
			var type=$(form).attr("method");
			$.aikxianAjax({
				"url" : $(form).attr("action"),
				"data" : $(form).serializeArray(),
				type:type?type:"POST",
				success : function(data) {
					if(data && (data.success==true|| data.success=="true") && data.code){
						if (0 == data.code || '0' == data.code) {
							$(form).closest('.modal').find('button.close').click();     
							  if($(".queryForm")){
								  $(".queryForm").submit();
							  }
							  $.showInfo("操作成功！");
						} else {
							$.showInfo("操作错误："+data.message);
						}
					}else{
						$.showSystemErrorMsg(data);
					}
					
				},
				error : function(err) {
					$.showSystemErrorMsg(err);
				}
			});
		}
	});
});