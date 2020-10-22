package com.enservsolutions.dig.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckUsername {
    private String username;
    private String message;
}
