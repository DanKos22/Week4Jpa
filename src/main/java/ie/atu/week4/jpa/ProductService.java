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

    public List<Product> updateProduct(Long id, Product product){
        //Product existingProduct = productRepository.findById(id);


       // if(existingProduct.e)
        if(productRepository.existsById(id)){
            product.setId(id);
            /*product.setProductName(product.getProductName());
            existingProduct.setProductDescription(product.getProductDescription());
            existingProduct.setProductPrice(product.getProductPrice());
            existingProduct.setProductCode(product.getProductCode());*/
            productRepository.save(product);
        }

            /*if (existingProduct.getId() == id) {
                existingProduct.setProductName(product.getProductName());
                existingProduct.setProductDescription(product.getProductDescription());
                existingProduct.setProductPrice(product.getProductPrice());
                //return ResponseEntity.ok(existingProduct);
                return existingProduct;
            }*/

        /*productRepository.(product);
        return productRepository.findAll();*/
        return productRepository.findAll();
    }

    public List<Product> deleteProduct(Long id){
        //Product existingProduct = productRepository.findProductById(id);

        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
        /*if(existingProduct.getId() == id){
            productRepository.delete(existingProduct);

        }*/
        //productRepository.delete(product);
        return productRepository.findAll();

    }

}
