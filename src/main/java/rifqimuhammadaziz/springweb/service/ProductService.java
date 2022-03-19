package rifqimuhammadaziz.springweb.service;

import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springweb.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private static List<Product> products = new ArrayList<Product>() {
        {
            add(new Product(System.currentTimeMillis(), "0001", "iPhone", 5000000.0));
            add(new Product(System.currentTimeMillis(), "0002", "Samsung", 5000000.0));
            add(new Product(System.currentTimeMillis(), "0003", "Realme", 5000000.0));
            add(new Product(System.currentTimeMillis(), "0004", "Xiaomi", 5000000.0));
            add(new Product(System.currentTimeMillis(), "0005", "Oppo", 5000000.0));
        }
    };

    public List<Product> findAll() {
        return products;
    }

    public void addProduct(Product product) {
        product.setId(System.currentTimeMillis()); // create ID from current time
        products.add(product);
    }
}
