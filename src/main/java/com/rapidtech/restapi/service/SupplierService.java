package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.ProductModel;
import com.rapidtech.restapi.model.ShipperModel;
import com.rapidtech.restapi.model.SupplierModel;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierModel> getAll();
    Optional<SupplierModel> getById(Integer id);
    Optional<SupplierModel> save(SupplierModel model);
    Optional<SupplierModel> update(Integer id, SupplierModel model);
    Optional<SupplierModel> delete(Integer id);
}
