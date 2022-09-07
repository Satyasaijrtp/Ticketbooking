package com.info.inet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.inet.model.Ticket;
import com.info.inet.repository.TicketBookingDao;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;

	
	
	public Ticket getTicketById(Integer ticketId) {
		List<Ticket> tickets = ticketBookingDao.findAll();
		Ticket ticket=null;
		for(Ticket ticket1:tickets) {
			if(ticket1.getTicketId()==ticketId)
				ticket=ticket1;
		}
		return ticket;
	}

	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}

	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Ticket ticketFromDb = ticketBookingDao.findById(ticketId).get();
		ticketFromDb.setEmail(newEmail);
		Ticket upadedTicket = ticketBookingDao.save(ticketFromDb);
		return upadedTicket;
	}

	public Ticket createTicket(Ticket ticket) {

		return ticketBookingDao.save(ticket);
	}
}
