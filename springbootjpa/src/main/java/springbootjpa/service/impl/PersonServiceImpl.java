package springbootjpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springbootjpa.entity.Person;
import springbootjpa.repository.PersonRepository;
import springbootjpa.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
   
   @Autowired
   private PersonRepository personRepository;
   
   @Override
   public List<Person> getPersonList() {
      return personRepository.findAll();
   }
   
   @Override
   public Optional<Person> getPerson(Long pid) {
      return personRepository.findById(pid);
   }
   
   @Override
   @Transactional
   public Person insertPerson(Person person) {
      return personRepository.save(person);
   }
   
   @Override
   @Transactional
   public Person updatePerson(Person person) {
      Person findPerson = getPerson(person.getPid()).get();
      findPerson.setPname(person.getPname());
      findPerson.setPage(person.getPage());
      return personRepository.save(findPerson);
   }
   
   @Override
   @Transactional
   public void deletePerson(Long pid) {
      personRepository.deleteById(pid);
   }

}















