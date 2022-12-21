package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.ProductModel;
import com.rapidtech.restapi.model.ShipperModel;

import java.util.List;
import java.util.Optional;

public interface ShipperService {
    List<ShipperModel> getAll();
    Optional<ShipperModel> getById(Integer id);
    Optional<ShipperModel> save(ShipperModel model);
    Optional<ShipperModel> update(Integer id, ShipperModel model);
    Optional<ShipperModel> delete(Integer id);
}
