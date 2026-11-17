package ma.urbaneye.incident.incident;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncidentService {
    private final IncidentRepository repository;
    private final StatusHistoryRepository historyRepository;
    public IncidentService(IncidentRepository repository, StatusHistoryRepository historyRepository){
        this.repository = repository;
        this.historyRepository = historyRepository;
    }
    @Transactional
    public Incident create(CreateIncidentRequest r, long authorId){
        Incident saved = repository.save(new Incident(
                r.title(),r.description(),r.latitude(),r.longitude(),r.address(),authorId
        ));
        historyRepository.save(new StatusHistory(saved, null, IncidentStatus.REPORTED, authorId));
                return saved;

    }
    @Transactional(readOnly = true)
    public List<Incident> findAll(){
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    public Incident findById(Long id){
        return repository.findById(id).orElseThrow(()-> new IncidentNotFoundException(id));
}
    @Transactional
    public Incident changeStatus(Long id, IncidentStatus newStatus, Long userId){
        Incident incident = findById(id);
        IncidentStatus old = incident.getStatus();
        if(!old.canMoveTo(newStatus)){
            throw new InvalidStatusTransitionException(old, newStatus);
        }
        incident.changeStatus(newStatus);
        historyRepository.save(new StatusHistory(incident, old, newStatus, userId));
        return incident;
    }
}
