package com.enservsolutions.dig.service;

import com.enservsolutions.dig.entity.Paperwork;
import com.enservsolutions.dig.entity.PaperworkType;
import com.enservsolutions.dig.repository.PaperworkRepository;
import com.enservsolutions.dig.repository.PaperworkTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaperworkTypeService {
    private final PaperworkTypeRepository paperworkTypeRepository;

    public List<PaperworkType> getAllPaperworkType() {
        return (List<PaperworkType>) this.paperworkTypeRepository.findAll();
    }
}
