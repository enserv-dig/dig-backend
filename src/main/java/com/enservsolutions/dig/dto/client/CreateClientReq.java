package com.enservsolutions.dig.dto.client;

import lombok.Data;

@Data
public class CreateClientReq {
    private String clientName;
    private String clientActive;
}
