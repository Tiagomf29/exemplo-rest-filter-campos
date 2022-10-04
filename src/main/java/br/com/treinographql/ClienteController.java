package br.com.treinographql;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public MappingJacksonValue listarTodos(@RequestParam(required = false) String campos){
		
		// Para funcionar o processo é necessário configurar as classes de domínio com a anotação @JsonFilter
		// A partir de então toda uma lógica precisa ser implementada para que as funções funcione conforme o esperado.
		
		Cliente c1 = new Cliente(1, "Cliente 1", LocalDate.of(1985, 5, 29), "Pai cliente 1", "Mae cliente 1",new Bairro(1,"Bairro 1"));
		Cliente c2 = new Cliente(2, "Cliente 2", LocalDate.of(1980, 1, 10), "Pai cliente 2", "Mae cliente 2",new Bairro(1,"Bairro 1"));
		Cliente c3 = new Cliente(3, "Cliente 3", LocalDate.of(1983, 7, 16), "Pai cliente 3", "Mae cliente 3",new Bairro(1,"Bairro 1"));
		
		List<Cliente> lista = Arrays.asList(c1,c2,c3);
			
		MappingJacksonValue clientesWrapper =  new MappingJacksonValue(lista);
		
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		
		if(campos != null) {
			filterProvider.addFilter("clienteFilter", SimpleBeanPropertyFilter.filterOutAllExcept(campos.split(",")))
			.addFilter("bairroFilter", SimpleBeanPropertyFilter.filterOutAllExcept(campos.split(",")));
		}else {
			filterProvider.addFilter("clienteFilter", SimpleBeanPropertyFilter.serializeAll());
			filterProvider.addFilter("bairroFilter", SimpleBeanPropertyFilter.serializeAll());
		}
		
		clientesWrapper.setFilters(filterProvider);
		
		return clientesWrapper;
		
		// exemplo de url de requisição: http://localhost:8080/clientes?campos=nome,id
	}
	
	@GetMapping("/squiggly-clientes")
	public List<Cliente2> listarTodosClientes(){
		
		// Para funcionar esse processo é necessário utilizar a biblioteca Squiggly e configurar um Bean onde toda a configuração é realizado lá.
		// Neste projeto a configuração está no arquivo SquigglyConfig
		
		Cliente2 c1 = new Cliente2(1, "Cliente 1", LocalDate.of(1985, 5, 29), "Pai cliente 1", "Mae cliente 1",new Bairro2(1,"Bairro 1"));
		Cliente2 c2 = new Cliente2(2, "Cliente 2", LocalDate.of(1980, 1, 10), "Pai cliente 2", "Mae cliente 2",new Bairro2(1,"Bairro 1"));
		Cliente2 c3 = new Cliente2(3, "Cliente 3", LocalDate.of(1983, 7, 16), "Pai cliente 3", "Mae cliente 3",new Bairro2(1,"Bairro 1"));
		
		List<Cliente2> lista = Arrays.asList(c1,c2,c3);
			
		return lista;
		
		// Exemplo de url de requisição: http://localhost:8080/squiggly-clientes?fields=nome,id,nascimento,bairro.nome
		
	}
	
}
