package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private int id;
    private String code;
    private String name;
    private Double price;
    private Integer categoryId;
    private String categoryName;

    public ProductModel(ProductEntity entity){
        /*
        this.id = entity.getId();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.categoryId = entity.getCategoryId();*/
        BeanUtils.copyProperties(entity, this);
        if(entity.getCategory() != null) {
            this.categoryName = entity.getCategory().getName();
        }
    }

    public ProductModel(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
