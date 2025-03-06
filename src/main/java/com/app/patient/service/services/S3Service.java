package com.app.patient.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class S3Service {

    @Autowired
    private S3Client s3Client;

    private String bucketName = "mylearningbucket1396";
    private String downloadDirectory = "C:\\Users\\mathanpandi.p\\Documents\\Training\\s3";

    public S3Service() {
    }

    // Create an S3 Bucket
    public void createBucket() {
        CreateBucketRequest bucketRequest = CreateBucketRequest.builder()
                .bucket(bucketName)
                .build();
        s3Client.createBucket(bucketRequest);
        System.out.println("Bucket Created: " + bucketName);
    }

    // Upload a File to S3
    public void uploadFile(String filePath) {
        Path path = Paths.get(filePath);
        File file = path.toFile();

        if (!file.exists()) {
            throw new RuntimeException("File not found: " + filePath);
        }

        String fileName = file.getName(); // Extracts only the file name

        PutObjectRequest putRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName) // S3 Key (File Name)
                .build();

        s3Client.putObject(putRequest, RequestBody.fromFile(file));

        System.out.println("File Uploaded: " + filePath);
    }

    public String downloadFile(String s3FileName) {
        // Ensure the filename is exactly how it was stored in S3
        if (s3FileName == null || s3FileName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid file name.");
        }

        // Define the local path where the file will be downloaded
        Path downloadPath = Paths.get(downloadDirectory, s3FileName);

        GetObjectRequest getRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(s3FileName) // Ensure exact key
                .build();

        s3Client.getObject(getRequest, ResponseTransformer.toFile(downloadPath));

        return "File Downloaded: " + downloadPath.toAbsolutePath();
    }
}
