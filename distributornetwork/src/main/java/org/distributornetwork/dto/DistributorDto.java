package org.distributornetwork.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DistributorDto {
    private Integer distributorId;
    private String distributorCode;
    private String distributorName;
    private String distributorAddress;
    private String contactNo;
    private String emailAddress;
}
