package br.com.murilo.artgalley.service;

import br.com.murilo.artgalley.exceptions.ResourceNotFoundException;
import br.com.murilo.artgalley.model.Product;
import br.com.murilo.artgalley.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductService {

    private static final String PRODUCT_DOES_NOT_EXIST = "Product does not exists";

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(final Product product) {
        return this.productRepository.save(product);
    }

    public Product update(final UUID id, final Product product) {
        if(productExists(id)) {
            product.setId(id);
            return this.productRepository.save(product);
        }
        throw new ResourceNotFoundException(PRODUCT_DOES_NOT_EXIST);
    }

    public void delete(final UUID id) {
        if(productExists(id)) {
            this.productRepository.deleteById(id);
        }
        throw new ResourceNotFoundException(PRODUCT_DOES_NOT_EXIST);
    }

    public Product findById(final UUID id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(PRODUCT_DOES_NOT_EXIST));
    }

    public List<Product> findByName(final String name, final Pageable page) {
        return this.productRepository.findByName(name, page);
    }

    public List<Product> findByArtist(final String artist, final Pageable page) {
        return this.productRepository.findByArtist(artist, page);
    }

    public List<Product> findByCategory(final List<UUID> ids, final Pageable page) {
        return this.productRepository.findByCategoriesIn(ids, page);
    }

    public Page<Product> findAll(final Pageable page) {
        return this.productRepository.findAll(page);
    }

    private boolean productExists(final UUID id) {
        return this.productRepository.findById(id).isPresent();
    }
}
