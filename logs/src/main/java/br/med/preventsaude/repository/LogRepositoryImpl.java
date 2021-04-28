package br.med.preventsaude.repository;

import br.med.preventsaude.model.LogModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class LogRepositoryImpl implements ILogRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public LogModel insert(LogModel log) {
        if(log.getId() != null){
            entityManager.merge(log);
        }else{
            entityManager.persist(log);
        }
        return log;
    }

    @Override
    public List<LogModel> findAll() {
        return entityManager.createQuery("Select t from log_tab t").getResultList();
    }

    @Override
    public Optional<LogModel> findById(Long logId) {
        LogModel log = (LogModel) entityManager.find(LogModel.class, logId);
        return Optional.of(log);
    }

    @Override
    public void delete(LogModel log) {
        entityManager.remove(log);
    }
}
