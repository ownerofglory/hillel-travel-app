package ua.ithillel.travelapp.service;

import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FileUploadMinIoService implements FileUploadService {
    private final MinioClient minioClient;

    @Override
    public String uploadFile(String name) throws Exception {
        BucketExistsArgs arg = BucketExistsArgs.builder().bucket("hillel-travel-images").build();
        boolean found = minioClient.bucketExists(arg);

        if (!found) {
            throw new Exception();
        }

        String fileName = "Image" + LocalDateTime.now().toLocalDate();
        UploadObjectArgs build = UploadObjectArgs.builder()
                .bucket("hillel-travel-images")
                .object(name)
                .filename(fileName)
                .build();

        minioClient.uploadObject(build);

        return "http://localhost:9000/buckets/hillel-travel-images/"
                + fileName.replace(" ", "%20");
    }
}
