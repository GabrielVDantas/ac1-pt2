package br.com.ac1pt2.ac1pt2;

import br.com.ac1pt2.ac1pt2.entities.Categoria;
import br.com.ac1pt2.ac1pt2.entities.Produto;
import br.com.ac1pt2.ac1pt2.repositories.CategoriaRepository;
import br.com.ac1pt2.ac1pt2.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Ac1pt2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ac1pt2Application.class, args);
	}


	@Bean
	public CommandLineRunner init(
			@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaRepository categoriaRepository
	) {
		return  args -> {
			Produto p1 = new Produto("Camisa", 30.00);
			Produto p2 = new Produto("Celular", 2500.50);
			Produto p3 = new Produto("Carro", 200.000);

			Produto pSalvo1 = produtoRepository.save(p1);
			Produto pSalvo2 = produtoRepository.save(p2);
			Produto pSalvo3 = produtoRepository.save(p3);

			Categoria c1 = new Categoria("Roupas");
			Categoria c2 = new Categoria("Eletrônicos");
			Categoria c3 = new Categoria("Automóvies");

			c1.setProdutos(List.of(pSalvo1));
			c2.setProdutos(List.of(pSalvo2));
			c3.setProdutos(List.of(pSalvo3));

			categoriaRepository.save(c1);
			categoriaRepository.save(c2);
			categoriaRepository.save(c3);

			System.out.println("CATEGORIA C1");
			System.out.println(c1);

			List<Produto> produtosCaros = produtoRepository.findByPrecoGreaterThan(20.000);
			List<Produto> produtosBaratos = produtoRepository.findByPrecoLessThanEqual(2500.50);
			List<Produto> produtosComCa = produtoRepository.findByNomeContaining("Ca");

			System.out.println("PRODUTOS CAROS");
			produtosCaros.forEach(System.out::println);
			System.out.println("PRODUTOS BARATOS");
			produtosBaratos.forEach(System.out::println);

			System.out.println("PRODUTOS COM CA");
			produtosComCa.forEach(System.out::println);

			List<Categoria> categoriasQueComecamComR = categoriaRepository.findByNomeStartingWith("R");
			Categoria produtosComDeterminadaCategoria = categoriaRepository.findByAlgumaCoisa(1L);

			System.out.println("PRODUTOS COM R");
            for (Categoria categoria : categoriasQueComecamComR) {
                System.out.println(categoria);
            }

			System.out.println("PRODUTOS COM CATEGORIA");
            System.out.println(produtosComDeterminadaCategoria);
		};
	}
}
