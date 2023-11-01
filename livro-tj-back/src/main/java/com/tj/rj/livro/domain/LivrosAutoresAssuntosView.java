package com.tj.rj.livro.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "livro_autor_assunto_view")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class LivrosAutoresAssuntosView implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long livroId;
	private String tituloLivro;
	private Long autorId;
	private String nomeAutor;
	private Long assuntoId;
	private String descricaoAssunto;
	
}
