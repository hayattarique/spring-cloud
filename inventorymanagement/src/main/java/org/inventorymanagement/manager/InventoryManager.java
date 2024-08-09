package org.inventorymanagement.manager;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "manager")
public class InventoryManager {
    private String managerName;
    private String address;
    private String phoneNumber;

}
