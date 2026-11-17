package ma.urbaneye.incident.incident;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("api/incidents")
public class IncidentController {
    private final IncidentService service;
    public IncidentController(IncidentService service){
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncidentResponse create(@Valid @RequestBody CreateIncidentRequest request, @RequestHeader("X-User-Id")Long authorId){
        return IncidentResponse.from(service.create(request, authorId));
    }
    @GetMapping
    public List<IncidentResponse> findAll(){
        return service.findAll().stream().map(IncidentResponse::from).toList();
    }
    @PatchMapping("/{id}/status")
    public IncidentResponse changeStatus(@PathVariable Long id, @Valid @RequestBody ChangeStatusRequest request, @RequestHeader("X-User-Id") Long userId){
        return IncidentResponse.from(service.changeStatus(id, request.status(), userId));
    }
}
