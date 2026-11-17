package ma.urbaneye.incident.incident;

public class IncidentNotFoundException extends RuntimeException{
    public IncidentNotFoundException(Long id){
        super("je peux pas trouver l'incident avec id" + id);
    }
}
