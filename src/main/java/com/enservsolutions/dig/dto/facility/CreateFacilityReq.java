package com.enservsolutions.dig.dto.facility;

import lombok.Data;

@Data
public class CreateFacilityReq {
    private String facilityName;
    private String facilityStatus;
    private String client;
}
