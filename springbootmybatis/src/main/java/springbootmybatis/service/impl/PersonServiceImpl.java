package springbootmybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootmybatis.mapper.PersonMapper;
import springbootmybatis.model.Person;
import springbootmybatis.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonMapper personMapper;

	@Override
	public List<Person> getPersonList() {
		return personMapper.findAll();
	}
	
	@Override
	public Person getPerson(int pid) {
		return personMapper.findById(pid);
	}
	
	@Override
	public void insertPerson(Person person) {
		personMapper.insertPerson(person);
	}
	
	@Override
	public void updatePerson(Person person) {
		personMapper.updatePerson(person);
	}
	
	@Override
	public void deletePerson(int pid) {
		personMapper.deletePerson(pid);
	}
	
}
