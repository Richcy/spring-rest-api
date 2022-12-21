package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.CustomerModel;
import com.rapidtech.restapi.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeModel> getAll();
    Optional<EmployeeModel> getById(Integer id);
    Optional<EmployeeModel> save(EmployeeModel model);
    Optional<EmployeeModel> update(Integer id, EmployeeModel model);
    Optional<EmployeeModel> delete(Integer id);
}
