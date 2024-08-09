package org.distributornetwork.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.distributornetwork.dto.DistributorDto;
import org.distributornetwork.exception.DistributorNotFoundException;
import org.distributornetwork.repositories.DistributorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class DistributorService {
    private final DistributorRepository distributorRepository;

    @Transactional(readOnly = true)
    public DistributorDto findByDistributorCode(String distributorCode) {
        log.info("findByDistributorCode service method called");
        return distributorRepository.findByDistributorCode(distributorCode)
                .stream()
                .map(e -> DistributorDto.builder()
                        .distributorId(e.getDistributorId())
                        .distributorName(e.getDistributorName())
                        .distributorAddress(e.getDistributorAddress())
                        .distributorCode(e.getDistributorCode())
                        .contactNo(e.getContactNo())
                        .emailAddress(e.getEmailAddress())
                        .build())
                .findFirst()
                .orElseThrow(() -> new DistributorNotFoundException(distributorCode + " Not Found"));
    }

}
