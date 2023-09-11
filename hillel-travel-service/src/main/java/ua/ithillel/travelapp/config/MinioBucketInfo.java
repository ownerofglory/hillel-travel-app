package ua.ithillel.travelapp.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MinioBucketInfo {
    private String url;
    private String bucketName;
}
