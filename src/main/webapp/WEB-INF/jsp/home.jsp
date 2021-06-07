<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>The jQuery Example</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
	
</script>

<script type="text/javascript" >
$(document).ready(function() {
    $("#driver").click(function(event){
        var orgId = $('#txt_org_id').val();
		var url = "http://localhost:8080/group?organizerId=" + orgId;
       	$.getJSON(url, function(groupList) {
          	$('#stage').html('<p> Name: ' + groupList[0].name + '</p>');
          	$('#stage').append('<p>Id : ' + groupList[0].id+ '</p>');
          	
          
       	});
			
    }); 
 });
</script>
</head>

<body>
	<div id="stage">STAGE</div>
	Organizer ID: <input type="text" id="txt_org_id" />
	<input type="button" id="driver" value="Load Data" />
</body>
</html>