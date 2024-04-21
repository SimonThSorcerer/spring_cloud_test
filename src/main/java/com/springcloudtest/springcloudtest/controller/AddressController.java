package com.springcloudtest.springcloudtest.controller;

import com.springcloudtest.springcloudtest.dto.AddressDto;
import com.springcloudtest.springcloudtest.object.Address;
import com.springcloudtest.springcloudtest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDto> getAddressByEmployeeId(@PathVariable("id") int id) {
        return status(HttpStatus.OK).body(addressService.getAddressById(id));
    }

//    @GetMapping("/address/{empid}")
//    public ResponseEntity<AddressDto> getAddressByEmployeeId(@PathVariable("empid") int empId) {
//
//        return status(HttpStatus.OK).body();
//    }
}
