package com.enservsolutions.dig.dto.dig;

import com.enservsolutions.dig.entity.Dig;
import com.enservsolutions.dig.entity.Paperwork;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DigWorkspaceRes {
    private Dig dig;
    private List<Paperwork> paperworks;

}
