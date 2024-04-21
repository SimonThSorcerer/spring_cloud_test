package com.springcloudtest.springcloudtest.service;

import com.springcloudtest.springcloudtest.dto.EmployeeDto;
import com.springcloudtest.springcloudtest.feigncliebt.AddressExternalFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceExternalRestTemplate {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    WebClient webClient;
    @Autowired
    AddressExternalFeignClient addressExternalFeignClient;

    public ResponseEntity<EmployeeDto> getResponseEntityEmployeeDtoFromAnotherMicroServiceUsingRestTemplate(int id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restTemplate.getForObject("http://localhost:8080/employee-app/api/employees/{id}", EmployeeDto.class, id));
    }

    public Mono<EmployeeDto> getResponseEntityEmployeeDtoFromAnotherMicroServiceUsingWebClient(int id) {
        return webClient.get()
                .uri("api/employees/{id}", id)
                .retrieve()
                .bodyToMono(EmployeeDto.class);
    }


    public EmployeeDto getMonoEmployeeDtoFromAnotherMicroServiceUsingFeign(int id) {
        return addressExternalFeignClient.getEmployeeDtoFromAnotherMicroserviceUsingFeignClient(id);
    }
}
