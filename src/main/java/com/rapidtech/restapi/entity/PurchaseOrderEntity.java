package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "po_tab")
public class PurchaseOrderEntity {
    @Id
    @TableGenerator(name = "po_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="product_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "po_id_generator")
    private Integer id;

    @Column(name = "po_code", length = 20, nullable = false)
    private String poCode;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "shipper_id", nullable = false)
    private Integer shipperId;

    @Temporal(TemporalType.DATE)
    @Column(name = "po_date", nullable = false)
    private Date poDate;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;
}
