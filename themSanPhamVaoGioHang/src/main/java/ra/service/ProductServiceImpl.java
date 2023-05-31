package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Product;
import ra.repository.IProductRepository;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findAllById(Long id) {
        return productRepository.findById(id);
    }
}
