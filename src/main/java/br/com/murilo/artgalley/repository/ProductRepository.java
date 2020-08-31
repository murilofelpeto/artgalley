package br.com.murilo.artgalley.repository;

import br.com.murilo.artgalley.model.Category;
import br.com.murilo.artgalley.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByName(String name, Pageable page);
    List<Product> findByArtist(String artist, Pageable page);
    List<Product> findByCategoriesIn(List<UUID> categoryID, Pageable page);
}
