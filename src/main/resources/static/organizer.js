var groups;
$(document).ready(function() {
	$("#btn_submit").click(function(event) {
		var orgId = $('#txt_org_id').val();
		var url = "/group?organizerId=" + orgId;
		$.getJSON(url, function(grpList) {
			groups = grpList;
			$('#div_group_list').text("");
			$.each( grpList, function(i, grp) {
				$('#div_group_list').append('&nbsp;&nbsp;<a>' + grp.id + '</a> &nbsp;&nbsp;').append(grp.name );
			});					
			
		});
	});
	
	$('#div_group_list').click(function(event) {
		console.log(event.target.text);
		var url = "/member?groupId=" + event.target.text;
		$.getJSON(url, function(memberList) {
			//groups = grpList;
			$('#div_member_list').text("");
			$.each( memberList, function(i, member) {
				$('#div_member_list').append('&nbsp;&nbsp;<a>' + member.id + '</a> &nbsp;&nbsp;').append(member.name + '</br>');
			});					
			
		});
	});
	
	$('#div_member_list').click(function(event) {
		console.log(event.target.text);
		
	});
});

