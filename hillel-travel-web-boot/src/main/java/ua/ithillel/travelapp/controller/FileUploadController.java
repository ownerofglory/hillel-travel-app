package ua.ithillel.travelapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.ithillel.travelapp.model.dto.FileUploadResultDTO;
import ua.ithillel.travelapp.service.FileUploadService;

@RequestMapping("/upload")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = {HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE})
public class FileUploadController {
    private final FileUploadService fileUploadService;
    @PostMapping
    public ResponseEntity<FileUploadResultDTO> uploadFile(@RequestParam("file") MultipartFile file,
                                                          @RequestParam("name") String fileName) throws Exception {

        FileUploadResultDTO uploadedFile = fileUploadService.uploadFile(file.getInputStream(), fileName, file.getSize(), file.getContentType());

        return ResponseEntity.ok(uploadedFile);
    }
}
