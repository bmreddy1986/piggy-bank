$(document).ready(function() {
            $("#driver").click(function(event){
				
               $.getJSON('http://localhost:8080/group/10001', function(group) {
                  $('#stage').html('<p> Name: ' + group.name + '</p>');
                  $('#stage').append('<p>Id : ' + group.id+ '</p>');
                  
               });
					
            });
         });