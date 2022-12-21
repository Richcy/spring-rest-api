package com.rapidtech.restapi.service.impl;

import com.rapidtech.restapi.entity.ProductEntity;
import com.rapidtech.restapi.entity.ShipperEntity;
import com.rapidtech.restapi.model.ProductModel;
import com.rapidtech.restapi.model.ShipperModel;
import com.rapidtech.restapi.repository.ProductRepo;
import com.rapidtech.restapi.repository.ShipperRepo;
import com.rapidtech.restapi.service.ProductService;
import com.rapidtech.restapi.service.ShipperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ShipperServiceImpl implements ShipperService {
    private ShipperRepo repo;

    @Autowired
    public ShipperServiceImpl(ShipperRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<ShipperModel> getAll() {
        return this.repo.findAll().stream().map(ShipperModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ShipperModel> getById(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<ShipperEntity> result = this.repo.findById(id);
        /*
        if(result.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(new ProductModel(result.get()));
         */
        return result.map(ShipperModel::new);
    }

    @Override
    public Optional<ShipperModel> save(ShipperModel model) {
        if(model == null) {
            return Optional.empty();
        }
        ShipperEntity entity = new ShipperEntity(model);
        try {
            this.repo.save(entity);
            return Optional.of(new ShipperModel(entity));
        }catch (Exception e){
            log.error("Shipper save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ShipperModel> update(Integer id, ShipperModel model) {
        if(id == 0) {
            return Optional.empty();
        }

        ShipperEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        // copy property
        BeanUtils.copyProperties(model, result);
        try {
            this.repo.save(result);
            return Optional.of(new ShipperModel(result));
        }catch (Exception e){
            log.error("Shipper update is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ShipperModel> delete(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }

        ShipperEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        try {
            this.repo.delete(result);
            return Optional.of(new ShipperModel(result));
        }catch (Exception e){
            log.error("Shipper delete is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
