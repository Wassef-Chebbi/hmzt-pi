package com.example.pi;

import com.example.pi.dto.newRessource;
import com.example.pi.exception.AzureBlobStorageException;
import com.example.pi.model.Ressource;
import com.example.pi.serviceImpl.AzureBlobStorageServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.util.List;

@SpringBootTest
class PiApplicationTests {

	@Autowired
	AzureBlobStorageServiceImpl storageImpl;

	@Test
	void contextLoads() {
	}
//	@BeforeEach
//	public void createContainer() throws  AzureBlobStorageException {
//		storageImpl.createContainer();
//	}

//	@AfterEach
//	public void deleteContainer() throws  AzureBlobStorageException {
//		storageImpl.deleteContainer();
//	}
	@Test
	public  void writeBlob() throws AzureBlobStorageException {
		//Ressource storage = getStorage("cust","cust1.txt","Hello World");
//		String writeStr = storageImpl.write(storage);
//		System.out.println(writeStr + "++++++");
//		storage = getStorage("cust","cust1.txt","Hello World1");
//		String updateStr = storageImpl.update(storage);
//		List<String> listFiles = storageImpl.listFiles(storage);
//		System.out.println(listFiles);
//		byte[] readContents =storageImpl.read(storage);
//		System.out.println(readContents);
//		storageImpl.delete(storage);

	}

//	private Ressource getStorage(String path , String fileName, String data){
//		Ressource storage = new Ressource();
//		storage.setPath(path);
//		storage.setFileName(fileName);
//		if(StringUtils.isNotBlank(data)){
//			storage.setInputStream(new ByteArrayInputStream(data.getBytes()));
//		}
//
//		return storage;
//	}

}
