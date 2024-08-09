package org.distributornetwork.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.distributornetwork.dto.DistributorDto;
import org.distributornetwork.exception.DistributorNotFoundException;
import org.distributornetwork.service.DistributorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/distributor")
@Log4j2
public class DistributorController {
    private final DistributorService distributorService;

    @GetMapping("/{distributorCode}")
    public ResponseEntity<DistributorDto> getDistributors(@PathVariable String distributorCode) {
        log.info("get distributor handler method called{} ", distributorCode);
        return new ResponseEntity<>(distributorService.findByDistributorCode(distributorCode), HttpStatus.OK);
    }

    @ExceptionHandler(DistributorNotFoundException.class)
    public ResponseEntity<String> handleDistributorException(DistributorNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
