package com.springcloudtest.springcloudtest.controller;

import com.springcloudtest.springcloudtest.dto.EmployeeDto;
import com.springcloudtest.springcloudtest.service.EmployeeServiceExternalRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeControllerExternalRestTemplate {


    @Autowired
    EmployeeServiceExternalRestTemplate employeeServiceExternalRestTemplate;

    @GetMapping("/getemployeeinfo/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeDtoFromAnotherMicroservice(@PathVariable("id") int id) {

        return employeeServiceExternalRestTemplate.getResponseEntityEmployeeDtoFromAnotherMicroServiceUsingRestTemplate(id);
    }

    @GetMapping("/getemployeeinfowithwebclient/{id}")
    public ResponseEntity<Mono<EmployeeDto>> getEmployeeDtoFromAnotherMicroserviceWithWebClient(@PathVariable("id") int id) {

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeServiceExternalRestTemplate.getResponseEntityEmployeeDtoFromAnotherMicroServiceUsingWebClient(id));
    }

//    @GetMapping("/employeesfeign/{id}")
//    public ResponseEntity<Mono<EmployeeDto>> getEmployeeDtoFromAnotherMicroserviceWithFeignClient(@PathVariable("id") int id) {
//
//    }
    @GetMapping("/employeesfeign/{id}")
    public Mono<EmployeeDto> getEmployeeDtoFromAnotherMicroserviceWithFeignClient(@PathVariable("id") int id) {
//        Mono<EmployeeDto> employeeDtoMono = employeeServiceExternalRestTemplate.getMonoEmployeeDtoFromAnotherMicroServiceUsingFeign(id);
//        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDtoMono);
        return employeeServiceExternalRestTemplate.getMonoEmployeeDtoFromAnotherMicroServiceUsingFeign(id);

    }

}
