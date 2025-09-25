package springbootjpa.service;

import java.util.List;
import java.util.Optional;

import springbootjpa.entity.Person;

public interface PersonService {
	
	public abstract List<Person> getPersonList();
	
	public abstract Optional<Person> getPerson(Long pid);
	
	public abstract Person insertPerson(Person person);

	public abstract Person updatePerson(Person person);
	
	public abstract void deletePerson(Long pid);

}













