package br.med.preventsaude.services;

import org.springframework.web.multipart.MultipartFile;

public interface IFileStorageService {

    Integer storeDataFile(MultipartFile file);
}
