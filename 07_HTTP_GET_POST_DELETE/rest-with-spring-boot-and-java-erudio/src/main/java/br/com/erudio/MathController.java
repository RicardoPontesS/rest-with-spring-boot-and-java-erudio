package br.com.erudio;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET) // chamada do método
																						// (requisição) vinda do
																						// navegador
	public double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {

			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return convertToDouble(numberOne) + convertToDouble(numberTwo);

	}

	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)

	public double subtraction(@PathVariable(value = "numberOne") double numberOne,
			@PathVariable(value = "numberTwo") double numberTwo) {

		return numberOne - numberTwo;
	}

	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public double mutiplication(@PathVariable(value = "numberOne") double numberOne,
			@PathVariable(value = "numberTwo") double numberTwo) {

		return numberOne * numberTwo;
	}

	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public double division(@PathVariable(value = "numberOne") double numberOne,
			@PathVariable(value = "numberTwo") double numberTwo) {

		return numberOne / numberTwo;
	}

//----------------------------------------------------------------------
	private double convertToDouble(String strNumber) {

		if (strNumber == null)
			return 0D;

		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 0D;
	}

	private boolean isNumeric(String strNumber) {

		if (strNumber == null)
			return false;

		String number = strNumber.replaceAll(",", ".");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
