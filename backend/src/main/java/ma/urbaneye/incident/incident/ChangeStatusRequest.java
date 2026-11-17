package ma.urbaneye.incident.incident;

import jakarta.validation.constraints.NotNull;

public record ChangeStatusRequest(@NotNull IncidentStatus status) {
}
