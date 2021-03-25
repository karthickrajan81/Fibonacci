package helloworld.api.nebula.com.api;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Hello %s!", name);
	}

	@GetMapping("/fib")
	public Collection<Long> getFibonacciSeries(@RequestParam(value = "input", defaultValue = "2") int input) {
		var fibProcessor = new fibonacciProcessor(input);
		return fibProcessor.GetFibonacciSeries();
	}

	@GetMapping("/fibsum")
	public Long getFibonacciValue(@RequestParam(value = "input", defaultValue = "2") int input) {
		var fibProcessor = new fibonacciProcessor(input);
		return fibProcessor.GetSumOfFibonacciSeries();
	}
}
