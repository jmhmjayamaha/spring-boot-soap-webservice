package lk.harshana.endpoint;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import lk.harshana.entity.Person;
import lk.harshana.service.PersonService;
import lk.harshana.student_ws.AddPersonRequest;
import lk.harshana.student_ws.AddPersonResponse;
import lk.harshana.student_ws.PersonInfo;
import lk.harshana.student_ws.ServiceStatus;

@Endpoint
public class WSEndpoint {

	private static final String NAMESPACE_URI = "http://www.example.com/person-ws";
	
	@Autowired
	private PersonService personService;
	
	@PayloadRoot(namespace=NAMESPACE_URI , localPart="addPersonRequest")
	@ResponsePayload
	public AddPersonResponse addPerson(@RequestPayload AddPersonRequest request) {
		AddPersonResponse response = new AddPersonResponse();
		
		ServiceStatus status = new ServiceStatus();
		status.setStatusCode("SUCCESS");
		status.setMessage("Content added");
		
		Person person = new Person();
		person.setFirstName(request.getFirstName());
		person.setLastName(request.getLastName());
		person.setAge(request.getAge());
		person.setAddress(request.getAddress());
		person.setEmail(request.getEmail());
		
		personService.addPerson(person);
		
		PersonInfo personInfo = new PersonInfo();
		BeanUtils.copyProperties(person, personInfo);
		response.setPersonInfo(personInfo);
		response.setServiceStatus(status);
		
		return response;
	}

}
