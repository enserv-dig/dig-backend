package com.enservsolutions.dig.mapper;

import com.enservsolutions.dig.dto.ExcavationSafety.ExcavationSafetyReq;
import com.enservsolutions.dig.entity.ExcavationSafety;

@org.mapstruct.Mapper
public interface Mapper {
    ExcavationSafety getES(ExcavationSafetyReq ecReq);
}
