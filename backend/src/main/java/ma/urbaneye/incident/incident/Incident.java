package ma.urbaneye.incident.incident;

import jakarta.persistence.*;
import ma.urbaneye.incident.municipalservice.MunicipalService;

import java.time.Instant;

@Entity
@Table(name = "incident")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double longitude;
    @Column(nullable = false)
    private Double latitude;
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentStatus status = IncidentStatus.REPORTED;
    @Enumerated(EnumType.STRING)
    @Column(name = "analysis_status", nullable = false)
    private AnalysisStatus analysisStatus = AnalysisStatus.PENDING;
    private String category;
    private Short severity;
    @Column(name = "author_id", nullable = false)
    private Long authorId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipal_service_id")
    private MunicipalService municipalService;
    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();
    protected Incident() {}
    public Incident(String title, String description, Double latitude, Double longitude, String address, Long authorId){
        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.authorId = authorId;
    }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getAddress() { return address; }
    public IncidentStatus getStatus() { return status; }
    public AnalysisStatus getAnalysisStatus() { return analysisStatus; }
    public String getCategory() { return category; }
    public Short getSeverity() { return severity; }
    public Long getAuthorId() { return authorId; }
    public MunicipalService getMunicipalService() { return municipalService; }
    public Instant getCreatedAt() { return createdAt; }
    public void changeStatus(IncidentStatus newStatus){
        this.status = newStatus;
    }
}
