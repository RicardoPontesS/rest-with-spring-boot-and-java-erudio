package br.com.erudio;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices service;

	// chamada do método (requisição) vinda do navegador
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)

	public Person findById(@PathVariable(value = "id") String id) throws Exception {

		return service.findById(id);

	}

	@RequestMapping()
	public List<Person> findAll() {

		return service.findAll();

	}
}
