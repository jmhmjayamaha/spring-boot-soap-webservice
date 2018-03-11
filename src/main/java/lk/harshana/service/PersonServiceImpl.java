package lk.harshana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.entity.Person;
import lk.harshana.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepo;
	
	@Override
	public void addPerson(Person person) {
		personRepo.save(person);
	}

	@Override
	public boolean deletePerson(long id) {
		Person person = personRepo.findById(id);
		if(person != null ) {
			personRepo.delete(person);
			return true;
		}
		return false;
	}

	@Override
	public List<Person> listAllPerson() {
		
		return (List<Person>) personRepo.findAll();
	}

	@Override
	public boolean updatePerson(long id , Person person) {
		Person p = personRepo.findById(id);
		
		if(p != null) {
			person.setId(p.getId());
			
			personRepo.save(person);
		}
		return false;
	}

	@Override
	public Person findById(long id) {
		return personRepo.findById(id);
	}

}
