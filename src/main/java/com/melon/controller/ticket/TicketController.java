package com.melon.controller.ticket;

import com.melon.dto.ticket.TicketDto;
import com.melon.service.ticket.ITicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/ticket")
@RequiredArgsConstructor
@Controller
@Slf4j
public class TicketController{

	private final ITicketService ticketService;
	
	/**
	* 할인 특가 조회
	* @author 임휘재 (2023.09.11)
	*/
	@GetMapping("/sale")
	public String ticketSale(Model model) {
		TicketDto ticket6 = ticketService.getTicketSaleOne(6);
		TicketDto ticket7 = ticketService.getTicketSaleOne(7);

		model.addAttribute("ticket6", ticket6);
		model.addAttribute("ticket7", ticket7);
		return "ticket/ticket_sale";
	}

	/**
	 * 전체 이용권 조회
	 * @author 임휘재 (2023.09.11)
	 */
	@GetMapping
	public String ticket(Model model) {
		TicketDto ticket8 = ticketService.getTicketSaleOne(8);
		TicketDto ticket9 = ticketService.getTicketSaleOne(9);

		model.addAttribute("ticket8", ticket8);
		model.addAttribute("ticket9", ticket9);
		return "ticket/ticket";
	}

}
