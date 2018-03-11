package lk.harshana.repository;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	Person findById(long personId);
	
}
