package com.tj.rj.livro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tj.rj.livro.domain.LivrosAutoresAssuntosView;
import com.tj.rj.livro.repositories.LivrosAutoresAssuntosViewRepository;

@RestController
@RequestMapping("/livros-autores-assuntos")
@CrossOrigin(origins = "http://localhost:4200") 
public class LivrosAutoresAssuntosController {

	@Autowired
	private LivrosAutoresAssuntosViewRepository assuntosViewRepository;
	
	@GetMapping
    public ResponseEntity<List<LivrosAutoresAssuntosView>> listarLivrosAutoresAssuntos() {
        List<LivrosAutoresAssuntosView> lista = assuntosViewRepository.findAll();
        return ResponseEntity.ok().body(lista);
    }
}
