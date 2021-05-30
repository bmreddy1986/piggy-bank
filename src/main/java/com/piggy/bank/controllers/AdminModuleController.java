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
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Member;

@Controller
public class AdminModuleController {

	@Autowired
	private IAdminModuleDomainService domainService;

	@RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
	public ResponseEntity<Group> getGroupById(@PathVariable("id") String id) {
		Group group = domainService.getGroupById(id);
		return ResponseEntity.ok().headers(getResponseHeader()).body(group);
	}

	@RequestMapping(value = "/group", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Group> createGroup(@RequestBody Group group) {
		group = domainService.createGroup(group);
		return ResponseEntity.ok().headers(getResponseHeader()).body(group);
	}

	@RequestMapping(value = "/group/{id}/addMember", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Member> addMember(@RequestBody Member member, @PathVariable String id) {
		member = domainService.addMember(id, member);
		return ResponseEntity.ok().headers(getResponseHeader()).body(member);
	}

	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	public ResponseEntity<Member> getMemberById(@PathVariable("id") String id) {
		Member member = member = domainService.getMemberById(id);
		return ResponseEntity.ok().headers(getResponseHeader()).body(member);
	}

	/*
	 * @RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE,
	 * consumes = "application/json")
	 * 
	 * @ResponseBody public String delete(@PathVariable("id") int id) { boolean
	 * isDeleted = false; HttpHeaders headers = new HttpHeaders();
	 * headers.add("Content-Type", "application/json"); headers.add("Responded",
	 * "GroupController");
	 * 
	 * try { // Group emp = new Group(id); // isDeleted = GroupDao.delete(emp); }
	 * catch (Exception ex) { System.out.println("Group not found to delete" +
	 * ex.getMessage()); return "Error deleting the Group: " + ex.toString(); }
	 * 
	 * if (isDeleted) { return "Group succesfully deleted!"; } return
	 * "Error! Group deleted!"; }
	 */

	public HttpHeaders getResponseHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "GroupController");
		return headers;
	}
}
