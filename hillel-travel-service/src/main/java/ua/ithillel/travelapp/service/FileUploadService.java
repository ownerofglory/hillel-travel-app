package ua.ithillel.travelapp.service;

import java.io.InputStream;

public interface FileUploadService {
    String uploadFile(InputStream in, String fileName, long size, String contentType) throws Exception;
}
