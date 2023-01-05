package br.com.erudio;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices service;

	// chamada do método (requisição) vinda do navegador

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)

	public Person create(@RequestBody() Person person) throws Exception {

		return service.create(person);   
    
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)

	public Person update(@RequestBody() Person person) throws Exception {

		return service.update(person);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value ="id") Long id) {

		service.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)

	public Person findById(@PathVariable(value = "id") Long id) throws Exception {

		return service.findById(id);

	}

	@RequestMapping()
	public List<Person> findAll() {

		return service.findAll();

	}
}
