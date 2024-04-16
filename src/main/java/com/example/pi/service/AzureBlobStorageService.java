package com.example.pi.service;

import com.example.pi.dto.FileDTO;
import com.example.pi.dto.Resp;
import com.example.pi.exception.AzureBlobStorageException;
import com.example.pi.model.Ressource;

import java.util.List;


public interface AzureBlobStorageService {

    public Resp write(FileDTO file) throws AzureBlobStorageException;

    public String update(FileDTO file) throws AzureBlobStorageException;

    public byte[] read(Ressource storage) throws AzureBlobStorageException;

    public List<String> listFiles(Ressource storage) throws AzureBlobStorageException;

    public void delete(FileDTO file) throws AzureBlobStorageException;

    public void createContainer() throws AzureBlobStorageException;

    public void deleteContainer() throws AzureBlobStorageException;


}
