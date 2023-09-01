package br.com.alura.screenmatch30;

import br.com.alura.screenmatch30.domain.DadosEpisodio;
import br.com.alura.screenmatch30.domain.DadosSerie;
import br.com.alura.screenmatch30.domain.DadosTemporada;
import br.com.alura.screenmatch30.service.ConsumoApi;
import br.com.alura.screenmatch30.service.ConverteDados;
import br.com.alura.screenmatch30.service.EntradaDaSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EntradaDaSerie nomeDaSerie = new EntradaDaSerie();
		String nome = nomeDaSerie.obeterNome();

		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t="+nome+"&apikey=885f0db5");

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		json = consumoApi.obterDados("https://www.omdbapi.com/?t="+nome+"&season=1&episode=2&apikey=885f0db5");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i < dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados("https://www.omdbapi.com/?t="+nome+"&season="+i+"&apikey=885f0db5");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}

		temporadas.forEach(System.out::println);



	}
}
