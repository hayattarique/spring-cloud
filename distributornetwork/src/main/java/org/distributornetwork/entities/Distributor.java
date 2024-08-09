package org.distributornetwork.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "distributors")
@Data
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distributor_id")
    private Integer distributorId;
    @Column(name = "distributor_code")
    private String distributorCode;
    @Column(name = "distributor_nm")
    private String distributorName;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "distributor_address")
    private String distributorAddress;
}
