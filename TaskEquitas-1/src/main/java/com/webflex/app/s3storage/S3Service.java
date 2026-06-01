package com.webflex.app.s3storage;
import java.net.URI;
import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
@Service
public class S3Service {

	private final S3Client s3Client;
    private final S3Presigner presigner;
    
    private final String bucket = "my-bucket";

    public S3Service(S3Client s3Client, S3Presigner presigner) {
        this.s3Client = s3Client;
        this.presigner = presigner;
    }
    
    public Mono<Object> uploadFile(String fileName,byte[] data){
    	
    	return Mono.fromRunnable(()->{
    		PutObjectRequest req=PutObjectRequest.builder()
    				.bucket(bucket)
    				.key(fileName)
    				.build();
    		s3Client.putObject(req, RequestBody.fromBytes(data));
    	}).subscribeOn(Schedulers.boundedElastic());
    }
    
    public String generateUrl(String fileName) {
    	GetObjectRequest getObj=GetObjectRequest.builder()
    			.bucket(bucket)
    			.key(fileName)
    			.build();
    	
    	GetObjectPresignRequest req=GetObjectPresignRequest.builder()
    			.signatureDuration(Duration.ofMinutes(10))
    			.getObjectRequest(getObj)
    			.build();
    	  return presigner.presignGetObject(req)
                  .url()
                  .toString();
    	  }


}
