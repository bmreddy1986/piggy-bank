package com.piggy.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piggy.bank.resource.models.Member;

@Controller
public class MemberController {
	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Member> getById(@PathVariable("id") int id) {
		Member member = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "MemberController");

		try {
			List<String> memberGroup = new ArrayList<>();
			memberGroup.add("GRP_12345");
			memberGroup.add("GRP_11115");
			member = new Member("8446115525", "Manohar Reddy", "Hyderabad", "manohar@gmail.com", "Unix11!",
					memberGroup);
			// Member = MemberDao.getById(MemberId);
		} catch (Exception ex) {
			System.out.println("Member not found" + ex.getMessage());
			return ResponseEntity.accepted().headers(headers).body(member);
		}

		return ResponseEntity.ok().headers(headers).body(member);
	}

	@RequestMapping(value = "/member/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		boolean isDeleted = false;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "MemberController");

		try {
			// Member emp = new Member(id);
			// isDeleted = MemberDao.delete(emp);
		} catch (Exception ex) {
			System.out.println("Member not found to delete" + ex.getMessage());
			return "Error deleting the Member: " + ex.toString();
		}

		if (isDeleted) {
			return "Member succesfully deleted!";
		}
		return "Error! Member deleted!";
	}

//	@RequestMapping(value = "/member", method = RequestMethod.POST, consumes = "application/json")
//	@ResponseBody
//	public ResponseEntity<Member> create(@RequestBody Member group) {
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "application/json");
//		headers.add("Responded", "GroupController");
//
//		try {
//
//			// group = GroupDao.create(group);
//		} catch (Exception ex) {
//			System.out.println("Group not found" + ex.getMessage());
//			return ResponseEntity.ok().headers(headers).body(group);
//		}
//
//		return ResponseEntity.ok().headers(headers).body(group);
//	}

}
