package com.info.inet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.info.inet.model.Ticket;
import com.info.inet.repository.TicketBookingDao;
import com.info.inet.service.TicketBookingService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { TicketServiceTest.class })

public class TicketServiceTest {

	@InjectMocks
	private TicketBookingService bookingService;

	@Mock
	private TicketBookingDao bookingDao;

	@Test
	@Order(1)
	public void saveTicket() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("satyasai");
		ticket.setSourceStation("hyd");
		ticket.setDestStation("ongole");
		ticket.setBookingDate(new Date());
		ticket.setEmail("sai@gmail.com");

		when(bookingDao.save(ticket)).thenReturn(ticket);
		assertEquals(ticket, bookingService.createTicket(ticket));
	}

	@Test
	@Order(2)
	public void getAllTickets() {

		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("satyasai");
		ticket.setSourceStation("hyd");
		ticket.setDestStation("ongole");
		ticket.setBookingDate(new Date());
		ticket.setEmail("sai@gmail.com");

		Ticket ticke2 = new Ticket();
		ticke2.setTicketId(2);
		ticke2.setPassengerName("satyasai");
		ticke2.setSourceStation("hyd");
		ticke2.setDestStation("ongole");
		ticke2.setBookingDate(new Date());
		ticke2.setEmail("sai@gmail.com");
		tickets.add(ticket);
		tickets.add(ticke2);

		when(bookingDao.findAll()).thenReturn(tickets);
		assertEquals(2, ((List<Ticket>) bookingService.getAllBookedTickets()).size());

	}

	@Test
	@Order(3)
	public void getTicketByIdTest() {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("satyasai");
		ticket.setSourceStation("hyd");
		ticket.setDestStation("ongole");
		ticket.setBookingDate(new Date());
		ticket.setEmail("sai@gmail.com");

		Ticket ticke2 = new Ticket();
		ticke2.setTicketId(2);
		ticke2.setPassengerName("satyasai");
		ticke2.setSourceStation("hyd");
		ticke2.setDestStation("ongole");
		ticke2.setBookingDate(new Date());
		ticke2.setEmail("sai@gmail.com");
		tickets.add(ticket);
		tickets.add(ticke2);

		int ticketId = 2;
		when(bookingDao.findAll()).thenReturn(tickets);
		Ticket ticketById = bookingService.getTicketById(ticketId);
		assertEquals(ticketId, ticketById.getTicketId());

	}

	@Test
	@Order(4)
	public void deleteTicket() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("satyasai");
		ticket.setSourceStation("hyd");
		ticket.setDestStation("ongole");
		ticket.setBookingDate(new Date());
		ticket.setEmail("sai@gmail.com");
		bookingService.deleteTicket(ticket.getTicketId());
		verify(bookingDao,times(1)).deleteById(ticket.getTicketId());
	
		


	}

}
