package com.rapidtech.restapi.service.impl;

import com.rapidtech.restapi.entity.PurchaseOrderEntity;
import com.rapidtech.restapi.model.PurchaseOrderModel;
import com.rapidtech.restapi.repository.PurchaseOrderRepo;
import com.rapidtech.restapi.repository.PurchaseOrderDetailRepo;
import com.rapidtech.restapi.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private PurchaseOrderRepo orderRepo;
    private PurchaseOrderDetailRepo detailRepo;

    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepo orderRepo, PurchaseOrderDetailRepo detailRepo) {
        this.orderRepo = orderRepo;
        this.detailRepo = detailRepo;
    }

    @Override
    public Optional<PurchaseOrderModel> save(PurchaseOrderModel model) {
        if(model == null || model.getDetails().isEmpty()) {
            return Optional.empty();
        }

        PurchaseOrderEntity entity = new PurchaseOrderEntity(model);
        entity.addDetailList(model.getDetails());

        try{
            orderRepo.save(entity);
            return Optional.of(model);
        }catch (Exception e){
            log.error("Purchase Order save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
