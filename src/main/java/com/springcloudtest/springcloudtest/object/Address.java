package com.springcloudtest.springcloudtest.object;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "lane1")
    String lane1;

    @Column(name = "lane2")
    String lane2;

    @Column(name = "state")
    String state;

    @Column(name = "zip")
    String zip;

//    @OneToOne
//    @JoinColumn(name = "employee_address_foreignkey", referencedColumnName = "id")
//    private Employee employee;
}
