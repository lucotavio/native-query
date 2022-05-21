package br.com.luciano.nativequery;

import br.com.luciano.nativequery.entity.Socio;
import br.com.luciano.nativequery.repository.DependenteRepository;
import br.com.luciano.nativequery.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private SocioRepository socioRepository;

	@Autowired
	private DependenteRepository dependenteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		//socioRepository.listarTodos().forEach(System.out::println);
		dependenteRepository.listarTodos().forEach(System.out::println);

	}
}
