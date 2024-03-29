package com.example.gerenciadordecarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gerenciadordecarros.domain.Carro;
import com.example.gerenciadordecarros.service.AcessorioService;
import com.example.gerenciadordecarros.service.CarroService;
import com.example.gerenciadordecarros.service.ChaveService;
import com.example.gerenciadordecarros.service.DocumentoService;
import com.example.gerenciadordecarros.service.FabricanteService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("carros")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@Autowired
	private AcessorioService acessosioService;

	@Autowired
	private FabricanteService fabricanteService;

	@Autowired
	private ChaveService chaveService;
	
	@Autowired
	private DocumentoService documentoService;

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("carros/listar");
		mv.addObject("carros", carroService.findAll());
		mv.addObject("acessorios", acessosioService.findAll());
		mv.addObject("documentos", documentoService.findAll());
		mv.addObject("chaves", chaveService.findAll());
		mv.addObject("fabricantes", fabricanteService.findAll());
		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("carros/cadastrar");
		mv.addObject("carro", new Carro());
		mv.addObject("acessorios", acessosioService.findAll());
		mv.addObject("documentos", documentoService.findAll());
		mv.addObject("chaves", chaveService.findAll());
		mv.addObject("fabricantes", fabricanteService.findAll());
		return mv;
	}

	@PostMapping("/salvar")
	public String salvar(Carro carro) {
		carroService.save(carro);
		return "redirect:/carros/listar";
	}

	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") int id) {
		carroService.delete(id);
		return "redirect:/carros/listar";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("carros/editar");
		mv.addObject("carro", carroService.findOne(id));
		mv.addObject("acessorios", acessosioService.findAll());
		mv.addObject("documentos", documentoService.findAll());
		mv.addObject("chaves", chaveService.findAll());
		mv.addObject("fabricantes", fabricanteService.findAll());
		return mv;
	}

	@PostMapping("/atualizar")
	public String atualizar(Carro carro) throws ObjectNotFoundException {
		carroService.update(carro);
		return "redirect:/carros/listar";
	}

}
