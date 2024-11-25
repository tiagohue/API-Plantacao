package com.tiago.apiplantacao;

import com.tiago.apiplantacao.model.*;
import com.tiago.apiplantacao.repository.CanteiroRepository;
import com.tiago.apiplantacao.repository.InsumoRepository;
import com.tiago.apiplantacao.repository.PlantaRepository;
import com.tiago.apiplantacao.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiPlantacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPlantacaoApplication.class, args);
	}

	@Bean
	CommandLineRunner popularBanco(@Autowired ResponsavelRepository responsavelRepository,
								   @Autowired CanteiroRepository canteiroRepository,
								   @Autowired InsumoRepository insumoRepository,
								   @Autowired PlantaRepository plantaRepository) {
		return args -> {
			//Adicionando 3 de cada entidade pelo código:
			//Responsavel:
			Responsavel resTiago = responsavelRepository.save(new Responsavel("Tiago"));
			Responsavel resHelena = responsavelRepository.save(new Responsavel("Dona Helena"));
			Responsavel resDomigos = responsavelRepository.save(new Responsavel("Seu Domingos"));

			//Canteiro:
			Canteiro canteiro1 = canteiroRepository.save(new Canteiro(5.0 , resTiago));
			Canteiro canteiro2 = canteiroRepository.save(new Canteiro(12.0 , resDomigos));
			Canteiro canteiro3 = canteiroRepository.save(new Canteiro(8.0 , resHelena));

			//Insumo:
			Insumo insumo1 = insumoRepository.save(new Insumo("Estrume -> cocô de vaca."));
			Insumo insumo2 = insumoRepository.save(new Insumo("Casca de ovo -> em pó, facilita a absorcao pelas plantas."));
			Insumo insumo3 = insumoRepository.save(new Insumo("Cinzas -> ricas em minerais e nutrientes."));

			//Planta:
			Planta planta1 = plantaRepository.save(new Planta("Alface", 75));
			Planta planta2 = plantaRepository.save(new Planta("Abóbora", 105));
			Planta planta3 = plantaRepository.save(new Planta("Batata Doce", 105));

			//Adicionando 3 de cada relacionamento:
			//recuperando os canteiros:
			canteiro1 = canteiroRepository.findById(canteiro1.getId()).get();
			canteiro2 = canteiroRepository.findById(canteiro2.getId()).get();
			canteiro3 = canteiroRepository.findById(canteiro3.getId()).get();

			//Plantado:
			canteiro1.getPlantas().add(planta2);
			canteiro2.getPlantas().add(planta3);
			canteiro3.getPlantas().add(planta1);

			//Aplicado:
			canteiro1.getInsumos().add(insumo3);
			canteiro2.getInsumos().add(insumo1);
			canteiro3.getInsumos().add(insumo2);

			//Salvando:
			canteiroRepository.save(canteiro1);
			canteiroRepository.save(canteiro2);
			canteiroRepository.save(canteiro3);
		};
	}
}