package ma.urbaneye.incident.incident;

public class InvalidStatusTransitionException extends RuntimeException {
    public InvalidStatusTransitionException(IncidentStatus from, IncidentStatus to) {
        super("passage impossible de "+ from + "a"+ to);
    }
}
