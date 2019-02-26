package br.com.alura.forum.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.alura.forum.validator.dto.ValidationErrorsOutputDto;

public class ValidationErrorHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidationErrorsOutputDto handlevalidationError(MethodArgumentNotValidException exception) {
		
		List<ObjectError> globalErros = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto(); 
		
		globalErros.forEach(error -> validationErrors.addError(getErrorMessage(error)));
		
		fieldErrors.forEach(error -> {
			String errorMessage = getErrorMessage(error);
			validationErrors.addFieldError(error.getField(), errorMessage);
		});
		
		return validationErrors;
	}

	private String getErrorMessage(ObjectError error) {
		return messageSource.getMessage(error, LocaleContextHolder.getLocale());
	}
}
