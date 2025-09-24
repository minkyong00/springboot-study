package springbootmybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import springbootmybatis.model.Person;

@Mapper
public interface PersonMapper {

	@Select(" select * from person order by pid desc ")
	List<Person> findAll(); 
	
	@Select(" select * from person where pid=#{pid} ")
	Person findById(int pid);
	
	@Insert(" insert into person values(seq_person.nextval, #{pname}, #{page}) ")
	void insertPerson(Person person);
	
	@Update(" update person set pname=#{pname}, page=#{page} where pid=#{pid} ")
	void updatePerson(Person person);
	
	@Delete(" delete from person where pid=#{pid} ")
	void deletePerson(int pid);
	
}
