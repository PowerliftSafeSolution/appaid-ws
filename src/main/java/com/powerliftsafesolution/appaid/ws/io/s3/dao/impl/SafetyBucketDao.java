package com.powerliftsafesolution.appaid.ws.io.s3.dao.impl;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.powerliftsafesolution.appaid.ws.io.s3.S3Utils;
import com.powerliftsafesolution.appaid.ws.io.s3.dao.BucketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.net.URL;

@Repository
@PropertySource("classpath:awsobject-appaid-live.properties")
public class SafetyBucketDao implements BucketDao {


    @Autowired
    AmazonS3 s3;

    @Autowired
    S3Utils s3Utils;

    @Value("${s3.safetyBucket}")
    private String bucketName;

    @Override
    public URL uploadObject(String objectKey) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, objectKey)
                .withMethod(HttpMethod.PUT)
                .withExpiration(s3Utils.getExpirationTime());

        URL url = s3.generatePresignedUrl(generatePresignedUrlRequest);

        return url;
    }

    @Override
    public URL downloadObject(String objectKey) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, objectKey)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(s3Utils.getExpirationTime());

        URL url = s3.generatePresignedUrl(generatePresignedUrlRequest);

        return url;
    }
}
