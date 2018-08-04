package com.powerliftsafesolution.appaid.ws.io.s3.config;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:awsobject-appaid-live.properties")
public class s3Config {

    @Value("${s3.clientRegion}")
    private String clientRegion;

    public s3Config(){

    }

    @Bean
    public AmazonS3 getS3Client(){
        try{
            AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                            .withRegion(clientRegion)
                            .withCredentials(InstanceProfileCredentialsProvider.getInstance())
                            .build();
            return s3;
        }catch(AmazonServiceException e) {
            e.printStackTrace();
        }

        return null;
    }
}
