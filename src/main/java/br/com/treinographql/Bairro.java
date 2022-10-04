package br.com.treinographql;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonFilter("bairroFilter")
@Getter @Setter
@AllArgsConstructor
public class Bairro {
	
	private Integer id;
	private String nome;

}
