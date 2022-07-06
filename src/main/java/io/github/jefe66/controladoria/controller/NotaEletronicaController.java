package io.github.jefe66.controladoria.controller;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jefe66.controladoria.model.entity.NotaEletronica;

@RestController
@RequestMapping("/api/nfe")
public class NotaEletronicaController {
	
	@PostMapping
	public NotaEletronica nfeStt(String status, String estado, Date data) {
		try {
			Document doc = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx/").get();
			Elements estados = doc.getElementById("conteudoDinamico").getElementsByTag("th");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		NotaEletronica nfe = new NotaEletronica(status, estado, data);
		
		return nfe;
	}

}
