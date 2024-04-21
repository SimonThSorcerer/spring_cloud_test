package com.springcloudtest.springcloudtest.repository;

import com.springcloudtest.springcloudtest.object.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
