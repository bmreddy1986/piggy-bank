package com.piggy.bank;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piggy.bank.domain.interfaces.IGroupDomainService;
import com.piggy.bank.resource.mappers.AppMapper;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Member;

@Controller
public class GroupController {

	@Autowired
	private IGroupDomainService groupDomainService;

	@RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Group> getById(@PathVariable("id") String id) {
		Group group = null;

		try {
			group = groupDomainService.getGroupById(id);
		} catch (Exception ex) {
			System.out.println("Group not found" + ex.getMessage());
			// return ResponseEntity.accepted().headers(headers).body(group);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "GroupController");
		return ResponseEntity.ok().headers(headers).body(group);
	}

	@RequestMapping(value = "/group", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Group> create(@RequestBody Group group) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "GroupController");

		try {
			group = groupDomainService.createGroup(group);
		} catch (Exception ex) {
			System.out.println("Group not found" + ex.getMessage());
			return ResponseEntity.ok().headers(headers).body(group);
		}

		return ResponseEntity.ok().headers(headers).body(group);
	}

	@RequestMapping(value = "/group/{id}/addMember", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Member> create(@RequestBody Member member, @PathVariable String id) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "GroupController");
		headers.add("Message", "Member is added successfully to the group!");

		try {
			member = groupDomainService.addMember(id, member);
		} catch (Exception ex) {
			System.out.println("Group not found" + ex.getMessage());
			return ResponseEntity.ok().headers(headers).body(member);
		}

		return ResponseEntity.ok().headers(headers).body(member);
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
}
