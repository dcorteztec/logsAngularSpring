package br.med.preventsaude.repository;

import br.med.preventsaude.model.LogModel;

import java.util.List;
import java.util.Optional;

public interface ILogRepository {

    LogModel insert(LogModel log);
    List<LogModel> findAll();
    Optional<LogModel> findById(Long logId);
    void delete(LogModel log);
}
