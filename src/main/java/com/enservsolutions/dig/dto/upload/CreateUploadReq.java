package com.enservsolutions.dig.dto.upload;

import lombok.Data;

@Data
public class CreateUploadReq {
    private String tag;
    private String fileName;
    private int digId;
}
