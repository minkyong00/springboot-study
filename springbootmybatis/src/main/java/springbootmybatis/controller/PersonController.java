package springbootmybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootmybatis.model.Person;
import springbootmybatis.service.PersonService;
import springbootmybatis.service.impl.PersonServiceImpl;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonServiceImpl personService_1;

	@Autowired
	private PersonService personService;

    PersonController(PersonServiceImpl personService_1) {
        this.personService_1 = personService_1;
    }
	
	@GetMapping("/")
	public List<Person> getPersonList() {
		return personService.getPersonList();
	}
	
	@GetMapping("/{pid}")
	public Person getPerson(@PathVariable int pid) {
		return personService.getPerson(pid);
	}
	
	@PostMapping("/")
	public String insertPerson(@RequestBody Person person) {
		personService.insertPerson(person);
		return "inserted";
	}
	
	@PutMapping("/{pid}")
	public String updatePerson(@PathVariable int pid, @RequestBody Person person) {
		person.setPid(pid);
		personService.updatePerson(person);
		return "updated";
	}
	
	@DeleteMapping("/{pid}")
	public String deletePerson(@PathVariable int pid) {
		personService.deletePerson(pid);
		return "deleted";
	}
	
	
}


























