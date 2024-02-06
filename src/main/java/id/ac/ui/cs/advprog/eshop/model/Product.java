package id.ac.ui.cs.advprog.eshop.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Getter @Setter

public class Product{
    private String productId;
    @NotNull
    private String productName;
    @Min(value = 0,message="Quantity must positive or cannot be alphabet")
    private int productQuantity;
    public Product(){
        this.productId = UUID.randomUUID().toString();
    }
}
