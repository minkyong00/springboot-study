package springbootthymeleaf.service.impl;

import org.springframework.stereotype.Service;

import springbootthymeleaf.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Override
	public void thymeleaftags() {
		PersonService.super.thymeleaftags();
	}
	
	@Override
	public void example() {
		PersonService.super.example();
	}

}
