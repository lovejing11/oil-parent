$(document).ready(function() {
	$(".modal").on("hidden.bs.modal", function() {
	     $(this).removeData("bs.modal");
	}); 
	 
	$('.modal-body').on('select2:open', function(e) {
		$('.modal').append($('.select2-dropdown').parent());
	})
});