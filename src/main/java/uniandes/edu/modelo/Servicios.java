package uniandes.edu.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicios {
    private Integer precioUnitario;

    public Servicios(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Servicios()
    {;}

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
}
