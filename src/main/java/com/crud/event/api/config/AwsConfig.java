package com.crud.event.api.config;


import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Configurable
public class AwsConfig {


    @Value("${aws.region}")
    private String region;


    @Bean
    public AmazonS3 createS3Instance() {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(region)
                .build();
    }

}
