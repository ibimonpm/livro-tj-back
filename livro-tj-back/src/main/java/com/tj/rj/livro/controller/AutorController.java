/**
 * 
 */
package com.tj.rj.livro.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tj.rj.livro.domain.Autor;
import com.tj.rj.livro.dto.AutorDto;
import com.tj.rj.livro.service.AutorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {
	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public ResponseEntity<List<Autor>> findAll(){
		List<Autor>  obj = autorService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Autor> findById(@Valid @PathVariable Long id){
		Autor obj = autorService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/livros/{idLivro}")	
	public ResponseEntity<List<Autor>> findAllPorLivro(@Valid @PathVariable Long idLivro){
		List<Autor> lista = autorService.findAllPorLivro(idLivro);		
		return ResponseEntity.ok().body(lista); 
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Autor> adicionar(@Valid @RequestBody Autor autor) {
		
		autor = autorService.salvar(autor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(autor.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Autor> update(@PathVariable Long  id, @Valid @RequestBody AutorDto dto){
		Autor novo = autorService.update(id, dto);
		return ResponseEntity.ok().body(novo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
		autorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
