package br.com.treinographql;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonFilter("clienteFilter")
@Getter @Setter
@AllArgsConstructor
public class Cliente {

	private Integer id;
	private String nome;
	private LocalDate nascimento;
	private String nomePai;
	private String nomeMae;
	private Bairro bairro;
	
}
