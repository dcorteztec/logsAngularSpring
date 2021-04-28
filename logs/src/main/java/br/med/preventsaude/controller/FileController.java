package br.med.preventsaude.controller;

import br.med.preventsaude.services.IFileStorageService;
import br.med.preventsaude.utilsMessage.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
public class FileController {

    private IFileStorageService fileService;

    public FileController(IFileStorageService fileService){
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    @ApiOperation(value = "upload", notes="Upload do arquivo de Logs",nickname = "upload")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.storeDataFile(file);
            return ResponseEntity.status(HttpStatus.OK).body(Message.UPLOAD_SUCESSO.getDescription());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(Message.UPLOAD_ERROR.getDescription());
        }
    }
}
