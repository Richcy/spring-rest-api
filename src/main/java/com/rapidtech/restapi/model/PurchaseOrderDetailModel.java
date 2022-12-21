package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.PurchaseOrderDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDetailModel {
    private Integer id;
    private Integer poId;
    private Integer productId;
    private Double quantity;
    private Double price;
    private Double subAmount;

    public PurchaseOrderDetailModel(PurchaseOrderDetailEntity entity) {
        BeanUtils.copyProperties(entity,this);
    }
}
