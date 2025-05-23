package com.spring.Exceptional;

public class RentalNotFound extends RuntimeException{
	private String mesg;

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

}