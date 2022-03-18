package rifqimuhammadaziz.springweb.service;

import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springweb.entity.Product;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private static List<Product> products = Arrays.asList(
            new Product(1L, "0001", "iPhone", 5000000.0),
            new Product(2L, "0002", "Samsung", 5000000.0),
            new Product(3L, "0003", "Realme", 5000000.0),
            new Product(4L, "0004", "Xiaomi", 5000000.0),
            new Product(5L, "0005", "Oppo", 5000000.0)
    );

    public List<Product> findAll() {
        return products;
    }
}
