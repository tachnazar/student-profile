package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import se331.lab.rest.service.AmazonClient;

@Controller
public class BucketController {
    @Autowired
    private AmazonClient amazonClient;


    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return ResponseEntity.ok(this.amazonClient.uploadFile(file));
    }

    @DeleteMapping("/deleteFile")
    public ResponseEntity<?> deleteFile(@RequestPart(value = "url") String fileUrl) {
        return ResponseEntity.ok(this.amazonClient.deleteFileFromS3Bucket(fileUrl));
    }
}
