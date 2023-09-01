package br.com.alura.screenmatch30;

import br.com.alura.screenmatch30.domain.DadosEpisodio;
import br.com.alura.screenmatch30.domain.DadosSerie;
import br.com.alura.screenmatch30.service.ConsumoApi;
import br.com.alura.screenmatch30.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=885f0db5");

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

		System.out.println(dados);

		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

	}
}
