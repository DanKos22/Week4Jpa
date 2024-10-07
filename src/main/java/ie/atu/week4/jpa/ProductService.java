package ie.atu.week4.jpa;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> addProduct(Product product){
        productRepository.save(product);
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product product){


        for(Product existingProduct : productRepository){
            if (existingProduct.getId() == id) {
                existingProduct.setProductName(product.getProductName());
                existingProduct.setProductDescription(product.getProductDescription());
                existingProduct.setProductPrice(product.getProductPrice());
                //return ResponseEntity.ok(existingProduct);
                return existingProduct;
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        productRepository.(product);
        return productRepository.findAll();
    }
}
