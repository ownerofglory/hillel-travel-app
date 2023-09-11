package ua.ithillel.travelapp.service;

import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.travelapp.config.MinioBucketInfo;
import ua.ithillel.travelapp.exception.AppException;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.FileUploadResultDTO;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class FileUploadMinIoService implements FileUploadService {
    private final MinioClient minioClient;
    private final MinioBucketInfo minioBucketInfo;

    @Override
    public FileUploadResultDTO uploadFile(InputStream in, String fileName, long size, String contentType) throws EntityNotFoundException, AppException {
        try {
            BucketExistsArgs arg = BucketExistsArgs.builder().bucket(minioBucketInfo.getBucketName()).build();

            boolean found = minioClient.bucketExists(arg);

            if (!found) {
                throw new EntityNotFoundException("Error when saving an image: bucket not found");
            }

            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(minioBucketInfo.getBucketName())
                    .object(fileName)
                    .stream(in, size, -1)
                    .contentType(contentType)
                    .build();

            ObjectWriteResponse writeResponse = minioClient.putObject(putObjectArgs);

            FileUploadResultDTO resultDTO = new FileUploadResultDTO();
            String fileUrl = String.format("%s/%s/%s", minioBucketInfo.getUrl(),
                    minioBucketInfo.getBucketName(), fileName.replace(" ", "%20"));
            resultDTO.setFileUrl(fileUrl);

            return resultDTO;

        } catch (ServerException | InternalException | XmlParserException | InvalidResponseException |
                 InvalidKeyException | NoSuchAlgorithmException | IOException | ErrorResponseException |
                 InsufficientDataException e) {
            String message = String.format("Error when saving the image %s: %s", fileName, e.getMessage());

            throw new AppException(message);
        }
    }
}
