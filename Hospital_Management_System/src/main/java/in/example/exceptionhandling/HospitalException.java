package in.example.exceptionhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HospitalException {

	@ExceptionHandler(value = Exception.class)
	public String handleRuntimeException(Exception exception) {
		return "All exception are handled";
	}
}
