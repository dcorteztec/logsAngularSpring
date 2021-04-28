package br.med.preventsaude.services;

import br.med.preventsaude.repository.ILogRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileStorageServiceTest {

    @Autowired
    private ILogRepository repository;
    private FileStorageService service;

    @Test
    public void storeDataFile() {
        this.service = new FileStorageService(repository);
        MockMultipartFile file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
        Assert.assertTrue(service.storeDataFile(file)==1);

    }

}
