package com.kiku.boardweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kiku.boardweb.service.MemberDTO;
import com.kiku.boardweb.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/login")
	public String login(HttpSession session) {
		System.out.println("=> MemberController - login(get)");
		session.invalidate();
		return "/login";
	}
	
	@PostMapping(value = "/login")
	public String login(MemberDTO dto, Model model, HttpSession session) {
		System.out.println("=> MemberController - login(post)");
		MemberDTO member = memberService.login(dto);
		if(member == null) {
			return "member/login";
		}
		session.setAttribute("member", member);
		return "redirect:/board/list?pageNum=1";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		System.out.println("=> MemberController - logout");
		session.invalidate();
		return "redirect:login";
	}
	
	@GetMapping(value = "/join")
	public String join() {
		System.out.println("=> MemberController - join(get)");
		return "member/memberJoin";
	}
	
	@PostMapping(value = "/join")
	public String join(MemberDTO dto) {
		System.out.println("=> MemberController - join(post)");
		memberService.join(dto);
		return "redirect:/member/login";
	}
	
	@ResponseBody
	@PostMapping(value = "/memberCheck")
	public int checkMember(@RequestParam("id") String id) {
		System.out.println("=> MemberController - memberCheck");
		int cnt = 0; // memberJoin.jsp에서 ajax를 사용했음. 결과 코드 번호를 받아서 처리하기 위한 cnt 값. member 중에서 동일한 id가 있는지 조회 결과를 저장. 0은 사용 가능, 1은 사용 불가
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id); // 회원가입을 시도하려는 id를 저장
		if (memberService.getMember(dto) == null) { // member중에서 해당 아이디가 없을 경우 
			cnt = 0; // 사용 가능 코드 번호 반환
		} else { // member 중에서 해당 id가 있을 경우
			cnt = 1; // 사용 불가 코드 번호 반환
		}
		
		return cnt; // ajax에게 코드 번호 반환
	}
	
	/* shopHeader.jsp -> member 정보 확인 */
	@RequestMapping("/info")
	public String info(MemberDTO dto, Model model, HttpSession session) {
		System.out.println("=> MemberController - info");
		
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		if (member != null) {
			model.addAttribute("member", memberService.getMember(member));
		} else {
			return "member/login"; // login 중이 아닐시 login 페이지로 이동
		}

		return "member/memberInfo";
	}
	
	@RequestMapping("/update")
	public String update(MemberDTO dto, HttpSession session) {
		System.out.println("=> MemberController - update");
		memberService.update(dto);
		session.setAttribute("member", memberService.getMember(dto));
		return "redirect:/board/list";
	}
	
	/* memberInfo.jsp -> member 삭제*/
	@RequestMapping("/delete")
	public String delete(MemberDTO dto) {
		System.out.println("=> MemberController - delete");
		memberService.delete(dto);
		return "login";
	}
}
