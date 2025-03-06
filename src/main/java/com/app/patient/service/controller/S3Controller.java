package com.app.patient.service.controller;

import com.app.patient.service.services.S3Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/s3")
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/bucket")
    public String createBucket() {
        s3Service.createBucket();
        return "S3 Bucket Created!";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam String filePath) {
        s3Service.uploadFile(filePath);
        return "File Uploaded Successfully!";
    }

    @GetMapping("/download")
    public String downloadFile(@RequestParam String fileName) {
        return s3Service.downloadFile(fileName);
    }
}
