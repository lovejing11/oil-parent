$(document).ready(function() {
} );
/**type:1 id,name
 * type:2 code,name*/
function select2_4_select(id,path,type){
	$("#"+id).select2({
		language: "zh-CN",
		theme: "classic",
		placeholder: {
			  id: "",
			  text: "请选择..."
			},
		allowClear: true,
		  ajax: {
		    url: path,
		    dataType: 'json',
		    type:"GET",
		    delay: 250,
		    allowClear: true,  //是否允许用户清除文本信息
		    data: function (params) {
		      return {
		    	  length:10,
		    	  name:params.term,
		    	  pageNumber: params.page
		      };
		    },
		    processResults: function (data,params) {
		    	 params.page = params.page || 1;
		      if(data.data){
		    	  var results= new Array();
		    	  $.each(data.data, function(i, item) {
		    		  if(type==1 || type==undefined)
		    			  results.push({ "id":item.accountId , "text": item.accountName});
		    		  else{
		    			  results.push({ "id":item.code , "text": item.accountName});
		    		  }
		    	  });
			      return {
			    	  results:results,
			    	  pagination: {
			              more: ( params.page  * 10) < data.recordsTotal
			            }
			      };
		      }
		    },
		    cache: true
		  }
		});
}