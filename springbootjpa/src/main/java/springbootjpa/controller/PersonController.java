package springbootjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootjpa.entity.Person;
import springbootjpa.service.PersonService;

@RestController("personRestController")
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/")
	public ResponseEntity<List<Person>> getPersonList() {
		return ResponseEntity.ok(personService.getPersonList());
	} //ResponseEntity: 결과와 액션을 같이 담아 보냄
	
	@GetMapping("/{pid}")
	public ResponseEntity<Optional<Person>> getPerson(@PathVariable Long pid) {
		return ResponseEntity.ok(personService.getPerson(pid));
	}
	
	@PostMapping("/")
	public ResponseEntity<Person> insertPerson(@RequestBody Person person) {
		return ResponseEntity.ok(personService.insertPerson(person));
	}
	
	@PutMapping("/{pid}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long pid, @RequestBody Person person) {
		person.setPid(pid);
		return ResponseEntity.ok(personService.updatePerson(person));
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<Void> deletePersonEntity(@PathVariable Long pid) {
		personService.deletePerson(pid);
		return ResponseEntity.noContent().build(); // 아무것도 안보냄
	}

}


















