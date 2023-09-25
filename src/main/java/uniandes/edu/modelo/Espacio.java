package uniandes.edu.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "espacio")
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private TipoEspacio tipoEspacio;
    private Double capacidad;
    
    public Espacio()
    {;}
    
    public Espacio(Integer id, TipoEspacio tipoEspacio, Double capacidad) {
        this.id = id;
        this.tipoEspacio = tipoEspacio;
        this.capacidad = capacidad;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public TipoEspacio getTipoEspacio() {
        return tipoEspacio;
    }
    public void setTipoEspacio(TipoEspacio tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }
    public Double getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    
}
