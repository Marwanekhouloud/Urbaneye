package ma.urbaneye.incident.incident;

import jakarta.validation.constraints.*;

public record CreateIncidentRequest(
        @NotBlank @Size(max = 150) String title,
        @NotBlank String description,
        @NotBlank @DecimalMin("-90.0") @DecimalMax("90.0") Double latitude,
        @NotBlank @DecimalMin("-180.0") @DecimalMax("180.0") Double longitude,
        @Size(max = 255) String address
) {
}
