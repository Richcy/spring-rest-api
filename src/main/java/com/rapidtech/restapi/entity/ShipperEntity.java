package com.rapidtech.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "shipper_tab")
public class ShipperEntity {
    @Id
    @TableGenerator(name = "shipper_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="customer_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "shipper_id_generator")
    private Long id;

    @Column(name = "shipper_name", length = 100, nullable = false)
    private String shipperName;
    @Column(name = "phone", length = 20)
    private String phone;
}
