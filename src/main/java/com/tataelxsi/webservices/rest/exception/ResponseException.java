package com.tataelxsi.webservices.rest.exception;

import java.sql.Date;

public class ResponseException extends Exception {
	
	private Date timeStamp;
	private String message;
	private String detail;
	public ResponseException(Date timeStamp, String privmessage, String detail) {
		super();
		this.timeStamp = timeStamp;
		this.message = privmessage;
		this.detail = detail;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	

}
