package springbootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import springbootsecurity.entity.Member;
import springbootsecurity.service.MemberService;

@Controller("memberController")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/")
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute("user", request.getRemoteUser());
		return "index";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/join")
	public String joinForm(Model model) {
		model.addAttribute("member", new Member());
		return "join";
	}

	@PostMapping("/join")
	public String join(@ModelAttribute Member member) {
		memberService.registMember(member);
		return "redirect:/login?joined";
	}

}
