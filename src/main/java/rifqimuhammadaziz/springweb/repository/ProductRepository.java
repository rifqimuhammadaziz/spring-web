package rifqimuhammadaziz.springweb.repository;

import org.springframework.data.repository.CrudRepository;
import rifqimuhammadaziz.springweb.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
