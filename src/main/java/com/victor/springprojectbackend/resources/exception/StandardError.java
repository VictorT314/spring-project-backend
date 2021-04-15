package com.victor.springprojectbackend.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS
	private Integer status;
	private String msg;
	private Long timeStamp;
	
	
	//CONSTRUTORES
	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	
	//GETTERS + SETTERS
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

	
}
