package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        product.setProductId(UUID.randomUUID().toString());
        productData.add(product);
        return  product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public void delete(String productId){
        productData.removeIf(product -> product.getProductId().equals(productId));
    }

    public Product get(String productId){
        for (Product product:productData){
            if(product.getProductId().equals(productId)){
                return product;
            }
        }
    }

    public void update(Product productUpdate){
       for (Product product:productData){
           if(product.getProductId().equals(productUpdate.getProductId())){
               product.setProductName(productUpdate.getProductName());
               product.setProductQuantity(productUpdate.getProductQuantity());
           }
       }
    }
}