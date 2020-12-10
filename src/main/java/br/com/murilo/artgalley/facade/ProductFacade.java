package br.com.murilo.artgalley.facade;

import br.com.murilo.artgalley.dto.request.ProductRequest;
import br.com.murilo.artgalley.dto.response.DetailedProduct;
import br.com.murilo.artgalley.dto.response.SimplifiedProduct;
import br.com.murilo.artgalley.model.Product;
import br.com.murilo.artgalley.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProductFacade {

    private final ProductService productService;
    private final ConversionService conversionService;

    @Autowired
    public ProductFacade(final ProductService productService, final ConversionService conversionService) {
        this.productService = productService;
        this.conversionService = conversionService;
    }


    public DetailedProduct save (final ProductRequest productRequest) {
        final var product = this.conversionService.convert(productRequest, Product.class);
        final var savedProduct = this.productService.save(product);
        return this.conversionService.convert(savedProduct, DetailedProduct.class);
    }

    public DetailedProduct update(final UUID id, final ProductRequest productRequest) {
        final var product = this.conversionService.convert(productRequest, Product.class);
        final var updatedProduct = this.productService.update(id, product);
        return this.conversionService.convert(updatedProduct, DetailedProduct.class);
    }

    public void delete(final UUID id) {
        this.productService.delete(id);
    }

    public DetailedProduct findById(final UUID id) {
        final var product = this.productService.findById(id);
        return this.conversionService.convert(product, DetailedProduct.class);
    }

    public List<SimplifiedProduct> findByName(final String name, Pageable page) {
        final var products = this.productService.findByName(name, page);
        return products.stream().map(product -> this.conversionService.convert(product, SimplifiedProduct.class)).collect(Collectors.toList());
    }

    public List<SimplifiedProduct> findByArtist(final String artist, Pageable page) {
        final var products = this.productService.findByArtist(artist, page);
        return products.stream().map(product -> this.conversionService.convert(product, SimplifiedProduct.class)).collect(Collectors.toList());
    }

    public List<SimplifiedProduct> findByCategory(final List<UUID> categoryIds, Pageable page) {
        final var products = this.productService.findByCategory(categoryIds, page);
        return products.stream().map(product -> this.conversionService.convert(product, SimplifiedProduct.class)).collect(Collectors.toList());
    }

    public Page<SimplifiedProduct> findAll(Pageable page) {
        final var products = this.productService.findAll(page);
        return products.map(product -> this.conversionService.convert(product, SimplifiedProduct.class));
    }
}
