package ra.service;

import ra.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findAllById(Long id);
}
