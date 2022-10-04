package br.com.treinographql;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Cliente2 {

	private Integer id;
	private String nome;
	private LocalDate nascimento;
	private String nomePai;
	private String nomeMae;
	private Bairro2 bairro;
	
}
