package br.com.erudio;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello %S,!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting") // chamada do método (requisição) vinda do navegador
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/soma")
	public int retornaSoma() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o primeiro numero: ");
		int a = input.nextInt();
		System.out.println("Digite o segundo numero: ");
		int b = input.nextInt();
		return a+b;

	}

}
