package com.enservsolutions.dig.service;

import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.entity.Company;
import com.enservsolutions.dig.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

}
