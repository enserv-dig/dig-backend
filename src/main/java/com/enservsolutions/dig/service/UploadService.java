package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.upload.CreateUploadReq;
import com.enservsolutions.dig.entity.Dig;
import com.enservsolutions.dig.entity.Upload;
import com.enservsolutions.dig.repository.DigRepository;
import com.enservsolutions.dig.repository.UploadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UploadService {
    private final DigRepository digRepository;
    private final UploadRepository uploadRepository;

    public Upload onUploadDocument(CreateUploadReq createUploadReq) {
        Dig dig = digRepository.findById(createUploadReq.getDigId()).get();
        Upload upload = null;
        if(dig != null) {
            upload = new Upload();
            upload.setDig(dig);
            upload.setFileName(createUploadReq.getFileName());
            upload.setTag(createUploadReq.getTag());

            uploadRepository.save(upload);
        }
        return upload;
    }

    public List<Upload> getAllUploads() {
        return (List<Upload>) this.uploadRepository.findAll();
    }
}
