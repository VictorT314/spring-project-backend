package com.victor.springprojectbackend.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS
	private String fieldName;
	private String message;
	
	
	//CONSTRUTORES
	public FieldMessage() {
	}


	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}


	//GETTERS + SETTERS
	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
}
