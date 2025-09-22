package springbootbasic.service;

import java.util.List;

import springbootbasic.model.Person;

public interface PersonService {

	public default List<Person> getPersonList() { return null; }
	
	public default Person getPerson(int pid) { return null; }
	
}
