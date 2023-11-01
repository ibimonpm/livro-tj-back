package com.tj.rj.livro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tj.rj.livro.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	@Query(" SELECT l FROM Autor l JOIN l.livros a WHERE a.id = :idLivro")
	List<Autor> findAllByLivro(@Param(value = "idLivro") Long idLivro);

}
