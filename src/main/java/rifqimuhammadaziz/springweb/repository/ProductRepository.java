package rifqimuhammadaziz.springweb.repository;

import org.springframework.data.repository.CrudRepository;
import rifqimuhammadaziz.springweb.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameContains(String keyword);
}
