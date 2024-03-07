package com.example.pi.service;

import com.example.pi.dto.FileDTO;
import com.example.pi.dto.newRessource;
import com.example.pi.exception.AzureBlobStorageException;
import com.example.pi.model.Ressource;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AzureBlobStorageService {

    public String write(FileDTO ressource) throws AzureBlobStorageException;

    public String update(Ressource storage) throws AzureBlobStorageException;

    public byte[] read(Ressource storage) throws AzureBlobStorageException;

    public List<String> listFiles(Ressource storage) throws AzureBlobStorageException;

    public void delete(Ressource storage) throws AzureBlobStorageException;

    public void createContainer() throws AzureBlobStorageException;

    public void deleteContainer() throws AzureBlobStorageException;


}
