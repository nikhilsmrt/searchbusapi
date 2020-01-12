package com.altimetrik.bus.search.bean;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class BusSearchInputParameter {
	@NotNull(message = "Souce City is Required")
	private String sourceCity;
	@NotNull(message = "Destination City is Required")
	private String destCity;
	@NotNull(message = "Date of Journey is Required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJourney;
public BusSearchInputParameter() {
	
}
	public BusSearchInputParameter(String sourceCity, String destCity, LocalDate dateOfJourney) {
		this.sourceCity = sourceCity;
		this.destCity = destCity;
		this.dateOfJourney = dateOfJourney;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestCity() {
		return destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

}
