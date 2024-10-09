package ie.atu.week4.jpa;


import jakarta.validation.constraints.Null;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    private List<Product> productList = new ArrayList<>();

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> addProduct(Product product){
        productRepository.save(product);
        return productRepository.findAll();
    }

    private Product findProductById(Long id) {
        for (Product product : productList) {
            if (product.getProductCode() == id) {
                return product;
            }
        }
        return null;
    }

    public Product updateProduct(Long id, Product product){
        /*Product existingProduct = productRepository.findById(id);

            if (existingProduct.getId() == id) {
                existingProduct.setProductName(product.getProductName());
                existingProduct.setProductDescription(product.getProductDescription());
                existingProduct.setProductPrice(product.getProductPrice());
                //return ResponseEntity.ok(existingProduct);
                return existingProduct;
            }*/

        /*productRepository.(product);
        return productRepository.findAll();*/
        return product;
    }

    public List<Product> deleteProduct(Long id){
        Product existingProduct = findProductById(id);

        if(existingProduct != null){
            productRepository.delete(existingProduct);

        }
        //productRepository.delete(product);
        return productRepository.findAll();

    }

}
