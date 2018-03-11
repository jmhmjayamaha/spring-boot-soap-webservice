package lk.harshana.service;

import java.util.List;

import lk.harshana.entity.Person;

public interface PersonService {

	void addPerson(Person person);
	boolean deletePerson(long id);
	List<Person> listAllPerson();
	boolean updatePerson(long id, Person person);
	Person findById(long id);
}
