package com.rapidtech.restapi.service.impl;

import com.rapidtech.restapi.entity.ProductEntity;
import com.rapidtech.restapi.entity.ShipperEntity;
import com.rapidtech.restapi.entity.SupplierEntity;
import com.rapidtech.restapi.model.ProductModel;
import com.rapidtech.restapi.model.ShipperModel;
import com.rapidtech.restapi.model.SupplierModel;
import com.rapidtech.restapi.repository.ProductRepo;
import com.rapidtech.restapi.repository.ShipperRepo;
import com.rapidtech.restapi.repository.SupplierRepo;
import com.rapidtech.restapi.service.ProductService;
import com.rapidtech.restapi.service.ShipperService;
import com.rapidtech.restapi.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepo repo;

    @Autowired
    public SupplierServiceImpl(SupplierRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<SupplierModel> getAll() {
        return this.repo.findAll().stream().map(SupplierModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SupplierModel> getById(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<SupplierEntity> result = this.repo.findById(id);
        /*
        if(result.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(new ProductModel(result.get()));
         */
        return result.map(SupplierModel::new);
    }

    @Override
    public Optional<SupplierModel> save(SupplierModel model) {
        if(model == null) {
            return Optional.empty();
        }
        SupplierEntity entity = new SupplierEntity(model);
        try {
            this.repo.save(entity);
            return Optional.of(new SupplierModel(entity));
        }catch (Exception e){
            log.error("Supplier save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierModel> update(Integer id, SupplierModel model) {
        if(id == 0) {
            return Optional.empty();
        }

        SupplierEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        // copy property
        BeanUtils.copyProperties(model, result);
        try {
            this.repo.save(result);
            return Optional.of(new SupplierModel(result));
        }catch (Exception e){
            log.error("Supplier update is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierModel> delete(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }

        SupplierEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        try {
            this.repo.delete(result);
            return Optional.of(new SupplierModel(result));
        }catch (Exception e){
            log.error("Supplier delete is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
