package com.example.gerenciadordecarros.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.gerenciadordecarros.domain.Acessorio;
import com.example.gerenciadordecarros.domain.Carro;
import com.example.gerenciadordecarros.service.AcessorioService;
import com.example.gerenciadordecarros.service.CarroService;
import com.example.gerenciadordecarros.service.ChaveService;
import com.example.gerenciadordecarros.service.DocumentoService;
import com.example.gerenciadordecarros.service.FabricanteService;


@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private AcessorioService acessorioService;	
	
	@Autowired
	private DocumentoService documentoService;
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@Autowired
	private ChaveService chaveService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Acessorio acessorio1 = new Acessorio();
		acessorio1.setNome("Vidro-elétrico");		
		Acessorio acessorio2 = new Acessorio();
		acessorio2.setNome("Ar-condicionado");		
		Acessorio acessorio3 = new Acessorio();
		acessorio3.setNome("Painel solar");
		Acessorio acessorio4 = new Acessorio();
		acessorio4.setNome("Câmera traseira");
		Acessorio acessorio5 = new Acessorio();
		acessorio5.setNome("Piloto automático");
		
		List<Acessorio> listaAcessorios1 = new ArrayList();
		listaAcessorios1.add(acessorio5);
		listaAcessorios1.add(acessorio3);
		listaAcessorios1.add(acessorio4);

		List<Acessorio> listaAcessorios2 = new ArrayList();
		listaAcessorios2.add(acessorio5);
		listaAcessorios2.add(acessorio1);
		listaAcessorios2.add(acessorio2);
		
		List<Acessorio> listaAcessorios3 = new ArrayList();
		listaAcessorios3.add(acessorio1);
		listaAcessorios3.add(acessorio2);
		listaAcessorios3.add(acessorio5);
		
		
		
	}
}
