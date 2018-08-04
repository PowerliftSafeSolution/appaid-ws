package com.powerliftsafesolution.appaid.ws.io.s3.dao;

import java.net.URL;

public interface BucketDao {

    URL uploadObject(String objectKey);
    URL downloadObject(String objectKey);
}
