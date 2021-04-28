package br.med.preventsaude.services;

import br.med.preventsaude.model.LogModel;
import br.med.preventsaude.repository.ILogRepository;
import br.med.preventsaude.utilsMessage.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileStorageService implements IFileStorageService{

    private ILogRepository repository;

    Logger logger = LoggerFactory.getLogger(FileStorageService.class);

    public FileStorageService(ILogRepository repository){
        this.repository = repository;
    }

    @Override
    public Integer storeDataFile(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            InputStreamReader scan = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(scan);
            String logLine = br.readLine();
            while (logLine != null) {
                logLine = br.readLine();
                String[] dados = logLine.split("\\|");
                saveDados(dados);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            return Message.UPLOAD_ERROR.getCode();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Message.UPLOAD_ERROR.getCode();
        }

        return Message.UPLOAD_SUCESSO.getCode();
    }

    private void saveDados(String[] dados) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(dados[0], formatter);
        LogModel log = new LogModel(dateTime,dados[1],dados[2],dados[3],dados[4]);
        repository.insert(log);
    }
}
