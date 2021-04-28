package br.med.preventsaude.services;

import br.med.preventsaude.model.LogModel;

import java.util.List;
import java.util.Optional;

public interface ILogService {

    LogModel insert(LogModel user);
    List<LogModel> findAll();
    Optional<LogModel> findById(Long logId);
    void delete(LogModel log);
}
