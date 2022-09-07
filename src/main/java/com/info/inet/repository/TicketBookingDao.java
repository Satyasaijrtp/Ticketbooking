package com.info.inet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.inet.model.Ticket;

public interface TicketBookingDao extends JpaRepository<Ticket, Integer> {

	

}