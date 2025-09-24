package springbootmybatis.service;

import java.util.List;

import springbootmybatis.model.Person;

public interface PersonService {

	public default List<Person> getPersonList() { return null; }
	
	public default Person getPerson(int pid) { return null; }
	
	public default void insertPerson(Person person) {}
	
	public default void updatePerson(Person person) {}
	
	public default void deletePerson(int pid) {}

}
