package ma.urbaneye.incident.municipalservice;

import jakarta.persistence.*;

@Entity
@Table(name = "municipal_service")
public class MunicipalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 100)
    private String name;
    protected MunicipalService(){}
    public MunicipalService(String name){this.name = name;}
    public Long getId() { return id; }
    public String getName() { return name; }
}
