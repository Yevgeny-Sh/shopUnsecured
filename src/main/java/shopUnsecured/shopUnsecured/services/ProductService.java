package shopUnsecured.shopUnsecured.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopUnsecured.shopUnsecured.models.Product;
import shopUnsecured.shopUnsecured.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products=new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getProduct(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product, int id) {
        productRepository.save(product);

    }
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
