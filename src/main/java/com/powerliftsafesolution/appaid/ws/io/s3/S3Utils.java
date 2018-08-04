package com.powerliftsafesolution.appaid.ws.io.s3;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class S3Utils {

    private final int VALID_TIME = 1000*60*60;

    public Date getExpirationTime(){
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += this.VALID_TIME;
        expiration.setTime(expTimeMillis);
        return expiration;
    }

    public Boolean checkIfUploadSuccessful(String objectKey, AmazonS3 s3){
        return false;
    }

}
