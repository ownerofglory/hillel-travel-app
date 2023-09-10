package ua.ithillel.travelapp.service;

import ua.ithillel.travelapp.model.dto.FileUploadResultDTO;

import java.io.InputStream;

public interface FileUploadService {
    FileUploadResultDTO uploadFile(InputStream in, String fileName, long size, String contentType) throws Exception;
}
