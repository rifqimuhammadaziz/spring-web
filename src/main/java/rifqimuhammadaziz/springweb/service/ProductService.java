package rifqimuhammadaziz.springweb.service;

import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springweb.entity.Product;
import rifqimuhammadaziz.springweb.utils.RandomNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static List<Product> products = new ArrayList<Product>() {
        {
            add(new Product(RandomNumber.getRandom(1000,9999), "0001", "iPhone", 5000000.0));
            add(new Product(RandomNumber.getRandom(1000,9999), "0002", "Samsung", 5000000.0));
            add(new Product(RandomNumber.getRandom(1000,9999), "0003", "Realme", 5000000.0));
            add(new Product(RandomNumber.getRandom(1000,9999), "0004", "Xiaomi", 5000000.0));
            add(new Product(RandomNumber.getRandom(1000,9999), "0005", "Oppo", 5000000.0));
        }
    };

    public List<Product> findAll() {
        return products;
    }

    public void addProduct(Product product) {
        product.setId(RandomNumber.getRandom(1000,9999)); // create ID from current time
        products.add(product);
    }

    public Optional<Product> findById(long id) {
        return products.stream().filter(item -> item.getId() == id).findFirst();
    }

    public void updateProduct(Product product) {
        deleteById(product.getId());
        products.add(product);
    }

    public void deleteById(long id) {
        products.removeIf(item -> item.getId() == id);
    }
}
