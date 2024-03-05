package com.example.pi.serviceImpl;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobStorageException;
import com.example.pi.dto.newRessource;
import com.example.pi.exception.AzureBlobStorageException;
import com.example.pi.model.Ressource;
import com.example.pi.service.AzureBlobStorageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AzureBlobStorageServiceImpl implements AzureBlobStorageService {

    @Value("${azure.storage.container.name}")
    private String containerName;


    @Autowired
    private BlobServiceClient blobServiceClient;
    @Autowired
    private BlobContainerClient blobContainerClient;




    @Override
    public String write(Ressource ressource) throws AzureBlobStorageException {
        try {
            String path = getPath(ressource);
            BlobClient blob = blobContainerClient.getBlobClient(path);
            blob.upload(ressource.getInputStream(), false);

            return path;
        }catch(BlobStorageException e){
            throw new AzureBlobStorageException(e.getServiceMessage());
        }catch(RuntimeException e){
            throw new AzureBlobStorageException(e.getMessage());
        }catch (Exception e){
            throw new AzureBlobStorageException(e.getMessage());
        }
    }

    @Override
    public String update(Ressource storage) throws AzureBlobStorageException {
        return null;
    }

    @Override
    public byte[] read(Ressource storage) throws AzureBlobStorageException {
        return new byte[0];
    }

    @Override
    public List<String> listFiles(Ressource storage) throws AzureBlobStorageException {
        try {
            PagedIterable<BlobItem> blobList = blobContainerClient.listBlobsByHierarchy(storage.getPath() + "/");
            List<String> blobNamesList = new ArrayList<>();
            for (BlobItem blob : blobList) {
                blobNamesList.add(blob.getName());
            }
            return blobNamesList;
        }catch(BlobStorageException e){
            throw new AzureBlobStorageException(e.getServiceMessage());
        }catch(RuntimeException e){
            throw new AzureBlobStorageException(e.getMessage());
        }catch (Exception e){
            throw new AzureBlobStorageException(e.getMessage());
        }
    }

    @Override
    public void delete(Ressource storage) throws AzureBlobStorageException {
//        String path=getPath(storage);
//        BlobClient client = blobContainerClient.getBlobClient(path);
//        client.delete();
//        log.info(" blob is deleted successfully");

    }

    @Override
    public void createContainer() throws AzureBlobStorageException {
        blobServiceClient.createBlobContainer(containerName);
        log.info("Container created successfully");

    }

    @Override
    public void deleteContainer() throws AzureBlobStorageException {
        blobServiceClient.deleteBlobContainer(containerName);
        log.info("Container deleted successfully");

    }

    private String getPath(Ressource storage){
        if(StringUtils.isNotBlank(storage.getPath())
                && StringUtils.isNotBlank(storage.getFileName())){
            return  storage.getPath()+"/"+storage.getFileName();
        }
        return null;
    }
}
