package br.com.alura.forum.validator.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutputDto {

	private List<String> globalErroMessages = new ArrayList<>();
	
	private List<FieldErrorOutputDto> fieldErrors = new ArrayList<>();

	public ValidationErrorsOutputDto(List<String> globalErroMessages, List<FieldErrorOutputDto> fieldErrors) {
		super();
		this.globalErroMessages = globalErroMessages;
		this.fieldErrors = fieldErrors;
	}

	public ValidationErrorsOutputDto() {
	}

	public void addError(String message) {
		globalErroMessages.add(message);
	}
	
	public void addFieldError(String field, String message) {
		FieldErrorOutputDto fieldError = new FieldErrorOutputDto();
		fieldErrors.add(fieldError);
	}
	
	public List<String> getGlobalErroMessages() {
		return globalErroMessages;
	}

	public void setGlobalErroMessages(List<String> globalErroMessages) {
		this.globalErroMessages = globalErroMessages;
	}

	public List<FieldErrorOutputDto> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorOutputDto> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
}
