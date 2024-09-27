package br.com.ac1pt2.ac1pt2.repositories;

import br.com.ac1pt2.ac1pt2.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByPrecoGreaterThan(Double preco);

    List<Produto> findByPrecoLessThanEqual(Double preco);

    List<Produto> findByNomeContaining(String nome);
}
