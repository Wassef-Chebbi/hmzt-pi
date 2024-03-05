package com.example.pi.azure;


import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureBlobStorageConfig {

    @Value("${azure.storage.connection-string}")
    private String connectionString;

    @Value("${azure.storage.container.name}")
    private String containerName;


    @Bean
    public BlobServiceClient getBlobServiceClient(){
        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
        return serviceClient;
    }

    @Bean
    public BlobContainerClient getBlobContainerClient(){
        BlobContainerClient containerClient = getBlobServiceClient()
                .getBlobContainerClient(containerName);
        return containerClient;
    }


}
