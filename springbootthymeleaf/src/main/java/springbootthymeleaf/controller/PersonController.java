package springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springbootthymeleaf.model.Person;

@Controller("personController")
@RequestMapping("/person")
public class PersonController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("person", new Person());
		return "form";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute Person person, Model model) {
		model.addAttribute("person", person);
		return "result";
	}
	
}
