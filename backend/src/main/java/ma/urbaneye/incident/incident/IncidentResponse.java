package ma.urbaneye.incident.incident;

import java.time.Instant;

public record IncidentResponse(
        Long id, String title, String description, Double latitude, Double longitude, String address, IncidentStatus status, AnalysisStatus analysisStatus, String category, short severiry, Instant createdAt
) {
    public static IncidentResponse from (Incident i){
        return new IncidentResponse(
                i.getId(), i.getTitle(), i.getDescription(), i.getLatitude(),i.getLongitude(),i.getAddress(),i.getStatus(),i.getAnalysisStatus(),i.getCategory(),i.getSeverity(),i.getCreatedAt()
        );
    }
}
