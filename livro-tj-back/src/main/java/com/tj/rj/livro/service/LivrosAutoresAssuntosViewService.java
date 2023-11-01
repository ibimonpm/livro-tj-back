package com.tj.rj.livro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.rj.livro.domain.LivrosAutoresAssuntosView;
import com.tj.rj.livro.repositories.LivrosAutoresAssuntosViewRepository;

@Service
public class LivrosAutoresAssuntosViewService {
	@Autowired 
	private LivrosAutoresAssuntosViewRepository viewRepository;
	
	public List<LivrosAutoresAssuntosView> listarLivrosAutoresAssuntos() {
        return viewRepository.findAll();
    }
}
