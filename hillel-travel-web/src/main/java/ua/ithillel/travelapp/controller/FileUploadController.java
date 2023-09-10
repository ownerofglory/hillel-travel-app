package ua.ithillel.travelapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ua.ithillel.travelapp.model.dto.FileUploadResultDTO;
import ua.ithillel.travelapp.service.FileUploadService;

@RequestMapping("/upload")
@RestController
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUploadService fileUploadService;
    @PostMapping
    public ResponseEntity<FileUploadResultDTO> uploadFile(@RequestParam("file") MultipartFile file,
                                                          @RequestParam("name") String fileName) throws Exception {

        FileUploadResultDTO uploadedFile = fileUploadService.uploadFile(file.getInputStream(), fileName, file.getSize(), file.getContentType());

        return ResponseEntity.ok(uploadedFile);
    }
}
