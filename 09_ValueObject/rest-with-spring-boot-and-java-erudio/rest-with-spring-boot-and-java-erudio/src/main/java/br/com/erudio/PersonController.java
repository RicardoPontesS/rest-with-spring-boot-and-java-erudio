package br.com.erudio;
 
import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.exceptions.handler.CustomizedResponseEntityExceptionHandler;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices service;

	// chamada do método (requisição) vinda do navegador

	@GetMapping(value = "/{id}")

	public Person findById(@PathVariable(value = "id") Long id) throws Exception {

		return service.findById(id);

	}

	@PostMapping(value = "/{id}")
	public Person create(@RequestBody() Person person) throws Exception {

		return service.create(person);

	}

	@PutMapping(value = "/{id}")
	public Person update(@RequestBody() Person person) throws Exception {

		return service.update(person);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping()
	public List<Person> findAll() {

		return service.findAll();

	}
}
