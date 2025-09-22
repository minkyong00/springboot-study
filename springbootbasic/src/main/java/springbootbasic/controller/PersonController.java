package springbootbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springbootbasic.service.PersonService;

@Controller("personController")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/getPersonList")
	public ModelAndView getPersonList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("personList", personService.getPersonList());
		mav.setViewName("personList");
		return mav;
	}
	
	@GetMapping("/getPerson")
	public ModelAndView getPerson(@RequestParam Integer pid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("person", personService.getPerson(pid));
		mav.setViewName("personView");
		return mav;
	}
	
}
