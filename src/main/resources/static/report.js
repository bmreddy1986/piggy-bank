
$(document).ready(function() {
	$("#btn_org_submit").click(function(event) {
		alert("Not implemented");
	});
	
	$('#btn_mem_submit').click(function(event) {
		
		var memId = $('#txt_mem_id').val();
		if(null == memId || undefined == memId || "" == memId ){
			alert("MemberId should not be empty");
			event.preventDefault();
		}
		var url = '/member/' + memId + '/deposit';
		$.getJSON(url, function(depositList) {
			$('#div_mem_dep_in_grp').text("");
			var sum=0;
			var intermediateSum=0;
			$.each( depositList, function(i, deposit) {
				if(i==0 || depositList[i-1].groupid != depositList[i].groupid){
					if(i!=0){
						$('#div_mem_dep_in_grp').append('Sum in the Group ' + depositList[i-1].groupid + ':'+ intermediateSum).append('</br>');	
					}
					
					$('#div_mem_dep_in_grp').append(deposit.groupid).append('</br>');
					intermediateSum=0;
				} 
				$('#div_mem_dep_in_grp').append('&nbsp;&nbsp;<a>' + deposit.id + '</a> &nbsp;&nbsp;')
				.append(deposit.amount + '&nbsp;&nbsp;')
				.append(deposit.depositMonth + '</br>');
				sum+=deposit.amount;
				intermediateSum+=deposit.amount;
			});
			$('#div_mem_dep_in_grp').append('Sum in the Group ' + depositList[depositList.length-1].groupid + ':'+ intermediateSum);
			$('#div_mem_dep_in_grp').append('</br> Total Sum:' + sum);
			if(0 == depositList.length){
				$('#div_mem_dep_in_grp').text("No deposit found");
			}
		});
	});
	
	$('#div_member_list').click(function(event) {
		console.log(event.target.text);
	});
});

