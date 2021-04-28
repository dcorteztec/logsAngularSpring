package br.med.preventsaude.controller;

import br.med.preventsaude.exception.ResourceNotFoundException;
import br.med.preventsaude.model.LogModel;
import br.med.preventsaude.services.ILogService;
import br.med.preventsaude.utilsMessage.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LogController {

    private ILogService logService;

    public LogController (ILogService logService){
        this.logService = logService;
    }

    @ApiOperation(value = "listLogs", notes="Listar todos os Logs",nickname = "listLogs")
    @RequestMapping(value = "/listLogs", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LogModel>> listAllLogs() {
        List<LogModel> ret = new ArrayList<>();
        try {
            ret = logService.findAll();

            return ResponseEntity.status(HttpStatus.OK).body(ret);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ArrayList<>());
        }
    }

    @PostMapping("/create-log")
    public LogModel createLog(@RequestBody LogModel log) {
        return logService.insert(log);
    }

    @GetMapping("/log/{id}")
    public ResponseEntity<LogModel> getLogById(@PathVariable(value = "id") Long logId)
            throws ResourceNotFoundException {
        LogModel log = logService.findById(logId)
                .orElseThrow(() -> new ResourceNotFoundException(Message.FIND_BY_ID_ERROR.getDescription() + logId));
        return ResponseEntity.ok().body(log);
    }

    @PutMapping("/edit-log/{id}")
    public ResponseEntity<LogModel> updateLog(@PathVariable(value = "id") Long logid,
                                                   @RequestBody LogModel logReq) throws ResourceNotFoundException {
        LogModel log = logService.findById(logid)
                .orElseThrow(() -> new ResourceNotFoundException(Message.FIND_BY_ID_ERROR.getDescription() +" :: "+ logid));

        log.setDateTime(logReq.getDateTime());
        log.setHttpMethod(logReq.getHttpMethod());
        log.setIp(logReq.getIp());
        log.setStatusMethod(logReq.getStatusMethod());
        log.setUserAgent(logReq.getUserAgent());
        final LogModel updatedLog = logService.insert(log);
        return ResponseEntity.ok(updatedLog);
    }

    @DeleteMapping("/delete-log/{id}")
    public Map<String, Boolean> deleteLog(@PathVariable(value = "id") Long logId)
            throws ResourceNotFoundException {
        LogModel log = logService.findById(logId)
                .orElseThrow(() -> new ResourceNotFoundException(Message.FIND_BY_ID_ERROR.getDescription() +" :: "+ logId));

        logService.delete(log);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
