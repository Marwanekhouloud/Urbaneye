package ma.urbaneye.incident.incident;

public enum IncidentStatus {
    REPORTED, ASSIGNED, IN_PROGRESS, RESOLVED;
    public boolean canMoveTo(IncidentStatus next){
      return switch(this){
          case REPORTED -> next == ASSIGNED;
          case ASSIGNED -> next == IN_PROGRESS;
          case IN_PROGRESS -> next == RESOLVED;
          case RESOLVED -> false;
      };
    };
}
