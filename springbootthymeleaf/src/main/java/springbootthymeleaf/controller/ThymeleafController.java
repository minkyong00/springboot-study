package springbootthymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springbootthymeleaf.model.Person;

@Controller("thymeleafController")
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@GetMapping("/thymeleaftags")
	public String thymeleaftags(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("content", "<strong>content</strong>");
		model.addAttribute("userId", "hong");
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("홍길동", 20));
		personList.add(new Person("이순신", 40));
		personList.add(new Person("강감찬", 30));
		model.addAttribute("personList", personList);
		
		model.addAttribute("isLoggedIn", true);
		model.addAttribute("role", "admin");
		model.addAttribute("isActive", false);
		
		return "thymeleaftags";
	}
	
	
}






































