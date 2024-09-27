package br.com.ac1pt2.ac1pt2.repositories;

import br.com.ac1pt2.ac1pt2.entities.Categoria;
import br.com.ac1pt2.ac1pt2.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNomeStartingWith(String nome);

    @Query("""
    SELECT c FROM categorias c
    LEFT JOIN FETCH c.produtos
    WHERE c.id = :id
    """)
    Categoria findByAlgumaCoisa(Long id);

}
