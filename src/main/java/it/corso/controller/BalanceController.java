package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.corso.model.Bilancio;
//import it.corso.model.Prodotto;
import it.corso.service.BilancioService;

//localhost:8051
@Controller
@RequestMapping("/")
public class BalanceController {
	
	
	@Autowired
	private BilancioService bilancioService;
	
	@GetMapping
	public String getPage(Model model) {
	    List<Bilancio> bilancio = bilancioService.getMovimenti();
	    model.addAttribute("bilancio", bilancio);

	    double saldo = bilancioService.estrattoConto(bilancio);
	    String messaggio;
	    if (saldo >= 0) {
	        messaggio = "Il saldo del conto è positivo: " + saldo;
	    } else {
	        messaggio = "Il saldo del conto è negativo: " + saldo;
	    }
	    model.addAttribute("estrattoConto", messaggio);

	    return "balance";
	}

	
//	@GetMapping("/cancella")
//	public String cancellaMovimento(@RequestParam(name="id") int id) {
//		Bilancio bilancio = bilancioService.getMovimentoById(id);
//		bilancioService.cancellaMovimento(bilancio);
//		return "redirect:/";
//	}
	
	@GetMapping("/cancella")
	@ResponseBody
	public String cencellaProdotto(@RequestParam(name="id") int id) {
		Bilancio bilancio = bilancioService.getMovimentoById(id);
		bilancioService.cancellaMovimento(bilancio);
		return "cancellato";
	}
	
}
