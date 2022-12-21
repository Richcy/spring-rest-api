package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.PurchaseOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderModel {
    private int id;
    private String poCode;
    private Integer customerId;
    private Integer employeeId;
    private Integer shipperId;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date poDate;
    private Double totalAmount;

    public PurchaseOrderModel(PurchaseOrderEntity entity) {
        BeanUtils.copyProperties(entity,this);
    }
}
