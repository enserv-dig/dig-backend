package com.enservsolutions.dig.dto.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateClientRes {
    private String clientName;
    private boolean clientStatus;
}
