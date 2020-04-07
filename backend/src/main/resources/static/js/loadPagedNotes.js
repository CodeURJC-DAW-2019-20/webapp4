$(document).ready(function(){
	
	const PAGE_SIZE= 10;
    var page = 1;
    
    $('#spinner').hide();
	
	function loadNotes(id) {
		$('#spinner').show();
		$.ajax({
			type: "GET",
			url: "https://localhost:8443/search/subject/" + id + "/notes?page=" + page + "&size=" + PAGE_SIZE,
			dataType: 'html',
			success: function(data){
				setTimeout(function(){
					$('#spinner').hide();
					$('#list2').append(data);
				}, 1000);
				
			},
			error: function (data) 
	        {
				setTimeout(function(){ $('#spinner').hide(); }, 1000);
	        }
		});
		page++;
	}
	
	 $('#buttonload').click(function(e) {
		 var url = window.location.href; 
		 var res = url.split("/");
		 loadNotes(res[5])
	    });
	  
	  
});