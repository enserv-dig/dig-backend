package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.upload.CreateUploadReq;
import com.enservsolutions.dig.entity.Upload;
import com.enservsolutions.dig.service.UploadService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("upload")
@CrossOrigin
@AllArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    @PostMapping
    public ResponseEntity<Upload> onUpload(@RequestBody CreateUploadReq createUploadReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(uploadService.onUploadDocument(createUploadReq));
    }

    @GetMapping
    public ResponseEntity<List<Upload>> getAllUploads() {
        return ResponseEntity.status(HttpStatus.OK).body(uploadService.getAllUploads());
    }
}
