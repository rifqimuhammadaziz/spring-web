package rifqimuhammadaziz.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springweb.entity.Product;
import rifqimuhammadaziz.springweb.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByName(String keyword) {
        return productRepository.findByNameContains(keyword);
    }
}
