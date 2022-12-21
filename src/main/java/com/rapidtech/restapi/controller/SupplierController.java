package com.rapidtech.restapi.controller;

import com.rapidtech.restapi.model.ProductModel;
import com.rapidtech.restapi.model.ResponseModel;
import com.rapidtech.restapi.model.ShipperModel;
import com.rapidtech.restapi.model.SupplierModel;
import com.rapidtech.restapi.service.ProductService;
import com.rapidtech.restapi.service.ShipperService;
import com.rapidtech.restapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private SupplierService service;

    @Autowired
    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping

    public ResponseEntity<Object> get(){
        List<SupplierModel> result = service.getAll();
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id){
        Optional<SupplierModel> result = service.getById(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PostMapping()
    public ResponseEntity<Object> saveSupplier(@RequestBody SupplierModel request){
        Optional<SupplierModel> result = service.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateSupplier(@PathVariable("id") Integer id, @RequestBody SupplierModel request){
        Optional<SupplierModel> result = service.update(id, request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        Optional<SupplierModel> result = service.delete(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }
}
