package com.info.inet.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ticket_db")
public class Ticket  {

	@Id
	@GeneratedValue
	@Column(name = "ticket_id")
	private Integer ticketId;

	@Column(name = "passenger_name", nullable = false)
	private String passengerName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	@Column(name = "booking_date")
	private Date bookingDate;

	@Column(name = "source_station")
	private String sourceStation;

	@Column(name = "dest_station")
	private String destStation;

	@Column(name = "email")
	private String email;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(Integer ticketId, String passengerName, Date bookingDate, String sourceStation, String destStation,
			String email) {
		super();
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.bookingDate = bookingDate;
		this.sourceStation = sourceStation;
		this.destStation = destStation;
		this.email = email;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestStation() {
		return destStation;
	}

	public void setDestStation(String destStation) {
		this.destStation = destStation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
