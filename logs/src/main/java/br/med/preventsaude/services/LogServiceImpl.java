package br.med.preventsaude.services;

import br.med.preventsaude.model.LogModel;
import br.med.preventsaude.repository.ILogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogServiceImpl implements ILogService{

    private ILogRepository repository;

    public LogServiceImpl(ILogRepository repository){
        this.repository = repository;
    }

    @Override
    public LogModel insert(LogModel log) {
        return repository.insert(log);
    }

    @Override
    public List<LogModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<LogModel> findById(Long logId) {
        return repository.findById(logId);
    }

    @Override
    public void delete(LogModel log) {
        repository.delete(log);
    }
}
