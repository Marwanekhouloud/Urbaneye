package ma.urbaneye.incident.incident;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "status_history")
public class StatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "incident_id")
    private Incident incident;
    @Enumerated(EnumType.STRING)
    @Column(name = "old_status")
    private IncidentStatus oldStatus;
    @Enumerated(EnumType.STRING)
    @Column(name = "new_status", nullable = false)
    private IncidentStatus newStatus;
    @Column(name = "changed_by", nullable = false)
    private Long changedBy;
    @Column(name = "changed_at", nullable = false)
    private Instant changedAt = Instant.now();
    protected StatusHistory(){}
    public StatusHistory(Incident incident, IncidentStatus oldStatus, IncidentStatus newStatus, Long changedBy){
        this.incident = incident;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.changedBy = changedBy;
    }
    public Long getId() { return id; }
    public Incident getIncident() { return incident; }
    public IncidentStatus getOldStatus() { return oldStatus; }
    public IncidentStatus getNewStatus() { return newStatus; }
    public Long getChangedBy() { return changedBy; }
    public Instant getChangedAt() { return changedAt; }
}
