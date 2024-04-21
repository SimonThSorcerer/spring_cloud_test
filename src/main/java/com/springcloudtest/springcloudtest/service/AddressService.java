package com.springcloudtest.springcloudtest.service;

import com.springcloudtest.springcloudtest.dto.AddressDto;
import com.springcloudtest.springcloudtest.object.Address;
import com.springcloudtest.springcloudtest.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    RestTemplate restTemplate;

    public AddressDto getAddressById(int id) {
        Address address = addressRepository.findById(id).orElse(null);
        return addressToAddressDtoMapper(address);
    }

    public ResponseEntity<AddressDto> getAddressByIdUsingRestTemplate(int id) {
        AddressDto addressdto = addressToAddressDtoMapper(addressRepository.findById(id).orElse(null));
        return ResponseEntity.status(HttpStatus.CREATED).body(addressdto);
    }


    public AddressDto addressToAddressDtoMapper(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }
}
