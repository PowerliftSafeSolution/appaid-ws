package com.powerliftsafesolution.appaid.ws.io.s3;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class s3Config {

    @Value("{s3.clientRegion}")
    private String clientRegion;
    @Value("{s3.bucketName}")
    private String bucketName;

    @Bean
    public AmazonS3 getS3Client(){
        try{
            AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new ProfileCredentialsProvider())
                            .withRegion(clientRegion).build();
            return s3;
        }catch(AmazonServiceException e) {
            e.printStackTrace();
        }

        return null;
    }
}
