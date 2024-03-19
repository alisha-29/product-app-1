package service;

import entity.Product;
import exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        updatedProduct.setId(id); // Ensure ID consistency
        return productRepository.save(updatedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
