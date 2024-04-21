package com.springcloudtest.springcloudtest.feigncliebt;

import com.springcloudtest.springcloudtest.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient (name = "addressFeignClient", url = "http://localhost:8080/employee-app/api/")
public interface AddressExternalFeignClient {

    @GetMapping("employees/{id}")
    EmployeeDto getEmployeeDtoFromAnotherMicroserviceUsingFeignClient(@PathVariable("id") int id);
}
