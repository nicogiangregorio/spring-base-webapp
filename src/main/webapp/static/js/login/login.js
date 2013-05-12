$(document).ready(function(){
	$("#login_submit").click(function(){
		$.ajax({
			type: 'POST',
			url: 'j_spring_security_check',
			data: $("#login_form").serialize(),
			dataType: 'json',
			success: function(data, textStatus, jqXHR) {
				if(data.login.status === "success")
					window.location = window.location + data.login.redirect_url;
				else 
					$("#login_failed").fadeIn(500);

			},
			error: function(jqXHR, textStatus, errorThrown){
				$("#login_failed").fadeIn(500);
			}
		});
		return false;
	});
});