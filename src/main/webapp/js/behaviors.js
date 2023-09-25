$(document).ready(function() {
	/**
	 * Global
	 */
	$('#amount').keyup(function(e) {
		$(this).val(format($(this).val()));
	});
	
	var format = function(num){
    var str = num.toString().replace("$", ""), parts = false, output = [], i = 1, formatted = null;
	    if(str.indexOf(".") > 0) {
	        parts = str.split(".");
	        str = parts[0];
	    }
	    str = str.split("").reverse();
	    for(var j = 0, len = str.length; j < len; j++) {
	        if(str[j] != ",") {
	            output.push(str[j]);
	            if(i%3 == 0 && j < (len - 1)) {
	                output.push(",");
	            }
	            i++;
	        }
	    }
	    formatted = output.reverse().join("");
	    return("$" + formatted + ((parts) ? "." + parts[1].substr(0, 2) : ""));
	};
	
	/**
	 * Home page
	 */
	$('.account-tools').on('click', function() {
		console.log("Hello World!");
	});
	
	/**
	 * Zelle page
	 */
    $('button[name="contact_id"]').on('click', function(e) {
		e.preventDefault();
		var contactName = $(this).text().trim();
		var contactId = $(this).val();
		var receiverId = $(this).data('receiver-id');
		
		$('input[name="contact_name"]').val(contactName);
		$('input[name="contact_id"]').val(contactId);
		$('input[name="receiver_id"]').val(receiverId);
		
		$('form').submit();
	});
	
	$(document).on("click", ".add-contact #webform-submit", function(e) {
	    e.preventDefault();

	    var email = $("#email").val();
	    var phoneNumber = $("#phoneNumber").val();
	    
	    if (!email && !phoneNumber) {
	        alert("Please fill in at least one of the fields (Email or Phone Number).");
	        return false;
	    }
	    
	    return true;
	});
});