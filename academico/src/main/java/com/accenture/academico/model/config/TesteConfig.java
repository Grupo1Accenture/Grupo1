package com.accenture.academico.model.config;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.accenture.academico.model.entities.Agencia;
import com.accenture.academico.model.entities.Cliente;
import com.accenture.academico.model.entities.ContaCorrente;
import com.accenture.academico.model.repositories.AgenciaRepository;
import com.accenture.academico.model.repositories.ClienteRepository;
import com.accenture.academico.model.repositories.ContaCorrenteRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private AgenciaRepository agenciaReposiroty;
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente1 = new Cliente(null, "Claudemir", "888.888.888-88", "988888888");
		Cliente cliente2 = new Cliente(null, "Adson", "777.777.777-77", "977777777"); 
		
		Agencia agencia1 = new Agencia(null, "Itau", "Rua chego lá", "81-955555555", cliente1);
		Agencia agencia2 = new Agencia(null, "Santander", "Rua bora lá", "81-944444444", cliente2);
		Agencia agencia3 = new Agencia(null,  "Banco Brasil", "Rua vamos lá", "81-933333333", cliente1);
		
		ContaCorrente conta1 = new ContaCorrente(null, "5555-5", 1000.00, cliente1);
		ContaCorrente conta2 = new ContaCorrente(null, "33333-3", 100.00, cliente2);
		ContaCorrente conta3 = new ContaCorrente(null, "44444-4", 500.00, cliente1);
		
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
		agenciaReposiroty.saveAll(Arrays.asList(agencia1, agencia2, agencia3));
		contaCorrenteRepository.saveAll(Arrays.asList(conta1, conta2, conta3));
	}
}
