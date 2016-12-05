

$(function() {
	$.extend({
		initIcheck : function() {
			$(':checkbox:not(.hasInit),:radio:not(.hasInit)').addClass("hasInit").iCheck({
				checkboxClass : 'icheckbox_square-yellow',
				radioClass : 'iradio_square-yellow',
				increaseArea : '20%' // optional
			});
			$('table.table.datatable input.checkall').iCheck('uncheck');
		},
		initSelect2:function(){
			$('.aikxian-select2:not(.hasInit)').addClass("hasInit").select2({
				language: "zh-CN",
				theme: "classic"
			});
		},
		resetSelect2:function(){
			$('select.hasInit').val('').trigger('change');
		},
		initEditor:function(){
			$('.full-text-editor:not(.hasInit)').addClass("hasInit").each(function() {
				UE.getEditor($(this).attr("id"));
			});
		}
	})

	$.initIcheck();
	$.initSelect2();
	$.initEditor();
});