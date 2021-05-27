package com.piggy.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piggy.bank.domain.interfaces.IAdminModuleDomainService;
import com.piggy.bank.resource.models.Deposit;

@Controller
public class DepositModuleController {

	@Autowired
	private IAdminModuleDomainService domainService;

	@RequestMapping(value = "/group/{groupId}/member/{memberId}/deposit", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Deposit> createDeposit(@PathVariable String groupId, @PathVariable String memberId,
			@RequestBody Deposit deposit) {

		try {
			deposit = domainService.addDeposit(groupId, memberId, deposit);
		} catch (Exception ex) {
			System.out.println("Group not found" + ex.getMessage());
			return ResponseEntity.ok().headers(getResponseHeader()).body(deposit);
		}

		return ResponseEntity.ok().headers(getResponseHeader()).body(deposit);
	}

	public HttpHeaders getResponseHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "GroupController");
		return headers;
	}
}