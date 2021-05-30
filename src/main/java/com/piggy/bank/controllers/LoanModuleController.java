package com.piggy.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.piggy.bank.domain.interfaces.IAdminModuleDomainService;
import com.piggy.bank.resource.models.Deposit;
import com.piggy.bank.resource.models.LoanProposal;

@Controller
public class LoanModuleController {

	@Autowired
	private IAdminModuleDomainService domainService;

	@RequestMapping(value = "/group/{groupId}/member/{memberId}/loan", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Deposit> createLoan(@PathVariable String groupId, @PathVariable String memberId,
			@RequestBody Deposit deposit) {
		return ResponseEntity.ok().headers(getResponseHeader()).body(deposit);
	}

	@RequestMapping(value = "/group/{groupId}/member/{memberId}/loan/propose", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LoanProposal> proposeLoan(@PathVariable String groupId, @PathVariable String memberId,
			@RequestBody LoanProposal loanProposal) {
		loanProposal = domainService.proposeLoan(groupId, memberId, loanProposal);
		return ResponseEntity.ok().headers(getResponseHeader()).body(loanProposal);
	}

	public HttpHeaders getResponseHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "GroupController");
		return headers;
	}
}
