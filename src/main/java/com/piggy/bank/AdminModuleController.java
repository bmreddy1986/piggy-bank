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

import com.piggy.bank.domain.interfaces.IGroupAndMemberDomainService;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Member;

@Controller
public class AdminModuleController {

	@Autowired
	private IGroupAndMemberDomainService domainService;

	@RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Group> getGroup(@PathVariable("id") String id) {
		Group group = null;
		try {
			group = domainService.getGroupById(id);
		} catch (Exception ex) {
			System.out.println("Group not found" + ex.getMessage());
		}

		return ResponseEntity.ok().headers(getResponseHeader()).body(group);
	}

	@RequestMapping(value = "/group", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Group> create(@RequestBody Group group) {

		try {
			group = domainService.createGroup(group);
		} catch (Exception ex) {
			System.out.println("Group not found" + ex.getMessage());
			return ResponseEntity.ok().headers(getResponseHeader()).body(group);
		}

		return ResponseEntity.ok().headers(getResponseHeader()).body(group);
	}

	@RequestMapping(value = "/group/{id}/addMember", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Member> create(@RequestBody Member member, @PathVariable String id) {

		try {
			member = domainService.addMember(id, member);
		} catch (Exception ex) {
			System.out.println("Group not found" + ex.getMessage());
			return ResponseEntity.ok().headers(getResponseHeader()).body(member);
		}

		return ResponseEntity.ok().headers(getResponseHeader()).body(member);
	}
	
	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Member> getMember(@PathVariable("id") String id) {
		Member member = null;
		
		try {
			member = domainService.getMemberById(id);
		} catch (Exception ex) {
			System.out.println("Member not found" + ex.getMessage());
			return ResponseEntity.accepted().headers(getResponseHeader()).body(member);
		}

		return ResponseEntity.ok().headers(getResponseHeader()).body(member);
	}

	@RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		boolean isDeleted = false;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "GroupController");

		try {
			// Group emp = new Group(id);
			// isDeleted = GroupDao.delete(emp);
		} catch (Exception ex) {
			System.out.println("Group not found to delete" + ex.getMessage());
			return "Error deleting the Group: " + ex.toString();
		}

		if (isDeleted) {
			return "Group succesfully deleted!";
		}
		return "Error! Group deleted!";
	}
	
	public HttpHeaders getResponseHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "GroupController");
		return headers;
	}
}
