package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Bilancio;
import it.corso.service.BilancioService;

@Controller
@RequestMapping("/operation")
public class OperationController {
	
	@Autowired
	private BilancioService bilancioService;
	
	@GetMapping
	public String getPage(Model model, @RequestParam(name="id", required = false) Integer id) {
		Bilancio bilancio = id == null ? new Bilancio() : bilancioService.getMovimentoById(id);
		model.addAttribute("bilancio", bilancio);
		model.addAttribute("edit", id !=null);
		return "operation";
	}
	
	@PostMapping
	public String registraMovimento(@ModelAttribute("bilancio") Bilancio bilancio) {
		bilancioService.registraMovimento(bilancio);
		return "redirect:/";
	}
	
}
