package com.piggy.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.piggy.bank.domain.interfaces.IGroupDomainService;
import com.piggy.bank.resource.models.Loan;
import com.piggy.bank.resource.models.LoanProposal;

@Controller
public class LoanController {

	@Autowired
	private IGroupDomainService domainService;

	@RequestMapping(value = "/group/{groupId}/member/{memberId}/loan", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Loan> createLoan(@PathVariable String groupId, @PathVariable String memberId,
			@RequestBody Loan loan) {
		loan = domainService.createLoan(groupId, memberId, loan);
		return ResponseEntity.ok().headers(getResponseHeader()).body(loan);
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
		return headers;
	}
}
